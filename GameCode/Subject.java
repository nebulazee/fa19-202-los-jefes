import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Subject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Subject extends GameActor implements ISubject 
{
    
    /**
     * Subject Constructor
     */
    Subject()
    {
        super();
    }
    
    /**
     * Act - do whatever the Subject wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    } 
    
    /**
     * @param s Observer
     */
    public void notifyObservers(ISubject s){}
    
    /**
     * @param s Observer
     */
    public void addObservers(ISubject s){}
     
    
    public void die(ISubject s){}
    
    
    public void causeDamage(ISubject a){}
}
