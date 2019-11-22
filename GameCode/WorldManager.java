
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class WorldManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldManager extends GameActor
{
    // instance variables - replace the example below with your own
    BaseWorld[][] worldMap;
    public BaseWorld currentWorld;
    
    static WorldManager instance;
    
    int worldHeight = 4;
    int worldWidth = 3;

    /**
     * Constructor for objects of class WorldManager
     */
    private WorldManager()
    {
    }
    
    public static BaseWorld getCurrentWorld()
    {
        return instance.currentWorld;
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
        worldMap = new BaseWorld[worldHeight][worldWidth];
        constructWorlds();
        currentWorld.getTextbox().setMsg(currentWorld.getTitle() + "\n\n" + "");
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
                    BaseWorld world = new TavernWorld(constructConfigurationCode(i, j)); 
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
                            MonsterWorld mw = new MonsterWorld(constructConfigurationCode(i, j));
                            if(monsters == 3) {
                                mw.setMonster(new BaseMonster("Demon1.png","Demon2.png"));
                            }
                            else if(monsters == 2) {
                                mw.setMonster(new BaseMonster("0.png","1.png"));
                            }
                            else {
                                mw.setMonster(new BaseMonster("ogre1.png","ogre2.png"));
                            }
                            worldMap[i][j] = mw;//new MonsterWorld(constructConfigurationCode(i, j)){
                                /*if(monsters==3){
                                 public void setMonster(new BaseMonster("Demon1.png","Demon2.png"));
                                }
                                else if(monsters==2) 
                                 setMonster(new BaseMonster("0.png","1.png"));
                                else
                                 setMonster(new BaseMonster("ogre1.png","ogre2.png"));  
                                 
                                
                            };*/
                            monsters--;
                            break;
                        case "animal":
                            worldMap[i][j] = new AnimalWorld(constructConfigurationCode(i, j));
                            break;
                        case "treasure":
                            worldMap[i][j] = new TreasureWorld(constructConfigurationCode(i, j));
                            treasures--;
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }

    private String constructConfigurationCode(int i, int j)
    {
        StringBuffer buf = new StringBuffer();
        if (i > 0) { buf.append("N,"); }
        if (i < worldHeight - 1) { buf.append("S,"); }
        if (j > 0) { buf.append("W,"); }
        if (j < worldWidth - 1) { buf.append("E,"); }

        return buf.toString();
    }
    
    /**
     * Receives Signal From BaseWorld
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
        // System.out.println(displayWorldMap());
    }
    
    private void switchWorlds(String direction)
    {
        int hor = 0;
        int ver = 0;
        char playerSpot;
        
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
                playerSpot = 'R';
                break;
            case "right":
                if (hor+1 < worldWidth) { new_hor = hor + 1; }
                playerSpot = 'L';
                break;
            case "up":
                if (ver-1 >=0) { new_ver = ver - 1; }
                playerSpot = 'B';
                break;
            case "down":
                if (ver+1 < worldHeight) { new_ver = ver + 1; }
                playerSpot = 'T';
                break;
            default:
                playerSpot = 'X';
                break;
        }
        
        // System.out.println("Switching screens from " + Integer.valueOf(getWorldId(hor, ver)) + " to " + Integer.valueOf(getWorldId(new_hor, new_ver)));
        
        worldMap[ver][hor] = currentWorld;
        currentWorld = worldMap[new_ver][new_hor];
        currentWorld.setPlayerSpot(playerSpot);
        currentWorld.getTextbox().setMsg(currentWorld.getTitle() + "\n\n" + "");
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
        display.append("\u2015 \u2015 \u2015\n");
        
        for (BaseWorld[] wList: instance.worldMap)
        {
            // display.append("|");
            StringBuffer items = new StringBuffer();

            for (BaseWorld w: wList)
            {
                items.append(getCode(w) + " ");
            }
            // display.append("\u00A0");
            display.append(items.toString().trim());
            // display.append("\u00A0");
            display.append("\n");
        }
        display.append("\u2015 \u2015 \u2015\n");

        return display.toString();
        
    }
    
    private static String getCode(BaseWorld w)
    {
        String code;
        switch(w.getClass().getName())
        {
            case "MonsterWorld": code = "\u2612"; break;
            case "AnimalWorld": code = "\u25A2"; break;
            case "TreasureWorld": code = "\u272A"; break; //25CE
            case "TavernWorld": code = "\u25A9"; break;
            default: code = "\u00A0"; break;
        }
        // code = "+";
        if (instance.currentWorld.equals(w) == true)
        {
            code = "\u25A3";
        }
        return code;
    }
}
