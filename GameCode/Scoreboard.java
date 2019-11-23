import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Scoreboard here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Scoreboard extends Subject {
    
    GreenfootImage img;
    GreenfootImage imgM;
    int manVal;
    int goldCount;
    int monsterKilledCount;
    Weapon currentWeapon;
    EndScreen es;
    EndScreenText est;
    GreenfootImage vic = new GreenfootImage("victoryedited.jpg");
    GreenfootImage def = new GreenfootImage("defeat.png");
    private ArrayList<IScoreboardObserver> observers;
    private static Scoreboard scoreboard;
    
    /**
     * Constructor method 
     * 
     */
    private Scoreboard() {
        observers = new ArrayList<IScoreboardObserver>();

        monsterKilledCount = 0;
        currentWeapon = new Weapon("golden-sword.png", 25, 0.5f);
        manVal = WorldManager.getInstance().getInitialHealth();
        goldCount = WorldManager.getInstance().getInitialGold();

        es = new EndScreen();

        this.setLocation(100, 100);
    }
    
    /**
     * Singleton pattern 
     * @return Scoreboard instance
     */
    public static synchronized Scoreboard getScoreboardInstance() {
        if (scoreboard == null) {
            return getNewScoreboardInstance();
        }
        return scoreboard;
    }
    
    /**
     * Singleton pattern 
     * @return new Scoreboard instance if not created
     */
    public static synchronized Scoreboard getNewScoreboardInstance() {
        scoreboard = new Scoreboard();
        return scoreboard;
    }
    
    /**
     * Act - do whatever the Scoreboard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {

    }    

    /**
     * Getter method 
     * @return Monster Kill Count
     */
    public int getMonsterKill() {
        return monsterKilledCount;
    }
    
    /**
     * not used 
     * @param s ISubject
     */
    public void updateDamage(ISubject s) {
    }
    
    /**
     * Updates Players stats 
     * @param man Man object 
     */
    public static void setPlayerStats(Man man) {
        scoreboard.manVal = man.health;
        scoreboard.goldCount = man.gold;

        notifyScoreboardObservers(((IScoreboardObserver) man));
        if (scoreboard.manVal <= 0) {
            // scoreboard.est.setImage(scoreboard.def);
            Greenfoot.setWorld(new EndScreen());
        }

    }
    
    /**
     * Getter method 
     * @return Gold Count
     */
    public static int getGoldCount() {
        return scoreboard.goldCount;
    }
    
    /**
     * Getter method 
     * @return Health Count
     */
    public static int getHealth() {
        return scoreboard.manVal;
    }
    
    /**
     * Setter method 
     * @param health Sets Man health
     */
    public static void setHealth(int health) {
        scoreboard.manVal = health;
    }
    
    /**
     * Checks End Game condition
     * 
     */
    public static void monsterDead() {
        scoreboard.monsterKilledCount++;
        System.out.println("Monster killed so far " + scoreboard.monsterKilledCount);
        if (scoreboard.monsterKilledCount == 3) {
            // scoreboard.est.setImage(scoreboard.vic);
            Greenfoot.setWorld(new EndScreen());
        }

    }
    
    /**
     * Weapon Update 
     * @param w Weapon to be updated
     */
    public static void updateWeapon(Weapon w) {
        scoreboard.currentWeapon = w;
        notifyScoreboardObservers(null);
    }
    
    /**
     * Getter method 
     * @return Current Weapon
     */
    public static Weapon getCurrentWeapon() {

        return scoreboard.currentWeapon;
    }
    
    /**
     * Observer pattern 
     * @param obs Observer
     */
    public static void addScoreboardObserver(IScoreboardObserver obs) {
        scoreboard.observers.add(obs);
    }

    /**
     * Notify all Observers of Update Event
     */
    public static void notifyScoreboardObservers(IScoreboardObserver updater) {
        for (int i = 0; i < scoreboard.observers.size(); i++) {
            IScoreboardObserver observer = scoreboard.observers.get(i);
            if (updater != null && updater != observer) {
                observer.scoreboardUpdateEvent();
            }
        }
    }
}
