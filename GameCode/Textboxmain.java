import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Textboxmain here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Textboxmain extends GameActor 
{
    private static Textboxmain textbox = null;
    private String message = "";
    GreenfootImage img;
    GreenfootImage map;
    GreenfootImage textDec;
    Color n;
    Color map_background;

    public Textboxmain() 
    {
        textDec = new GreenfootImage("txtbox.png");
        textDec.scale(textDec.getWidth() - 400, textDec.getHeight() - 50);
        setImage(textDec);
        n = new Color(0, 0, 0, 0);
        img = new GreenfootImage("", 20, Color.BLACK, n);

        map_background = new Color(0, 0, 0, 0);

        // this.setLocation(100,100);
        // setImage(img);
        textDec.drawImage(img, textDec.getWidth() / 2 - 200, textDec.getHeight() / 2);
        this.setLocation(400, 700);
        // setImage(imgM);
    }

    /**
     * Act - do whatever the Textboxmain wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
    }

    public void updateTextbox() 
    {

        img.clear();
        // textDec.clear();

        img = new GreenfootImage(getMsg(), 20, Color.BLACK, n);


        map = new GreenfootImage(WorldManager.displayWorldMap(), 27, Color.BLACK, map_background);

        textDec = new GreenfootImage("txtbox.png");
        textDec.scale(textDec.getWidth() - 400, textDec.getHeight() - 50);
        textDec.drawImage(map, 30, 30);
        textDec.drawImage(img, textDec.getWidth() / 2 -150 , textDec.getHeight() / 2 - 50);
        setImage(textDec);
        this.setLocation(400, 700);
        // setImage(img);
    }

    public String getMsg()
    {
        return message;
    }
    public synchronized static void setTextboxMsg(String msg)
    {
        textbox = WorldManager.getCurrentWorld().getTextbox();
        textbox.setMsg(msg);
    }

    public void setMsg(String msg)
    {
        message = msg;
        updateTextbox();
    }    

    public synchronized static Textboxmain getInstance() 
    {
        if (textbox == null) 
        {
           return  getNewTextboxmainInstance();
        } 
        else
            return textbox;
    }
    
    public static Textboxmain getNewTextboxmainInstance()
    {
        textbox = new Textboxmain();
        return textbox;
    }
    
    
}
