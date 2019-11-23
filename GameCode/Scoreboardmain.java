import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scoreboardmain here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Scoreboardmain extends Subject 
{
    int monsterVal = 1000;
    int manVal = 1000;
    GreenfootImage img;
    GreenfootImage scoreboard;
    Color n = new Color(255, 232, 213);
    
    public void updateDamage(ISubject s) 
    {

    }

    public Scoreboardmain() {
        scoreboard = new GreenfootImage("upper_textbox.png");
        scoreboard.scale(scoreboard.getWidth() - 400, scoreboard.getHeight() - 150);
        img = new GreenfootImage("    Health : " + Scoreboard.getHealth() + "" + "    Monster :" + 1000, 20, Color.BLACK, n);
      

        scoreboard.drawImage(img, scoreboard.getWidth() / 2 - 200, scoreboard.getHeight() / 2);

        this.setLocation(400, 50);
           
        
        setImage(scoreboard);
        // setImage(imgM);
    }

    public void setMonsterHealth(int val) 
    {
        this.monsterVal = val;
    }

    /**
     * Act - do whatever the Scoreboardmain wants to do. This method is called
     * whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        scoreboard = new GreenfootImage("upper_textbox.png");
        scoreboard.scale(scoreboard.getWidth() - 400, scoreboard.getHeight() - 150);
        if (WorldManager.getCurrentWorld() instanceof MonsterWorld) {
            img = new GreenfootImage("    Health : " + Scoreboard.getHealth() + " " + "    Monster :" + monsterVal + " "
                    + "    Gold Count :" + Scoreboard.getGoldCount(), 20, Color.BLACK, n);
        } else if (WorldManager.getCurrentWorld() instanceof AnimalWorld) {
            img = new GreenfootImage("    Health : " + Scoreboard.getHealth() + " " + "    Gold Count :" + Scoreboard.getGoldCount(), 20,
                    Color.BLACK, n);

        } else if (WorldManager.getCurrentWorld() instanceof TreasureWorld) {
            img = new GreenfootImage("    Health : " + Scoreboard.getHealth() + " " + "    Gold Count :" + Scoreboard.getGoldCount(), 20,
                    Color.BLACK, n);
        } else if (WorldManager.getCurrentWorld() instanceof TavernWorld) {
            img = new GreenfootImage("    Health : " + Scoreboard.getHealth() + " " + "    Gold Count :" + Scoreboard.getGoldCount(), 20,
                    Color.BLACK, n);
        }

        scoreboard.drawImage(img, scoreboard.getWidth() / 2 - 200, scoreboard.getHeight() / 2);
        //this.setLocation(400, 5);
        setImage(scoreboard);
        // setImage(img);
        // Add your action code here.
    }

}
