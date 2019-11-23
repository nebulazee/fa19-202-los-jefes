import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Treasure here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public  class Treasure extends Subject
{
    String image1;
    Treasure()
    {
        super();
    }
    Treasure(String image1) {
        super();
        this.image1 = image1;
        
        GreenfootImage img = new GreenfootImage(this.image1);

        img.scale(60, 60);
        this.setImage(img);
    }
    
    /**
     * Act - do whatever the Treasure wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public  void pickWeapon(ISubject s)
    {
    }
    
    //public abstract Treasure getTreasure();  
    
}
