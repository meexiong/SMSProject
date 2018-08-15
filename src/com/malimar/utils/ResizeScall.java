/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.utils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Malimar
 */
public class ResizeScall {
    public static BufferedImage ResizeScall(Image img, int w, int h){
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
