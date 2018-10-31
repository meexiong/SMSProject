/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;


import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
        
public class VideoCap {
    Webcam webcam = Webcam.getDefault();
    public static void main(String args[]) throws IOException {
        Webcam webcam = Webcam.getDefault();
        webcam.setViewSize(WebcamResolution.VGA.getSize());
        WebcamPanel panel = new WebcamPanel(webcam);
        panel.setFPSDisplayed(true);
        panel.setImageSizeDisplayed(true);
        panel.setMirrored(true);
        JPanel p = new JPanel();
        p.add(panel);
        JFrame window = new JFrame("Capture");
        window.add(p);
        window.setResizable(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
//        webcam.open();
//        ImageIO.write(webcam.getImage(), "PNG", new File("hello-world.png"));
    }
}
