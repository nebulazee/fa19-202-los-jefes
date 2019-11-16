import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TavernWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TavernWorld extends BaseWorld
{

    /**
     * Constructor for objects of class TavernWorld.
     * 
     */
    
    public TavernWorld(String config)
    {
        super(config); 
        prepare();
    }
    
    private void prepare()
    {

        Tavern tavern = new Tavern();
        addObject(tavern, getWidth()/2, getHeight()/2);

        Scoreboard scoreboard = Scoreboard.getScoreboardInstance();
        // System.out.println("Added scoreboard");
        // addObject(scoreboard,30,100);

        man = new Man();
        addObject(man,287,355);

        man.addObservers(scoreboard);      

        tavern.setLocation(386,348);
    }
}
