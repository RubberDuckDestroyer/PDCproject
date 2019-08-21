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

/**
 * This class is the Data reader class for the main game.
 * @author Patricia Virgen and Hitarth Asrani
 */
public class WorldGenerator 
{
    private static final String worldDataPath = "Data\\worlddata.txt";
    private static final boolean outputToConsole = true;
    // Enum for world data tags used.
    public enum WorldDataTag
    {
        rooms, desc;
        public static WorldDataTag readLine(String line)
        {
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
        /*
        private static Sword parseWeaponData(String data)
        {
        }
        
        private static Forest generateForest()
        {
        }
        
        private static Forest generateRoom()
        {
        }
        
        private static Monster parseMonsterData(String data)
        {
        }
        */
        private static SwordPrincess loadWorld(String path) throws IOException
        {
            Scanner fileReader = new Scanner(new File(path));
            
            log("Loading game data from: "+ path);
            log("meta tag: "+ fileReader.nextLine());
            int numberOfForests = new Integer(fileReader.nextLine());
            log("Number of forests: "+ numberOfForests);
            while(!fileReader.hasNextLine())
            {
                fileReader.nextLine();
            }
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
}
