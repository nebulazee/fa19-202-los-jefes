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
    //BottomText bottomtext;

    final protected int max_width, min_width;
    final protected int max_height, min_height;
    protected int portalOffset = 30;
    
    
    public BaseWorld(String config)
    {
        super(800, 800, 1); 
        
        max_width=800;
        max_height=600;
        min_width=0;
        min_height=95;

        scoreboardmain=new Scoreboardmain();
        addObject(scoreboardmain,400,50);
        textboxmain = new Textboxmain();
        addObject(textboxmain,400,700);
        //bottomtext = new BottomText();
        //addObject(bottomtext,400,680);
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
