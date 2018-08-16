/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.utils;

import static com.malimar.controllers.LabelManager.LangType;
import static com.malimar.utils.EnumType.L1;
import javax.swing.JOptionPane;

/**
 *
 * @author Malimar
 */
public class MsgBox {
     public static void msgInfo() {
         
        if ("L1".equals(LangType)) {
            JOptionPane.showMessageDialog(null, "<html><p><font color=\"#000\"size=\"3\" face=\"Saysettha OT\">" + "ສໍາເລັດ" + "</font></p></html>", "ແຈ້ງເຕືອນ", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "<html><p><font color=\"#000\"size=\"3\" face=\"Saysettha OT\">" + "Sucessful" + "</font></p></html>", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void msgWarning() {
        if ("L1".equals(LangType)) {
            JOptionPane.showMessageDialog(null, "<html><p><font color=\"#000\"size=\"3\" face=\"Saysettha OT\">" + "ລົ້ມເຫຼວ" + "</font></p></html>", "ແຈ້ງເຕືອນ", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "<html><p><font color=\"#000\"size=\"3\" face=\"Saysettha OT\">" + "Failed" + "</font></p></html>", "MESSAGE", JOptionPane.WARNING_MESSAGE);
        }
    }
    public static void msgError() {
        if ("L1".equals(LangType)) {
            JOptionPane.showMessageDialog(null, "<html><p><font color=\"#000\"size=\"3\" face=\"Saysettha OT\">" + "ການລຸນາກວດສອບໃໝ່" + "</font></p></html>", "ແຈ້ງເຕືອນ", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "<html><p><font color=\"#000\"size=\"3\" face=\"Saysettha OT\">" + "Plese check data again" + "</font></p></html>", "MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
    }
   public static boolean msgQuestion(){
        if ("L1".equals(LangType)) {
            int joption = JOptionPane.showConfirmDialog(null,  "<html><p><font color=\"#000\"size=\"3\" face=\"Saysettha OT\">" + "ທ່ານຕ້ອງການລົບບໍ?" + "</font></p></html>", "ແຈ້ງເຕືອນ",JOptionPane.YES_NO_OPTION);
            if(joption==0){
                return true;
            }
        }else{
           int joption = JOptionPane.showConfirmDialog(null,  "<html><p><font color=\"#000\"size=\"3\" face=\"Saysettha OT\">" + "Do you want to Delete?" + "</font></p></html>", "MESSAGE",JOptionPane.YES_NO_OPTION);
            if(joption==0){
                return true;
            } 
        }
        return false;
   }
}
