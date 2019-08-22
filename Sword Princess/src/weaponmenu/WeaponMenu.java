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
 * @author hitar
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
    
    public void printWeaponMenu()
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
                System.out.println("Description: "+ sword.getDescription());
            }
        }
            
    }

    public void buyWeapon()
    {
        
    }
}