
package com.malimar.views;

import static com.malimar.controllers.LabelManager.LN;
import static com.malimar.controllers.LabelManager.WindowChangeLabel;
import static com.malimar.controllers.LabelManager.hmapLang;
import com.malimar.controllers.ReceiptManager;
import com.malimar.controllers.TableAlignmentHeader;
import com.malimar.models.Receipt;
import com.malimar.utils.Border;
import com.malimar.utils.ClearTable;
import com.malimar.utils.MsgBox;
import com.malimar.utils.SetText;
import static com.malimar.views.FrmMain.userNbr;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class FrmReceipt extends javax.swing.JDialog {
    String frm;
    DefaultTableModel model  = new DefaultTableModel();
    HashMap<String, Object[]>mapPayment = null;
    ReceiptManager rcm = new ReceiptManager();
    Receipt rct = new Receipt();
    String currency;
    public FrmReceipt(java.awt.Frame parent, boolean modal,int rctID, String cur, double fee) {
        super(parent, modal);
        initComponents();
        txtRegisterID.setText(String.valueOf(rctID));
        showReceipt();
        getcmbPayment();
        txtRateLAK.setText(String.format("%,.4f", rcm.showRateLAK(cur)));
        txtRateTHB.setText(String.format("%,.4f", rcm.showRateTHB(cur)));
        txtRateUSD.setText(String.format("%,.4f", rcm.showRateUSD(cur)));
        currency=cur;
        rct.setRegisterID(Integer.parseInt(txtRegisterID.getText()));
        txtFeeTotal.setText(String.format("%,.2f", fee));
        showTotal();
    }
    private void showReceipt(){
        try {
            frm = this.getClass().getSimpleName();
            table.getTableHeader().setFont(new Font("Saysettha OT", Font.BOLD, 12));
            model = (DefaultTableModel) table.getModel();
            Date now = new Date();
            txtCreateDate.setDate(now);
            txtReceivedDate.setDate(now);
            SetText.dateTextColor(txtCreateDate);
            jScrollPane1.getViewport().setBackground(Color.WHITE);
            table.setShowGrid(true);
            table.getTableHeader().setBackground(Color.decode("#4169E1"));
            table.getTableHeader().setForeground(Color.WHITE);
            table.getTableHeader().setOpaque(false);
            lblReceiptInfo.setText(hmapLang.get("lblReceiptInfo".concat(frm).toUpperCase())[LN]);
            lblRegisterID.setText(hmapLang.get("lblRegisterID".concat(frm).toUpperCase())[LN]);
            lblCreateDate.setText(hmapLang.get("lblCreateDate".concat(frm).toUpperCase())[LN]);
            lblReceiptDate.setText(hmapLang.get("lblReceiptDate".concat(frm).toUpperCase())[LN]);
            lblPaymentType.setText(hmapLang.get("lblPaymentType".concat(frm).toUpperCase())[LN]);
            lblAmountLAK.setText(hmapLang.get("lblAmountLAK".concat(frm).toUpperCase())[LN]);
            lblAmountTHB.setText(hmapLang.get("lblAmountTHB".concat(frm).toUpperCase())[LN]);
            lblAmountUSD.setText(hmapLang.get("lblAmountUSD".concat(frm).toUpperCase())[LN]);
            lblNote.setText(hmapLang.get("lblNote".concat(frm).toUpperCase())[LN]);
            btnPay.setText(hmapLang.get("btnPay".concat(frm).toUpperCase())[LN]);
            lblRateLAK.setText(hmapLang.get("lblRateLAK".concat(frm).toUpperCase())[LN]);
            lblRateTHB.setText(hmapLang.get("lblRateTHB".concat(frm).toUpperCase())[LN]);
            lblRateUSD.setText(hmapLang.get("lblRateUSD".concat(frm).toUpperCase())[LN]);
            lblFeeTotal.setText(hmapLang.get("lblFeeTotal".concat(frm).toUpperCase())[LN]);
            lblPaidTotal.setText(hmapLang.get("lblPaidTotal".concat(frm).toUpperCase())[LN]);
            lblBalanceTotal.setText(hmapLang.get("lblBalanceTotal".concat(frm).toUpperCase())[LN]);
            JTableHeader th = table.getTableHeader();
            TableColumnModel tcm = th.getColumnModel();
            table.getColumnCount();
            for (int i = 0; i < table.getColumnCount(); i++) {
                TableColumn tc = tcm.getColumn(i);
                tc.setHeaderValue(hmapLang.get(table.getModel().getColumnName(i).concat(frm).toUpperCase())[LN]);
            }
            table.setAutoCreateRowSorter(true);
            th.repaint();
            table.getColumnModel().getColumn(0).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.CENTER));
            table.getColumnModel().getColumn(1).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.LEFT));
            table.getColumnModel().getColumn(2).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.LEFT));
            table.getColumnModel().getColumn(3).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.RIGHT));
            table.getColumnModel().getColumn(4).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.RIGHT));
            table.getColumnModel().getColumn(5).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.RIGHT));
            table.getColumnModel().getColumn(6).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.RIGHT));
            table.getColumnModel().getColumn(7).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.CENTER));
            table.getColumnModel().getColumn(8).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.CENTER));
            DefaultTableCellRenderer CenterRenderer = new DefaultTableCellRenderer();
            CenterRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            table.getColumnModel().getColumn(0).setCellRenderer(CenterRenderer);
            table.getColumnModel().getColumn(7).setCellRenderer(CenterRenderer);
            table.getColumnModel().getColumn(8).setCellRenderer(CenterRenderer);
            DefaultTableCellRenderer RightRenderer = new DefaultTableCellRenderer();
            RightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
            table.getColumnModel().getColumn(3).setCellRenderer(RightRenderer);
            table.getColumnModel().getColumn(4).setCellRenderer(RightRenderer);
            table.getColumnModel().getColumn(5).setCellRenderer(RightRenderer);
            table.getColumnModel().getColumn(6).setCellRenderer(RightRenderer);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
    private void getcmbPayment() {
        try {
            mapPayment = rcm.mapRecType();
            Map<String, Object[]> ms = new TreeMap<>(mapPayment);
            cmbPaymentType.removeAllItems();
            ms.keySet().forEach((s) -> {
                cmbPaymentType.addItem(s);
            });
            cmbPaymentType.setSelectedIndex(-1);
            AutoCompleteDecorator.decorate(cmbPaymentType);
        } catch (Exception e) {
        }
    }
    private void showTotal() {
        ClearTable.clearFirstLoad(table, model);
        rcm.loadPayment(model, rct);
        txtPaidTotal.setText(String.format("%,.2f", rcm.paid(table)));
        rct.setPaid(Double.parseDouble(txtPaidTotal.getText().replace(",", "")));
        rct.setGrandTotal(Double.parseDouble(txtFeeTotal.getText().replace(",", "")));
        txtBalanceTotal.setText(String.format("%,.2f", rcm.balance(rct)));
    }
    private void clearText(){
        txtAmountLAK.setText("0.00");
        txtAmountTHB.setText("0.00");
        txtAmountUSD.setText("0.00");
        txtNote.setText("0.00");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnExit = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblReceiptInfo = new javax.swing.JLabel();
        lblRegisterID = new javax.swing.JLabel();
        txtRegisterID = new javax.swing.JTextField();
        lblCreateDate = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtCreateDate = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        lblReceiptDate = new javax.swing.JLabel();
        txtReceivedDate = new com.toedter.calendar.JDateChooser();
        lblPaymentType = new javax.swing.JLabel();
        cmbPaymentType = new javax.swing.JComboBox<>();
        lblAmountLAK = new javax.swing.JLabel();
        txtAmountLAK = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        txtAmountTHB = new javax.swing.JTextField();
        lblAmountTHB = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        lblAmountUSD = new javax.swing.JLabel();
        txtAmountUSD = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        btnPay = new javax.swing.JLabel();
        lblNote = new javax.swing.JLabel();
        txtNote = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        txtFeeTotal = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        lblFeeTotal = new javax.swing.JLabel();
        txtPaidTotal = new javax.swing.JTextField();
        lblPaidTotal = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        lblBalanceTotal = new javax.swing.JLabel();
        txtBalanceTotal = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        lblRateLAK = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        txtRateLAK = new javax.swing.JTextField();
        lblRateTHB = new javax.swing.JLabel();
        txtRateTHB = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        lblRateUSD = new javax.swing.JLabel();
        txtRateUSD = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 15, 255)));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

        btnExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Close Window_30px.png"))); // NOI18N
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });

        jPanel5.setLayout(new java.awt.BorderLayout());

        lblReceiptInfo.setBackground(new java.awt.Color(255, 255, 255));
        lblReceiptInfo.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblReceiptInfo.setForeground(new java.awt.Color(0, 15, 255));
        lblReceiptInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReceiptInfo.setText("Receipt Infomation");
        lblReceiptInfo.setOpaque(true);
        jPanel5.add(lblReceiptInfo, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 925, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(2, 2, 2))
        );

        lblRegisterID.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblRegisterID.setText("Registter#");

        txtRegisterID.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtRegisterID.setBorder(null);
        txtRegisterID.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtRegisterID.setEnabled(false);
        txtRegisterID.setOpaque(false);

        lblCreateDate.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblCreateDate.setText("Create Date");

        txtCreateDate.setBackground(new java.awt.Color(255, 255, 255));
        txtCreateDate.setDateFormatString("dd-MM-yyyy");
        txtCreateDate.setEnabled(false);
        txtCreateDate.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new java.awt.BorderLayout());

        table.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "lblReceipt#", "lblReceiptDate", "lblPaymentType", "lblAmountLAK", "lblAmountTHB", "lblAmountUSD", "lblAmountTotal", "lblAttach1", "lblAttach2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        table.setRowHeight(25);
        table.setSelectionBackground(new java.awt.Color(204, 204, 204));
        table.setSelectionForeground(java.awt.Color.red);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(70);
            table.getColumnModel().getColumn(0).setMaxWidth(70);
            table.getColumnModel().getColumn(1).setMinWidth(100);
            table.getColumnModel().getColumn(1).setMaxWidth(100);
            table.getColumnModel().getColumn(2).setMinWidth(125);
            table.getColumnModel().getColumn(2).setMaxWidth(125);
            table.getColumnModel().getColumn(3).setMinWidth(120);
            table.getColumnModel().getColumn(3).setMaxWidth(120);
            table.getColumnModel().getColumn(4).setMinWidth(110);
            table.getColumnModel().getColumn(4).setMaxWidth(110);
            table.getColumnModel().getColumn(5).setMinWidth(100);
            table.getColumnModel().getColumn(5).setMaxWidth(100);
            table.getColumnModel().getColumn(6).setMinWidth(130);
            table.getColumnModel().getColumn(6).setMaxWidth(130);
            table.getColumnModel().getColumn(7).setMinWidth(100);
            table.getColumnModel().getColumn(7).setMaxWidth(100);
            table.getColumnModel().getColumn(8).setMinWidth(100);
            table.getColumnModel().getColumn(8).setMaxWidth(100);
        }

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        lblReceiptDate.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblReceiptDate.setText("Received Date");

        txtReceivedDate.setDateFormatString("dd-MM-yyyy");
        txtReceivedDate.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N

        lblPaymentType.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblPaymentType.setText("Payment Type");

        cmbPaymentType.setEditable(true);
        cmbPaymentType.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N

        lblAmountLAK.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblAmountLAK.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAmountLAK.setText("Amount LAK");

        txtAmountLAK.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtAmountLAK.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtAmountLAK.setText("0.00");
        txtAmountLAK.setBorder(null);
        txtAmountLAK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmountLAKActionPerformed(evt);
            }
        });

        txtAmountTHB.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtAmountTHB.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtAmountTHB.setText("0.00");
        txtAmountTHB.setBorder(null);
        txtAmountTHB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmountTHBActionPerformed(evt);
            }
        });

        lblAmountTHB.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblAmountTHB.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAmountTHB.setText("Amount THB");

        lblAmountUSD.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblAmountUSD.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAmountUSD.setText("Amount USD");

        txtAmountUSD.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtAmountUSD.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtAmountUSD.setText("0.00");
        txtAmountUSD.setBorder(null);
        txtAmountUSD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmountUSDActionPerformed(evt);
            }
        });

        btnPay.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        btnPay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPay.setText("Pay");
        btnPay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPay.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnPayMouseMoved(evt);
            }
        });
        btnPay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPayMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPayMouseExited(evt);
            }
        });

        lblNote.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblNote.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNote.setText("Note");

        txtNote.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtNote.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNote.setBorder(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        txtFeeTotal.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtFeeTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtFeeTotal.setText("0.00");
        txtFeeTotal.setBorder(null);
        txtFeeTotal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtFeeTotal.setEnabled(false);
        txtFeeTotal.setOpaque(false);

        lblFeeTotal.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblFeeTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFeeTotal.setText("Fee Total");

        txtPaidTotal.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtPaidTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtPaidTotal.setText("0.00");
        txtPaidTotal.setBorder(null);
        txtPaidTotal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtPaidTotal.setEnabled(false);
        txtPaidTotal.setOpaque(false);

        lblPaidTotal.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblPaidTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPaidTotal.setText("Paid Total");

        lblBalanceTotal.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblBalanceTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblBalanceTotal.setText("Balance Total");

        txtBalanceTotal.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtBalanceTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtBalanceTotal.setText("0.00");
        txtBalanceTotal.setBorder(null);
        txtBalanceTotal.setDisabledTextColor(java.awt.Color.red);
        txtBalanceTotal.setEnabled(false);
        txtBalanceTotal.setOpaque(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(239, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFeeTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtFeeTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblPaidTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtPaidTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblBalanceTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtBalanceTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jSeparator7, lblFeeTotal, txtFeeTotal});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFeeTotal)
                .addGap(2, 2, 2)
                .addComponent(txtFeeTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblPaidTotal)
                .addGap(2, 2, 2)
                .addComponent(txtPaidTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblBalanceTotal)
                .addGap(2, 2, 2)
                .addComponent(txtBalanceTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        lblRateLAK.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblRateLAK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRateLAK.setText("Rate LAK");

        txtRateLAK.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtRateLAK.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRateLAK.setText("0.00");
        txtRateLAK.setBorder(null);
        txtRateLAK.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtRateLAK.setEnabled(false);
        txtRateLAK.setOpaque(false);

        lblRateTHB.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblRateTHB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRateTHB.setText("Rate THB");

        txtRateTHB.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtRateTHB.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRateTHB.setText("0.00");
        txtRateTHB.setBorder(null);
        txtRateTHB.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtRateTHB.setEnabled(false);
        txtRateTHB.setOpaque(false);

        lblRateUSD.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblRateUSD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRateUSD.setText("Rate USD");

        txtRateUSD.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtRateUSD.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRateUSD.setText("0.00");
        txtRateUSD.setBorder(null);
        txtRateUSD.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtRateUSD.setEnabled(false);
        txtRateUSD.setOpaque(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator12)
                        .addComponent(txtRateUSD)
                        .addComponent(lblRateUSD, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator11)
                        .addComponent(txtRateTHB)
                        .addComponent(lblRateTHB, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator10)
                        .addComponent(txtRateLAK)
                        .addComponent(lblRateLAK, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRateLAK)
                .addGap(2, 2, 2)
                .addComponent(txtRateLAK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblRateTHB)
                .addGap(2, 2, 2)
                .addComponent(txtRateTHB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblRateUSD)
                .addGap(2, 2, 2)
                .addComponent(txtRateUSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblRegisterID, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1)
                            .addComponent(txtRegisterID, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCreateDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCreateDate, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblReceiptDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtReceivedDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbPaymentType, 0, 150, Short.MAX_VALUE)
                            .addComponent(lblPaymentType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator2)
                            .addComponent(txtAmountLAK)
                            .addComponent(lblAmountLAK, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator3)
                            .addComponent(txtAmountTHB)
                            .addComponent(lblAmountTHB, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator4)
                            .addComponent(txtAmountUSD)
                            .addComponent(lblAmountUSD, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator6)
                            .addComponent(txtNote)
                            .addComponent(lblNote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblRegisterID)
                        .addComponent(txtRegisterID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCreateDate))
                    .addComponent(txtCreateDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblReceiptDate)
                    .addComponent(lblPaymentType)
                    .addComponent(lblAmountLAK)
                    .addComponent(lblAmountTHB)
                    .addComponent(lblAmountUSD)
                    .addComponent(lblNote))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtReceivedDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPaymentType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAmountLAK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAmountTHB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAmountUSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmbPaymentType, lblAmountLAK, lblAmountTHB, lblAmountUSD, lblCreateDate, lblNote, lblPaymentType, lblReceiptDate, lblRegisterID, txtAmountLAK, txtAmountTHB, txtAmountUSD, txtCreateDate, txtNote, txtReceivedDate, txtRegisterID});

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnPayMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPayMouseMoved
        Border.blueColor(btnPay);
    }//GEN-LAST:event_btnPayMouseMoved

    private void btnPayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPayMouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("btnSave", frm);
        } else {
            if (cmbPaymentType.getSelectedIndex() != -1) {
                rct.setAmountLAK(Double.parseDouble(txtAmountLAK.getText().replace(",", "")));
                rct.setAmountTHB(Double.parseDouble(txtAmountTHB.getText().replace(",", "")));
                rct.setAmountUSD(Double.parseDouble(txtAmountUSD.getText().replace(",", "")));
                rct.setRateLAK(Float.parseFloat(txtRateLAK.getText().replace(",", "")));
                rct.setRateTHB(Float.parseFloat(txtRateTHB.getText().replace(",", "")));
                rct.setRateUSD(Float.parseFloat(txtRateUSD.getText().replace(",", "")));
                rct.setCurrency(currency);
                String payment = cmbPaymentType.getSelectedItem().toString();
                rct.setPayment_L1(mapPayment.get(payment)[1].toString());
                rct.setPayment_L2(mapPayment.get(payment)[2].toString());
                rct.setReceiptDate(txtReceivedDate.getDate());
                rct.setReceiptBy(userNbr);
                rct.setRegisterID(Integer.parseInt(txtRegisterID.getText()));
                if (rcm.insert(rct)) {
                    MsgBox.msgInfo();
                    showTotal();
                    clearText();
                } else {
                    MsgBox.msgError();
                }
            }
        }
    }//GEN-LAST:event_btnPayMouseClicked

    private void btnPayMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPayMouseExited
        Border.WhiteColor(btnPay);
    }//GEN-LAST:event_btnPayMouseExited

    private void txtAmountLAKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmountLAKActionPerformed
        if ("".equals(txtAmountLAK.getText())) {
            txtAmountLAK.setText("0.00");
        } else {
            double a = Double.parseDouble(txtAmountLAK.getText().replace(",", ""));
            txtAmountLAK.setText(String.valueOf(String.format("%,.2f", a)));
        }
    }//GEN-LAST:event_txtAmountLAKActionPerformed

    private void txtAmountTHBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmountTHBActionPerformed
        if ("".equals(txtAmountTHB.getText())) {
            txtAmountTHB.setText("0.00");
        } else {
            double a = Double.parseDouble(txtAmountTHB.getText().replace(",", ""));
            txtAmountTHB.setText(String.valueOf(String.format("%,.2f", a)));
        }
    }//GEN-LAST:event_txtAmountTHBActionPerformed

    private void txtAmountUSDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmountUSDActionPerformed
        if ("".equals(txtAmountUSD.getText())) {
            txtAmountUSD.setText("0.00");
        } else {
            double a = Double.parseDouble(txtAmountUSD.getText().replace(",", ""));
            txtAmountUSD.setText(String.valueOf(String.format("%,.2f", a)));
        }
    }//GEN-LAST:event_txtAmountUSDActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmReceipt dialog = new FrmReceipt(new javax.swing.JFrame(), true,0,null,0);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnExit;
    private javax.swing.JLabel btnPay;
    private javax.swing.JComboBox<String> cmbPaymentType;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblAmountLAK;
    private javax.swing.JLabel lblAmountTHB;
    private javax.swing.JLabel lblAmountUSD;
    private javax.swing.JLabel lblBalanceTotal;
    private javax.swing.JLabel lblCreateDate;
    private javax.swing.JLabel lblFeeTotal;
    private javax.swing.JLabel lblNote;
    private javax.swing.JLabel lblPaidTotal;
    private javax.swing.JLabel lblPaymentType;
    private javax.swing.JLabel lblRateLAK;
    private javax.swing.JLabel lblRateTHB;
    private javax.swing.JLabel lblRateUSD;
    private javax.swing.JLabel lblReceiptDate;
    private javax.swing.JLabel lblReceiptInfo;
    private javax.swing.JLabel lblRegisterID;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtAmountLAK;
    private javax.swing.JTextField txtAmountTHB;
    private javax.swing.JTextField txtAmountUSD;
    private javax.swing.JTextField txtBalanceTotal;
    private com.toedter.calendar.JDateChooser txtCreateDate;
    private javax.swing.JTextField txtFeeTotal;
    private javax.swing.JTextField txtNote;
    private javax.swing.JTextField txtPaidTotal;
    private javax.swing.JTextField txtRateLAK;
    private javax.swing.JTextField txtRateTHB;
    private javax.swing.JTextField txtRateUSD;
    private com.toedter.calendar.JDateChooser txtReceivedDate;
    private javax.swing.JTextField txtRegisterID;
    // End of variables declaration//GEN-END:variables
}
