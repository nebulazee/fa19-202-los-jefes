import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scoreboardmain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scoreboardmain extends Subject
{
    Scoreboard sc=null;
    int monsterVal=1000;
    int manVal=1000000;
    GreenfootImage img;
    GreenfootImage scoreboard;
    Color n = new Color(255,232,213);
    
    public void updateDamage(ISubject s) {
        
    }    
    
    public  Scoreboardmain(){
        sc=Scoreboard.getScoreboardInstance();
        scoreboard = new GreenfootImage("upper_textbox.png");
        scoreboard.scale(scoreboard.getWidth()-400  ,scoreboard.getHeight()- 150 );
        img = new GreenfootImage("    Health : "+sc.manVal+""+"    Monster :"+1000, 20, 
                                    Color.BLACK, n);
//       imgM = new GreenfootImage(,20,Color.WHITE, Color.BLACK);
       
        scoreboard.drawImage(img,scoreboard.getWidth()/2 - 100,scoreboard.getHeight()/2);
        
        this.setLocation(400,50);
        setImage(scoreboard);
        //setImage(imgM);
        }
    
        public void setMonsterHealth(int val) {
        this.monsterVal = val;
    }
    
    /**
     * Act - do whatever the Scoreboardmain wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */    
    public void act() 
    {
          sc=Scoreboard.getScoreboardInstance();
          scoreboard = new GreenfootImage("upper_textbox.png");
          scoreboard.scale(scoreboard.getWidth()-400  ,scoreboard.getHeight()- 150 );
          if(WorldManager.getInstance().currentWorld instanceof MonsterWorld) {
              img = new GreenfootImage("    Health : "+sc.manVal+" "+"    Monster :"+sc.monsterVal+" "+"    Gold Count :"
                                        +sc.goldCount, 20, Color.BLACK, n);
                                    }
          else if(WorldManager.getInstance().currentWorld instanceof AnimalWorld) {
              img = new GreenfootImage("    Health : "+sc.manVal+" "+"    Gold Count :"
                                        +sc.goldCount, 20, 
                                     Color.BLACK, n);
            
            }
          else if(WorldManager.getInstance().currentWorld instanceof TreasureWorld) {
              img = new GreenfootImage("    Health : "+sc.manVal+" "+"    Gold Count :"
                                        +sc.goldCount, 20, 
                                     Color.BLACK, n);
            }    
          else if(WorldManager.getInstance().currentWorld instanceof TavernWorld) {
              img = new GreenfootImage("    Health : "+sc.manVal+" "+"    Gold Count :"
                                        +sc.goldCount, 20, 
                                     Color.BLACK, n);
            }

        scoreboard.drawImage(img,scoreboard.getWidth()/2 - 100,scoreboard.getHeight()/2);
        this.setLocation(400,50);
        setImage(scoreboard);
        //setImage(img);
        // Add your action code here.
    }    
   
}
