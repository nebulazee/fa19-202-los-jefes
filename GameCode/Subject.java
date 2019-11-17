import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Subject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Subject extends Actor implements ISubject
{
    /**
     * Act - do whatever the Subject wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   /* MonsterGenerator mg;
    Subject(){
    mg = new MonsterGenerator();
    }*/
    public void act() 
    {
        // Add your action code here.
    } 
   public void notifyObservers(ISubject s){}
  
  public void addObservers(ISubject s){}
     
  public void die(ISubject s){}
    
  public void causeDamage(ISubject a){}
}
