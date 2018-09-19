
package com.malimar.models;

public class Room {
    int roomID;
    String roomNbr;
    int roomMax;
    public void Room(){
        
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public void setRoomNbr(String roomNbr) {
        this.roomNbr = roomNbr;
    }

    public void setRoomMax(int roomMax) {
        this.roomMax = roomMax;
    }

    public int getRoomID() {
        return roomID;
    }

    public String getRoomNbr() {
        return roomNbr;
    }

    public int getRoomMax() {
        return roomMax;
    }
    
}
