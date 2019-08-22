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
    
    protected int flowerDropMultiplier;
    protected int monsterDamage; //both Geothern and Golem have the same damage 
    protected int dragonDamage;
    protected boolean isPurchased;

    public Sword(int flowerDropMultiplier, int monsterDamage, int dragonDamage, boolean isPurchased, String description) {
        super(description);
        this.flowerDropMultiplier = flowerDropMultiplier;
        this.monsterDamage = monsterDamage;
        this.dragonDamage = dragonDamage;
        this.isPurchased = isPurchased;
    }

    public int getFlowerDropMultiplier() {
        return flowerDropMultiplier;
    }

    public void setFlowerDropMultiplier(int flowerDropMultiplier) {
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

    public boolean isIsPurchased() {
        return isPurchased;
    }

    public void setIsPurchased(boolean isPurchased) {
        this.isPurchased = isPurchased;
    }
    
    
    /***the following methods will be implemented by the subclasses 
     * which are the other types of swords
     * 
     * 
     */
    
    /*
    public abstract int dealMonsterDamage(int monsterDamage);
    int monsterDamage
    public abstract int dealDragonDamage(int DragonDamage);
    
     /**
     * This method multiples the amount of flowers as a consequence of killing the monster 
     
    public abstract int flowerDecrease(int flowerDropMultiplier);
    */
}
