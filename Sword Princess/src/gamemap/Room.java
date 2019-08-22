/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemap;

import characters.Monster;
import entities.Entity;
import entities.Flower;
import java.util.ArrayList;

/**
 *
 * @author hitar
 */
public class Room extends Entity
{
    private ArrayList<Monster> monsters;
    private ArrayList<Connect> connecting;
    private int numberOfFlowers;
    private Connect connectRight;
    private Connect connectLeft;
    private Forest ownForest;
    private Forest nextForest;
    private String description;
    private boolean isStartRoom;
    private boolean isFinalGameRoom;
    private boolean isFinalForestRoom;
    public Room(String description) 
    {
        super(description);
        this.ownForest = null;
        this.isStartRoom = false;
        this.isFinalForestRoom = false;
        this.isFinalGameRoom = false;
        this.monsters = new ArrayList<Monster>();
        this.connecting = new ArrayList<Connect>();
        this.connectLeft = null;
        this.connectRight = null;
        this.description = "";
        this.numberOfFlowers = 0;
    }
    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(ArrayList<Monster> monsters) {
        this.monsters = monsters;
    }

    public ArrayList<Connect> getConnecting() {
        return connecting;
    }

    public void setConnecting(ArrayList<Connect> connecting) {
        this.connecting = connecting;
    }

    public Connect getConnectRight() {
        return connectRight;
    }

    public void setConnectRight(Connect connectRight) {
        this.connectRight = connectRight;
    }

    public Connect getConnectLeft() {
        return connectLeft;
    }

    public void setConnectLeft(Connect connectLeft) {
        this.connectLeft = connectLeft;
    }

    public Forest getOwnForest() {
        return ownForest;
    }

    public void setOwnForest(Forest ownForest) {
        this.ownForest = ownForest;
    }

    public Forest getNextForest() {
        return nextForest;
    }

    public void setNextForest(Forest nextForest) {
        this.nextForest = nextForest;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIsStartRoom() {
        return isStartRoom;
    }

    public void setIsStartRoom(boolean isStartRoom) {
        this.isStartRoom = isStartRoom;
    }
    
    public void addMonsterToRoom(Monster m)
    {
        this.monsters.add(m);
    }

    public boolean isIsFinalGameRoom() {
        return isFinalGameRoom;
    }

    public void setIsFinalGameRoom(boolean isFinalGameRoom) {
        this.isFinalGameRoom = isFinalGameRoom;
    }

    public boolean isIsFinalForestRoom() {
        return isFinalForestRoom;
    }

    public void setIsFinalForestRoom(boolean isFinalForestRoom) {
        this.isFinalForestRoom = isFinalForestRoom;
    }

    
    public void addConnecting(String[] connectors)
    {
        System.out.println("gamemap.Room.addConnecting(): Connectors:"+ connectors[0]+ " Length"+ connectors.length);
        for(int i =0;i<connectors.length;i++)
        {
            Connect c = Connect.readLine(connectors[i]);
            System.out.println("Connect c"+ c);
            this.connecting.add(c);         
        }
        
    }
    
    public void addFlowersToRoom(int numberOfFlowers)
    {
        this.numberOfFlowers += numberOfFlowers;
    }

    public int getNumberOfFlowers() {
        return numberOfFlowers;
    }

    public void setNumberOfFlowers(int numberOfFlowers) {
        this.numberOfFlowers = numberOfFlowers;
    }
    
    public Monster getMonster()
    {
        return this.monsters.get(0);
    }
    
    public void printConnectingRooms()
    {
        if(this.connectLeft != null)
        {
            System.out.println("A Room lies on the left.");
        }
        if(this.connectRight != null)
        {
            System.out.println("A Room lies on the right.");
        }
        if(this.connecting != null)
        {
            int size = this.connecting.size();
            Connect nextRoom;
            Connect previousRoom;
            String out="";
                    
            if( this.connecting.get(0)!= null && size == 1)
            {
                nextRoom =this.connecting.get(0);
                if(nextRoom == Connect.forest)
                {
                    out="A forest lies ahed, type \'connect forest\' to move to the next level. You cannot turn back once you switch forests.";
                }
                else
                {
                    out="Room "+nextRoom+ " is the next room."; 
                }
            }
            else{
               previousRoom = this.connecting.get(0);
               nextRoom = this.connecting.get(1);
               
               out = "The previous room is: room"+ previousRoom+". ";
               if(nextRoom == Connect.forest)
               {
                    out+="A forest lies ahed, type \'connect forest\' to move to the next level. You cannot turn back once you switch forests.";
                }
                else
                {
                    out+="Room "+nextRoom+ " is the next room."; 
                }
            }
            
            System.out.println(out);
        }
    }
}
