import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnimalWorld extends BaseWorld
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */ 
    public AnimalWorld(String config)
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
        worldType = "AnimalWorld";
        
        tooltipTitle = "A field of goblins! Neither friend, nor foe.\nBest to avoid them and continue on your quest.";
        
        Goblin goblin = new Goblin();
        addObject(goblin,20,225);   
        Goblin goblin2 = new Goblin();
        addObject(goblin2,20,450);
       
       
    }
}
