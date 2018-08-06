/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import com.malimar.models.Student;

/**
 *
 * @author Malimar
 */
public class StudentController {
    
    public static void main(String[] args) {
        Student st1 = new Student();

        
        
        st1.setStdID(1);
        st1.setStdNbr("001");
        st1.setStdName_L2("sss");
        st1.setStdName_L1("khammao");
        
        System.out.println(""+st1.getStdID()+", "+st1.getStdNbr()+", "+st1.getStdName_L1());
    }
   
}
