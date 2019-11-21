import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sword here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sword extends GameActor
{
    /**
     * Act - do whatever the Sword wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int damage;
    public Sword()
    {
        setImage(new GreenfootImage("sword1.png"));
        damage= 15;
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
