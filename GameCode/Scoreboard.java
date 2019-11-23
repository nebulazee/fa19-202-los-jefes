import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Scoreboard here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Scoreboard extends Subject {
    /**
     * Act - do whatever the Scoreboard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage img;
    GreenfootImage imgM;
    int monsterVal = 1000;
    int manVal = 10000;
    int goldCount = 30;
    int monsterKilledCount = 0;
    int currentWeapon;
    EndScreen es;
    private ArrayList<IScoreboardObserver> observers ;

    private static Scoreboard scoreboard;

    private Scoreboard() 
    {
        observers = new ArrayList<IScoreboardObserver>() ;

        goldCount = 30;
        monsterKilledCount = 0;
        currentWeapon = 0;
        es = new EndScreen();
        this.setLocation(100, 100);
    }

    
    public static synchronized Scoreboard getScoreboardInstance() {
        if (scoreboard == null) {
            return getNewScoreboardInstance();
        }
        return scoreboard;
    }
    
    public static synchronized Scoreboard getNewScoreboardInstance() {
        
        scoreboard = new Scoreboard(); 
        return scoreboard;
    }

    public void act() {

    }

    public void updateDamage(ISubject s) {
    }

    public static void setPlayerStats(Man man) 
    {
        scoreboard.manVal = man.health;
        scoreboard.goldCount = man.gold;

        notifyScoreboardObservers(((IScoreboardObserver)man));

    }

    public static int getGoldCount() 
    {
        return scoreboard.goldCount;
    }

    public static int getHealth() 
    {
        return scoreboard.manVal;
    }
    
    public static void setHealth(int health) 
    {
        scoreboard.manVal = health;
    }

    public static void monsterDead() {
        scoreboard.monsterKilledCount++;
        System.out.println("Monster killed so far " + scoreboard.monsterKilledCount);
        if(scoreboard.monsterKilledCount==3)
        {
            Greenfoot.setWorld(scoreboard.es);
        }
        
    }

    public static void updateWeapon(int no)
    {
        if(no == 1)
        {
            scoreboard.currentWeapon = 1;
            System.out.println("Current Weapon: 1");
        }
        else if(no == 2)
        {
            scoreboard.currentWeapon = 2;
            System.out.println("Current Weapon: 2");
        }
        else if(no == 3)
        {
            scoreboard.currentWeapon = 3;
            System.out.println("Current Weapon: 3");
        }
        notifyScoreboardObservers(null);

    }
    
    public static int getCurrentWeapon()
    {
        
        return scoreboard.currentWeapon;
    }

    public static void addScoreboardObserver( IScoreboardObserver obs ) 
    {
        scoreboard.observers.add( obs ) ;
    }

    /**
     * Notify all Observers of Update Event
     */
    public static void notifyScoreboardObservers(IScoreboardObserver updater)
    {
        for (int i=0; i<scoreboard.observers.size(); i++)
        {
            IScoreboardObserver observer = scoreboard.observers.get(i);
            if (updater != null && updater != observer)
            {
                observer.scoreboardUpdateEvent() ;
            }
        }
    }    
}
