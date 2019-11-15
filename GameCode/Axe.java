import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Axe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Axe extends Actor
{
    /**
     * Act - do whatever the Axe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int damage;
    public Axe()
    {
        setImage(new GreenfootImage("axe1.png"));
        this.damage= 5;
    }
    public void act() 
    {
        // Add your action code here.
        
    }    
}
