import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Treasure here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Treasure extends GameActor
{
    String imageClosed, imageOpen;
    private int strength;
    private int openDelay;
    private boolean pickedWeapon;
    public Weapon associatedWeapon;
    
    Treasure()
    {
        super();
    }
    
    Treasure(String imageClosed, String imageOpen) 
    {
        super();
        this.imageClosed = imageClosed;
        this.imageOpen = imageOpen;
        
        createWeapon();
        
        GreenfootImage treasureClosedImage = new GreenfootImage(imageClosed);
        treasureClosedImage.scale(50,50);
        setImage(treasureClosedImage);

        this.strength = 30;
        this.openDelay = 0;
        //this.pickedWeapon = false;
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
    public void takeDamage()
    {
        this.strength = this.strength-10;
            // System.out.println(this.strength);
    }
    
    public Weapon exchangeWeapon(Weapon w)
    {
        //this.pickedWeapon = true;
        Weapon temp = associatedWeapon;
        this.associatedWeapon = w;
        Scoreboard.updateWeapon(1);
        updateWeaponImage();
        
        return temp;

    }
    
    private void updateWeaponImage()
    {
        GreenfootImage weaponImage = new GreenfootImage(associatedWeapon.getWeaponImage());
        setImage(weaponImage);
    }

    public abstract void createWeapon();
    
    public void act() 
    {
        
        if(this.strength <= 0)
        {
            this.openDelay++;
            if(this.openDelay == 60)
            {
                GreenfootImage treasureOpenImage = new GreenfootImage(imageOpen);
                treasureOpenImage.scale(50,50);
                setImage(treasureOpenImage);
                //this.setImage(new MotionRenderer("treasure-open-blue.png").image);
            }
            else if(this.openDelay == 120)
            {
                GreenfootImage weaponImage = new GreenfootImage(associatedWeapon.getWeaponImage());
                setImage(weaponImage);
                //this.setImage(new MotionRenderer("blue-sword.png").image);
            }
        }
        
    }  
    public void setImage(MotionRenderer img){
    //System.err.println("Man image is set to "+img.fileName);
        super.setImage(img.image);
    }
    
    //public abstract Treasure getTreasure();
    
    
    
    
    
    
}
