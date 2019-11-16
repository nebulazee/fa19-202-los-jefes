import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BaseWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BaseWorld extends World
{

    /**
     * Constructor for objects of class BaseWorld.
     * 
     */
    Scoreboardmain scoreboardmain;
    Textboxmain textboxmain;
    //BottomText bottomtext;

    final int width;
    final int height;

    public BaseWorld(String config)
    {
        super(800, 800, 1); 
        width = 800;
        height = 800;

        scoreboardmain=new Scoreboardmain();
        addObject(scoreboardmain,300,130);
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
        int offset = 30;
        for (String o: orientations)
        {
            switch(o)
            {
                case "N": 
                {
                    Portal p = new Portal('N');
                    addObject(p, width/2, 0 + offset);
                    break;
                }
                case "S": 
                {
                    Portal p = new Portal('S');
                    addObject(p, width/2, height - offset);
                    break;
                }
                case "W":
                {
                    Portal p = new Portal('W');
                    addObject(p, 0 + offset, height/2);
                    break;
                }
                case "E":
                {
                    Portal p = new Portal('E');
                    addObject(p, width - offset, height/2);
                    break;
                }
                default: break;
            }
        }

    } 
}
