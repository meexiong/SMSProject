/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import static com.malimar.controllers.LabelManager.LangType;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Malimar
 */
public class AttachFile {
    public static void openFile(String sql,String col){
        try {
            Connection conn = DatabaseManagerSQL.getConnection();
            Statement statement = null;
            ResultSet rs = null;
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            if (rs.next()){
            String filename = "AttachFile.pdf";
            Blob blob = rs.getBlob(col);
            InputStream is = blob.getBinaryStream();
            FileOutputStream fos = new FileOutputStream("C:\\Conn\\"+ filename);
            int b = 0;
            while ((b = is.read()) != -1)
            {
                fos.write(b); 
            }
            fos.close();
            }
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(new File("C:\\Conn\\AttachFile.pdf"));
            }
        } catch (Exception e) {
        }
    }
    public static void saveAttachFile(String sql,int id){
        try {
            try (Connection conn = DatabaseManagerSQL.getConnection()) {
                JLabel lbgetpath = new JLabel();
                ResultSet rs = null;
                FileInputStream fis;
                PreparedStatement psmnt = null;
                JFileChooser choose = new JFileChooser(lbgetpath.getText() + "\\*.pdf");
                FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF FILES", ".pdf", "pdf");
                choose.setAcceptAllFileFilterUsed(false);
                
                choose.setFileFilter(filter);
                choose.showOpenDialog(null);
                File image = new File(choose.getSelectedFile().getAbsolutePath());
                psmnt = conn.prepareStatement(sql);
                fis = new FileInputStream(image);
                psmnt.setBinaryStream(1, (InputStream) fis, (int) (image.length()));
                psmnt.setInt(2, id);
                int s = psmnt.executeUpdate();
                if (s > 0) {
                    if ("L1".equals(LangType)) {
                        JOptionPane.showMessageDialog(null, "<html><p><font color=\"#000\"size=\"3\" face=\"Saysettha OT\">" + "ສຳເລັດ..!" + "</font></p></html>", "ແຈ້ງເຕືອນ", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "<html><p><font color=\"#000\"size=\"3\" face=\"Saysettha OT\">" + "Succce..!" + "</font></p></html>", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                } else {
                    if ("L1".equals(LangType)) {
                        JOptionPane.showMessageDialog(null, "<html><p><font color=\"#000\"size=\"3\" face=\"Saysettha OT\">" + "ບໍ່ສຳເລັດ..!" + "</font></p></html>", "ແຈ້ງເຕືອນ", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "<html><p><font color=\"#000\"size=\"3\" face=\"Saysettha OT\">" + "Unsuccce..!" + "</font></p></html>", "MESSAGE", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (Exception e) {
        }
    }
}
