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
public class Flower extends Entity
{
    private static final int FLOWER_HEALTH_RESTORED = 10;
    private int healthRestored;
    private boolean isPickedUp;
    public int getHealthRestored() {
        return healthRestored;
    }

    public void setHealthRestored(int healthRestored) {
        this.healthRestored = healthRestored;
    }
    public Flower(String description) {
        super(description);
        this.healthRestored = FLOWER_HEALTH_RESTORED;
    }
    
}
