
import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class WorldManager here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class WorldManager extends GameActor {
    // instance variables - replace the example below with your own
    BaseWorld[][] worldMap;
    public BaseWorld currentWorld;
    static WorldManager instance;

    int worldHeight = 4;
    int worldWidth = 3;

    final int gameHitPoints = 10000;
    final int startingGold = 20;

    enum WorldType {
        MONSTER, ANIMAL, TREASURE;
    }

    /**
     * Constructor for objects of class WorldManager
     */
    private WorldManager() {
    }

    public static BaseWorld getCurrentWorld() {
        return instance.currentWorld;
    }

    public static WorldManager getInstance() {
        if (instance == null) {
            return getNewInstance();
        } else {
            return instance;
        }
    }

    public static WorldManager getNewInstance() {
        instance = new WorldManager();
        instance.startUp();
        return instance;
    }

    private void startUp() {
        Scoreboard.getNewScoreboardInstance();
        Textboxmain.getNewTextboxmainInstance();
        worldMap = new BaseWorld[worldHeight][worldWidth];
        constructWorlds();

        currentWorld.getTextbox().setMsg(currentWorld.getTitle() + "\n\n" + "");
    }

    private void constructWorlds() {
        List<WorldType> worldTypes = new ArrayList<>();
        worldTypes.add(WorldType.MONSTER);
        worldTypes.add(WorldType.ANIMAL);
        worldTypes.add(WorldType.TREASURE);
        Random rand = new Random();

        int monsters = 3;
        int treasures = 2;

        for (int i = 0; i < worldHeight; i++) {
            for (int j = 0; j < worldWidth; j++) {
                if (monsters == 0) {
                    worldTypes.remove(WorldType.MONSTER);
                }
                if (treasures == 0) {
                    worldTypes.remove(WorldType.TREASURE);
                }

                if (i == 3 && j == 2) {
                    BaseWorld world = new TavernWorld(constructConfigurationCode(i, j));
                    worldMap[i][j] = world;
                    currentWorld = world;
                    Greenfoot.setWorld(world);
                } else {
                    WorldType type = worldTypes.get(rand.nextInt(worldTypes.size()));
                    switch (type) {
                    case MONSTER:
                        if (monsters == 3) {
                            worldMap[i][j] = new MonsterWorld(constructConfigurationCode(i, j)) {
                                public void createMonster() {
                                    currentMonster = new BaseMonster("Demon1.png", "Demon2.png", "CEREBRUS", 300, 0.30f);
                                }
                            };
                        } else if (monsters == 2) {
                            worldMap[i][j] = new MonsterWorld(constructConfigurationCode(i, j)) {
                                public void createMonster() {
                                    currentMonster = new BaseMonster("0.png", "1.png", "EL DIABLO", 500, 0.10f);
                                }
                            };
                        } else {
                            worldMap[i][j] = new MonsterWorld(constructConfigurationCode(i, j)) {
                                public void createMonster() {
                                    currentMonster = new BaseMonster("ogre1.png", "ogre2.png", "OGRE", 200, 0.50f);
                                }
                            };
                        }
                        monsters--;
                        break;
                    case ANIMAL:
                        worldMap[i][j] = new AnimalWorld(constructConfigurationCode(i, j));
                        break;
                    case TREASURE:
                        String[] treasureTypes = { "red", "blue", "golden" };
                        String color = treasureTypes[Greenfoot.getRandomNumber(3)];
                        String weapon = "sword (" + String.valueOf(Greenfoot.getRandomNumber(51)) + ").png";
                        int dmg = 21 + Greenfoot.getRandomNumber(30);
                        float speed = Greenfoot.getRandomNumber(8) / 10;

                        worldMap[i][j] = new TreasureWorld(constructConfigurationCode(i, j)) {
                            public void createTreasure() {
                                this.worldTreasure = new Treasure("treasure-closed-" + color + ".png",
                                        "treasure-open-" + color + ".png") {
                                    public void createWeapon() {
                                        associatedWeapon = new Weapon(weapon, dmg, speed);
                                    }
                                };
                            }
                        };

                        treasures--;
                        break;
                    default:
                        break;
                    }
                }
            }
        }
    }

    private String constructConfigurationCode(int i, int j) {
        StringBuffer buf = new StringBuffer();
        if (i > 0) {
            buf.append("N,");
        }
        if (i < worldHeight - 1) {
            buf.append("S,");
        }
        if (j > 0) {
            buf.append("W,");
        }
        if (j < worldWidth - 1) {
            buf.append("E,");
        }

        return buf.toString();
    }

    /**
     * Receives Signal From BaseWorld
     * 
     * @param signal north, south, west, or east
     * @return void
     */
    public static void signal(Signal signal) {
        switch (signal) {
        case WEST:
            instance.switchWorlds(Signal.LEFT);
            break;
        case EAST:
            instance.switchWorlds(Signal.RIGHT);
            break;
        case NORTH:
            instance.switchWorlds(Signal.UP);
            break;
        case SOUTH:
            instance.switchWorlds(Signal.DOWN);
            break;
        default:
            break;
        }
    }

    private void switchWorlds(Signal s) {
        int hor = 0;
        int ver = 0;
        Signal playerSpot;

        for (int i = 0; i < worldHeight; i++) {
            for (int j = 0; j < worldWidth; j++) {
                if (currentWorld.equals(worldMap[i][j]) == true) {
                    hor = j;
                    ver = i;
                }
            }
        }
        int new_hor = hor;
        int new_ver = ver;
        switch (s) {
        case LEFT:
            if (hor - 1 >= 0) {
                new_hor = hor - 1;
            }
            playerSpot = Signal.R;
            break;
        case RIGHT:
            if (hor + 1 < worldWidth) {
                new_hor = hor + 1;
            }
            playerSpot = Signal.L;
            break;
        case UP:
            if (ver - 1 >= 0) {
                new_ver = ver - 1;
            }
            playerSpot = Signal.B;
            break;
        case DOWN:
            if (ver + 1 < worldHeight) {
                new_ver = ver + 1;
            }
            playerSpot = Signal.T;
            break;
        default:
            playerSpot = Signal.X;
            break;
        }

        worldMap[ver][hor] = currentWorld;
        currentWorld = worldMap[new_ver][new_hor];
        currentWorld.setPlayerSpot(playerSpot);
        currentWorld.getTextbox().setMsg(currentWorld.getTitle() + "\n\n" + "");
        Greenfoot.setWorld(currentWorld);
        Greenfoot.start();

    }

    private int getWorldId(int x, int y) {
        int id = (y * 3) + (x + 1);
        return id;
    }

    public static String displayWorldMap() {
        StringBuffer display = new StringBuffer();
        display.append("\u2015 \u2015 \u2015\n");

        for (BaseWorld[] wList : instance.worldMap) {
            // display.append("|");
            StringBuffer items = new StringBuffer();

            for (BaseWorld w : wList) {
                items.append(getCode(w) + " ");
            }
            // display.append("\u00A0");
            display.append(items.toString().trim());
            // display.append("\u00A0");
            display.append("\n");
        }
        display.append("\u2015 \u2015 \u2015\n");

        return display.toString();

    }

    private static String getCode(BaseWorld w) {
        String code;
        switch (w.worldType()) {
        case "MonsterWorld":
            code = "\u2612";
            break;
        case "AnimalWorld":
            code = "\u25A2";
            break;
        case "TreasureWorld":
            code = "\u272A";
            break; // 25CE
        case "TavernWorld":
            code = "\u25A9";
            break;
        default:
            code = "\u00A0";
            break;
        }
        // code = "+";
        if (instance.currentWorld.equals(w) == true) {
            code = "\u25A3";
        }
        return code;
    }

    public int getInitialHealth() {
        return gameHitPoints;
    }

    public int getInitialGold() {
        return startingGold;
    }
}
