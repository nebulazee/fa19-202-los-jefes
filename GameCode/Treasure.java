import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Treasure here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Treasure extends GameActor {
    String imageClosed, imageOpen;
    private int strength;
    private int openDelay;
    private boolean openedChest;
    public Weapon associatedWeapon;

    Treasure() {
        super();
    }

    Treasure(String imageClosed, String imageOpen) {
        super();
        this.imageClosed = imageClosed;
        this.imageOpen = imageOpen;

        setActorTitle("TREASURE CHEST");

        createWeapon();

        GreenfootImage treasureClosedImage = new GreenfootImage(imageClosed);
        treasureClosedImage.scale(50, 50);
        setImage(treasureClosedImage);

        this.strength = 30;
        this.openDelay = 0;
        this.openedChest = false;
    }

    class MotionRenderer {
        String file;
        GreenfootImage image;

        public MotionRenderer(String file) {
            this.file = file;
            this.image = new GreenfootImage(file);
            // image.scale(60,60);
        }
    }

    MotionRenderer im;

    public void takeDamage() {
        this.strength = this.strength - 10;
        // System.out.println(this.strength);
    }

    public Weapon exchangeWeapon(Weapon w) {
        Weapon temp = associatedWeapon;
        this.associatedWeapon = w;
        updateWeaponImage();
        setActorTitle(w.getWeaponStats());

        return temp;

    }

    private void updateWeaponImage() {
        GreenfootImage weaponImage = new GreenfootImage(associatedWeapon.getWeaponImage());
        weaponImage.scale(60, 60);
        setImage(weaponImage);
    }

    public abstract void createWeapon();

    public void act() {

        if (this.strength <= 0) {
            this.openDelay++;
            if (this.openDelay == 60) {
                GreenfootImage treasureOpenImage = new GreenfootImage(imageOpen);
                treasureOpenImage.scale(50, 50);
                setImage(treasureOpenImage);
            } else if (this.openDelay == 120) {
                chestOpened();
            }
        }

    }

    private void chestOpened() {

        this.openedChest = true;
        updateWeaponImage();

        setActorTitle(associatedWeapon.getWeaponStats());

        commandMap.remove("A");
        IPlayerCommandTarget pickWeaponCmd = new IPlayerCommandTarget() {
            public void act(Man player) {
                Weapon picked = exchangeWeapon(Scoreboard.getCurrentWeapon());
                Scoreboard.updateWeapon(picked);
            }
        };
        newCommandBinding("Q", "Swap with this weapon", pickWeaponCmd);
    }

    public void setImage(MotionRenderer img) {
        // System.err.println("Man image is set to "+img.fileName);
        super.setImage(img.image);
    }

    public void createCommandBindings() {

        IPlayerCommandTarget openChestCmd = new IPlayerCommandTarget() {
            public void act(Man player) {
                takeDamage();
            }
        };
        newCommandBinding("A", "Attack to break open!", openChestCmd);

    }

    // public abstract Treasure getTreasure();

}
