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
public class Geothern extends Monster
{
    
    
    //class constructor 
    public Geothern(String description, String name, int damage, int flowerChange, double probAppear, int health) {
        super(description, name, health, damage, flowerChange, probAppear);
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