import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class knight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class knight extends Actor
{
    /**
     * Act - do whatever the knight wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        moveAround();
        
    }
    
    public void moveAround()
    {
        int x = getX();
        int y = getY();
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(x + 4, y);
            if( hitTavern() || hitGoblin() ){
                setLocation( x - 4 , y );
            }
        }
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(x - 4, y);
             if( hitTavern() || hitGoblin() ){
                setLocation( x + 4 , y );
            }
        }
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(x , y - 4);
             if( hitTavern() || hitGoblin() ){
                setLocation( x , y + 4 );
            }
        }
        if(Greenfoot.isKeyDown("down"))
        {
            setLocation(x , y + 4);
             if( hitTavern() || hitGoblin() ){
                setLocation( x , y - 4 );
            }
        }
    }
    
    public boolean hitTavern()
    {
        if( isTouching(Tavern.class) )
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
    public boolean hitGoblin()
    {
        if( isTouching(Goblin.class) )
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
    
}
