import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WeaponSingleton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WeaponSingleton extends GameActor
{
    static WeaponSingleton weaponInstance;
    private WeaponSingleton()
    {
    }
    public static WeaponSingleton getInstance()
    {
        if (weaponInstance == null)
        {
            weaponInstance = new WeaponSingleton();
            weaponInstance.startUp();
            return weaponInstance;
        }
        else
        {
            return weaponInstance;
        }
    }
    
    private void startUp()
    {
        System.out.println("Current Weapon: 0");
    }

    /**
     * Act - do whatever the WeaponSingleton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
