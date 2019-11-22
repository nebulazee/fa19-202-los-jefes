import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Man here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Man extends Subject {
    /**
     * Act - do whatever the Man wants to do. This method is called whenever the
     * 'Act' or 'Run' button gets pressed in the environment.
     */
    ISubject scoreBoardObs = null;
    int health = 1000000;
    int gold = 30;
    int animationCounter = 0;
    int timer = 1;
    boolean manDead = false;
    boolean trackMovement = false;
    Textbox textbox = null;

    class MotionRenderer {
        String file;
        GreenfootImage image;

        public MotionRenderer(String file) {
            this.file = file;
            this.image = new GreenfootImage(file);
        }
    }

    IMonsterFactory monster = null;
    Treasure treasure = null;
    private MotionRenderer img, imgW, imgA, imgS, imgD, imgR, imgB, imgL;

    public Man() {
        // img = new GreenfootImage("warrior.png");
        // imgW= new GreenfootImage("warrior-front-attack.png");
        // imgD= new GreenfootImage("warrior-right-attack.png");
        // imgA= new GreenfootImage("warrior-left-attack.png");
        // imgS= new GreenfootImage("warrior-back-attack.png");
        // img.scale(60,60);

        img = new MotionRenderer("warrior.png");
        imgW = new MotionRenderer("warrior-front-attack.png");
        imgD = new MotionRenderer("warrior-right-attack.png");
        imgA = new MotionRenderer("warrior-left-attack.png");
        imgS = new MotionRenderer("warrior-back-attack.png");
        imgR = new MotionRenderer("warrior-right.png");
        imgB = new MotionRenderer("warrior-back.png");
        imgL = new MotionRenderer("warrior-left.png");
        img.image.scale(60, 60);

        // gif = new GifImage("skeleton-club.gif");
        // gif.resizeImages(60,60);

        setImage(img);
        // ((Scoreboard) scoreBoardObs).setGoldCount(gold);

    }

    public void updateDamage(ISubject s) {
        if (s instanceof Monster) {
            damage(1);
            // System.out.println(this.health);
        }
        if (s instanceof Demon) {
            damage(1);
            // System.out.println(this.health);
        }
        if (s instanceof banana) {
            heal(5);
        }
        if (s instanceof Goblin) {
            damage(50);
        }
        notifyObservers(s);
    }

    public void notifyObservers(ISubject s) {
        // man shud update score board observer
        if (s != null) {
            ((Scoreboard) scoreBoardObs).setValue(health);
            ((Scoreboard) scoreBoardObs).setGoldCount(gold);

        }
    }

    public void addObservers(ISubject s) {
        scoreBoardObs = s;
    }

    private void checktouching() {
        if (isTouching(banana.class)) {
            removeTouching(banana.class);
            this.updateDamage(new banana());
            // notifyObservers() i.e scoreboard
        }
    }

    public void setImage(MotionRenderer img) {
        // System.err.println("Man image is set to "+img.fileName);
        super.setImage(img.image);
    }

    private void checkGold() {
        if (this.getOneIntersectingObject(Gold.class) != null) {
            gold += 15;
            ((Scoreboard) scoreBoardObs).setGoldCount(gold);
            this.removeTouching(Gold.class);
        }
    }

    public void heal(int hpUp) { health += hpUp; }
    public void damage(int hit) { health -= hit; }
    public void addGold(int reward)
    {
        gold += reward;
        ((Scoreboard) scoreBoardObs).setGoldCount(gold);
    }

    public Boolean chargeGold(int cost)
    {
        if (gold >= cost)
        {
            gold -= cost;
            ((Scoreboard) scoreBoardObs).setGoldCount(gold);
            return true;
        }
        else
        {
            return false;
        }
    }

    public void act() {

        movement();
        checkGold();
        trackMovement = Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("left")
                || Greenfoot.isKeyDown("down");
        if (trackMovement == false) {
            timer = 1;

            setImage(img);
        }
        checktouching();
        attack();
        animationCounter++;

        checkScreenChange();
        // Add your action code here.
    }

    private void attack() {

        if (Greenfoot.isKeyDown("a")) {
            if (animationCounter % 2 == 0)
                animateAttack(imgA);

        }
        if (Greenfoot.isKeyDown("d")) {
            if (animationCounter % 2 == 0)
                animateAttack(imgD);

        }
        if (Greenfoot.isKeyDown("w")) {
            if (animationCounter % 2 == 0)
                animateAttack(imgW);

        }
        if (Greenfoot.isKeyDown("s")) {
            if (animationCounter % 2 == 0)
                animateAttack(imgS);

        }

        // if(getObjectsInRange(80, Monster.class).size()>0) {
        // monster = getObjectsInRange(80, Monster.class).get(0);
        monster = (Monster) getOneIntersectingObject(Monster.class);
        if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("w")
                || Greenfoot.isKeyDown("s")) {
            if (null != monster)
                ((Monster) monster).updateDamage(this);
        }

        // }
        // if (getObjectsInRange(80, Demon.class).size() > 0) {
        // monster = getObjectsInRange(80, Demon.class).get(0);
        monster = (Demon) getOneIntersectingObject(Demon.class);
        if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("w")
                || Greenfoot.isKeyDown("s")) {
            if (null != monster)
                ((Demon) monster).updateDamage(this);
        }

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
            setRotation(Direction.UP);
            movePlayer();
        } else if(Greenfoot.isKeyDown("down")){
            setRotation(Direction.DOWN);
            movePlayer();
        } else if(Greenfoot.isKeyDown("left")){
            setRotation(Direction.LEFT);
            movePlayer();
        } else if(Greenfoot.isKeyDown("right")){
            setRotation(Direction.RIGHT);
            movePlayer();
        }
    }


    public void movePlayer(){
        int currentX = getX();
        int currentY = getY();
        int direction = getRotation();
        int changeX = getChangeX(direction);
        int changeY = getChangeY(direction);
        setLocation(currentX + changeX,currentY + changeY);
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

    // public void movement() {
    //     int x = getX();
    //     int y = getY();
    //     Actor Tavern = getOneObjectAtOffset(2, 0, Tavern.class);
    //     String title = ((BaseWorld)WorldManager.getInstance().currentWorld).getTitle();
    //     StringBuffer msg = new StringBuffer();
    //     msg.append(title);
    //     msg.append("\n\n");
    //     GameActor obj = (GameActor)getOneIntersectingObject(GameActor.class);
    //     if (obj != null)
    //     {
    //         msg.append(obj.getCommandTooltips());
    //         Textbox.getInstance().setMsg(msg.toString());
    //         if (Greenfoot.isKeyDown("q"))
    //         {
    //             obj.checkAndRunCommand("q");
    //         }
    //     }
    //     else
    //     {
    //         Textbox.getInstance().setMsg(msg.toString());
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
    //         //if (!(hitTavern() || hitGoblin() || hitTreasure() || hitScoreboard() || hitTextbox())) {
    //             //setLocation(x, y - 2);
    //             //setLocation(x, y + 2);
    //         //}
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
