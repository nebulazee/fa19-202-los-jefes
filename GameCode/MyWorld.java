import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends BaseWorld
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Tavern tavern = new Tavern();
        addObject(tavern, getWidth()/2, getHeight()/2);
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

        Man man = new Man();
        addObject(man,287,355);

        
        Portal portal = new Portal('E');
        addObject(portal,792,316);
        portal.setLocation(771,351);
        Portal portal2 = new Portal('S');
        addObject(portal2,426,572);
        portal2.setLocation(415,586);
        Portal portal3 = new Portal('N');
        addObject(portal3,422,24);
        portal3.setLocation(408,12);
        portal3.setLocation(402,9);
        Portal portal4 = new Portal('W');
        addObject(portal4,34,282);
        portal4.setLocation(8,288);

    }
}
