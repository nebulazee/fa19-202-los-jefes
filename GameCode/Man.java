import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Man here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Man extends Subject implements IScoreboardObserver
{
    /**
     * Act - do whatever the Man wants to do. This method is called whenever the
     * 'Act' or 'Run' button gets pressed in the environment.
     */
    int health = 1000;
    int gold = 30;
    int animationCounter = 0;
    int timer = 1;
    boolean manDead = false;
    boolean trackMovement = false;
    int speed = 2;
    int length;
    int direction = 0;
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

    BaseMonster monster = null;
    Treasure treasure = null;
    private MotionRenderer img, imgW, imgA, imgS, imgD, imgR, imgB, imgL;

    public Man() 
    {
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

        Scoreboard.addScoreboardObserver(this);

        this.health=Scoreboard.getHealth();
        this.gold=Scoreboard.getGoldCount();

        setImage(img);

    }

    public void updateDamage(ISubject s) {
        if(s instanceof BaseMonster) {
            damage(10);
        }
        /*if (s instanceof Monster) {
            damage(1);
            // System.out.println(this.health);
        }
        if (s instanceof Demon) {
            damage(1);
            // System.out.println(this.health);
        }
        if (s instanceof Monster2 ) {
            damage(1);
        }
        */
        if (s instanceof banana) {
            heal(5);
        }
        if (s instanceof Goblin) {
            damage(50);
        }
    }

    public void updateScoreboard() {
        // man shud update score board observer
            Scoreboard.setHealth(health);
            Scoreboard.setGoldCount(gold);
    }


    public void setImage(MotionRenderer img) {
        // System.err.println("Man image is set to "+img.fileName);
        super.setImage(img.image);
    }

    private void checkGold() {
        if (this.getOneIntersectingObject(Gold.class) != null) {
            gold += 15;
            Scoreboard.setGoldCount(gold);
            this.removeTouching(Gold.class);
        }
    }

    public void heal(int hpUp) 
    { 
        health += hpUp; 
        updateScoreboard();
    }
    public void damage(int hit) 
    {
        health -= hit;
        updateScoreboard();
    }
    public void addGold(int reward)
    {
        gold += reward;
        updateScoreboard();
    }

    public Boolean chargeGold(int cost)
    {
        if (gold >= cost)
        {
            gold -= cost;
            updateScoreboard();
            return true;
        }
        else
        {
            return false;
        }
    }

    public void scoreboardUpdateEvent()
    {
        this.health = Scoreboard.getHealth();
        this.gold = Scoreboard.getGoldCount();
    }

    public void act() 
    {
        updateTooltips();
        movement();
        checkGold();
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

        if (Greenfoot.isKeyDown("a")) {
            if (animationCounter % 2 == 0 && direction==Direction.LEFT)
                animateAttack(imgA);
            if (animationCounter % 2 == 0 && direction==Direction.RIGHT)
                animateAttack(imgD);
            if (animationCounter % 2 == 0 && direction==Direction.UP)
                animateAttack(imgW);
            if (animationCounter % 2 == 0 && direction==Direction.DOWN)
                animateAttack(imgS);

        }

        // if(getObjectsInRange(80, Monster.class).size()>0) {
        // monster = getObjectsInRange(80, Monster.class).get(0);
        monster = (BaseMonster) getOneIntersectingObject(BaseMonster.class);
        if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("w")
                || Greenfoot.isKeyDown("s")) {
            if (null != monster)
                 monster.updateDamage(this);
        }

        // }
        // if (getObjectsInRange(80, Demon.class).size() > 0) {
        // monster = getObjectsInRange(80, Demon.class).get(0);
        //monster = (Demon) getOneIntersectingObject(Demon.class);
        /*if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("w")
                || Greenfoot.isKeyDown("s")) {
            if (null != monster)
                ((Demon) monster).updateDamage(this);
        }

        monster = (Monster2) getOneIntersectingObject(Monster2.class);
        if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("w")
                || Greenfoot.isKeyDown("s")) {
            if (null != monster)
                ((Monster2) monster).updateDamage(this);
        }*/
        // }
        // if (getObjectsInRange(80, Treasure.class).size() > 0) {
        // treasure = getObjectsInRange(80, Treasure.class).get(0);
        treasure = (Treasure) getOneIntersectingObject(Treasure.class);
        if (treasure != null)
        {
            if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("w")
                    || Greenfoot.isKeyDown("s")) {
                treasure.updateDamage(this);
            } else if (Greenfoot.isKeyDown("g")) {
                treasure.pickWeapon(this);
            }
        }

        // }
    }

    public void animateAttack(MotionRenderer img) {

        if (timer == 1)
            setImage(img);
        else if (timer == 2)
            setImage(imgD);
        else if (timer == 3)
            setImage(imgA);
        // else if(timer>=4)
        // endAnimation();
        timer++;

    }

    private void checkLocation() {
        System.out.println(getX() + "  , " + getY());
        // if(getX() == 599)
        // Greenfoot.setWorld(new MonsterWorld());
    }

    public void movement(){
        if(Greenfoot.isKeyDown("up")){
            direction=Direction.UP;
            //setRotation(Direction.UP);
            setImage(img);
            movePlayer();
        } else if(Greenfoot.isKeyDown("down")){
            direction=Direction.DOWN;
            //setRotation(Direction.DOWN);
            setImage(imgB);
            movePlayer();
        } else if(Greenfoot.isKeyDown("left")){
            direction=Direction.LEFT;
            //setRotation(Direction.LEFT);
            setImage(imgL);
            movePlayer();
        } else if(Greenfoot.isKeyDown("right")){
            direction=Direction.RIGHT;
            //setRotation(Direction.RIGHT);
            setImage(imgR);
            movePlayer();
        }
    }


    public void movePlayer(){

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
        //Actor gob = getOneObjectAtOffset(adjustedChangeX, adjustedChangeY, Goblin.class);
        
        if(tavern==null && treasure==null && score==null && text==null){
            setLocation(currentX + changeX,currentY + changeY);
            if (hitGoblin()) {
                setLocation(currentX - changeX,currentY - changeY);
            }
           
        }
    }

    private void updateTooltips()
    {
        String title;
        GameActor obj = (GameActor)getOneIntersectingObject(GameActor.class);
        if (obj != null)
        {
            title = obj.getActorTitle();
            StringBuffer msg = new StringBuffer();
            msg.append(title);
            msg.append("\n\n");
            msg.append(obj.getCommandTooltips());
            Textboxmain.setTextboxMsg(msg.toString());
            if (Greenfoot.isKeyDown("q"))
            {
                obj.checkAndRunCommand("q");
            }
        }
        else
        {
            title = WorldManager.getCurrentWorld().getTitle();
            Textboxmain.setTextboxMsg(title.toString());
        }
    }
    
    private int getChangeX(int direction){
        if(direction == Direction.RIGHT){
            return speed;
        }
        if(direction == Direction.LEFT){
            return -speed;
        }
        return 0;
    }
    
    private int getChangeY(int direction){
        if(direction == Direction.DOWN){
            return speed;
        }
        if(direction == Direction.UP){
            return -speed;
        }
        return 0;
    }

    private int adjustOffset(int offset){
        int signOfOffset = (int)Math.signum(offset);
        int distanceToFront = length/2;
        int adjustAmount = distanceToFront * signOfOffset;
        return offset + adjustAmount;
    }

    // public void movement() {
    //     int x = getX();
    //     int y = getY();
    //     String title = ((BaseWorld)WorldManager.getCurrentWorld()).getTitle();
    //     StringBuffer msg = new StringBuffer();
    //     msg.append(title);
    //     msg.append("\n\n");
    //     GameActor obj = (GameActor)getOneIntersectingObject(GameActor.class);
    //     if (obj != null)
    //     {
    //         msg.append(obj.getCommandTooltips());
    //         Textboxmain.setTextboxMsg(msg.toString());
    //         if (Greenfoot.isKeyDown("q"))
    //         {
    //             obj.checkAndRunCommand("q");
    //         }
    //     }
    //     else
    //     {
    //         Textboxmain.setTextboxMsg(msg.toString());
    //     }
    //     if(Tavern == null){
    //     if (Greenfoot.isKeyDown("up")) {
    //         setImage(img);
    //         setLocation(x, y - 2);
    //         //if (!(hitTavern() || hitGoblin() || hitTreasure() || hitScoreboard() || hitTextbox())) {
    //             //setLocation(x, y - 2);
    //              //setLocation(x, y + 2);
    //         //}
    //         /*
    //          * if(hitMonster()) { setLocation( x, y ); }
    //          */
    //     }
    //     if (Greenfoot.isKeyDown("down")) {
    //         setImage(imgB);
    //         setLocation(x, y + 2);
            // if (!(hitTavern() || hitGoblin() || hitTreasure() || hitScoreboard() || hitTextbox())) {
            //     setLocation(x, y - 2);
            //     setLocation(x, y + 2);
            // }
    //         /*
    //          * if(hitMonster()) { setLocation( x, y ); }
    //          */
    //     }
    //     if (Greenfoot.isKeyDown("right")) {
    //         setImage(imgR);
    //         setLocation(x + 2, y);

    //         //if (!(hitTavern() || hitGoblin() || hitTreasure() || hitScoreboard() || hitTextbox())) {
    //             //setLocation(x - 2, y);
    //             //setLocation(x + 2, y);
    //         //}
    //         /*
    //          * if(hitMonster()) { setLocation( x, y ); }
    //          */
    //     }
    //     if (Greenfoot.isKeyDown("left")) {
    //         setImage(imgL);
    //         setLocation(x - 2, y);
    //         //if (!(hitTavern() || hitGoblin() || hitTreasure() || hitScoreboard() || hitTextbox())) {
    //             //setLocation(x + 2, y);
    //             // setLocation(x - 2, y);
    //         //}
    //         /*
    //          * if(hitMonster()){ setLocation( x, y ); }
    //          */
    //     }
    //     }
    

    // }

    private void checkScreenChange() {
        Portal p = (Portal) getOneIntersectingObject(Portal.class);
        if (p != null) {
            switch (p.getFlag()) {
            case 'N':
                WorldManager.signal("north");
                break;
            case 'S':
                WorldManager.signal("south");
                break;
            case 'E':
                WorldManager.signal("east");
                break;
            case 'W':
                WorldManager.signal("west");
                break;
            default:
                break;

            }

        }

    }

    public boolean hitTavern() {
        if (isTouching(Tavern.class)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hitGoblin() {
        if (isTouching(Goblin.class)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hitMonster() {
        if (isTouching(Monster.class)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hitTreasure() {
        if (isTouching(Treasure.class)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hitScoreboard() {
        if (isTouching(Scoreboardmain.class)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hitTextbox() {
        if (isTouching(Textboxmain.class)) {
            return true;
        } else {
            return false;
        }
    }
}
