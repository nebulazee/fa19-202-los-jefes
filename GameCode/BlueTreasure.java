import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Treasure here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlueTreasure extends Treasure
{
    /**
     * Act - do whatever the Treasure wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int strength;
    private int openDelay;
    private boolean pickedBlueSword;
    private Weapon associated_weapon;
    public BlueTreasure()
    {
        GreenfootImage blueTreasureClosedImage = new GreenfootImage("treasure-closed-blue.png");
        blueTreasureClosedImage.scale(50,50);
        setImage(blueTreasureClosedImage);
        //setImage(new GreenfootImage("treasure-closed-blue.png"));
        this.strength = 30;
        this.openDelay = 0;
        this.pickedBlueSword = false;
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
              this.associated_weapon = new BlueSword();
            // System.out.println(this.strength);
            }
        
    }
    
    public void pickWeapon(ISubject s)
    {
        if(s instanceof Man && this.strength <= 0){
              this.pickedBlueSword = true;
              this.associated_weapon = new BlueSword();
              Scoreboard.updateWeapon(1);
              this.getWorld().removeObject(this);
            }
        
    }
    
    /*
    public Treasure getTreasure()
    {
        return new BlueTreasure();
    }
    */
    public void act() 
    {
        
        if(this.strength <= 0)
        {
            this.openDelay++;
            if(this.openDelay == 60)
            {
                GreenfootImage blueTreasureOpenImage = new GreenfootImage("treasure-open-blue.png");
                blueTreasureOpenImage.scale(50,50);
                setImage(blueTreasureOpenImage);
                //this.setImage(new MotionRenderer("treasure-open-blue.png").image);
            }
            else if(this.openDelay == 120)
            {
                GreenfootImage blueSwordImage = new GreenfootImage("blue-sword.png");
                setImage(blueSwordImage);
                //this.setImage(new MotionRenderer("blue-sword.png").image);
            }
        }
        
    }  
    public void setImage(MotionRenderer img){
    //System.err.println("Man image is set to "+img.fileName);
        super.setImage(img.image);
    }
}
