import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Monster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Monster extends Subject
{
    /**
     * Act - do whatever the Monster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Man man=null;
    int health=10000;
    ISubject scoreBoardObs;
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
    Monster() {
        GreenfootImage img = new GreenfootImage("ogre10.png");
        
        img.scale(60,60);
        this.setImage(img);
    }
      public void updateDamage(ISubject s){
          if(s instanceof Man){
              this.health = this.health-1;
            notifyObservers(s);
            System.out.println(this.health);
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
    public void act() 
    {
        int c=0;
        
        {
            if(getObjectsInRange(60, Man.class).size()>0)
            man =getObjectsInRange(60, Man.class).get(0);
            else 
            man=null;
            if(null==man) {
                this.setImage(new MotionRenderer("ogre10.png").image);
                c=1;
            }
            else {
                this.setImage(new MotionRenderer("ogre2.png").image);
                man.updateDamage(this);
                c=0;
                
            }
        }
        // Add your action code here.
    }    
}
