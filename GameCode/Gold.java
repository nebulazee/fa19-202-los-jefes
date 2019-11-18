import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gold here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gold extends Actor
{
    /**
     * Act - do whatever the Gold wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Gold(){
    GreenfootImage img = new GreenfootImage("gold.png");
        
        img.scale(60,60);
        this.setImage(img);
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
