/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weaponmenu;

/**
 *
 * @author Patricia Virgen and Hitarth Asrani
 */
public enum WeaponType 
{
    defaultsword(0),
    firesword(1),
    watersword(2),
    dualsword(3),
    dragonsword(4);
    
    private int weaponNum;
    private WeaponType(int weaponNum)
    {
        this.weaponNum = weaponNum;
    }
    
    public static WeaponType readLine(String line)
    {
        line = line.replace("$","").toLowerCase();
        return WeaponType.valueOf(line);
    }
    
    public int getWeaponNmm()
    {
        return this.weaponNum;
    }
}
