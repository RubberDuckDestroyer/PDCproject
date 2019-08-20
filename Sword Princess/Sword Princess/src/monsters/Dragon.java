/*
 * This class represents one of the monster characters that will attack the princess
 * 
 * 
 */
package monsters;

import characters.Monster;

/**
 *
 * @author Patricia Virgen and Hitarth Asrani
 */
public class Dragon extends Monster
{
    
    //class constructor 
    public Dragon(String description, String name, int damage, int flowerChange, double probAppear) {
        super(description, name, damage, flowerChange, probAppear);
    }

    
    //class methods
    @Override
    public int IncreaseFlower(int flowerChange) 
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
