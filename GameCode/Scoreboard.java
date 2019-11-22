import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scoreboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scoreboard extends Subject
{
    /**
     * Act - do whatever the Scoreboard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     GreenfootImage img;
     GreenfootImage imgM;
     int monsterVal=1000;
     int manVal=1000000;
     static int goldCount=30;
     int monsterKilledCount=0;
     private static Scoreboard scoreboard;
     EndScreen endscreen;
     private Scoreboard(){
       img = new GreenfootImage("    Health : "+manVal+"\n"+"    Monster :"+monsterVal, 20, 
                                     Color.WHITE, Color.BLACK);
//       imgM = new GreenfootImage(,20,Color.WHITE, Color.BLACK);
        goldCount = 30;
        this.setLocation(100,100);
        setImage(img);
        endscreen = new EndScreen();
        //setImage(imgM);
        }
        public int getMonsterKillCount(){
        return this.monsterKilledCount;
        }
       public int getGoldCount(){
           return goldCount;
        }
        public static synchronized  Scoreboard getScoreboardInstance(){
        if(scoreboard == null) {
            goldCount=30;
           scoreboard=new Scoreboard();
        }
            return scoreboard;
        }
        
    public void act() 
    {
        
    }   
    public void updateDamage(ISubject s){}
    public void setGoldCount(int gold) {
        goldCount = gold;
    }
    
    public void setValue(int val)
    {
        manVal=val;
        img = new GreenfootImage("    Health : "+manVal+"\n"+"    Monster :"+monsterVal, 20, 
                                     Color.WHITE, Color.BLACK);
                      
        setImage(img);
    }
    public void setMonsterHealth(int val){
        monsterVal=val;
        img = new GreenfootImage("    Health : "+manVal+"\n"+"    Monster :"+monsterVal, 20, 
                                     Color.WHITE, Color.BLACK);
        setImage(img);
    }
    public void monsterDead(){
        this.monsterKilledCount++;
        System.out.println("Monster killed so far "+this.monsterKilledCount);
        if(this.monsterKilledCount==3){
            //getWorld().removeObject(getWorld().getObjects(WorldManager));
            Greenfoot.setWorld(endscreen);
            Greenfoot.start();
        }        
    }
}
