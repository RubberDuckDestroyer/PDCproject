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
    public int defendAttack(Princess player)
    {
        int playerDamage = player.getCurrentSword().getDragonDamage();
        this.setHealth(this.getHealth() - playerDamage);
        return playerDamage;
    }
    
    
    public boolean dragonDefeated()
    {
        if(this.isDefeated)
        {
            System.out.println("Congratulations, you defeated the dragon and it turned into a pet cat. Sword Princess can now go home with her pet cat!");
        }
        
        return false;
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
