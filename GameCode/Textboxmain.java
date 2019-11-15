import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Textboxmain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Textboxmain extends Actor
{
    /**
     * Act - do whatever the Textboxmain wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Textbox tb =null;
    GreenfootImage img;
    
     public  Textboxmain(){
        tb=Textbox.getInstance();
       img = new GreenfootImage(" csjna ", 20, 
                                     Color.WHITE, Color.BLACK);
       
        this.setLocation(100,100);
        setImage(img);
        //setImage(imgM);
        }
    public void act() 
    {
        // Add your action code here.
         tb=Textbox.getInstance();
         if(WorldManager.getInstance().currentWorld instanceof MonsterWorld) {
         img = new GreenfootImage( tb.message , 20, 
                                     Color.WHITE, Color.BLACK);
          }
          else if(WorldManager.getInstance().currentWorld instanceof MyWorld) {
         img = new GreenfootImage( tb.message , 20, 
                                     Color.WHITE, Color.BLACK);
            
            }

       
        this.setLocation(400,580);
        setImage(img);
    }    
}
