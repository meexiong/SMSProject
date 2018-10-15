
package com.malimar.views;

import static com.malimar.controllers.LabelManager.LN;
import static com.malimar.controllers.LabelManager.WindowChangeLabel;
import static com.malimar.controllers.LabelManager.hmapLang;
import com.malimar.controllers.OpenPicture;
import static com.malimar.controllers.OpenPicture.imagePath;
import com.malimar.controllers.ProductManager;
import com.malimar.controllers.UserPermission;
import com.malimar.models.Product;
import com.malimar.utils.Border;
import com.malimar.utils.FrameMove;
import com.malimar.utils.MsgBox;
import static com.malimar.views.FrmMain.userNbr;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.ImageIcon;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class FrmNewProduct extends javax.swing.JDialog {
    String frm;
    Product pd = new Product();
    ProductManager pm = new ProductManager();
    HashMap<String, Object[]>mapUnit = null;
    public FrmNewProduct(java.awt.Frame parent, boolean modal, int pid) {
        super(parent, modal);
        initComponents();
        getcmbUnit();
        if(pid !=0){
            txtProductID.setText(String.valueOf(pid));
            load();
        }
        frm=this.getClass().getSimpleName();
        lblNewProduct.setText(hmapLang.get("lblNewProduct".concat(frm).toUpperCase())[LN]);
        lblProductID.setText(hmapLang.get("lblProductID".concat(frm).toUpperCase())[LN]);
        lblProductName_L1.setText(hmapLang.get("lblProductName_L1".concat(frm).toUpperCase())[LN]);
        lblProductName_L2.setText(hmapLang.get("lblProductName_L2".concat(frm).toUpperCase())[LN]);
        lblBarcode.setText(hmapLang.get("lblBarcode".concat(frm).toUpperCase())[LN]);
        lblCost.setText(hmapLang.get("lblCost".concat(frm).toUpperCase())[LN]);
        lblPrice.setText(hmapLang.get("lblPrice".concat(frm).toUpperCase())[LN]);
        lblQuantity.setText(hmapLang.get("lblQuantity".concat(frm).toUpperCase())[LN]);
        lblInActive.setText(hmapLang.get("lblInActive".concat(frm).toUpperCase())[LN]);
        lblDescription.setText(hmapLang.get("lblDescription".concat(frm).toUpperCase())[LN]);
        lblImage.setText(hmapLang.get("lblImage".concat(frm).toUpperCase())[LN]);
        btnSave.setText(hmapLang.get("btnSave".concat(frm).toUpperCase())[LN]);
        lblCurrency.setText(hmapLang.get("lblCurrency".concat(frm).toUpperCase())[LN]);
        lblCurrency1.setText(hmapLang.get("lblCurrency".concat(frm).toUpperCase())[LN]);
        lblUnit.setText(hmapLang.get("lblUnit".concat(frm).toUpperCase())[LN]);
        chInActive.setSelected(true);
        UserPermission.getPermission_S(userNbr, frm, btnSave);
    }
    private void clear(){
        txtProductID.setText("New");
        txtProductName_L1.setText("");
        txtProductName_L2.setText("");
        txtBarcode.setText("");
        txtCost.setText("0.00");
        txtPrice.setText("0.00");
        txtQuantity.setText("0.00");
        chInActive.setSelected(true);
        txtDescription.setText("");
        lblImage.setIcon(null);
        lblImage.setText(hmapLang.get("lblImage".concat(frm).toUpperCase())[LN]);
        cmbUnit.setSelectedIndex(-1);
    }
    private void getcmbUnit() {
        try {
            mapUnit = pm.mapUnit();
            Map<String, Object[]> ms = new TreeMap<>(mapUnit);
            cmbUnit.removeAllItems();
            ms.keySet().forEach((s) -> {
                cmbUnit.addItem(s);
            });
            cmbUnit.setSelectedIndex(-1);
            AutoCompleteDecorator.decorate(cmbUnit);
        } catch (Exception e) {
        }
    }
    private void load(){
        pd.setProductID(Integer.parseInt(txtProductID.getText()));
        pm.loadEdit(pd);
        txtProductName_L1.setText(pd.getProductName_L1());
        txtProductName_L2.setText(pd.getProductName_L2());
        txtBarcode.setText(pd.getBarcode());
        txtCost.setText(String.format("%,.2f", pd.getCost()));
        txtPrice.setText(String.format("%,.2f", pd.getPrice()));
        txtQuantity.setText(String.valueOf(pd.getQuantity()));
        chInActive.setSelected(pd.isChInActive());
        txtDescription.setText(pd.getDescription());
        cmbUnit.setSelectedItem(pd.getUnitName());
        if (pd.getPicture() != null) {
            Image img1 = new ImageIcon(pd.getPicture()).getImage();
            Image ic = OpenPicture.ResizeScall(img1, lblImage.getWidth(), lblImage.getHeight());
            lblImage.setIcon(new ImageIcon(ic));
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnExit = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblNewProduct = new javax.swing.JLabel();
        lblProductID = new javax.swing.JLabel();
        txtProductID = new javax.swing.JTextField();
        txtProductName_L1 = new javax.swing.JTextField();
        lblProductName_L1 = new javax.swing.JLabel();
        txtProductName_L2 = new javax.swing.JTextField();
        lblProductName_L2 = new javax.swing.JLabel();
        lblBarcode = new javax.swing.JLabel();
        txtBarcode = new javax.swing.JTextField();
        lblCost = new javax.swing.JLabel();
        txtCost = new javax.swing.JTextField();
        lblPrice = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        lblQuantity = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        lblDescription = new javax.swing.JLabel();
        lblInActive = new javax.swing.JLabel();
        chInActive = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        btnSave = new javax.swing.JLabel();
        lblCurrency = new javax.swing.JLabel();
        lblCurrency1 = new javax.swing.JLabel();
        lblUnit = new javax.swing.JLabel();
        cmbUnit = new javax.swing.JComboBox<>();

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

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

        btnExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Close Window_30px.png"))); // NOI18N
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });

        jPanel6.setLayout(new java.awt.BorderLayout());

        lblNewProduct.setBackground(new java.awt.Color(255, 255, 255));
        lblNewProduct.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblNewProduct.setForeground(new java.awt.Color(0, 15, 255));
        lblNewProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNewProduct.setText("New Product");
        lblNewProduct.setOpaque(true);
        lblNewProduct.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lblNewProductMouseDragged(evt);
            }
        });
        lblNewProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNewProductMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblNewProductMousePressed(evt);
            }
        });
        jPanel6.add(lblNewProduct, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(2, 2, 2))
        );

        lblProductID.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblProductID.setText("ProductID");

        txtProductID.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtProductID.setText("New");
        txtProductID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(160, 160, 160)));
        txtProductID.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtProductID.setEnabled(false);
        txtProductID.setOpaque(false);

        txtProductName_L1.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtProductName_L1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(160, 160, 160)));

        lblProductName_L1.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblProductName_L1.setText("Product Name(Lao)");
        lblProductName_L1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblProductName_L1MouseClicked(evt);
            }
        });

        txtProductName_L2.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtProductName_L2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(160, 160, 160)));

        lblProductName_L2.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblProductName_L2.setText("Product Name(En)");
        lblProductName_L2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblProductName_L2MouseClicked(evt);
            }
        });

        lblBarcode.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblBarcode.setText("Barcode");
        lblBarcode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBarcodeMouseClicked(evt);
            }
        });

        txtBarcode.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtBarcode.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(160, 160, 160)));

        lblCost.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblCost.setText("Cost");
        lblCost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCostMouseClicked(evt);
            }
        });

        txtCost.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtCost.setText("0.00");
        txtCost.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(160, 160, 160)));
        txtCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostActionPerformed(evt);
            }
        });

        lblPrice.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblPrice.setText("Price");
        lblPrice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPriceMouseClicked(evt);
            }
        });

        txtPrice.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtPrice.setText("0.00");
        txtPrice.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(160, 160, 160)));
        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });

        lblQuantity.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblQuantity.setText("Quantity");
        lblQuantity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuantityMouseClicked(evt);
            }
        });

        txtQuantity.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtQuantity.setText("0.00");
        txtQuantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(160, 160, 160)));

        lblDescription.setBackground(new java.awt.Color(0, 15, 255));
        lblDescription.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblDescription.setForeground(new java.awt.Color(255, 255, 255));
        lblDescription.setText("Description");
        lblDescription.setOpaque(true);
        lblDescription.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDescriptionMouseClicked(evt);
            }
        });

        lblInActive.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblInActive.setText("InActive");
        lblInActive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblInActiveMouseClicked(evt);
            }
        });

        chInActive.setBackground(new java.awt.Color(255, 255, 255));
        chInActive.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        chInActive.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtDescription.setColumns(20);
        txtDescription.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel2.setLayout(new java.awt.BorderLayout());

        lblImage.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setText("Image");
        lblImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImageMouseClicked(evt);
            }
        });
        jPanel2.add(lblImage, java.awt.BorderLayout.CENTER);

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

        lblCurrency.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblCurrency.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCurrency.setText("LAK");
        lblCurrency.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCurrencyMouseClicked(evt);
            }
        });

        lblCurrency1.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblCurrency1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCurrency1.setText("LAK");
        lblCurrency1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCurrency1MouseClicked(evt);
            }
        });

        lblUnit.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblUnit.setText("Unit");
        lblUnit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUnitMouseClicked(evt);
            }
        });

        cmbUnit.setEditable(true);
        cmbUnit.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblProductID, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblProductName_L1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtProductID, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtProductName_L1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblProductName_L2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtProductName_L2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblCurrency1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblInActive, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(chInActive))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblCost, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmbUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductID)
                    .addComponent(txtProductID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductName_L1)
                    .addComponent(txtProductName_L1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductName_L2)
                    .addComponent(txtProductName_L2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBarcode)
                    .addComponent(txtBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCost)
                    .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCurrency))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrice)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCurrency1))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantity)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUnit)
                    .addComponent(cmbUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInActive)
                    .addComponent(chInActive))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDescription)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void lblNewProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNewProductMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblNewProduct", frm);
        }
    }//GEN-LAST:event_lblNewProductMouseClicked

    private void btnSaveMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseMoved
        Border.blueColor(btnSave);
    }//GEN-LAST:event_btnSaveMouseMoved

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("btnSave", frm);
        }else{
            pd.setProductName_L1(txtProductName_L1.getText().trim());
            pd.setProductName_L2(txtProductName_L2.getText().trim());
            pd.setDescription(txtDescription.getText().trim());
            pd.setBarcode(txtBarcode.getText().trim());
            pd.setCost(Double.parseDouble(txtCost.getText().replace(",", "")));
            pd.setPrice(Double.parseDouble(txtPrice.getText().replace(",", "")));
            pd.setQuantity(Integer.parseInt(txtQuantity.getText()));
            pd.setChInActive(chInActive.isSelected());
            pd.setPath(imagePath);
            String unit = cmbUnit.getSelectedItem().toString();
            pd.setUnitName_L1(mapUnit.get(unit)[1].toString());
            pd.setUnitName_L2(mapUnit.get(unit)[2].toString());
            if (txtProductID.getText().equals("New")) {
                if (pm.insert(pd)) {
                    MsgBox.msgInfo();
                }
            } else {
                pd.setProductID(Integer.parseInt(txtProductID.getText()));
                if(pm.update(pd)){
                    if(pd.getPath() !=null){
                        pm.updateImage(pd);
                    }
                    MsgBox.msgInfo();
                }
            }
            clear();
        }
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseExited
        Border.WhiteColor(btnSave);
    }//GEN-LAST:event_btnSaveMouseExited

    private void txtCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostActionPerformed
       if ("".equals(txtCost.getText())) {
            txtCost.setText("0.00");
        } else {
            double a = Double.parseDouble(txtCost.getText().replace(",", ""));
            txtCost.setText(String.valueOf(String.format("%,.2f", a)));
        }
    }//GEN-LAST:event_txtCostActionPerformed

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        if ("".equals(txtPrice.getText())) {
            txtPrice.setText("0.00");
        } else {
            double a = Double.parseDouble(txtPrice.getText().replace(",", ""));
            txtPrice.setText(String.valueOf(String.format("%,.2f", a)));
        }
    }//GEN-LAST:event_txtPriceActionPerformed

    private void lblImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImageMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblImage", frm);
        }else if(evt.getClickCount()==2){
            lblImage.setText("");
            lblImage.setIcon(OpenPicture.getImage(lblImage.getWidth(), lblImage.getHeight()));
        }
    }//GEN-LAST:event_lblImageMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        FrameMove.mousePressed(evt);
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        FrameMove.mouseDragded(evt, this);
    }//GEN-LAST:event_formMouseDragged

    private void lblProductName_L1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProductName_L1MouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblProductName_L1", frm);
        }
    }//GEN-LAST:event_lblProductName_L1MouseClicked

    private void lblProductName_L2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProductName_L2MouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblProductName_L2", frm);
        }
    }//GEN-LAST:event_lblProductName_L2MouseClicked

    private void lblBarcodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBarcodeMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblBarcode", frm);
        }
    }//GEN-LAST:event_lblBarcodeMouseClicked

    private void lblCostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCostMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblCost", frm);
        }
    }//GEN-LAST:event_lblCostMouseClicked

    private void lblPriceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPriceMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblPrice", frm);
        }
    }//GEN-LAST:event_lblPriceMouseClicked

    private void lblQuantityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuantityMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblQuantity", frm);
        }
    }//GEN-LAST:event_lblQuantityMouseClicked

    private void lblUnitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUnitMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblUnit", frm);
        }
    }//GEN-LAST:event_lblUnitMouseClicked

    private void lblInActiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInActiveMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblInActive", frm);
        }
    }//GEN-LAST:event_lblInActiveMouseClicked

    private void lblDescriptionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDescriptionMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblDescription", frm);
        }
    }//GEN-LAST:event_lblDescriptionMouseClicked

    private void lblCurrencyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCurrencyMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblCurrency", frm);
        }
    }//GEN-LAST:event_lblCurrencyMouseClicked

    private void lblCurrency1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCurrency1MouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblCurrency", frm);
        }
    }//GEN-LAST:event_lblCurrency1MouseClicked

    private void lblNewProductMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNewProductMousePressed
        FrameMove.mousePressed(evt);
    }//GEN-LAST:event_lblNewProductMousePressed

    private void lblNewProductMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNewProductMouseDragged
        FrameMove.mouseDragded(evt, this);
    }//GEN-LAST:event_lblNewProductMouseDragged

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
            java.util.logging.Logger.getLogger(FrmNewProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmNewProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmNewProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmNewProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmNewProduct dialog = new FrmNewProduct(new javax.swing.JFrame(), true,0);
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
    private javax.swing.JLabel btnSave;
    private javax.swing.JCheckBox chInActive;
    private javax.swing.JComboBox<String> cmbUnit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBarcode;
    private javax.swing.JLabel lblCost;
    private javax.swing.JLabel lblCurrency;
    private javax.swing.JLabel lblCurrency1;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblInActive;
    private javax.swing.JLabel lblNewProduct;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblProductID;
    private javax.swing.JLabel lblProductName_L1;
    private javax.swing.JLabel lblProductName_L2;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblUnit;
    private javax.swing.JTextField txtBarcode;
    private javax.swing.JTextField txtCost;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProductID;
    private javax.swing.JTextField txtProductName_L1;
    private javax.swing.JTextField txtProductName_L2;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
