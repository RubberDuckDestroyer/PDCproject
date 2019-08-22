/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weaponmenu;

/**
 *
 * @author hitar
 */

import java.io.*;
import java.util.*;
import entities.Sword;
import weapons.*;

public class WeaponMenuGenerator 
{
    private static final String weapondatapath = "Data\\weapondata.txt";
    private static WeaponMenu menu;
    private static final boolean outputToConsole = true;
      
        // Logger
        private static void log(String text)
        {
            if(outputToConsole)
            {
                System.out.println(text);
            }
        }

    
    private static WeaponMenu parseWeaponData(Scanner fileReader)
    {
            WeaponMenu generatedMenu  = new WeaponMenu();
            
            int numberOfSwords = new Integer(fileReader.nextLine());
            log(numberOfSwords +" is the number of Swords to be read!");
            
            int currentSword  = 0;
            
            do{
                String line = fileReader.hasNext()?fileReader.nextLine():"";
                WeaponType tag = WeaponType.readLine(line);
                Sword s;
                String[] weaponData = (fileReader.nextLine().trim()).split(" ");
                int monsterDamage = new Integer(weaponData[0]);
                int dragonDamage = new Integer(weaponData[1]);
                int flowerDrop = new Integer(weaponData[2]);
                int cost = new Integer(weaponData[3]);
                switch(tag)
                {
                    case defaultsword:
                        s = new DefaultSword(flowerDrop, monsterDamage, dragonDamage, true, "default sword");
                        generatedMenu.addWeapon(s, cost);
                        break;
                    case firesword:
                        s = new FireSword(flowerDrop, monsterDamage, dragonDamage, true, "Kills mosnters easies, but lesser flowers dropped.");
                        generatedMenu.addWeapon(s, cost);
                        break;
                    case watersword:
                        s = new WaterSword(flowerDrop, monsterDamage, dragonDamage, true, "Tougher to kill monsters, but more flowers dropped.");
                        generatedMenu.addWeapon(s, cost);
                        break;
                    case dragonsword:
                         s = new DragonSword(flowerDrop, monsterDamage, dragonDamage, true, "The legendary dragonkiller sword.");
                        generatedMenu.addWeapon(s, cost);
                        break;
                    case dualsword:
                         s = new DualSword(flowerDrop, monsterDamage, dragonDamage, true, "Kills forest monsters easier but weaker on the Dragon.");
                        generatedMenu.addWeapon(s, cost);
                        break;
                            
                }
                currentSword++;
            }while(currentSword <numberOfSwords);
        
        return generatedMenu;
    }
    private static void readWeaponData()
    {
        
        try{
            Scanner fileReader = new Scanner(new File(weapondatapath));
            log(fileReader.nextLine());
            WeaponMenuGenerator.menu = parseWeaponData(fileReader);
            
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File Not Found!");
            System.err.print(e);
        }
    }    

    public static WeaponMenu getMenu() {
        return menu;
    }
    
}
