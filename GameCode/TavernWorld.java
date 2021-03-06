import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TavernWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */ 
public class TavernWorld extends BaseWorld
{

    /**
     * Constructor for objects of class TavernWorld.
     * 
     */    
    public TavernWorld(String config)
    {
        super(config); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        worldType = "TavernWorld";
        tooltipTitle = "Welcome, brave warrior! Your quest awaits you!\nHeal up at the tavern before you head out!";
        Tavern tavern = new Tavern();
        addObject(tavern, getWidth()/2, getHeight()/2);

        // System.out.println("Added scoreboard");
        // addObject(scoreboard,30,100);


        tavern.setLocation(386,348);
        //WorldManager.getNewInstance();
    }
}
