/***
 * This class: kills easier but lesser flowers dropped.
 * 
 * 
 * @author Patricia Virgen  and  Hitarth Asrani   
 ***/
package weapons;

import entities.Sword;


public class FireSword extends Sword{
    
    //class instance variables
    
    
    //class constructors

    public FireSword(String description) {
        super(description);
    }

    //class methods
    @Override
    public int dealMonsterDamage(int monsterDamage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int dealDragonDamage(int DragonDamage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int flowerDecrease(int flowerDropMultiplier) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
