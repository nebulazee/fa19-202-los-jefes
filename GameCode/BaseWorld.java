import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BaseWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BaseWorld extends World
{
    protected Man man;

    /**
     * Constructor for objects of class BaseWorld.
     * 
     */
    Scoreboardmain scoreboardmain;
    Textboxmain textboxmain;

    final int max_width, min_width;
    final int max_height, min_height;
    int portalOffset = 30;

    public BaseWorld(String config)
    {
        super(800, 600, 1); 

        max_width = 800; // right of screen
        max_height = 600; // bottom of screen (smaller values go towards top)
        min_width = 0; // left of screen
        min_height = 0; // top of screen (larger values go towards bottom)

        scoreboardmain=new Scoreboardmain();
        addObject(scoreboardmain,300,130);
        textboxmain = new Textboxmain();
        addObject(textboxmain,400,580);
        /*scoreboard = Scoreboard.getScoreboardInstance();
        System.out.println("Added scoreboard");
        addObject(scoreboard,300,130);
        */

        populatePortals(config);
    }

    private void populatePortals(String config)
    {
        String orientations[] = config.split(",");
        for (String o: orientations)
        {
            switch(o)
            {
                case "N": 
                {
                    Portal p = new Portal('N');
                    addObject(p, max_width/2, min_height + portalOffset);
                    break;
                }
                case "S": 
                {
                    Portal p = new Portal('S');
                    addObject(p, max_width/2, max_height - portalOffset);
                    break;
                }
                case "W":
                {
                    Portal p = new Portal('W');
                    addObject(p, min_width + portalOffset, min_height + (max_height - min_height)/2);
                    break;
                }
                case "E":
                {
                    Portal p = new Portal('E');
                    addObject(p, max_width - portalOffset, min_height + (max_height - min_height)/2);
                    break;
                }
                default: break;
            }
        }
    }
    
    public void setPlayerSpot(char location)
    {
        int playerOffset = 60 + portalOffset;
        switch(location)
        {
            case 'L': // Left
                man.setLocation(min_width + playerOffset, min_height + (max_height - min_height)/2);
                break;
            case 'R': // Right
                man.setLocation(max_width - playerOffset, min_height + (max_height - min_height)/2);
                break;
            case 'T': // Top
                man.setLocation(max_width/2, min_height + playerOffset);
                break;
            case 'B': // Bottom
                man.setLocation(max_width/2, max_height - playerOffset);
                break;

            default:
                break;
        }
    }
}
