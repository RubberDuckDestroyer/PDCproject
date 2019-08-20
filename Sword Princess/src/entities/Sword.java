/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author hitar
 */
public abstract class Sword extends Entity {
    
    protected double flowerDropMultiplier;
    protected int golemDamage;
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

    public int getGolemDamage() {
        return golemDamage;
    }

    public void setGolemDamage(int golemDamage) {
        this.golemDamage = golemDamage;
    }

    public int getDragonDamage() {
        return dragonDamage;
    }

    public void setDragonDamage(int dragonDamage) {
        this.dragonDamage = dragonDamage;
    }
    
}
