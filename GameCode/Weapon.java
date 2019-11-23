import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weapon extends GameActor
{
    protected final int damage;
    protected final float attackSpeed;
    protected final String weaponImage;
    protected String strongAgainst;
    protected String weakAgainst;

    Weapon(String img, int dmg, float speed)
    {
        super();
        weaponImage = img;
        damage = dmg;
        attackSpeed = speed;
    }
    
    public int getDamage() { return damage; }    

    public float getSpeed() { return attackSpeed; } 
    
    public String getWeaponImage() { return weaponImage; }
 
    // public float getMonsterDamageMultiplier(Monster m) { } 

}
