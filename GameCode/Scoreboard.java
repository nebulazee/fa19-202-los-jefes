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
     private static Scoreboard scoreboard;
     private Scoreboard(){
       img = new GreenfootImage("    Health : "+manVal+"\n"+"    Monster :"+monsterVal, 20, 
                                     Color.WHITE, Color.BLACK);
//       imgM = new GreenfootImage(,20,Color.WHITE, Color.BLACK);
       
        this.setLocation(100,100);
        setImage(img);
        //setImage(imgM);
        }
       
        public static Scoreboard getScoreboardInstance(){
        if(scoreboard == null) {
           scoreboard=new Scoreboard();
        }
            return scoreboard;
        }
    public void act() 
    {
        // Add your action code here.
    }   
    public void updateDamage(ISubject s){}
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
}
