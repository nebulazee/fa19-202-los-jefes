import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Goblin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Goblin extends Subject
{    
    private int direction=5;
    private GreenfootImage right = new GreenfootImage("71.png");
    private GreenfootImage left = new GreenfootImage("bullWL1.png");
    
    /**
     * Constructor of Goblin
     *      
     */
    public Goblin()
    {
        super();
        setImage(left);
    }
    
    /**
     * Update Damage (not used)
     * 
     * @param s ISubject
     */
    public void updateDamage(ISubject s) {
        
    }
    
    /**
     * Act - do whatever the Goblin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveBackandForth();       
    }    
    
    /**
     *  Sets Goblin movement
     * 
     */
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
        move((direction-1)/2);
        }
    }
    
    /**
     *  Checks if Man is touching
     * 
     * @return true if Man touching
     */
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
