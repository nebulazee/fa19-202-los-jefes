import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TreasureWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TreasureWorld extends BaseWorld
{
    Treasure currentTreasure;
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
        tooltipTitle = "You come across a treasure chest.\nWhat rewards could it hold?";        
        //TreasureFactory tf = new TreasureFactory();
        //Treasure treasure = tf.getTreasure();
        //treasure1.setLocation(400,400);
        //addObject(treasure, 400, 350);
        
        
        //man = new Man();
        //addObject(man,287,355);
    }
    public void setTreasure(Treasure m) 
    {
        currentTreasure=m;
        addObject(m,400,350);
    }
}
