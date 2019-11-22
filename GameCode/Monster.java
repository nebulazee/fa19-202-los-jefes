import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Monster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Monster extends Subject implements IMonsterFactory
{
    /**
     * Act - do whatever the Monster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Man man=null;
    int health=1000;
    WeaponSingleton weaponInstance;
    ISubject scoreBoardObs;
    boolean monsterDead=false;
    int c=1;
    class MotionRenderer 
    {
        String file;
        GreenfootImage image;
        public MotionRenderer (String file){
            this.file=file;
            this.image= new GreenfootImage(file);
            image.scale(60,60);
        }
    }
    MotionRenderer im1,im2;
    Monster() 
    {
        super();
        GreenfootImage img = new GreenfootImage("0.png");
        
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
                ((Actor)s).getWorld().addObject(new Gold(), Greenfoot.getRandomNumber (300) , Greenfoot.getRandomNumber (300));
                ((Scoreboard)scoreBoardObs).monsterDead();
                }
                else {
                this.health = this.health-1;
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
            setImage(new MotionRenderer("0.png").image);
            c = 2;
            }
         else if (c == 2)
            {
            setImage(new MotionRenderer("1.png").image);
            c = 1;
            }
         
           
    }
    
    public void act() 
    {
        //int c=0;
         if(scoreBoardObs!=null)
        ((Scoreboard)scoreBoardObs).setMonsterHealth(health); 
        {
            // if(getObjectsInRange(60, Man.class).size()>0)
            // man =getObjectsInRange(60, Man.class).get(0);
            // else 
            // man=null;
            
            man = (Man) getOneIntersectingObject(Man.class);

            if(null==man) {
                //this.setImage(new MotionRenderer("0.png").image);
               
            }
            else {
                animasi();
                
                man.updateDamage(this);
              
                // System.out.println(c);
                
            }
        }
        // Add your action code here.
    }    
    
    public int getRandomNumber(int start,int end)
    {
       int normal = Greenfoot.getRandomNumber(end-start+1);
       return normal+start;
    }
}
