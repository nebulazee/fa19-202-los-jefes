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
    public BaseWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        scoreboardmain=new Scoreboardmain();
        addObject(scoreboardmain,300,130);
        textboxmain = new Textboxmain();
        addObject(textboxmain,400,580);
        /*scoreboard = Scoreboard.getScoreboardInstance();
        System.out.println("Added scoreboard");
        addObject(scoreboard,300,130);
        */
    }
}
