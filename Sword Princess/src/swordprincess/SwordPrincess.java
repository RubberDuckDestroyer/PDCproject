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
import monsters.Dragon;
import weaponmenu.WeaponMenu;
import weaponmenu.WeaponMenuGenerator;
import weaponmenu.WeaponType;

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
        
        System.out.println("Thank you for playing the game, see you soon!");
    
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
                    int swordFlowerdrop = player.getCurrentSword().getFlowerDropMultiplier();
                    player.pickUpFlower(flowerDrop+swordFlowerdrop);
                    System.out.println("The "+m + " died and dropped "+ flowerDrop +" flowers, and "+swordFlowerdrop +"flowers as bonus. The Princess picks up the flowers.");
                    this.gameMode = Mode.adventure;
                    
                }
                gameInProgress = isGameOver();
                
                break;
            case "weaponmenu": 
                this.gameMenu.printWeaponMenu(this.player.getCurrentNumOfFlowers());
                break;

            case "stats": //get the stats and display them 
                int playerHealth = this.player.getHealth();
                Sword playerWeapon = this.player.getCurrentSword();
                int currentNumberOfFlowers = this.player.getCurrentNumOfFlowers();
                System.out.println("Health: " + playerHealth + " , Flowers: " + currentNumberOfFlowers + " , Weapon: " + playerWeapon);
                break;
            case "equip":
                String swordToEquip = input[1]+"sword";
                int weaponNum = WeaponType.valueOf(swordToEquip).getWeaponNmm();
                player.setCurrentSword(gameMenu.getSword(weaponNum));
                break;
            case "help":
                System.out.println("Commands: Attack, equip, stats, weaponmenu, quit");
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
                String description = this.currentRoom.getRoomDescription();
                System.out.println(description);
                this.currentRoom.printConnectingRooms();
                break;
            case "help":
                System.out.println("Commands available: describe: Describe current room., help, weaponmenu: Access Weapon menu."
                        + "room n: go to room n or next forest. pickup: Pick up flowers in room. Quit: quit game"
                        + "stats: display stats");
                break;
            case "weaponmenu":
                this.gameMenu.printWeaponMenu(player.getCurrentNumOfFlowers());
                break;
            case "buy":
                String swordToBuy = input[1]+"sword";
                WeaponType weaponType = WeaponType.valueOf(swordToBuy);
                int weaponcost = this.gameMenu.buyWeapon(weaponType.getWeaponNmm());
                this.player.setCurrentNumOfFlowers(this.player.getCurrentNumOfFlowers() - weaponcost);
                System.out.println("Sword bought! Flowers remaining: "+ player.getCurrentNumOfFlowers());
                break;
            case "equip":
                String swordToEquip = input[1]+"sword";
                int weaponNum = WeaponType.valueOf(swordToEquip).getWeaponNmm();
                player.setCurrentSword(gameMenu.getSword(weaponNum));
                break;
            case "pickup":
                int numFlowers = this.currentRoom.getNumberOfFlowers();
                this.player.pickUpFlower(numFlowers);
                break;
            case "room":
                String nextRoom = input[1]; 
                connectRoom(nextRoom);
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
        System.out.println(currentRoom.getRoomDescription());
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
        else{
            adventureMode();
        }
    }
    
    public void connectRoom(String nextRoom)
    {
  

        switch (nextRoom) {
            case "forest":
                currentForestNumber++;
                currentRoomNumber = 0;
                break;
            case "one":
                currentRoomNumber = Connect.valueOf(nextRoom).getcId() -1;
                break;
            case "two":
                currentRoomNumber = Connect.valueOf(nextRoom).getcId() -1;
                break;
            case "three":
                currentRoomNumber = Connect.valueOf(nextRoom).getcId() -1;
                break;
            case "four":
                currentRoomNumber = Connect.valueOf(nextRoom).getcId() -1;
                break;
            case "left":
                this.currentRoomNumber = this.currentRoom.getConnectLeft().getcId();
                break;
            case "right":
                this.currentRoomNumber = this.currentRoom.getConnectRight().getcId();
                break;
        }
        
        Forest currentForest = this.gameMap.getForests()[currentForestNumber];
        currentRoom = currentForest.getRooms()[currentRoomNumber];
        if(currentRoom != null)
        {
            this.enterRoom();
        }
        else{
            System.out.println("Sorry, room does not exist!");
        }
    }
    
    public boolean isGameOver()
    {
        boolean defeated = false;
        if(currentRoom.isIsFinalGameRoom())
        {
            Dragon dragon = (Dragon) currentRoom.getMonster();
            defeated = dragon.dragonDefeated();
        }
        if(player.isIsDefeated())
        {
            System.out.println(player.getName() + " the princess died...Game Over... [+] Here's a tissue to wipe your tears....See you soon. ");
            defeated = true;
        }
        
        return defeated;
    }
    
    /**
    *  Main method
    */
    public static void main(String[] args) {
        
        System.out.println("Hello! It's Sword Princress!");
        SwordPrincess game = WorldGenerator.newWorld();
        Princess player = new Princess("Miranda", 100, 0, game.gameMenu.getDefaultSword());
        game.setPlayer(player);
        game.play(player);
        
    }
 
}
