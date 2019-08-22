/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weaponmenu;

import entities.Sword;
import java.util.ArrayList;

/**
 *
 * @author Patricia Virgen and Hitarth Asrani
 */
public class WeaponMenu 
{
    private ArrayList<Sword> swordList;
    private ArrayList<Integer> swordCost;
    
    public WeaponMenu()
    {
        this.swordList = new ArrayList<Sword>();
        this.swordCost = new ArrayList<Integer>();
    }
    
    public void addWeapon(Sword weapon, int cost)
    {
        this.swordList.add(weapon);
        this.swordCost.add(cost);
    }

    public ArrayList<Sword> getSwordList() {
        return swordList;
    }

    public void setSwordList(ArrayList<Sword> swordList) {
        this.swordList = swordList;
    }

    public ArrayList<Integer> getSwordCost() {
        return swordCost;
    }

    public void setSwordCost(ArrayList<Integer> swordCost) {
        this.swordCost = swordCost;
    }
    
    public void printWeaponMenu(int numberOfFlowers)
    {
        int length = swordCost.size();
        if(length == swordList.size())
        {
            System.out.println("---Weapon Menu---");
            for(int i =0;i<length;i++)
            {
                Sword sword = this.swordList.get(i);
                int cost = this.swordCost.get(i);
                System.out.println( sword +" : "+ cost +" flowers. Bought: " +sword.isIsPurchased());
                System.out.println("Description: "+ sword.getRoomDescription());
            }
            System.out.println("--------------");
            System.out.println("To buy a sword, type \'buy <swordname>\', for example \'buy fire\' to buy the fire sword. Current number of flowers: "+ numberOfFlowers);
            System.out.println("To equip a sword, type equip followed by the sword name");
        }
            
    }

    public Sword getDefaultSword()
    {
        return swordList.get(0);
    }
    
    public int buyWeapon(int weaponNumber)
    {
        
        Sword swordToBuy = swordList.get(weaponNumber);
        int cost =swordCost.get(weaponNumber);
        if(!swordToBuy.isIsPurchased())
        {
            swordToBuy.setIsPurchased(true);
        }
        else
        {
            System.out.println("Sword already bought!");
            cost = 0;
        }
        
        return cost;
    }
    
    // Returns sword of choice
    public Sword getSword(int num)
    {
        Sword s = this.swordList.get(num);
        
        if(s.isIsPurchased())
        {
            System.out.println("Switching to "+ s);
        }
        else{
            System.out.println("You have not bought that sword yet!! Shifting to default sword");
            s = getDefaultSword();
        }
        
        return s;
    }
}