/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.models;

/**
 *
 * @author Malimar
 */
public class Relationship {
    int id;
    String Relationship_L1;
    String Relationship_L2;

    public void setId(int id) {
        this.id = id;
    }

    public void setRelationship_L1(String Relationship_L1) {
        this.Relationship_L1 = Relationship_L1;
    }

    public void setRelationship_L2(String Relationship_L2) {
        this.Relationship_L2 = Relationship_L2;
    }

    public int getId() {
        return id;
    }

    public String getRelationship_L1() {
        return Relationship_L1;
    }

    public String getRelationship_L2() {
        return Relationship_L2;
    }
    
    
}
