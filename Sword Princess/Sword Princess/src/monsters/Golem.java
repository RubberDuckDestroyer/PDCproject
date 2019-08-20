/*
*This class represents one of the momster charactewrs that will attack the princess 
*
*/
package monsters;

import characters.Monster;

/**
 * * This class represents one of the monster characters that will attack the princess

 * @author Patricia Virgen and Hitarth Asrani
 */
public class Golem extends Monster
{
 
    


    //class constructor 
    public Golem(String description, String name, int damage, int flowerChange, double probAppear)
    {
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
