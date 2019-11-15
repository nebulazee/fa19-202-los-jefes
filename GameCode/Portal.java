import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Portal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Portal extends Subject
{
    
    public Character flag ; 
    
    
    Portal(Character flag)
    {
        this.flag = flag; 
        
        if(flag == 'E')
        {
            setImage("portal-east.png");
            getImage().scale(50,80);
        }
        if(flag == 'W')
        {
            setImage("portal-west.png");
            getImage().scale(50,80);
        }
        if(flag == 'S')
        {
            setImage("portal-south.png");
            getImage().scale(80,50);
        }
        if(flag == 'N')
        {
            setImage("portal-north.png");
            getImage().scale(80,50);
        }   

    }
    
    public Character getFlag()
    {
        return flag;   
        
    }    
    
      
    /**
     * Act - do whatever the Portal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        //timer =timer +1;
        //if(timer%30 == 0)
        //{
        //  switch(count) 
        //{
        //    case 0:
        //    setRotation(0);
        //    count = 1;
        //    break;
 
        //    case 1:
        //    setRotation(-90);
        //    count=2;
        //    break;
 
        //    case 2:
        //    setRotation(-180);
        //    count=3;
        //    break;
 
        //    case 3:
        //    setRotation( -270);
        //    count=0;
        //    break;
        //}
            
        //}
        
    }    
    
    public void updateDamage(ISubject s){}
}
