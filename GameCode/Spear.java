import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spear here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spear extends Actor
{
    /**
     * Act - do whatever the Spear wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int damage;
    public Spear()
    {
        setImage(new GreenfootImage("spear1.png"));
        damage= 10;
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
