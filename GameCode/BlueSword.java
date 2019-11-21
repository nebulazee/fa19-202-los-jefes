import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlueSword here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlueSword extends Weapon
{
    /**
     * Act - do whatever the Axe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int damage_capability;
    public BlueSword()
    {
        this.damage_capability = 50;
        setImage(new GreenfootImage("blue-sword.png"));
        
    }
    public void act() 
    {
        // Add your action code here.
        
    }    
}
