import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GoldenSword here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoldenSword extends Weapon
{
    /**
     * Act - do whatever the Axe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int damage_capability;
    public GoldenSword()
    {
        this.damage_capability = 150;
        setImage(new GreenfootImage("golden-sword.png"));
        
    }
    public void act() 
    {
        // Add your action code here.
        
    }    
}
