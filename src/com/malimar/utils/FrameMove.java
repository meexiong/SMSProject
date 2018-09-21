/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.utils;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Malimar
 */
public class FrameMove {

    static int xx = 0;
    static int yy = 0;
    
    public static void mouseDragded(java.awt.event.MouseEvent evt, JFrame fm) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        fm.setLocation(x - xx, y - yy);
    }
    public static void mouseDragded(java.awt.event.MouseEvent evt, JDialog fm) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        fm.setLocation(x - xx, y - yy);
    }
    public static void mousePressed(java.awt.event.MouseEvent evt) {
        xx = evt.getX();
        yy = evt.getY();
    }
}
