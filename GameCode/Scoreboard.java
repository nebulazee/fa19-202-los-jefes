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
    int manVal = 1000000;
    int goldCount = 30;
    int monsterKilledCount = 0;
    int currentWeapon;

    private ArrayList<IScoreboardObserver> observers ;

    private static Scoreboard scoreboard;

    private Scoreboard() 
    {
        observers = new ArrayList<IScoreboardObserver>() ;

        goldCount = 30;
        monsterKilledCount = 0;
        currentWeapon = 0;

        // img = new GreenfootImage("    Health : " + manVal + "\n" + "    Monster :" + monsterVal, 20, Color.WHITE,
                // Color.BLACK);
        this.setLocation(100, 100);
        // setImage(img);
    }

    public int getMonsterKillCount() {
        return monsterKilledCount;
    }

    public static synchronized Scoreboard getScoreboardInstance() {
        if (scoreboard == null) {
            scoreboard = new Scoreboard();
        }
        return scoreboard;
    }

    public void act() {

    }

    public void updateDamage(ISubject s) {
    }

    public static void setGoldCount(int gold) 
    {
        scoreboard.goldCount = gold;
        scoreboard.notifyObservers();
    }

    public static void setHealth(int val) 
    {
        scoreboard.manVal = val;
        scoreboard.notifyObservers();

        // img = new GreenfootImage("    Health : " + manVal + "\n" + "    Monster :" + monsterVal, 20, Color.WHITE,
        //         Color.BLACK);

        // setImage(img);
    }

    public static int getGoldCount() 
    {
        return scoreboard.goldCount;
    }

    public static int getHealth() 
    {
        return scoreboard.manVal;
        // img = new GreenfootImage("    Health : " + manVal + "\n" + "    Monster :" + monsterVal, 20, Color.WHITE,
        //         Color.BLACK);

        // setImage(img);
    }

    public static void monsterDead() {
        scoreboard.monsterKilledCount++;
        System.out.println("Monster killed so far " + scoreboard.monsterKilledCount);

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
        scoreboard.notifyObservers();

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
    public void notifyObservers()
    {
        for (int i=0; i<observers.size(); i++)
        {
            IScoreboardObserver observer = observers.get(i) ;
            observer.scoreboardUpdateEvent() ;
        }
    }    
}
