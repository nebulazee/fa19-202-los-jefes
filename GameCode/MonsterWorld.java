import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MonsterWorld extends BaseWorld
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
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
        tooltipTitle = "A ravenous monster confronts you!\nSlay it, brave warrior! Slay it to proceed!";

        Goblin goblin = new Goblin();
        addObject( goblin ,20,225);
        banana banana = new banana();
        addObject(banana,50,550);
        Scoreboard scoreboard = Scoreboard.getScoreboardInstance();
        
        // System.out.println("Added scoreboard");
        //addObject(scoreboard,300,130);
        
        man = new Man();
        addObject(man,287,355);

        //Monster monster = new Monster();
        int monsterCode = Greenfoot.getRandomNumber(3);
        IMonsterFactory monster = null;
        
        if(monsterCode == 1){
        monster = (Monster)mg.spawnMonster("monster");
        addObject(((Monster)monster),400,350);
        ((Monster)monster).addObservers(scoreboard);
        //monster.setLocation(278,37);
        }
        else if(monsterCode == 2){
        monster = (Demon)mg.spawnMonster("demon");
        addObject(((Demon)monster),400,350);
        ((Demon)monster).addObservers(scoreboard);
        }
        else {
        monster = (Monster2)mg.spawnMonster("monster2");
        addObject(((Monster2)monster),400,350);
        ((Monster2)monster).addObservers(scoreboard);
        }

        man.addObservers(scoreboard);
    }
}
