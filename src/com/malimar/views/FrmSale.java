
package com.malimar.views;

import com.malimar.controllers.DatabaseManagerSQL;
import com.malimar.controllers.LabelManager;
import static com.malimar.controllers.LabelManager.LN;
import static com.malimar.controllers.LabelManager.WindowChangeLabel;
import static com.malimar.controllers.LabelManager.hmapLang;
import com.malimar.controllers.NextCellActioin;
import com.malimar.controllers.SaleManager;
import com.malimar.controllers.TableAlignmentHeader;
import com.malimar.controllers.UserPermission;
import com.malimar.models.Sale;
import com.malimar.utils.Border;
import com.malimar.utils.FrameMove;
import com.malimar.utils.MsgBox;
import static com.malimar.views.FrmMain.userNbr;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class FrmSale extends javax.swing.JFrame {
    String frm;
    DefaultTableModel model = new DefaultTableModel();
    Connection c = DatabaseManagerSQL.getConnection();
    HashMap<String, Object[]>mapCurrency = null;
    HashMap<String, Object[]>mapSaleMan = null;
    HashMap<String, Object[]>mapPayment = null;
    SaleManager sm = new SaleManager();
    Sale sale = new Sale();
    public static int prodID;
    public static double paid;
    public FrmSale() {
        initComponents();
        start();
        getcmbCurrency();
        getcmbPaymentType();
        getcmbSalePerson();
        txtVAT.setText(String.format("%,.2f", sm.getVat()));
        Date now = new Date();
        txtSaleDate.setDate(now);
        UserPermission.getPermission_S(userNbr, frm, btnSave);
    }
    private void start(){
        frm = this.getClass().getSimpleName();
        table.getTableHeader().setFont(new Font("Saysettha OT", Font.BOLD,12));
        model = (DefaultTableModel) table.getModel();
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        table.setShowGrid(true);
        table.getTableHeader().setBackground(Color.decode("#4169E1"));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setOpaque(false);
        lblSaleTitle.setText(hmapLang.get("lblSaleTitle".concat(frm).toUpperCase()) [LN]);
        lblSaleID.setText(hmapLang.get("lblSaleID".concat(frm).toUpperCase()) [LN]);
        lblSalePerson.setText(hmapLang.get("lblSalePerson".concat(frm).toUpperCase()) [LN]);
        lblCurrency.setText(hmapLang.get("lblCurrency".concat(frm).toUpperCase()) [LN]);
        lblSaleDate.setText(hmapLang.get("lblSaleDate".concat(frm).toUpperCase()) [LN]);
        lblPaymentType.setText(hmapLang.get("lblPaymentType".concat(frm).toUpperCase()) [LN]);
        lblSubTotal.setText(hmapLang.get("lblSubTotal".concat(frm).toUpperCase()) [LN]);
        lblDiscount.setText(hmapLang.get("lblDiscount".concat(frm).toUpperCase()) [LN]);
        lblVAT.setText(hmapLang.get("lblVAT".concat(frm).toUpperCase()) [LN]);
        lblGrandTotal.setText(hmapLang.get("lblGrandTotal".concat(frm).toUpperCase()) [LN]);
        btnSave.setText(hmapLang.get("btnSave".concat(frm).toUpperCase()) [LN]);
        btnVoid.setText(hmapLang.get("btnVoid".concat(frm).toUpperCase()) [LN]);
        JTableHeader th = table.getTableHeader();
        TableColumnModel tcm = th.getColumnModel();
        table.getColumnCount();
        for (int i = 0; i < table.getColumnCount(); i++) {
            TableColumn tc = tcm.getColumn(i);
            tc.setHeaderValue(hmapLang.get(table.getModel().getColumnName(i).concat(frm).toUpperCase())[LN]);
        }
        table.setAutoCreateRowSorter(true);
        th.repaint();
        table.getColumnModel().getColumn(0).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.LEFT));
        table.getColumnModel().getColumn(1).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.LEFT));
        table.getColumnModel().getColumn(2).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.LEFT));
        table.getColumnModel().getColumn(3).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.CENTER));
        table.getColumnModel().getColumn(4).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.RIGHT));
        table.getColumnModel().getColumn(5).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.CENTER));
        table.getColumnModel().getColumn(6).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.RIGHT));
        DefaultTableCellRenderer RightRenderer = new DefaultTableCellRenderer();
        RightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        table.getColumnModel().getColumn(4).setCellRenderer(RightRenderer);
        table.getColumnModel().getColumn(6).setCellRenderer(RightRenderer);
        DefaultTableCellRenderer CenterRenderer = new DefaultTableCellRenderer();
        CenterRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.getColumnModel().getColumn(3).setCellRenderer(CenterRenderer);
        table.getColumnModel().getColumn(5).setCellRenderer(CenterRenderer);
    }
    private void getcmbCurrency() {
        try {
            mapCurrency = sm.mapCurrency();
            Map<String, Object[]> ms = new TreeMap<>(mapCurrency);
            cmbCurrency.removeAllItems();
            ms.keySet().forEach((s) -> {
                cmbCurrency.addItem(s);
            });
//            cmbCurrency.setSelectedIndex(-1);
            AutoCompleteDecorator.decorate(cmbCurrency);
        } catch (Exception e) {
        }
    }
    private void getcmbPaymentType() {
        try {
            mapPayment = sm.mapPaymentType();
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
    private void getcmbSalePerson() {
        try {
            mapSaleMan = sm.mapEmp();
            Map<String, Object[]> ms = new TreeMap<>(mapSaleMan);
            cmbSalePerson.removeAllItems();
            ms.keySet().forEach((s) -> {
                cmbSalePerson.addItem(s);
            });
            cmbSalePerson.setSelectedIndex(-1);
            AutoCompleteDecorator.decorate(cmbSalePerson);
        } catch (Exception e) {
        }
    }
    private void calculate() {
        try {
            int rowCount = table.getRowCount();
            double total = 0;
            for (int i = 0; i < rowCount; i++) {
                total += Double.parseDouble(table.getValueAt(i, 6).toString().replace(",", ""));
            }
            float dis = Float.parseFloat(txtDisPC.getText());
            txtDisAmount.setText(String.format("%,.2f", (total * dis) / 100));
            double dam = Double.parseDouble(txtDisAmount.getText().replace(",", ""));
            txtGrandTotal.setText(String.format("%,.2f", total - dam));
            double gt = Double.parseDouble(txtGrandTotal.getText().replace(",", ""));
            float vat = Float.parseFloat(txtVAT.getText().replace(",", ""));
            txtVatAmount.setText(String.format("%,.2f", (gt * vat) / 100));
            double vm = Double.parseDouble(txtVatAmount.getText().replace(",", ""));
            txtSubTotal.setText(String.format("%,.2f", gt - vm));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void clearValues() {
        try {
            int row = table.getRowCount();
            for (int i = 0; i < row; i++) {
                model.setValueAt(null, i, 0);
                model.setValueAt(null, i, 1);
                model.setValueAt(null, i, 2);
                model.setValueAt(null, i, 3);
                model.setValueAt(0.00, i, 4);
                model.setValueAt(0, i, 5);
                model.setValueAt(0.00, i, 6);
            }
            int index = table.getRowCount()-1;
            while(index >9){
                model.removeRow(index--);
            }
            txtSubTotal.setText("0.00");
            txtDisPC.setText("0.00");
            txtDisAmount.setText("0.00");
//            txtVAT.setText("0.00");
            txtVatAmount.setText("0.00");
            txtGrandTotal.setText("0.00");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnMinimize = new javax.swing.JLabel();
        btnExit = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblSaleTitle = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        lblSaleID = new javax.swing.JLabel();
        txtSaleID = new javax.swing.JTextField();
        lblSaleDate = new javax.swing.JLabel();
        lblSalePerson = new javax.swing.JLabel();
        cmbSalePerson = new javax.swing.JComboBox<>();
        txtSaleDate = new com.toedter.calendar.JDateChooser();
        lblPaymentType = new javax.swing.JLabel();
        cmbPaymentType = new javax.swing.JComboBox<>();
        lblSubTotal = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        txtDisAmount = new javax.swing.JTextField();
        lblDiscount = new javax.swing.JLabel();
        txtDisPC = new javax.swing.JTextField();
        lblVAT = new javax.swing.JLabel();
        txtVAT = new javax.swing.JTextField();
        txtVatAmount = new javax.swing.JTextField();
        lblGrandTotal = new javax.swing.JLabel();
        txtGrandTotal = new javax.swing.JTextField();
        lblCurrency = new javax.swing.JLabel();
        cmbCurrency = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JLabel();
        btnNewRow = new javax.swing.JButton();
        btnDeleteRow = new javax.swing.JButton();
        btnVoid = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 15, 255)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

        btnMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Minimize Window_30px.png"))); // NOI18N
        btnMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseClicked(evt);
            }
        });

        btnExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Close Window_30px.png"))); // NOI18N
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });

        jPanel4.setLayout(new java.awt.BorderLayout());

        lblSaleTitle.setBackground(new java.awt.Color(255, 255, 255));
        lblSaleTitle.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblSaleTitle.setForeground(new java.awt.Color(0, 15, 255));
        lblSaleTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSaleTitle.setText("Sale");
        lblSaleTitle.setOpaque(true);
        lblSaleTitle.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lblSaleTitleMouseDragged(evt);
            }
        });
        lblSaleTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSaleTitleMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblSaleTitleMousePressed(evt);
            }
        });
        jPanel4.add(lblSaleTitle, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(2, 2, 2))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N

        table.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, "0.00", "0", "0.00"},
                {null, null, null, null, "0.00", "0", "0.00"},
                {null, null, null, null, "0.00", "0", "0.00"},
                {null, null, null, null, "0.00", "0", "0.00"},
                {null, null, null, null, "0.00", "0", "0.00"},
                {null, null, null, null, "0.00", "0", "0.00"},
                {null, null, null, null, "0.00", "0", "0.00"},
                {null, null, null, null, "0.00", "0", "0.00"},
                {null, null, null, null, "0.00", "0", "0.00"},
                {null, null, null, null, "0.00", "0", "0.00"}
            },
            new String [] {
                "lblID", "lblProductID", "lblProductName", "lblUnit", "lblUnitPrice", "lblUnits", "lblTotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        table.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table.setRowHeight(25);
        table.setSelectionBackground(new java.awt.Color(204, 204, 204));
        table.setSelectionForeground(java.awt.Color.red);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(0);
            table.getColumnModel().getColumn(0).setMaxWidth(0);
            table.getColumnModel().getColumn(1).setMinWidth(120);
            table.getColumnModel().getColumn(1).setMaxWidth(120);
            table.getColumnModel().getColumn(2).setMinWidth(440);
            table.getColumnModel().getColumn(2).setMaxWidth(440);
            table.getColumnModel().getColumn(3).setMinWidth(60);
            table.getColumnModel().getColumn(3).setMaxWidth(60);
            table.getColumnModel().getColumn(4).setMinWidth(135);
            table.getColumnModel().getColumn(4).setMaxWidth(135);
            table.getColumnModel().getColumn(5).setMinWidth(80);
            table.getColumnModel().getColumn(5).setMaxWidth(80);
            table.getColumnModel().getColumn(6).setMinWidth(150);
            table.getColumnModel().getColumn(6).setMaxWidth(150);
        }

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        lblSaleID.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblSaleID.setText("SaleID");
        lblSaleID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSaleIDMouseClicked(evt);
            }
        });

        txtSaleID.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtSaleID.setText("New");
        txtSaleID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(160, 160, 160)));
        txtSaleID.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtSaleID.setEnabled(false);
        txtSaleID.setOpaque(false);

        lblSaleDate.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblSaleDate.setText("Sale Date");
        lblSaleDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSaleDateMouseClicked(evt);
            }
        });

        lblSalePerson.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblSalePerson.setText("Sale Person");
        lblSalePerson.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSalePersonMouseClicked(evt);
            }
        });

        cmbSalePerson.setEditable(true);
        cmbSalePerson.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        cmbSalePerson.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(160, 160, 160)));

        txtSaleDate.setDateFormatString("dd-MM-yyyy");
        txtSaleDate.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N

        lblPaymentType.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblPaymentType.setText("Payment Type");
        lblPaymentType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPaymentTypeMouseClicked(evt);
            }
        });

        cmbPaymentType.setEditable(true);
        cmbPaymentType.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        cmbPaymentType.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(160, 160, 160)));

        lblSubTotal.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblSubTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSubTotal.setText("SubTotal");
        lblSubTotal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSubTotalMouseClicked(evt);
            }
        });

        txtSubTotal.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtSubTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSubTotal.setText("0.00");
        txtSubTotal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(160, 160, 160)));
        txtSubTotal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtSubTotal.setEnabled(false);
        txtSubTotal.setOpaque(false);

        txtDisAmount.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtDisAmount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDisAmount.setText("0.00");
        txtDisAmount.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(160, 160, 160)));
        txtDisAmount.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDisAmount.setEnabled(false);
        txtDisAmount.setOpaque(false);

        lblDiscount.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblDiscount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDiscount.setText("Discount");
        lblDiscount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDiscountMouseClicked(evt);
            }
        });

        txtDisPC.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtDisPC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDisPC.setText("0.00");
        txtDisPC.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(160, 160, 160)));

        lblVAT.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblVAT.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblVAT.setText("VAT");
        lblVAT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVATMouseClicked(evt);
            }
        });

        txtVAT.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtVAT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtVAT.setText("0.00");
        txtVAT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(160, 160, 160)));

        txtVatAmount.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtVatAmount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtVatAmount.setText("0.00");
        txtVatAmount.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(160, 160, 160)));
        txtVatAmount.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtVatAmount.setEnabled(false);
        txtVatAmount.setOpaque(false);

        lblGrandTotal.setFont(new java.awt.Font("Saysettha OT", 0, 48)); // NOI18N
        lblGrandTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGrandTotal.setText("GrandTotal");
        lblGrandTotal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGrandTotalMouseClicked(evt);
            }
        });

        txtGrandTotal.setFont(new java.awt.Font("Saysettha OT", 0, 48)); // NOI18N
        txtGrandTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtGrandTotal.setText("0.00");
        txtGrandTotal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(160, 160, 160)));
        txtGrandTotal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtGrandTotal.setEnabled(false);
        txtGrandTotal.setOpaque(false);
        txtGrandTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGrandTotalActionPerformed(evt);
            }
        });

        lblCurrency.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblCurrency.setText("Currency");
        lblCurrency.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCurrencyMouseClicked(evt);
            }
        });

        cmbCurrency.setEditable(true);
        cmbCurrency.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        cmbCurrency.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(160, 160, 160)));

        btnSave.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        btnSave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSave.setText("Save");
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSave.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSaveMouseMoved(evt);
            }
        });
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaveMouseExited(evt);
            }
        });

        btnNewRow.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNewRow.setText("+");
        btnNewRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewRowActionPerformed(evt);
            }
        });

        btnDeleteRow.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDeleteRow.setText("-");
        btnDeleteRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteRowActionPerformed(evt);
            }
        });

        btnVoid.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        btnVoid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnVoid.setText("Void");
        btnVoid.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVoid.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnVoidMouseMoved(evt);
            }
        });
        btnVoid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVoidMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVoidMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblSaleDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                            .addComponent(lblSaleID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSaleDate, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                            .addComponent(txtSaleID))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblSalePerson, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbSalePerson, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblPaymentType, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbPaymentType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(52, 52, 52)
                        .addComponent(lblCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnNewRow, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(btnDeleteRow, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnVoid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSubTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVAT, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtVAT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtVatAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtDisPC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDisAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSaleID)
                            .addComponent(txtSaleID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSalePerson)
                            .addComponent(cmbSalePerson, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblCurrency)
                        .addComponent(cmbCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSaleDate)
                    .addComponent(txtSaleDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPaymentType)
                    .addComponent(cmbPaymentType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSubTotal)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnNewRow)
                    .addComponent(btnDeleteRow))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDisAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDiscount)
                            .addComponent(txtDisPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtVatAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVAT)
                            .addComponent(txtVAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVoid, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGrandTotal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmbCurrency, cmbSalePerson, lblCurrency, lblSaleDate, lblSaleID, lblSalePerson, txtSaleDate, txtSaleID});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmbPaymentType, lblPaymentType});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblGrandTotal, txtGrandTotal});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnDeleteRow, btnNewRow, btnSave});

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseClicked
        this.setState(FrmSale.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeMouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        try {
            DecimalFormat df = new DecimalFormat("#,##0.00");
            int row = table.getSelectedRow();
            int col = table.getSelectedColumn();
            if (col == 1 && evt.getClickCount() == 2) {
                FrmSearchProduct frmSearch = new FrmSearchProduct(null, rootPaneCheckingEnabled);
                frmSearch.setVisible(true);
                sm.selectItem(sale, prodID);
                model.setValueAt(prodID, row, 1);
                model.setValueAt(sale.getProductName(), row, 2);
                model.setValueAt(sale.getUnitName(), row, 3);
                model.setValueAt(df.format(sale.getPrice()), row, 4);
                model.setValueAt(1, row, 5);
                float qty = Float.parseFloat(table.getValueAt(row, 5).toString());
                model.setValueAt(df.format(sale.getPrice() * qty), row, 6);
                 calculate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tableMouseClicked

    private void txtGrandTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGrandTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGrandTotalActionPerformed

    private void tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyPressed
        try {
            DecimalFormat df = new DecimalFormat("#,##0.00");
            int row = table.getSelectedRow();
            int col = table.getSelectedColumn();
            if (col == 5 && evt.getKeyCode() == KeyEvent.VK_ENTER) {
                float qty = Float.parseFloat(table.getValueAt(row, 5).toString());
                double price = Double.parseDouble(table.getValueAt(row, 4).toString().replace(",", ""));
                model.setValueAt(df.format(price * qty), row, 6);
                calculate();
            } else if (col == 6 && evt.getKeyCode() == KeyEvent.VK_ENTER) {
                
                InputMap im = table.getInputMap();
                im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Action.NextCell");
                im.put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0), "Action.NextCell");
                ActionMap am = table.getActionMap();
                am.put("Action.NextCell", new NextCellActioin(table));
//                Object[] data = new Object[]{null, null, null, 0.00, 0, 0.00};
//                model.addRow(data);
                table.requestFocusInWindow();
                table.changeSelection(table.getRowCount() - 1, 0, false, false);
                table.editCellAt(table.getRowCount() - 1, 0);
                table.setSurrendersFocusOnKeystroke(true);
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tableKeyPressed

    private void tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyReleased
        try {
            if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
                int[] row = table.getSelectedRows();
                for (int i = row.length - 1; i >= 0; i--) {
                    int index = row[i];
                    model.removeRow(index);
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tableKeyReleased

    private void btnSaveMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseMoved
        Border.blueColor(btnSave);
    }//GEN-LAST:event_btnSaveMouseMoved

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("btnSave", frm);
        } else {
            
            FrmSalePayment frmCalculator = new FrmSalePayment(null, rootPaneCheckingEnabled, Double.parseDouble(txtGrandTotal.getText().replace(",", "")));
            frmCalculator.setVisible(true);
            sale.setSaleDate(txtSaleDate.getDate());
            String salePerson = cmbSalePerson.getSelectedItem().toString();
            sale.setSalePerson(mapSaleMan.get(salePerson)[1].toString());
            String currency = cmbCurrency.getSelectedItem().toString();
            sale.setCurrency_L1(mapCurrency.get(currency)[2].toString());
            sale.setCurrency_L2(mapCurrency.get(currency)[3].toString());
            String payment = cmbPaymentType.getSelectedItem().toString();
            sale.setPaymentType_L1(mapPayment.get(payment)[1].toString());
            sale.setPaymentType_L2(mapPayment.get(payment)[2].toString());
            sale.setSubTotal(Double.parseDouble(txtSubTotal.getText().replace(",", "")));
            sale.setDiscountPercentage(Float.parseFloat(txtDisPC.getText().replace(",", "")));
            sale.setDiscountAmount(Double.parseDouble(txtDisAmount.getText().replace(",", "")));
            sale.setVatPercentage(Float.parseFloat(txtVAT.getText().replace(",", "")));
            sale.setVatAmount(Double.parseDouble(txtVatAmount.getText().replace(",", "")));
            sale.setGrandTotal(Double.parseDouble(txtGrandTotal.getText().replace(",", "")));
            sale.setPaidTotal(paid);
            if (sm.insert(sale)) {
                int row = table.getRowCount();
                for (int i = 0; i < row; i++) {
                    double price = Double.parseDouble(table.getValueAt(i, 4).toString().replace(",", ""));
                    if (price > 0) {
                        sale.setProductID(Integer.parseInt(table.getValueAt(i, 1).toString()));
                        sale.setPrice(Double.parseDouble(table.getValueAt(i, 4).toString().replace(",", "")));
                        sale.setQty(Float.parseFloat(table.getValueAt(i, 5).toString().replace(",", "")));
                        sale.setTotal(Double.parseDouble(table.getValueAt(i, 6).toString().replace(",", "")));
                        sm.insertDetails(sale);
                    }
                }
//                MsgBox.msgInfo();
                clearValues();
                sm.printBill(sale);
            }
        }
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseExited
        Border.WhiteColor(btnSave);
    }//GEN-LAST:event_btnSaveMouseExited

    private void btnNewRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewRowActionPerformed
        Object[] data = new Object[]{null, null, null, null, 0.00, 0, 0.00};
        model.addRow(data);
    }//GEN-LAST:event_btnNewRowActionPerformed

    private void btnDeleteRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteRowActionPerformed
        int row = table.getRowCount()-1;
        double a =  Double.parseDouble(table.getValueAt(row, 4).toString().replace(",", ""));
        if(a==0.00){
            model.removeRow(row--);
        }
    }//GEN-LAST:event_btnDeleteRowActionPerformed

    private void btnVoidMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoidMouseMoved
        Border.blueColor(btnVoid);
    }//GEN-LAST:event_btnVoidMouseMoved

    private void btnVoidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoidMouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("btnVoid", frm);
        } else {
            FrmVoidBill frmVoid = new  FrmVoidBill(null, rootPaneCheckingEnabled);
            frmVoid.setVisible(true);
        }
    }//GEN-LAST:event_btnVoidMouseClicked

    private void btnVoidMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoidMouseExited
        Border.WhiteColor(btnVoid);
    }//GEN-LAST:event_btnVoidMouseExited

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        FrameMove.mousePressed(evt);
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        FrameMove.mouseDragded(evt, this);
    }//GEN-LAST:event_formMouseDragged

    private void lblSaleTitleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSaleTitleMouseClicked
         if (evt.getModifiers() == 6) {
            LabelManager.WindowChangeLabel("lblSaleTitle", frm);
        }
    }//GEN-LAST:event_lblSaleTitleMouseClicked

    private void lblSaleIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSaleIDMouseClicked
        if (evt.getModifiers() == 6) {
            LabelManager.WindowChangeLabel("lblSaleID", frm);
        }
    }//GEN-LAST:event_lblSaleIDMouseClicked

    private void lblSalePersonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalePersonMouseClicked
        if (evt.getModifiers() == 6) {
            LabelManager.WindowChangeLabel("lblSalePerson", frm);
        }
    }//GEN-LAST:event_lblSalePersonMouseClicked

    private void lblCurrencyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCurrencyMouseClicked
        if (evt.getModifiers() == 6) {
            LabelManager.WindowChangeLabel("lblCurrency", frm);
        }
    }//GEN-LAST:event_lblCurrencyMouseClicked

    private void lblSaleDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSaleDateMouseClicked
        if (evt.getModifiers() == 6) {
            LabelManager.WindowChangeLabel("lblSaleDate", frm);
        }
    }//GEN-LAST:event_lblSaleDateMouseClicked

    private void lblPaymentTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPaymentTypeMouseClicked
        if (evt.getModifiers() == 6) {
            LabelManager.WindowChangeLabel("lblPaymentType", frm);
        }
    }//GEN-LAST:event_lblPaymentTypeMouseClicked

    private void lblSubTotalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSubTotalMouseClicked
        if (evt.getModifiers() == 6) {
            LabelManager.WindowChangeLabel("lblSubTotal", frm);
        }
    }//GEN-LAST:event_lblSubTotalMouseClicked

    private void lblDiscountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDiscountMouseClicked
        if (evt.getModifiers() == 6) {
            LabelManager.WindowChangeLabel("lblDiscount", frm);
        }
    }//GEN-LAST:event_lblDiscountMouseClicked

    private void lblVATMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVATMouseClicked
        if (evt.getModifiers() == 6) {
            LabelManager.WindowChangeLabel("lblVAT", frm);
        }
    }//GEN-LAST:event_lblVATMouseClicked

    private void lblGrandTotalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGrandTotalMouseClicked
        if (evt.getModifiers() == 6) {
            LabelManager.WindowChangeLabel("lblGrandTotal", frm);
        }
    }//GEN-LAST:event_lblGrandTotalMouseClicked

    private void lblSaleTitleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSaleTitleMouseDragged
        FrameMove.mouseDragded(evt, this);
    }//GEN-LAST:event_lblSaleTitleMouseDragged

    private void lblSaleTitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSaleTitleMousePressed
        FrameMove.mousePressed(evt);
    }//GEN-LAST:event_lblSaleTitleMousePressed

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
            java.util.logging.Logger.getLogger(FrmSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSale().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteRow;
    private javax.swing.JLabel btnExit;
    private javax.swing.JLabel btnMinimize;
    private javax.swing.JButton btnNewRow;
    private javax.swing.JLabel btnSave;
    private javax.swing.JLabel btnVoid;
    private javax.swing.JComboBox<String> cmbCurrency;
    private javax.swing.JComboBox<String> cmbPaymentType;
    private javax.swing.JComboBox<String> cmbSalePerson;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCurrency;
    private javax.swing.JLabel lblDiscount;
    private javax.swing.JLabel lblGrandTotal;
    private javax.swing.JLabel lblPaymentType;
    private javax.swing.JLabel lblSaleDate;
    private javax.swing.JLabel lblSaleID;
    private javax.swing.JLabel lblSalePerson;
    private javax.swing.JLabel lblSaleTitle;
    private javax.swing.JLabel lblSubTotal;
    private javax.swing.JLabel lblVAT;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtDisAmount;
    private javax.swing.JTextField txtDisPC;
    private javax.swing.JTextField txtGrandTotal;
    private com.toedter.calendar.JDateChooser txtSaleDate;
    private javax.swing.JTextField txtSaleID;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtVAT;
    private javax.swing.JTextField txtVatAmount;
    // End of variables declaration//GEN-END:variables
}
