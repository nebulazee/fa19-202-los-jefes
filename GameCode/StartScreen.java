import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */ 
public class StartScreen extends World
{
    StartScreenText st;        
    GreenfootSound backgroundMusic = new GreenfootSound("music.mp3");
    
    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public StartScreen()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 800, 1); 
        // backgroundMusic.playLoop();
        st = new StartScreenText();
        addObject(st,400,400);
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
