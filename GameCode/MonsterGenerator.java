import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MonsterGenerator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MonsterGenerator extends GameActor
{
    /**
     * Act - do whatever the MonsterGenerator wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }   
    public IMonsterFactory spawnMonster(String name)
    {
       switch(name) 
        { 

            case "monster": 
               return new Monster(); 

            case "demon" :
               return new Demon();
                
             default : break;
           
        } 
        
        return null;
    }
}
