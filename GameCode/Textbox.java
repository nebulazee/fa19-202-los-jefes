import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Textbox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Textbox extends Actor
{
    /**
     * Act - do whatever the Textbox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //private int direction=5;
    //private GreenfootImage right = new GreenfootImage("71.png");
    //private GreenfootImage left = new GreenfootImage("bullWL1.png");
    //private static String message = "";
    //private GreenfootImage text = new GreenfootImage("msg"+message, 20, Color.WHITE, Color.BLACK);
    private static Textbox textbox = null;
    public String message = "";
    GreenfootImage img;
    
     public Textbox(){       
         img = new GreenfootImage(" vhgvjh ", 20, 
                                     Color.WHITE, Color.BLACK);
         setImage(img); 
         this.setLocation(100,100);
    }                               
    public void act() 
    {
        // Add your action code here.        
    }
    
    /*public String getMsg()
    {
        return message;
    }*/
    
     public void setMsg(String msg)
    {
        message = msg;
        img = new GreenfootImage(msg , 20,Color.WHITE, Color.BLACK);
                      
        setImage(img);
    }    
    
    public synchronized static Textbox getInstance() {
        if (textbox == null) {
            textbox = new Textbox();
            return textbox;
        } else
            return textbox;
    }
}
