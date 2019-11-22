import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Treasure here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoldenTreasure extends Treasure
{
    /**
     * Act - do whatever the Treasure wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int strength;
    private int openDelay;
    private boolean pickedGoldenSword;
    private Weapon associated_weapon;
    public GoldenTreasure()
    {
        GreenfootImage goldenTreasureClosedImage = new GreenfootImage("treasure-closed-golden.png");
        goldenTreasureClosedImage.scale(50,50);
        setImage(goldenTreasureClosedImage);
        //setImage(new GreenfootImage("treasure-closed-golden.png"));
        this.strength = 30;
        this.openDelay = 0;
        this.pickedGoldenSword = false;
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
            
            // System.out.println(this.strength);
            }
        
    }
    
    public void pickWeapon(ISubject s)
    {
        if(s instanceof Man && this.strength <= 0){
              this.pickedGoldenSword = true;
              Scoreboard.updateWeapon(3);
              this.associated_weapon = new GoldenSword();
              this.getWorld().removeObject(this);
            }
        
    }
    /*
    public Treasure getTreasure()
    {
        return new GoldenTreasure();
    }
    */
    public void act() 
    {
        
        if(this.strength <= 0)
        {
            this.openDelay++;
            if(this.openDelay == 60)
            {
                GreenfootImage goldenTreasureOpenImage = new GreenfootImage("treasure-open-golden.png");
                goldenTreasureOpenImage.scale(50,50);
                setImage(goldenTreasureOpenImage);
                //this.setImage(new MotionRenderer("treasure-open-golden.png").image);
            }
            else if(this.openDelay == 120)
            {
                GreenfootImage goldenSwordImage = new GreenfootImage("golden-sword.png");
                setImage(goldenSwordImage);
                //this.setImage(new MotionRenderer("golden-sword.png").image);
            }
        }
        
    }  
    public void setImage(MotionRenderer img){
    //System.err.println("Man image is set to "+img.fileName);
        super.setImage(img.image);
    }
}
