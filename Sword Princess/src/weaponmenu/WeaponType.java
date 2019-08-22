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
public enum WeaponType 
{
    defaultsword,
    firesword,
    watersword,
    dualsword,
    dragonsword;
        
    public static WeaponType readLine(String line)
    {
        line = line.replace("$","").toLowerCase();
        return WeaponType.valueOf(line);
    }
}
