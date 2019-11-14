import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Goblin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Goblin extends Actor
{
    /**
     * Act - do whatever the Goblin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int direction=5;
    private GreenfootImage right = new GreenfootImage("71.png");
    private GreenfootImage left = new GreenfootImage("bullWL1.png");
    public Goblin()
    {
        
    }
    
    public void act() 
    {
        moveBackandForth();
        // Add your action code here.
    }    
    
    public void moveBackandForth()
    {
        
        if(direction > 0 && getX() == getWorld().getWidth()-1)
        {
            setImage(right);
            direction = -direction;        
        } 
        if (direction < 0 && getX() == 0) 
        {
            setImage(left);
            direction = -direction;
        } 
        if( !hitknight() )
        {
        move(direction);
        }
    }
public boolean hitknight()
    {
        if( isTouching(knight.class) )
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
    
}
