package characters;

import entities.Entity;

/**
 *This class contains the monsters that will attack the main character: The sword Princess
 * There are two three types of Monsters: Golem, Dragon Geothern. 
 * 
 * 
 * @author Patricia Virgen and Hitarth Asrani
 */
public abstract class Monster extends Entity
{
    
   //class instances
    public String name;
    public int damage;
    public int flowerDrop;
    public int health;
    public  double probAppear;
    public boolean isDefeated;
    //class constructor
    /**Every monster must contain the following:
     **/
    public Monster(String description, String name, int health, int damage, int flowerDrop, double probAppear)
    {
        super(description);
        this.name = name;
        this.damage = damage;
        this.flowerDrop  = flowerDrop;
        this.probAppear = probAppear;
        this.health = health;
    }
    
    
    
    //class methods
    /**
     * This method Increases the amount of flowers as a consequence of killing the monster 
     */
    public abstract int IncreaseFlower(int flowerDrop, Princess player);
    
    /**
     *This method performs the damage to the Princess
     */
    public abstract int Damage();

    /*
    * Sets the name of the monster 
    */
    public abstract String setName();   
    
    
}
