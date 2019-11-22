import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Textbox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Textbox extends GameActor
{
    /**
     * Act - do whatever the Textbox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static Textbox textbox = null;
    private String message = "";
    GreenfootImage img;

    
     private Textbox()
     {       
        img = new GreenfootImage("", 20, 
                                     Color.WHITE, Color.BLACK);
        //  setImage(img); 
         this.setLocation(100,100);
    }                               
    public void act() 
    {
        // Add your action code here.        
    }
    
    public String getMsg()
    {
        return message;
    }
    
    public void setMsg(String msg)
    {
        message = msg;
        img = new GreenfootImage(msg , 20,Color.WHITE, Color.BLACK);
                      
        // setImage(img);
    }    
    
    public synchronized static Textbox getInstance() 
    {
        if (textbox == null) {
            textbox = new Textbox();
            return textbox;
        } else
            return textbox;
    }
}
