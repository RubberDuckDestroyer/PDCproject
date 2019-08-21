/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemap;

import entities.Entity;

/**
 *
 * @author hitar
 */
public class Forest extends Entity
{
    private Room[] rooms;
    private int numberOfRooms;
    private boolean isStartforest;
    private boolean isEndforest;
    
    public Forest(String description) {
        super(description);
        this.numberOfRooms = 0;
        this.rooms = null;
        this.isEndforest = false;
        this.isStartforest = false;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public boolean isIsStartforest() {
        return isStartforest;
    }

    public void setIsStartforest(boolean isStartforest) {
        this.isStartforest = isStartforest;
    }

    public boolean isIsEndforest() {
        return isEndforest;
    }

    public void setIsEndforest(boolean isEndForest) {
        this.isEndforest = isEndForest;
    }
    
    
}
