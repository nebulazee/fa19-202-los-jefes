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
        monster = (Monster)mg.spawnMonster("monster");
        addObject(((Monster)monster),400,350);
        ((Monster)monster).addObservers(scoreboard);
        }

        //banana.setLocation(496,102);
        //banana.setLocation(532,97);
        //Scoreboard scoreboard = Scoreboard.getScoreboardInstance();
        //addObject(scoreboard,34,13);
        man.addObservers(scoreboard);
        //scoreboard.setLocation(75,9);
        
        //scoreboard.setLocation(37,5);
        //scoreboard.setLocation(53,6);
        //bear.setLocation(57,200);
        //scoreboard.setLocation(81,28);
        //monster.setLocation(382,86);
        //monster.setLocation(382,89);
        //banana.setLocation(702,141);
        //bear.setLocation(60,230);
    }
}
