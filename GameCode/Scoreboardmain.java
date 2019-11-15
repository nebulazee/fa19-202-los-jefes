import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scoreboardmain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scoreboardmain extends Subject
{
    /**
     * Act - do whatever the Scoreboardmain wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void updateDamage(ISubject s) {
        
    }
    Scoreboard sc=null;
     int monsterVal=1000;
     int manVal=1000000;
    GreenfootImage img;
    public  Scoreboardmain(){
        sc=Scoreboard.getScoreboardInstance();
       img = new GreenfootImage("    Health : "+sc.manVal+"\n"+"    Monster :"+1000, 20, 
                                     Color.WHITE, Color.BLACK);
//       imgM = new GreenfootImage(,20,Color.WHITE, Color.BLACK);
       
        this.setLocation(100,100);
        setImage(img);
        //setImage(imgM);
        }
    public void setMonsterHealth(int val) {
    this.monsterVal = val;
    }
    public void act() 
    {
         sc=Scoreboard.getScoreboardInstance();
         if(WorldManager.getInstance().currentWorld instanceof MonsterWorld) {
              img = new GreenfootImage("    Health : "+sc.manVal+"\n"+"    Monster :"+sc.monsterVal, 20, 
                                     Color.WHITE, Color.BLACK);
          }
          else if(WorldManager.getInstance().currentWorld instanceof AnimalWorld) {
              img = new GreenfootImage("    Health : "+sc.manVal, 20, 
                                     Color.WHITE, Color.BLACK);
            
            }

       
        this.setLocation(100,100);
        setImage(img);
        // Add your action code here.
    }    
   
}
