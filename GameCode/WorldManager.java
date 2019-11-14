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
    public World currentWorld;
    
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
        List<String> worldTypes = new ArrayList<>();
        worldTypes.add("monster");
        worldTypes.add("animal");
        worldTypes.add("treasure");
        Random rand = new Random(); 
        
        int monsters = 3;
        int treasures = 2;
        
        for(int i=0; i<worldHeight; i++)
        {
            for(int j=0; j<worldWidth; j++)
            {
                if (monsters == 0) { worldTypes.remove("monster"); }
                if (treasures == 0) { worldTypes.remove("treasure"); }
                
                if (i == 3 && j == 2)
                {
                    World world = new TavernWorld(); 
                    worldMap[i][j] = world;
                    currentWorld = world;
                    Greenfoot.setWorld(world);
                }
                else
                {
                    String type = worldTypes.get(rand.nextInt(worldTypes.size()));
                    switch(type)
                    {
                        case "monster":
                            worldMap[i][j] = new MonsterWorld();
                            monsters--;
                            break;
                        case "animal":
                            worldMap[i][j] = new AnimalWorld();
                            break;
                        case "treasure":
                            worldMap[i][j] = new AnimalWorld();
                            treasures--;
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
        switch(signal)
        {
            case "west": instance.switchWorlds("left"); break;
            case "east": instance.switchWorlds("right"); break;
            case "north": instance.switchWorlds("up"); break;
            case "south": instance.switchWorlds("down"); break;
            default: break;
        }
        System.out.println(displayWorldMap());
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
    
    public static String displayWorldMap()
    {
        StringBuffer display = new StringBuffer();
        display.append("  - - -  \n");
        
        for (World[] wList: instance.worldMap)
        {
            display.append("| ");
            for (World w: wList)
            {
                display.append(getCode(w) + " ");
            }
            display.append("|\n");
        }
        display.append("  - - -  \n");

        return display.toString();
        
    }
    
    private static char getCode(World w)
    {
        char code;
        switch(w.getClass().getName())
        {
            case "MonsterWorld": code = 'M'; break;
            case "AnimalWorld": code = ' '; break;
            case "TreasureWorld": code = 'T'; break;
            case "TavernWorld": code = 'H'; break;
            default: code = ' '; break;
        }
        if (instance.currentWorld.equals(w) == true)
        {
            code = '*';
        }
        return code;
    }
}
