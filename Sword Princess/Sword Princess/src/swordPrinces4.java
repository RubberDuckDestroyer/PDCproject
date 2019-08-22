/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swordprincess;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class is the main game class for the Sword Princess Game.
 * 
 * @author Patricia Virgen and Hitarth Asrani
 */
public class SwordPrincess 
{

    private boolean gameInProgress;
    private Mode gameMode;
    private  boolean isValid = false;
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
        System.out.println("-------******------- Playing game! Let's get started -------******------- ");
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
      
       try
       {
            Scanner scan = new Scanner(System.in); //getting the user input 
            String input = scan.nextLine();
            
                if (input instanceof String) 
                {
                            input.equalsIgnoreCase(input);
                           
                            boolean Quite = false; 
                                  while (!Quite) //if it is not false then continue
                                  {
                                      switch(input)
                                      {
                                          case "attack": // TODO : WHAT NEXT?
                                              break;

                                          case "weapon": // TODO: WHAT NEXT?
                                              break;

                                          case "stats": //get the stats and display them 
                                              break;

                                          case"quite": //this will exit the game
                                              Quite = true;
                                              break;
                                      }
                                  }
                     } isValid = true; //so while the try block is true/ valid to function 
        }catch (InputMismatchException e) 
        {
                System.out.println("Please enter a String");
        }

            
           

       
        
        
        
        
        
        
        
    }
    /**
    *  Main method
    */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("Hello! It's Sword Princress!");
        System.out.println(System.getProperty("user.dir"));
        System.out.println(new File("Data\\worlddata.txt").getAbsoluteFile()); // TODO; maybe this file should not be printed?
        SwordPrincess game = WorldGenerator.newWorld();
        //TODO: Initialise Player
        //TODO: Play game/ Main game loop method!
        game.play();
        
    }
 
}
