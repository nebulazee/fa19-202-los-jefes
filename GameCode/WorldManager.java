import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class WorldManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldManager extends Actor
{
    // instance variables - replace the example below with your own
    World[][] worldMap;
    World currentWorld;
    
    static WorldManager instance;
    
    int worldHeight = 4;
    int worldWidth = 3;

    /**
     * Constructor for objects of class WorldManager
     */
    private WorldManager()
    {
    }
    
    public static WorldManager getInstance()
    {
        if (instance == null)
        {
            instance = new WorldManager();
            instance.startUp();
            return instance;
        }
        else
        {
            return instance;
        }
    }
    
    public static WorldManager getNewInstance()
    {
        instance = new WorldManager();
        instance.startUp();
        return instance;
    }
    
    private void startUp()
    {
        worldMap = new World[worldHeight][worldWidth];
        constructWorlds();
    }

    private void constructWorlds()
    {
        String[] worldTypes = {"monster", "animal", "treasure"};
        Random rand = new Random(); 
        
        for(int i=0; i<worldHeight; i++)
        {
            for(int j=0; j<worldWidth; j++)
            {
                if (i == 3 && j == 2)
                {
                    World world = new MyWorld(); 
                    worldMap[i][j] = world;
                    currentWorld = world;
                    Greenfoot.setWorld(world);
                }
                else
                {
                    String type = worldTypes[rand.nextInt(worldTypes.length)];
                    switch(type)
                    {
                        case "monster":
                            worldMap[i][j] = new MonsterWorld();
                            break;
                        case "animal":
                            worldMap[i][j] = new MyWorld();
                            break;
                        case "treasure":
                            worldMap[i][j] = new TreasureWorld();
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }
    
    /**
     * Receives Signal From World
     * 
     * @param  signal  north, south, west, or east
     * @return void
     */
    public static void signal(String signal)
    {
        // put your code here
        switch(signal)
        {
            case "west": instance.switchWorlds("left"); break;
            case "east": instance.switchWorlds("right"); break;
            case "north": instance.switchWorlds("up"); break;
            case "south": instance.switchWorlds("down"); break;
            default: break;
        }
    }
    
    private void switchWorlds(String direction)
    {
        int hor = 0;
        int ver = 0;
        
        for(int i=0; i<worldHeight; i++)
        {
            for(int j=0; j<worldWidth; j++)
            {
                if (currentWorld.equals(worldMap[i][j]) == true)
                {
                    hor = j;
                    ver = i;
                }
            }
        }
        int new_hor = hor;
        int new_ver = ver;
        switch(direction)
        {
            case "left":
                if (hor-1 >=0) { new_hor = hor - 1; }
                break;
            case "right":
                if (hor+1 < worldWidth) { new_hor = hor + 1; }
                break;
            case "up":
                if (ver-1 >=0) { new_ver = ver - 1; }
                break;
            case "down":
                if (ver+1 < worldHeight) { new_ver = ver + 1; }
                break;
            default:
                break;
        }
        
        System.out.println("Switching screens from " + Integer.valueOf(getWorldId(hor, ver)) + " to " + Integer.valueOf(getWorldId(new_hor, new_ver)));
        
        worldMap[ver][hor] = currentWorld;
        currentWorld = worldMap[new_ver][new_hor];
        Greenfoot.setWorld(currentWorld);
        Greenfoot.start();

    }
    
    private int getWorldId(int x, int y)
    {
        int id = (y*3) + (x+1);
        return id;
    }
}
