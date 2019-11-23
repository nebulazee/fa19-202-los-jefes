import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreen extends World
{      
    EndScreenText es;
    
    /**
     * Constructor for objects of class EndScreen. 
     */  
    public EndScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 800, 1);
        es = new EndScreenText();
        addObject(es,400,400);
        prepare();
    }

     /**
     * Act - do whatever the banana wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        this.checkNextScreen();  

    }   

    /**
     * going next screen
     */
    public void checkNextScreen()
    {
        if( Greenfoot.isKeyDown("q"))
        {
            WorldManager.getNewInstance();
        }
    }   

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
