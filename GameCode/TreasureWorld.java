import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TreasureWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TreasureWorld extends BaseWorld
{

    /**
     * Constructor for objects of class TreasureWorld.
     * 
     */
    public TreasureWorld(String config)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(config); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Treasure treasure1 = new Treasure();
        //treasure1.setLocation(400,400);
        addObject(treasure1, 400, 350);
        
        
        man = new Man();
        addObject(man,287,355);
    }
}
