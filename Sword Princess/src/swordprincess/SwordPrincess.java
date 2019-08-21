/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swordprincess;

import java.io.*;

/**
 * This class is the main game class for the Sword Princess Game.
 * 
 * @author Patricia Virgen and Hitarth Asrani
 */
public class SwordPrincess {

    private boolean gameInProgress;
    private Mode gameMode;
    /**
     * Enum Mode stores game modes available: Battle and Adventure
     */ 
    public enum Mode 
    {
        battle, adventure;
    }
    
    /**
     * Play method
     */
    
    private void play()
    {
        System.out.println("Playing game!");
        /*
        this.player = player;
        //Enter room
        while(gameInProgess)
        {
            switch (this.gameMode)
            {
                case adevnture: 
                        break;
                case battle: 
                    break;
            }
        }
        */
    }
    /**
    *  Main method
    */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("Hello! It's Sword Princress!");
        System.out.println(System.getProperty("user.dir"));
        System.out.println(new File("Data\\worlddata.txt").getAbsoluteFile());
        SwordPrincess game = WorldGenerator.newWorld();
        //TODO: Initialise Player
        //TODO: Play game/ Main game loop method!
        game.play();
        
    }
    
}
