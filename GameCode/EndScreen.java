import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreen extends World
{

    /**
     * Constructor for objects of class EndScreen.
     * 
     */
    Color n = new Color(0,0,0,0);
    GreenfootImage img;
    
    public EndScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 800, 1);
    }
    
    public void act()
    {
        this.checkNextScreen();            
    
    }   
    
    public void checkNextScreen()
    {
        if( Greenfoot.isKeyDown("enter"))
        {
            WorldManager.getNewInstance();
        }
    }   
    
}
