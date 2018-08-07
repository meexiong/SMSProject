/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.utils;

import AppPackage.AnimationClass;
import javax.swing.JLabel;

/**
 *
 * @author Malimar
 */
public class MenuSlide {

    public static void setMenu(JLabel btn) {
        AnimationClass menuShow = new AnimationClass();
        menuShow.jLabelXRight(-200, 10, 10, 5, btn);
        //<----
        AnimationClass menuHide = new AnimationClass();
        menuHide.jLabelXLeft(10, -200, 10, 5, btn);
    }
}
