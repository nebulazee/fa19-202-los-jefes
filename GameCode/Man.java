import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Man here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Man extends Subject implements IScoreboardObserver {
    
    int health;
    int gold;
    int animationCounter = 0;
    int timer = 1;
    boolean manDead = false;
    boolean trackMovement = false;
    int speed = 2;
    int length;
    int counter =0;
    int direction = 0;
    EndScreen es;
    
    int baseAttack = 15;
    float actionDelay = 0.16f;
    int actionTimer = 0;

    class Direction {
        public static final int UP = 270;
        public static final int DOWN = 90;
        public static final int LEFT = 180;
        public static final int RIGHT = 0;
    }

    class MotionRenderer {
        String file;
        GreenfootImage image;

        public MotionRenderer(String file) {
            this.file = file;
            this.image = new GreenfootImage(file);
        }
    }

    private MotionRenderer img, imgW, imgA, imgS, imgD, imgR, imgB, imgL;

    public Man() {
        img = new MotionRenderer("warrior.png");
        imgW = new MotionRenderer("warrior-front-attack.png");
        imgD = new MotionRenderer("warrior-right-attack.png");
        imgA = new MotionRenderer("warrior-left-attack.png");
        imgS = new MotionRenderer("warrior-back-attack.png");
        imgR = new MotionRenderer("warrior-right.png");
        imgB = new MotionRenderer("warrior-back.png");
        imgL = new MotionRenderer("warrior-left.png");
        img.image.scale(60, 60);
        length = getImage().getWidth();
        // gif = new GifImage("skeleton-club.gif");
        // gif.resizeImages(60,60);
        es = new EndScreen();
        Scoreboard.addScoreboardObserver(this);

        health = Scoreboard.getHealth();
        gold = Scoreboard.getGoldCount();

        setImage(img);

    }

    public void updateDamage(ISubject s) {
        if (s instanceof Goblin) {
            damage(25);
        }
    }

    public void updateScoreboard() {
        Scoreboard.setPlayerStats(this);
    }

    public void setImage(MotionRenderer img) {
        // System.err.println("Man image is set to "+img.fileName);
        super.setImage(img.image);
    }

    public void heal(int hpUp) {
        health += hpUp;
        updateScoreboard();
    }

    public void damage(int hit) {
        health -= hit;
        if (health <= 0) {
            Greenfoot.setWorld(es);
        }
        updateScoreboard();
    }

    public void restore() {
        health = WorldManager.getInstance().getInitialHealth();
        updateScoreboard();
    }

    public void addGold(int reward) {
        gold += reward;
        updateScoreboard();
    }

    public Boolean chargeGold(int cost) {
        if (gold >= cost) {
            gold -= cost;
            updateScoreboard();
            return true;
        } else {
            return false;
        }
    }

    public int getDamage()
    {
        return baseAttack + Scoreboard.getCurrentWeapon().getDamage();
    }

    public void scoreboardUpdateEvent() {
        this.health = Scoreboard.getHealth();
        this.gold = Scoreboard.getGoldCount();
    }
    
    /**
     * Act - do whatever the Man wants to do. This method is called whenever the
     * 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.actionTimer++;
        updateTooltips();
        movement();
        trackMovement = Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("left")
                || Greenfoot.isKeyDown("down");
        if (trackMovement == false) {
            timer = 1;

            setImage(img);
        }
        attack();
        animationCounter++;

        checkScreenChange();
        // Add your action code here.
    }

    private void attack() {
        
        Boolean attk = this.actionTimer/(int)(((actionDelay/4) + Scoreboard.getCurrentWeapon().getSpeed())*100) > 1;
        if (Greenfoot.isKeyDown("a")) {
            if (animationCounter % 2 == 0 && direction == Direction.LEFT)
                animateAttack(imgA);
            if (animationCounter % 2 == 0 && direction == Direction.RIGHT)
                animateAttack(imgD);
            if (animationCounter % 2 == 0 && direction == Direction.UP)
                animateAttack(imgW);
            if (animationCounter % 2 == 0 && direction == Direction.DOWN)
                animateAttack(imgS);
            
            // animationCounter = 1;
            //% 2 == 0

        }


    }

    public void animateAttack(MotionRenderer img) {

        if (timer == 1)
            setImage(img);
        else if (timer == 2)
            setImage(imgD);
        else if (timer == 3)
            setImage(imgA);
        // endAnimation();

    }
    
    /**
     * Prints Man's current location
     * 
     */
    private void checkLocation() {
        System.out.println(getX() + "  , " + getY());
        // if(getX() == 599)
        // Greenfoot.setWorld(new MonsterWorld());
    }
    
    /**
     * Mans movement method
     * 
     */
    public void movement() {
        if (Greenfoot.isKeyDown("up")) {
            direction = Direction.UP;
            // setRotation(Direction.UP);
            setImage(img);
            movePlayer();
        } else if (Greenfoot.isKeyDown("down")) {
            direction = Direction.DOWN;
            // setRotation(Direction.DOWN);
            setImage(imgB);
            movePlayer();
        } else if (Greenfoot.isKeyDown("left")) {
            direction = Direction.LEFT;
            // setRotation(Direction.LEFT);
            setImage(imgL);
            movePlayer();
        } else if (Greenfoot.isKeyDown("right")) {
            direction = Direction.RIGHT;
            // setRotation(Direction.RIGHT);
            setImage(imgR);
            movePlayer();
        }
    }
    
     
    public void movePlayer() {

        int currentX = getX();
        int currentY = getY();

        int changeX = getChangeX(direction);
        int changeY = getChangeY(direction);
        int adjustedChangeX = adjustOffset(changeX);
        int adjustedChangeY = adjustOffset(changeY);

        Actor tavern = getOneObjectAtOffset(adjustedChangeX, adjustedChangeY, Tavern.class);
        Actor treasure = getOneObjectAtOffset(adjustedChangeX, adjustedChangeY, Treasure.class);
        Actor score = getOneObjectAtOffset(adjustedChangeX, adjustedChangeY, Scoreboardmain.class);
        Actor text = getOneObjectAtOffset(adjustedChangeX, adjustedChangeY, Textboxmain.class);
        Actor monster = getOneObjectAtOffset(adjustedChangeX, adjustedChangeY, BaseMonster.class);
        // Actor gob = getOneObjectAtOffset(adjustedChangeX, adjustedChangeY,
        // Goblin.class);

        if (tavern == null && treasure == null && score == null && text == null && monster == null) {
            setLocation(currentX + changeX, currentY + changeY);
            if (hitGoblin()) {
                setLocation(currentX - changeX, currentY - changeY);
            }

        }
    }
    
     /**
     * Updates tool tip at bottom
     * 
     */
    private void updateTooltips() {
        String title;
        GameActor obj = (GameActor) getOneIntersectingObject(GameActor.class);
        if (obj != null) {
            title = obj.getActorTitle();
            StringBuffer msg = new StringBuffer();
            msg.append(title);
            msg.append("\n\n");
            msg.append(obj.getCommandTooltips());
            if (title != "" || obj.getCommandTooltips() != "") {
                Textboxmain.setTextboxMsg(msg.toString());
            } else {
                title = WorldManager.getCurrentWorld().getTitle();
                Textboxmain.setTextboxMsg(title);
            }
            if (Greenfoot.isKeyDown("q")) {
                if(this.actionTimer/(int)(actionDelay*100) > 1)
                {
                    obj.checkAndRunCommand("q");
                    actionTimer = 0;
                }
            }
            if (Greenfoot.isKeyDown("a")) {
                if(this.actionTimer/(int)(((actionDelay/4) + Scoreboard.getCurrentWeapon().getSpeed())*100) > 1)
                {
                    // animationCounter = 2;
                    attack();
                    obj.checkAndRunCommand("a");
                    actionTimer = 0;
                }

            }
        } else {
            title = WorldManager.getCurrentWorld().getTitle();
            Textboxmain.setTextboxMsg(title);
        }
    }

    private int getChangeX(int direction) {
        if (direction == Direction.RIGHT) {
            return speed;
        }
        if (direction == Direction.LEFT) {
            return -speed;
        }
        return 0;
    }

    private int getChangeY(int direction) {
        if (direction == Direction.DOWN) {
            return speed;
        }
        if (direction == Direction.UP) {
            return -speed;
        }
        return 0;
    }

    private int adjustOffset(int offset) {
        int signOfOffset = (int) Math.signum(offset);
        int distanceToFront = length / 2;
        int adjustAmount = distanceToFront * signOfOffset;
        return offset + adjustAmount;
    }
    
     /**
     * Checks Screen change condition on touching portals
     * 
     */
    private void checkScreenChange() {
        Portal p = (Portal) getOneIntersectingObject(Portal.class);
        if (p != null) {
            switch (p.getFlag()) {
            case NORTH:
                WorldManager.signal(Signal.NORTH);
                break;
            case SOUTH:
                WorldManager.signal(Signal.SOUTH);
                break;
            case EAST:
                WorldManager.signal(Signal.EAST);
                break;
            case WEST:
                WorldManager.signal(Signal.WEST);
                break;
            default:
                break;

            }

        }

    }
    
    /**
     * Checks if Man touches Goblin
     * @return true if Man touches Goblin
     */
    public boolean hitGoblin() {
        if (isTouching(Goblin.class)) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Checks if Man touches Monster
     * @return true if Man touches Monster
     */
    public boolean hitMonster() {
        if (isTouching(BaseMonster.class)) {
            return true;
        } else {
            return false;
        }
    }
}
