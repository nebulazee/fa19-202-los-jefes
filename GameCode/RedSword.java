import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RedSword here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RedSword extends Weapon
{
    /**
     * Act - do whatever the Axe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int damage_capability;
    private boolean is_active = false;
    public RedSword()
    {
        this.damage_capability = 100;
        setImage(new GreenfootImage("red-sword.png"));
        
    }
    public void act() 
    {
        // Add your action code here.
        
    }    
}
