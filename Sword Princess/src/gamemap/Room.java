/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemap;

import characters.Monster;
import entities.Entity;

/**
 *
 * @author hitar
 */
public class Room extends Entity
{
    private Monster[] monsters;

    
    public Room(String description) 
    {
        super(description);
    }
    
    public Monster[] getMonsters() {
        return monsters;
    }

    public void setMonsters(Monster[] monsters) {
        this.monsters = monsters;
    }
    
    private void addMonsterToRoome(Monster m)
    {
        
    }
}
