/*
 * 
 *
 *
 */
package characters;

import entities.Sword;
import swordprincess.Inventory;

/**
 *
 * @author Patricia Virgen and Hitarth Asrani
 */
public class Princess  
{
    //instance variables 
    String name;
    int damage;
    int health;
    Sword sword;
    Inventory inventory; 
    int currentNumOfFlower;
    
    //class constructor
    public Princess(String name,int damage, int health, int currentNumOfFlower)
    {   
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.currentNumOfFlower = currentNumOfFlower;
    }
    
    
    //class methods 
    /**
    *This method will be called when the princess attacks the monster
    * if she wins the number of flowers will increase, and as consequence her health points too
    * else she will have her number of flowers decreased, her health too and if it is 0 she will die the game exits?
    **/
    public void attack() // shouldn't it be void instead? since it only performs operations rather than returning something
    {
        
    }
    
    
    /**
    *This method assists the princes with collecting the flowers after wining/loosing 
    *
    **/
    public int pickUpFlpower()
    {
        return 0;
    }




}
