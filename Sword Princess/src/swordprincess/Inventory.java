/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swordprincess;

//import entities.Flower;
import entities.Sword;
import static java.lang.System.in;
import java.util.ArrayList;

/**
 *
 * @author hitar
 */
public class Inventory {
    private ArrayList<Sword> swords;
    
    public Inventory()
    {
        swords = new ArrayList<Sword>();
        //flowers = new ArrayList<Flower>();
        
    }
    
    public void addSword(Sword s)
    {
        this.swords.add(s);
    }

    public Sword[] getSwordsArray() {
        Sword[] s = new Sword[this.swords.size()];
        
        for(int i = 0;i<s.length; i++)
        {
            s[i] = this.swords.get(i);
        }
        return s;
    }
    
    public void setSwords(ArrayList<Sword> s)
    {
        this.swords.addAll(s);
    }
    
    @Override 
    public String toString()
    {
        String out = "";
        if(swords.size() == 0)
        {
            out = "no swords in inventory";
        }
        else{
            for(Sword w: swords)
            {
                out+= w+ " ";
            }
        }
        return out;
        
    }
    
    public Sword switchSword(Sword currentSword, int inventoryNumber)
    {
        this.swords.add(currentSword);
        return this.swords.remove(inventoryNumber);
    }
}
