import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Goblin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Goblin extends Subject
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
        super();
    }
    public void updateDamage(ISubject s) {
        
    }
    public void act() 
    {
        moveBackandForth();
       // updateDa
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
        move(direction-1);
        }
    }
public boolean hitknight()
    {
        if( isTouching( Man.class) )
        {
            // if(getObjectsInRange(100, Man.class).size()>0)
            // man =getObjectsInRange(100, Man.class).get(0);
            Man man = (Man) getOneIntersectingObject(Man.class);
            if (man != null)
            {
                man.updateDamage(this);
            }
            return true;
        }
        else 
        {
            return false;
        }
    }
    
}
