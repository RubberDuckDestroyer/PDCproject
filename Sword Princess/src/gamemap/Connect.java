/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemap;

/**
 *
 * @author Patricia Virgen and Hitarth Asrani
 */
public enum Connect 
{
    one(1), two(2), three(3), four(4), forest(0);
    private int cId;
    private Connect(int cId)
    {
        this.cId = cId;
    }
    
    public int getcId() {
        return cId;
    }
    
    public int getConnectId(Connect connector)
    {
        return connector.cId;
    }
    
    public static Connect readLine(String line)
    {
        System.out.println("Value of "+ line + " is :" + Connect.valueOf(line));
        return Connect.valueOf(line);
    }
}
