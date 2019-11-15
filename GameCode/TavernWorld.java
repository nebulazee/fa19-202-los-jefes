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
    
    public TavernWorld()
    {
         super(); 
        prepare();
    }
    private void prepare()
    {
        
      
        Tavern tavern = new Tavern();
        addObject(tavern, getWidth()/2, getHeight()/2);
        
        Scoreboard scoreboard = Scoreboard.getScoreboardInstance();
        System.out.println("Added scoreboard");
        //addObject(scoreboard,300,130);
        
        Man man = new Man();
        addObject(man,287,355);
        
        man.addObservers(scoreboard);
 
        
        
       
    }
}
