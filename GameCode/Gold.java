import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gold here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gold extends Subject
{
    /**
     * Act - do whatever the Gold wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Gold obj;
    Gold()
    {
        super();
        setActorTitle("LOOT (25 GOLD)");
        GreenfootImage img = new GreenfootImage("gold.png");    
        img.scale(60,60);
        this.setImage(img);
        obj = this;
    }
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void notifyObservers(ISubject s){}
    
    public void addObservers(ISubject s){}
     
    public void die(ISubject s){}
    
    public void causeDamage(ISubject a){}
      
    public void updateDamage(ISubject s){}

    public void createCommandBindings()
    {
        IPlayerCommandTarget getGoldCommand = new IPlayerCommandTarget(){
            public void act(Man player){
                player.addGold(25);
                obj.getWorld().removeObject(obj);

            }
        };
        newCommandBinding("Q", "PICK UP LOOT!", getGoldCommand);
    }
}
