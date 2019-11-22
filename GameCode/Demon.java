import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Demon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Demon  extends Subject implements IMonsterFactory
{
    /**
     * Act - do whatever the Demon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Man man=null;
    int health=1000;
    ISubject scoreBoardObs;
    boolean monsterDead=false;
    int weaponCode = 0;
    int attackpower=1;
    int c=1;
    String image1;
    GreenfootImage image2;
    
    
    class MotionRenderer {
        String file;
        GreenfootImage image;
        public MotionRenderer (String file){
            this.file=file;
            this.image= new GreenfootImage(file);
            image.scale(60,60);
        }
    }
    MotionRenderer im1,im2;
    Demon() {
    
        super();
        GreenfootImage img = new GreenfootImage("Demon1.png");
        
        img.scale(60,60);
        this.setImage(img);
        if(scoreBoardObs!=null)
        ((Scoreboard)scoreBoardObs).setMonsterHealth(health);
    }
   
      public void updateDamage(ISubject s){
          if(s instanceof Man){
              if(this.health<=0) {
                monsterDead = true;
                this.getWorld().removeObject(this);
                ((Actor)s).getWorld().addObject(new Gold(), this.getRandomNumber (0,500) , this.getRandomNumber (300,500));
                //this.getWorld(). (new Gold(),300,100);
                ((Scoreboard)scoreBoardObs).monsterDead();
                }
                else {
                    /*
                     * here the weapon power is taken from weapon singleton class  
                     */
                weaponCode = 0;//WeaponSingleton.getInstance().getCurrentWeapon();
                switch(weaponCode){
                case 0: attackpower = 1;
                        break;
                case 1: attackpower = 5;
                        break;
                case 2: attackpower = 10;
                        break;
                case 3: attackpower = 15;
                        break;
                default:attackpower = 2;
                }
                this.health = this.health-attackpower;
                notifyObservers(s);
                // System.out.println(this.health);
              }
            }
    }
    public void notifyObservers(ISubject s){
        //man shud update score board observer
        if(s!=null) {
        ((Scoreboard)scoreBoardObs).setMonsterHealth(health);
        }
    }
     public void addObservers(ISubject s){
        scoreBoardObs = s;
    }
    public void animasi()
    {
         if (c == 1)
            {
            setImage(new MotionRenderer("Demon0.png").image);
            c = 2;
            }
         else if (c == 2)
            {
            setImage(new MotionRenderer("Demon2.png").image);
            c = 1;
            }
         
           
    }
    
    public void act() 
    {
        
        // Add your action code here.
    }      
    
    public int getRandomNumber(int start,int end)
    {
       int normal = Greenfoot.getRandomNumber(end-start+1);
       return normal+start;
    }
}
