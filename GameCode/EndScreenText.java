import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreenText here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class EndScreenText extends Actor {
    
    GreenfootImage vic, def;
    Scoreboard sb;
    int health, monsterkill;
    EndScreen es;
    
    /**
     * EndScreen Constructor
     */
    public EndScreenText()
    {
        if(WorldManager.getCurrentWorld() instanceof MonsterWorld || WorldManager.getCurrentWorld() instanceof AnimalWorld){
         sb = Scoreboard.getScoreboardInstance();  
         health = sb.getHealth();
         monsterkill = sb.getMonsterKill();
         vic = new GreenfootImage("victoryedited.jpg");
         def = new GreenfootImage("defeat.png"); 
         if(health<=0)
         {
          setImage(def);
         }else{
           setImage(vic);      
         }
        }
    }
    
    /**
     * Act - do whatever the EndScreenText wants to do. This method is called
     * whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {        

    }
}
