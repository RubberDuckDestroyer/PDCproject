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
    public double probAppear;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getFlowerDrop() {
        return flowerDrop;
    }

    public void setFlowerDrop(int flowerDrop) {
        this.flowerDrop = flowerDrop;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if(health <=0)
        {
            this.setIsDefeated(true);
            //Drop flower?
        }
        else{
            this.health = health;
        }
    }

    public double getProbAppear() {
        return probAppear;
    }

    public void setProbAppear(double probAppear) {
        this.probAppear = probAppear;
    }

    public boolean isIsDefeated() {
        return isDefeated;
    }

    public void setIsDefeated(boolean isDefeated) {
        this.isDefeated = isDefeated;
    }
    
    protected int defendAttack(Princess player)
    {
        int playerDamage = player.getCurrentSword().getMonsterDamage();
        this.setHealth(this.getHealth() - playerDamage);
        return playerDamage;
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
