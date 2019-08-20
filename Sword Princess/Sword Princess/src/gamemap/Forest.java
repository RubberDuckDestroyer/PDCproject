/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemap;

import entities.Entity;

/**
 *
 * @author Patricia Virgen and Hitarth Asrani
 */
public class Forest extends Entity
{
    private Room[] rooms;
    private int numberOfRooms;

    public Forest(String description) {
        super(description);
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
    
    
}
