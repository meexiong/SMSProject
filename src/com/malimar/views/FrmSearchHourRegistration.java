package com.malimar.views;

import com.malimar.controllers.DatabaseManagerSQL;
import com.malimar.controllers.LabelManager;
import static com.malimar.controllers.LabelManager.LN;
import static com.malimar.controllers.LabelManager.hmapLang;
import com.malimar.controllers.SaleManager;
import com.malimar.controllers.TableAlignmentHeader;
import com.malimar.models.Sale;
import com.malimar.utils.ClearTable;
import com.malimar.utils.FrameMove;
import com.malimar.utils.MsgBox;
import com.malimar.utils.Variables;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class FrmSearchHourRegistration extends javax.swing.JDialog {

    String frm;
    DefaultTableModel model = new DefaultTableModel();
    Connection c = DatabaseManagerSQL.getConnection();

    public FrmSearchHourRegistration(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        frm = this.getClass().getSimpleName();
        table.getTableHeader().setFont(new Font("Saysettha OT", Font.BOLD, 12));
        model = (DefaultTableModel) table.getModel();
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        table.setShowGrid(true);
        table.getTableHeader().setBackground(Color.decode("#4169E1"));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setOpaque(false);
        changeLabel();
        load();
    }

    private void changeLabel() {
        lblSearch.setText(hmapLang.get("lblSearch".concat(frm).toUpperCase())[LN]);
        lblTitle.setText(hmapLang.get("lblTitle".concat(frm).toUpperCase())[LN]);
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
        table.getColumnModel().getColumn(3).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.RIGHT));
        table.getColumnModel().getColumn(4).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.RIGHT));
        DefaultTableCellRenderer RightRenderer = new DefaultTableCellRenderer();
        RightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        table.getColumnModel().getColumn(3).setCellRenderer(RightRenderer);
        table.getColumnModel().getColumn(4).setCellRenderer(RightRenderer);
    }

    private void load() {
        try {
            DecimalFormat df = new DecimalFormat("#,##0.00");
            ClearTable.clearFirstLoad(table, model);
            String query = "SELECT SaleID, Format(SaleDate,'dd/MM/yyyy') as sdate, Currency_" + LabelManager.LangType + " as currency, GrandTotal, PaidTotal\n"
                    + "FROM dbo.tbl_Sale WHERE (Void = 0) ORDER BY SaleDate DESC";
            ResultSet rs = c.createStatement().executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("SaleID");
                String date = rs.getString("sdate");
                String cur = rs.getString("currency");
                double total = rs.getDouble("GrandTotal");
                double paid = rs.getDouble("PaidTotal");
                Object[] obj = new Object[]{id, date, cur, df.format(total), df.format(paid)};
                model.addRow(obj);
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        btnVoid = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnExit1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();

        btnVoid.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        btnVoid.setText("ຍົກເລີກ");
        btnVoid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoidActionPerformed(evt);
            }
        });
        jPopupMenu1.add(btnVoid);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

        btnExit1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnExit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Close Window_30px.png"))); // NOI18N
        btnExit1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExit1MouseClicked(evt);
            }
        });

        jPanel4.setLayout(new java.awt.BorderLayout());

        lblTitle.setBackground(new java.awt.Color(255, 255, 255));
        lblTitle.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 15, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Search Hourly Registration");
        lblTitle.setOpaque(true);
        lblTitle.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lblTitleMouseDragged(evt);
            }
        });
        lblTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTitleMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblTitleMousePressed(evt);
            }
        });
        jPanel4.add(lblTitle, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(btnExit1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnExit1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(2, 2, 2))
        );

        jPanel3.setLayout(new java.awt.BorderLayout());

        table.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "lblBillID", "lblDate", "lblCurrency", "lblTotal", "lblPaid"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        table.setComponentPopupMenu(jPopupMenu1);
        table.setGridColor(new java.awt.Color(204, 204, 204));
        table.setRowHeight(25);
        table.setSelectionBackground(new java.awt.Color(255, 255, 255));
        table.setSelectionForeground(java.awt.Color.red);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(100);
            table.getColumnModel().getColumn(0).setMaxWidth(100);
            table.getColumnModel().getColumn(1).setMinWidth(120);
            table.getColumnModel().getColumn(1).setMaxWidth(120);
            table.getColumnModel().getColumn(2).setMinWidth(110);
            table.getColumnModel().getColumn(2).setMaxWidth(110);
            table.getColumnModel().getColumn(3).setMinWidth(170);
            table.getColumnModel().getColumn(3).setMaxWidth(170);
            table.getColumnModel().getColumn(4).setMinWidth(170);
            table.getColumnModel().getColumn(4).setMaxWidth(170);
        }

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        lblSearch.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblSearch.setText("Search");

        txtSearch.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(160, 160, 160)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSearch)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExit1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExit1MouseClicked
        dispose();
    }//GEN-LAST:event_btnExit1MouseClicked

    private void lblTitleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTitleMouseDragged
        FrameMove.mouseDragded(evt, this);
    }//GEN-LAST:event_lblTitleMouseDragged

    private void lblTitleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTitleMouseClicked
        if (evt.getModifiers() == 6) {
            LabelManager.WindowChangeLabel("lblTitle", frm);
        }
    }//GEN-LAST:event_lblTitleMouseClicked

    private void lblTitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTitleMousePressed
        FrameMove.mousePressed(evt);
    }//GEN-LAST:event_lblTitleMousePressed

    private void tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMousePressed
        try {
            if (evt.getClickCount() == 2) {
                int row = table.getSelectedRow();
                int id = Integer.parseInt(table.getValueAt(row, 0).toString());
                Variables.billID = id;
                this.dispose();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tableMousePressed

    private void btnVoidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoidActionPerformed
        try {
            Sale s = new Sale();
            SaleManager sm = new SaleManager();
            int row = table.getSelectedRow();
            int saleid = Integer.parseInt(table.getValueAt(row, 0).toString());
            s.setSaleid(saleid);
            s.setLoginBy(FrmMain.userNbr);
            s.setVoidDate(new Date());
            if(MsgBox.msgConfirm()==true){
                sm.cancelBill(s);
                load();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnVoidActionPerformed

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
            java.util.logging.Logger.getLogger(FrmSearchHourRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSearchHourRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSearchHourRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSearchHourRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmSearchHourRegistration dialog = new FrmSearchHourRegistration(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel btnExit1;
    private javax.swing.JMenuItem btnVoid;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
