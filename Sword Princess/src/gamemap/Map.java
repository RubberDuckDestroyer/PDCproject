/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemap;
import entities.Entity;
/**
 *
 * @author hitar
 */
public class Map extends Entity {
    
    private int numberOfForests;
    private Forest[] forests;

    public int getNumberOfForests() {
        return numberOfForests;
    }

    public void setNumberOfForests(int numberOfForests) {
        this.numberOfForests = numberOfForests;
    }

    public Forest[] getForests() {
        return forests;
    }

    public void setForests(Forest[] forests) {
        this.forests = forests;
    }
    
    public Map(String description) {
        super(description);
    }
    
}
