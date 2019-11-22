import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Portal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Portal extends Subject
{
    
    public Signal flag ; 
    
    
    Portal(Signal flag)
    {
        this.flag = flag; 
        
        if(flag == Signal.EAST)
        {
            setImage("portal-east.png");
            getImage().scale(50,80);
        }
        if(flag == Signal.WEST)
        {
            setImage("portal-west.png");
            getImage().scale(50,80);
        }
        if(flag == Signal.SOUTH)
        {
            setImage("portal-south.png");
            getImage().scale(80,50);
        }
        if(flag == Signal.NORTH)
        {
            setImage("portal-north.png");
            getImage().scale(80,50);
        }   

    }
    
    public Signal getFlag()
    {
        return flag;   
        
    }    
    
      
    /**
     * Act - do whatever the Portal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }    
    
    public void updateDamage(ISubject s){}
}
