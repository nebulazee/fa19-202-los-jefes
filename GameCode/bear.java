import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bear here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bear extends Subject
{
    /**
     * Act - do whatever the bear wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int f=0;
    public void act() 
    {
        //keyBind();
        //checktouching();
        move();
      //turn(2);
    } 
    private int direction=5;
    private void move() 
  { 
        // checking edges  
        if ((direction < 0 && getX() == 0) || (direction > 0 && getX() == getWorld().getWidth()-1)) direction = -direction;  
        // movement  
        move(direction);
    }
    
    public void updateDamage(ISubject s){
    }
    private void checktouching(){
        if(isTouching(banana.class)) {
            removeTouching(banana.class);
            //notifyObservers() i.e scoreboard 
            
        }
    }
    private void keyBind() {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-1);
            //turn(-5);
        }
        if(Greenfoot.isKeyDown("right"))
        {
            move(1);
        }
    }
}
