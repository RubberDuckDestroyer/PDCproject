/*
 * This class is the general type of sord
 * 
 * 
 */
package entities;

/**
 *
 * @author  Patricia Virgen  and  Hitarth Asrani   
 */
public abstract class Sword extends Entity {
    
    protected double flowerDropMultiplier;
    protected int monsterDamage; //both Geothern and Golem have the same damage 
    protected int dragonDamage;
    
    public Sword(String description) 
    {
        super(description);
    }
    
    public double getFlowerDropMultiplier() {
        return flowerDropMultiplier;
    }

    public void setFlowerDropMultiplier(double flowerDropMultiplier) {
        this.flowerDropMultiplier = flowerDropMultiplier;
    }

    public int getMonsterDamage() {
        return monsterDamage;
    }

    public void setMonsterDamage(int golemDamage) {
        this.monsterDamage = golemDamage;
    }

    public int getDragonDamage() {
        return dragonDamage;
    }

    public void setDragonDamage(int dragonDamage) {
        this.dragonDamage = dragonDamage;
    }
    
    /***the following methods will be implemented by the subclasses 
     * which are the other types of swords
     * 
     * 
     */
    
    
    public abstract int dealMonsterDamage(int monsterDamage);
    
    public abstract int dealDragonDamage(int DragonDamage);
    
     /**
     * This method multiples the amount of flowers as a consequence of killing the monster 
     */
    public abstract int flowerDecrease(int flowerDropMultiplier);
}
