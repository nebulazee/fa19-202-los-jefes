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
        
        Goblin goblin = new Goblin();
        addObject(goblin,23,137);
        
      
        
        goblin.setLocation(23,60);
        Goblin goblin2 = new Goblin();
        addObject(goblin2,20,179);
        goblin2.setLocation(21,173);
        Goblin goblin3 = new Goblin();
        addObject(goblin3,25,427);
        Goblin goblin4 = new Goblin();
        addObject(goblin4,25,542);
        goblin.setLocation(24,60);
        goblin.setLocation(14,66);
        goblin4.setLocation(19,519);

        Scoreboard scoreboard = Scoreboard.getScoreboardInstance();
        // System.out.println("Added scoreboard");
        //addObject(scoreboard,300,130);
        
        Man man = new Man();
        addObject(man,287,355);
        
        man.addObservers(scoreboard);
        goblin.addObservers(scoreboard);
        goblin2.addObservers(scoreboard);
        goblin3.addObservers(scoreboard);
        goblin4.addObservers(scoreboard);
        
        
       
    }
}
