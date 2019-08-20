/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Patricia Virgen and Hitarth Asrani 
 */
public abstract class Entity 
{
    private String id;
    private String description;

    public Entity(String description)
    {
        this.description = description;
        this.id = this.getClass().getSimpleName();
    }
    
    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}