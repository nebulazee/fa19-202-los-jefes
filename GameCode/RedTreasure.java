import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Treasure here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RedTreasure extends Treasure
{
    /**
     * Act - do whatever the Treasure wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int strength;
    private int openDelay;
    private boolean pickedRedSword;
    private Weapon associated_weapon;
    public RedTreasure()
    {
        setImage(new GreenfootImage("treasureclose.png"));
        this.strength = 30;
        this.openDelay = 0;
        this.pickedRedSword = false;
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
              this.strength = this.strength-10;
            
            System.out.println(this.strength);
            }
        
    }
    
    public void pickWeapon(ISubject s)
    {
        if(s instanceof Man){
              this.pickedRedSword = true;
              this.associated_weapon = new RedSword();
              this.getWorld().removeObject(this);
            }
        
    }
    /*
    public Treasure getTreasure()
    {
        return new RedTreasure();
    }
    */
    
    public void act() 
    {
        
        if(this.strength <= 0)
        {
            this.openDelay++;
            if(this.openDelay == 60)
                this.setImage(new MotionRenderer("treasureopen.png").image);
            else if(this.openDelay == 120)
                this.setImage(new MotionRenderer("red-sword.png").image);
        }
        
    }  
    public void setImage(MotionRenderer img){
    //System.err.println("Man image is set to "+img.fileName);
        super.setImage(img.image);
    }
}