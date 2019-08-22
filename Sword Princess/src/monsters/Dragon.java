/*
 * This class represents one of the monster characters that will attack the princess
 * 
 * 
 */
package monsters;

import characters.Monster;
import characters.Princess;

/**
 *
 * @author Patricia Virgen and Hitarth Asrani
 */
public class Dragon extends Monster
{
    
    //class constructor 
    public Dragon(String description, String name, int damage, int flowerChange, double probAppear, int health) {
        super(description, name, health, damage, flowerChange, probAppear);
    }
    
    @Override
    protected int defendAttack(Princess player)
    {
        int playerDamage = player.getCurrentSword().getDragonDamage();
        this.setHealth(this.getHealth() - playerDamage);
        return playerDamage;
    }
    
    
    public void dragonDefeated()
    {
        if(this.isDefeated)
        {
            //Method for turning into cat.
        }
    }
    //class methods
    @Override
    public int IncreaseFlower(int flowerDrop, Princess player) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Damage() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String setName() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
