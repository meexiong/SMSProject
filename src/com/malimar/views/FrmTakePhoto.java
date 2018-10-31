
package com.malimar.views;

import com.malimar.utils.Border;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.malimar.controllers.ExtensionFilter;
import static com.malimar.controllers.LabelManager.LN;
import static com.malimar.controllers.LabelManager.hmapLang;
import com.malimar.controllers.OpenPicture;
import com.malimar.utils.FrameMove;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class FrmTakePhoto extends javax.swing.JDialog {
    Webcam webcam = Webcam.getDefault();
    String frm;
    public FrmTakePhoto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        frm = this.getClass().getSimpleName();
        lblTakePhoto.setText(hmapLang.get("lblTakePhoto".concat(frm).toUpperCase())[LN]);
        btnCapture.setText(hmapLang.get("btnCapture".concat(frm).toUpperCase())[LN]);
        camera();
    }
    private void camera() {
        try {
            webcam.setViewSize(WebcamResolution.VGA.getSize());
            WebcamPanel panel = new WebcamPanel(webcam);
            panel.setFPSDisplayed(true);
            panel.setImageSizeDisplayed(true);
            panel.setMirrored(true);
            JPanel p = new JPanel();
            jPanel2.add(panel);
            this.setSize(new Dimension(500, 500));
            this.setLocationRelativeTo(this);
        } catch (Exception e) {
        }

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnExit = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblTakePhoto = new javax.swing.JLabel();
        btnCapture = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
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

        lblTakePhoto.setBackground(new java.awt.Color(255, 255, 255));
        lblTakePhoto.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblTakePhoto.setForeground(new java.awt.Color(0, 15, 255));
        lblTakePhoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTakePhoto.setText("Take a Photo");
        lblTakePhoto.setOpaque(true);
        lblTakePhoto.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lblTakePhotoMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblTakePhotoMouseMoved(evt);
            }
        });
        lblTakePhoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblTakePhotoMousePressed(evt);
            }
        });
        jPanel6.add(lblTakePhoto, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

        btnCapture.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        btnCapture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCapture.setText("Capture");
        btnCapture.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnCaptureMouseMoved(evt);
            }
        });
        btnCapture.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCaptureMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCaptureMouseExited(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCapture, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCapture)
                .addGap(10, 10, 10))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        webcam.close();
        dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnCaptureMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCaptureMouseMoved
        Border.blueColor(btnCapture);
    }//GEN-LAST:event_btnCaptureMouseMoved

    private void btnCaptureMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCaptureMouseClicked
        try {
            String directory = "src/com/malimar/images/";
            String extension = ".png";
            deleteFileWithExtension(directory, extension);
            OpenPicture.num++;
            //src/com/malimar/logos/picture.png  
            webcam.open();
            // ImageIO.write(webcam.getImage(), "PNG", new File(System.getProperty("user.home")+"/Desktop/picture_"+OpenPicture.num+".png"));
            ImageIO.write(webcam.getImage(), "PNG", new File("src/com/malimar/images/picture_" + OpenPicture.num + ".png"));
            webcam.close();
            this.dispose();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_btnCaptureMouseClicked
    public static void deleteFileWithExtension(String directory, String extension) throws IOException {
        File dir = new File(directory);
        // Listing only files having the extension.
        File[] filesToDelete = dir.listFiles(new ExtensionFilter(extension));
        // Using the custom filenameFilter : ExtensionFilter.
        for (File file : filesToDelete) {
            if (!file.delete()) {
                throw new IOException();
            }
        }
    }
    private void btnCaptureMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCaptureMouseExited
        Border.WhiteColor(btnCapture);
    }//GEN-LAST:event_btnCaptureMouseExited

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
    }//GEN-LAST:event_formWindowOpened

    private void lblTakePhotoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTakePhotoMousePressed
        FrameMove.mousePressed(evt);
    }//GEN-LAST:event_lblTakePhotoMousePressed

    private void lblTakePhotoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTakePhotoMouseMoved
        
    }//GEN-LAST:event_lblTakePhotoMouseMoved

    private void lblTakePhotoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTakePhotoMouseDragged
        FrameMove.mouseDragded(evt, this);
    }//GEN-LAST:event_lblTakePhotoMouseDragged

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
            java.util.logging.Logger.getLogger(FrmTakePhoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTakePhoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTakePhoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTakePhoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmTakePhoto dialog = new FrmTakePhoto(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel btnCapture;
    private javax.swing.JLabel btnExit;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblTakePhoto;
    // End of variables declaration//GEN-END:variables
}
