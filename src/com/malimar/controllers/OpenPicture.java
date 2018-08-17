
package com.malimar.controllers;

import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author Malimar
 */
public class OpenPicture {
    public static String imagePath=null;
    public static ImageIcon getImage(int w, int h) {
        try {
            JFileChooser choose = new JFileChooser();
            choose.showOpenDialog(null);
            File f = choose.getSelectedFile();
            if (f !=null) {
                imagePath = choose.getSelectedFile().getAbsolutePath();
                Image img = new ImageIcon(imagePath).getImage();
                Image ic = ResizeScall(img, w, h);
                return new ImageIcon(ic);
            }
        } catch (HeadlessException e) {
        }
        return null;
    }

    public static BufferedImage ResizeScall(Image img, int w, int h) {
        try {
            BufferedImage ims  = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = ims.createGraphics();
            g.drawImage(img,0,0,w,h,null);
            g.dispose();
            return ims;            
            
        } catch (Exception e) {
        }
        return null;
    }
}
