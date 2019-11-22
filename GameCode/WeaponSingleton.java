import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WeaponSingleton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WeaponSingleton extends GameActor
{
    static int currentWeapon;
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
        currentWeapon = 0;
        System.out.println("Current Weapon: 0");
    }
    public void updateWeapon(int no)
    {
        if(no == 1)
        {
            currentWeapon = 1;
           System.out.println("Current Weapon: 1");
        }
        else if(no == 2)
        {
            currentWeapon = 2;
            System.out.println("Current Weapon: 2");
        }
        else if(no == 3)
        {
            currentWeapon = 3;
            System.out.println("Current Weapon: 3");
        }
            
           
    }
    
    public int getCurrentWeapon()
    {
        return currentWeapon;
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
