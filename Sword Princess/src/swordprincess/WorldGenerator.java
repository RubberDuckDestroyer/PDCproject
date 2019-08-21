/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swordprincess;
import characters.Monster;
import entities.Sword;
import gamemap.Forest;
import java.io.*;
import java.util.*;
import monsters.Dragon;
import monsters.Geothern;
import monsters.Golem;
import gamemap.*;

/**
 * This class is the Data reader class for the main game.
 * @author Patricia Virgen and Hitarth Asrani
 */
public class WorldGenerator 
{
    private static final String worldDataPath = "Data\\worlddata.txt";
    private static final boolean outputToConsole = true;
    private static Gamemap generatedWorld;

    // Enum for world data tags used.
    public enum MonsterIdentifier
    {
        dragon, golem, geothern;
    }
    
    public enum WorldDataTag
    {
        start, 
        end, 
        rooms, 
        desc, 
        monster,
        connect,
        connectr,
        connectl,
        finalroom,
        startforest,
        dash,
        endquest;
        
        public static WorldDataTag readLine(String line)
        {
            log("Tagging "+ line);
            line = line.replace("$","").toLowerCase();
            return WorldDataTag.valueOf(line);
        }
    }    
        //TODO: Logger
        private static void log(String text)
        {
            if(outputToConsole)
            {
                System.out.println(text);
            }
        }
        
        /*private static Sword parseWeaponData(String data)
        {
        }*/
        
        static private Forest[] generateForest(Scanner fileReader, int numberOfForests)
        {
            Forest[] forests = new Forest[numberOfForests];
            
            int currentForest = 0;       
            boolean loadingForestcomplete = false;
            do
            {
                String line = fileReader.hasNext()?fileReader.nextLine():"";
                log(line);
                WorldDataTag tag = WorldDataTag.readLine(line);
                forests[currentForest] = new Forest("Forest");
                switch(tag)
                {
                    case rooms:
                        log("case rooms!");
                        int numberOfRooms = new Integer(fileReader.nextLine());
                        Room[] rooms = new Room[numberOfRooms];
                        rooms = WorldGenerator.generateRoom(fileReader, numberOfRooms, currentForest);
                        forests[currentForest].setRooms(rooms);
                        break;    
                    case startforest:
                        forests[currentForest].setIsStartforest(true);
                        break;
                    case end:
                        if(currentForest == (numberOfForests -1)){
                            forests[currentForest].setIsEndforest(true);
                            loadingForestcomplete = true;
                            break;
                        }
                        if(currentForest<numberOfForests-1)
                        {
                            log("Read forest "+ currentForest+" out of "+ numberOfForests);
                            currentForest+=1;
                        }
                        
                        break;
                }
                
            }while(!loadingForestcomplete);
            log("forest "+currentForest+ " Loaded");
            return forests;
        }
        
        private static Room[] generateRoom(Scanner fileReader, int numberOfRooms, int currentForest)
        {
            Room[] rooms = new Room[numberOfRooms];
            int currentRoom = 0;
            boolean loadingRoomsCompleted = false;
            do{
                String line = fileReader.hasNext()?fileReader.nextLine():"";
                WorldDataTag tag = WorldDataTag.readLine(line);
                rooms[currentRoom] = new Room( ("room "+(currentRoom+1)) );
                switch(tag)
                {
                    case start:
                        rooms[currentRoom].setIsStartRoom(true);
                        break;
                    case desc:
                        String desc = fileReader.nextLine();			
			log(desc);
			rooms[currentRoom].setDescription(desc);
			break;
                    case connect:
                        String[] text= (fileReader.nextLine().trim()).split(" ");
                        log("String: "+text[0]+" Length: "+text.length);
                        rooms[currentRoom].addConnecting(text);
                        break;
                    case connectr:
                        String rConnect = (fileReader.nextLine()).trim();
                        Connect rc = Connect.readLine(rConnect);
                        rooms[currentRoom].setConnectRight(rc);
                        break;
                    case connectl:
                        String lConnect = (fileReader.nextLine()).trim();
                        Connect lc = Connect.readLine(lConnect);
                        rooms[currentRoom].setConnectLeft(lc);
                        break;
                    case monster:
                        String[] monsterLine = (fileReader.nextLine().trim()).split(" ");
                        Monster m = parseMonsterData(monsterLine);
                        rooms[currentRoom].addMonsterToRoom(m);
                        break;
                    case dash:
                        if(currentRoom == (numberOfRooms-1))
                        {
                            rooms[currentRoom].setIsFinalForestRoom(true);
                            loadingRoomsCompleted = true;
                            break;
                        }
                        if(currentRoom < numberOfRooms)
                        {
                            log("Read room "+ currentRoom+" out of "+ numberOfRooms);
                            currentRoom+= 1;
                        }
                        
                        break;
                    case endquest:
                        rooms[currentRoom].setIsFinalGameRoom(true);
                        loadingRoomsCompleted = true;
                        break;
                }
                
            }while(!loadingRoomsCompleted);
            log("Rooms Loaded for forest");
            return rooms;
        }
        
        private static Monster parseMonsterData(String[] data)
        {
            Monster m = null;
            
            // Correct length so no data is lost
            if (data.length == 5)
            {
                String monsterType = data[0];
                int health = new Integer(data[1]);
                int damage = new Integer(data[2]);
                double probability = new Double(data[3]);
                int flowerDrop = new Integer(data[4]);
                
                MonsterIdentifier monsterToken = MonsterIdentifier.valueOf(monsterType.toLowerCase());
                switch(monsterToken)
                {
                    case dragon:
                        m = new Dragon("The forest's ",monsterType, health, damage, probability, flowerDrop);
                        break;
                    case geothern:
                        m = new Geothern("A daunting ",monsterType, health, damage, probability, flowerDrop);
                        break;
                    case golem:
                        m = new Golem("A small ",monsterType, health, damage, probability, flowerDrop);
                        break;
                }
            }
         
            return m;
        }
        
        private static SwordPrincess loadWorld(String path) throws IOException
        {
            Scanner fileReader = new Scanner(new File(path));
            
            log("meta tag: "+ fileReader.nextLine());
            int numberOfForests = new Integer(fileReader.nextLine());
            Gamemap map = new Gamemap("gamemap");
            map.setNumberOfForests(numberOfForests);
            log("Created Map with Number of forests =  "+ numberOfForests);
            
            Forest[] forests = null;
            forests = WorldGenerator.generateForest(fileReader, numberOfForests);
            map.setForests(forests);
            log("Game map loaded");
            fileReader.close();
            
            
            return null;
        }
        public static SwordPrincess newWorld()
        {
            String path = worldDataPath;
            try
            {
                return WorldGenerator.loadWorld(path);
            } catch (IOException ioe)
            {
                System.err.println("ERROR: File not found! Path: "+ path );
                System.out.println("Searching in: " + new File(path).getAbsolutePath());
                ioe.printStackTrace();
            }
            
            // Might need to change this to return read world based on params
            return null;
        }
        
    //Getters and Setters
    public Gamemap getGeneratedWorld() {
        return generatedWorld;
    }

    public void setGeneratedWorld(Gamemap generatedWorld) {
        this.generatedWorld = generatedWorld;
    }
}
