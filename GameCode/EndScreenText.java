import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreenText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreenText extends Actor
{
    /**
     * Act - do whatever the EndScreenText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage vic;  
    //Scoreboard sb;
    //EndScreen es;
    public EndScreenText()
    {
        //sb = Scoreboard.getScoreboardInstance();  
        vic = new GreenfootImage("victoryedited.jpg");
        setImage(vic);      
    }
    public void act() 
    {
        // Add your action code here.
        //if(sb.getMonsterKillCount()==3)
        //{
            //Greenfoot.setWorld(es);
            //Greenfoot.start();
       // }
        
    }    
}
