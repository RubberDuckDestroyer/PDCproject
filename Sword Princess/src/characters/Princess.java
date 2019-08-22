/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characters;

import entities.Sword;
import entities.Flower;
import swordprincess.Inventory;
import weaponmenu.WeaponMenu;
import weapons.DefaultSword;
/**
 *
 * @author Patricia Virgen and Hitarth Asrani
 */
public class Princess  
{
    //instance variables 
    private String name;
    private int health;
    private Sword currentSword;
    private Inventory inventory; 
    private int currentNumOfFlowers;
    private boolean isDefeated;
    private int currentRoom;
    private int currentForest;
    private WeaponMenu menu;
    //class constructor
    public Princess(String name, int health, int currentNumOfFlower, Sword startSword)
    {   
        this.name = name;
        this.health = health;
        this.currentNumOfFlowers = currentNumOfFlower;
        this.isDefeated = false;
        this.currentSword = startSword;
        this.inventory = new Inventory();
        this.setCurrentForest(0);
        this.setCurrentRoom(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if(health <=0)
        {
            // Princess defeated
            this.setIsDefeated(true);
            
        }
        else
        {
            this.health = health;
        }
    }

    public Sword getCurrentSword() {
        return currentSword;
    }

    public void setCurrentSword(Sword currentSword) {
        this.currentSword = currentSword;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getCurrentNumOfFlowers() {
        return currentNumOfFlowers;
    }

    public void setCurrentNumOfFlowers(int currentNumOfFlowers) {
        this.currentNumOfFlowers = currentNumOfFlowers;
    }

    public boolean isIsDefeated() {
        return isDefeated;
    }

    public void setIsDefeated(boolean isDefeated) {
        this.isDefeated = isDefeated;
    }

    public int getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(int currentRoom) {
        this.currentRoom = currentRoom;
    }

    public int getCurrentForest() {
        return currentForest;
    }

    public void setCurrentForest(int currentForest) {
        this.currentForest = currentForest;
    }
    
    
    //class methods 
    /**
    *This method will be called when the princess attacks the monster
    * if she wins the number of flowers will increase, and as consequence her health points too
    * else she will have her number of flowers decreased, her health too and if it is 0 she will die the game exits?
    **/
    public int defendAttack(Monster m)
    {
        int monsterDamage = m.getDamage();
        this.setHealth(this.getHealth() - monsterDamage);
        
        return monsterDamage;
    }
    
    
    /**
    *This method assists the princes with collecting the flowers after wining/loosing 
    *
    **/
    public void pickUpFlower(int numOfFlowers)
    {
        Flower f = new Flower("flower");
        this.currentNumOfFlowers += numOfFlowers;
        this.health += (numOfFlowers*f.getHealthRestored());
        
    }
    
    @Override
    public String toString()
    {
        return this.getName();
    }
}

