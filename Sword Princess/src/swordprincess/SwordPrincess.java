/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swordprincess;

import characters.Monster;
import characters.Princess;
import entities.Sword;
import gamemap.Connect;
import gamemap.Forest;
import gamemap.Gamemap;
import gamemap.Room;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import weaponmenu.WeaponMenu;
import weaponmenu.WeaponMenuGenerator;

/**
 * This class is the main game class for the Sword Princess Game.
 * 
 * @author Patricia Virgen and Hitarth Asrani
 */
public class SwordPrincess 
{

    private boolean gameInProgress;
    private Mode gameMode;
    private WeaponMenu gameMenu;
    private Princess player;
    private Room currentRoom;
    private int currentRoomNumber;
    private Gamemap gameMap;
    private int currentForestNumber;
    
    public boolean isGameInProgress() {
        return gameInProgress;
    }

    public void setGameInProgress(boolean gameInProgress) {
        this.gameInProgress = gameInProgress;
    }

    public Princess getPlayer() {
        return player;
    }

    public void setPlayer(Princess player) {
        this.player = player;
    }

    public SwordPrincess(Gamemap gamemap, WeaponMenu gameMenu) {
        this.gameInProgress = true;
        this.gameMenu = gameMenu;
        this.currentForestNumber = 0;
        this.currentRoomNumber = 0;
        this.player = null;
        this.gameInProgress = true;
        this.gameMap = gamemap;
        this.currentRoom = null;
    }
    
    
    /**
     * Enum Mode stores game modes available: Battle and Adventure
     */ 
    public enum Mode 
    {
        battle, adventure;
    }

    public Mode getGameMode() {
        return gameMode;
    }

    public void setGameMode(Mode gameMode) {
        this.gameMode = gameMode;
    }

    public WeaponMenu getGameMenu() {
        return gameMenu;
    }

    public void setGameMenu(WeaponMenu gameMenu) {
        this.gameMenu = gameMenu;
    }
    
    
    
    /**
     * Play method
     */
    
    public void play(Princess player)
    {
        System.out.println("-------******------- Playing game! Let's get started -------******------- ");
        Scanner scan = new Scanner(System.in);
        
        this.player = player;
        boolean playing = this.isGameInProgress();
        Forest currentForest = this.gameMap.getForests()[currentForestNumber];
        this.currentRoom = currentForest.getRooms()[0];
        this.enterRoom();
        //Enter room
        while(playing)
        {
            switch (this.gameMode)
            {
                case adventure:
                        processAdventureInput(scan);
                        break;
                case battle: 
                        processBattleInput(scan);
                        break;
            }
        }
        
    
    }
    
    public void processBattleInput(Scanner scan)
    {
        String input[] = scan.nextLine().toLowerCase().split(" ");
        switch (input[0]) {
            case "attack": 
                Monster m = this.currentRoom.getMonster();
                int monsterDamage = m.defendAttack(player);
                
                System.out.println("The Princess dealt " + monsterDamage + " damage to the " + m);
                if(!m.isDefeated)
                {
                    int playerDamage = player.defendAttack(m);
                    System.out.println("The " + m + " dealt " + playerDamage + " to the Princess");
                }
                else
                {
                    int flowerDrop = m.getFlowerDrop();
                    player.pickUpFlower(flowerDrop);
                    System.out.println("The "+m + " died and dropped "+ flowerDrop +" flowers. The Princess picks up the flowers.");
                }
                //TODO: check if game over!
                break;
            case "weaponmenu": 
                this.gameMenu.printWeaponMenu();
                break;

            case "stats": //get the stats and display them 
                int playerHealth = this.player.getHealth();
                Sword playerWeapon = this.player.getCurrentSword();
                int currentNumberOfFlowers = this.player.getCurrentNumOfFlowers();
                System.out.println("Health: " + playerHealth + " , Flowers: " + currentNumberOfFlowers + " , Weapon: " + playerWeapon);
                break;

            case "quit": //this will exit the game
                System.exit(0);
                break;
        }
            
    
    }
    
    public void processAdventureInput(Scanner scan)
    {
        String[] input = scan.nextLine().toLowerCase().split(" ");
        switch (input[0]) {
            case "describe":
                String description = this.currentRoom.getDescription();
                System.out.println(description);
                this.currentRoom.printConnectingRooms();
                break;
            case "help":
                System.out.println("Commands available: describe: Describe current room., help, weaponmenu: Access Weapon menu."
                        + "room n: go to room n or next forest. pickup: Pick up flowers in room. Quit: quit game");
                break;
            case "weaponmenu":
                this.gameMenu.printWeaponMenu();
                break;
            case "pickup":
                int numFlowers = this.currentRoom.getNumberOfFlowers();
                this.player.pickUpFlower(numFlowers);
                break;
            case "room":
                String nextRoom = input[1];
                connectRoom(nextRoom);
                break;
            case "quit": //this will exit the game
                
                break;
        }
        
    }
    
    public void battleMode()
    {
        this.gameMode = Mode.battle;
    }
    
    public void adventureMode()
    {
        this.gameMode = Mode.adventure;
    }
    public void enterRoom()
    {
        System.out.println(currentRoom.getDescription());
        Monster roomMonster = currentRoom.getMonster();
        
        if(roomMonster!= null)
        {
            boolean appear = roomMonster.appears();
            if(appear )
            {
                System.out.println("A "+ roomMonster+" appears!");
                battleMode();
            }
            else
            {
                adventureMode();
            }
            
        }
    }
    
    public void connectRoom(String nextRoom)
    {
  
        int roomConnect = Connect.valueOf(nextRoom).getcId() -1;
        switch (nextRoom) {
            case "forest":
                currentForestNumber++;
                break;
            case "one":
                currentRoomNumber = roomConnect;
                break;
            case "two":
                currentRoomNumber = roomConnect;
                break;
            case "three":
                currentRoomNumber = roomConnect;
                break;
            case "four":
                currentRoomNumber = roomConnect;
                break;
            case "left":
                this.currentRoomNumber = this.currentRoom.getConnectLeft().getcId();
                break;
            case "right":
                this.currentRoomNumber = this.currentRoom.getConnectRight().getcId();
                break;
        }
        
        Forest currentForest = this.gameMap.getForests()[currentForestNumber];
        Room currentR = currentForest.getRooms()[currentRoomNumber];
        if(currentR != null && currentForest != null)
        {
            this.enterRoom();
        }
        else{
            System.out.println("Sorry, room does not exist!");
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
        Princess player = new Princess("Miranda", 100, 0);
        game.setPlayer(player);
        System.out.println("Let's start the game!");
        game.play(player);
        
    }
 
}
