import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Weapon here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Weapon extends GameActor {
    protected final int damage;
    protected final float attackSpeed;
    protected final String weaponImage;
    protected String strongAgainst;
    protected String weakAgainst;
    private String weaponStats;

    Weapon(String img, int dmg, float speed) {
        super();
        weaponImage = img;
        damage = dmg;
        attackSpeed = speed;

        StringBuffer sBuf = new StringBuffer();
        sBuf.append("HOLY SWORD - ");
        sBuf.append(String.valueOf(dmg));
        sBuf.append(" damage boost - ");
        if (speed <= 0.25f) {
            sBuf.append("high");
        } else if (speed > 0.25f && speed <= 0.60f) {
            sBuf.append("medium");
        } else {
            sBuf.append("low");
        }

        sBuf.append(" speed.");
        weaponStats = sBuf.toString();
        setActorTitle(weaponStats);

    }

    public int getDamage() {
        return damage;
    }

    public float getSpeed() {
        return attackSpeed;
    }

    public String getWeaponImage() {
        return weaponImage;
    }

    public String getWeaponStats() {
        return weaponStats;
    }

    // public float getMonsterDamageMultiplier(Monster m) { }
    // Scoreboard.updateWeapon(temp);

}
