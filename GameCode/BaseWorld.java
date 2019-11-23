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
    protected String tooltipTitle;
    protected String worldType;
    
    public BaseWorld(String config)
    {
        super(800, 800, 1); 
        worldType = "BaseWorld";
        tooltipTitle = "";
        max_width=800;
        max_height=600;
        min_width=0;
        min_height=95;
        man = new Man();
        addObject(man,287,355);

        scoreboardmain=new Scoreboardmain();
        addObject(scoreboardmain,400,50);
        textboxmain = new Textboxmain();
        addObject(textboxmain,400,700);

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
                    Portal p = new Portal(Signal.NORTH);
                    addObject(p, max_width/2, min_height + portalOffset);
                    break;
                }
                case "S": 
                {
                    Portal p = new Portal(Signal.SOUTH);
                    addObject(p, max_width/2, max_height - portalOffset);
                    break;
                }
                case "W":
                {
                    Portal p = new Portal(Signal.WEST);
                    addObject(p, min_width + portalOffset, min_height + (max_height - min_height)/2);
                    break;
                }
                case "E":
                {
                    Portal p = new Portal(Signal.EAST);
                    addObject(p, max_width - portalOffset, min_height + (max_height - min_height)/2);
                    break;
                }
                default: break;
            }
        }
    }
    
    public void setPlayerSpot(Signal location)
    {
        int playerOffset = 60 + portalOffset;
        switch(location)
        {
            case L: // Left
                man.setLocation(min_width + playerOffset, min_height + (max_height - min_height)/2);
                break;
            case R: // Right
                man.setLocation(max_width - playerOffset, min_height + (max_height - min_height)/2);
                break;
            case T: // Top
                man.setLocation(max_width/2, min_height + playerOffset);
                break;
            case B: // Bottom
                man.setLocation(max_width/2, max_height - playerOffset);
                break;

            default:
                break;
        }
    }

    public String getTitle()
    {
        return tooltipTitle;
    }

    public Textboxmain getTextbox()
    {
        return textboxmain;
    }

    public Scoreboardmain getScoreboard()
    {
        return scoreboardmain;
    }

    public String worldType() { return worldType; }
}
