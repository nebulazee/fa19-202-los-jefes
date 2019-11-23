import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class MonsterWorld extends BaseWorld
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    BaseMonster currentMonster;
    Scoreboard scoreboard;
    public MonsterWorld(String config)
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
        worldType = "MonsterWorld";

        tooltipTitle = "A ravenous monster confronts you!\nSlay it, brave warrior! Slay it to proceed!";

        Goblin goblin = new Goblin();
        addObject( goblin ,20,225);
        banana banana = new banana();
        addObject(banana,50,550);
        scoreboard = Scoreboard.getScoreboardInstance();
        
        int monsterCode = Greenfoot.getRandomNumber(3);
        createMonster();
        addObject(currentMonster,400,350);
        
    }

    public abstract void createMonster() ;
}
