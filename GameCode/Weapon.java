import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weapon extends GameActor
{
    protected int damage;
    protected int attack_speed;
    protected String strong_against;
    protected String weak_against;

    Weapon()
    {
        super();
    }
    
    public int getDamage() { return damage; }    

    public int getSpeed() { return attack_speed; } 
 
    // public float getMonsterDamageMultiplier(Monster m) { } 

}
