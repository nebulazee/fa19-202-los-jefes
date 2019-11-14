import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Treasure here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Treasure extends Subject
{
    /**
     * Act - do whatever the Treasure wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int strength;
    public Treasure()
    {
        setImage(new GreenfootImage("treasure1a.png"));
        this.strength = 300;
    }
    class MotionRenderer {
        String file;
        GreenfootImage image;
        public MotionRenderer (String file){
            this.file=file;
            this.image= new GreenfootImage(file);
            //image.scale(60,60);
        }
    }
    
    MotionRenderer im;
    public void updateDamage(ISubject s)
    {
        if(s instanceof Man){
              this.strength = this.strength-5;
            
            System.out.println(this.strength);
            }
        
    }
    
    
    public void act() 
    {
        if(this.strength <= 0)
        {
            this.setImage(new MotionRenderer("treasure2.png").image);
        }
        
    }  
    public void setImage(MotionRenderer img){
    //System.err.println("Man image is set to "+img.fileName);
        super.setImage(img.image);
    }
}
