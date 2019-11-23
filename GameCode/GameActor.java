import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class GameActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class GameActor extends Actor
{
    protected HashMap<String, IPlayerCommand> commandMap;
    private String actorTitle;
    
    /**
     * GameActor Constructor
     */
    GameActor()
    {
        commandMap = new HashMap<String, IPlayerCommand>();
        actorTitle = "";
        createCommandBindings();
    }
    
    /**
     * GameActor Command Create
     */
    public void createCommandBindings(){}

    /**
     * GameActor new Command bind
     * 
     * @param key String
     * @param message String
     * @param command IPlayerCommandTarget
     */
    protected void newCommandBinding(String key, String message, IPlayerCommandTarget command)
    {
        PlayerCommand cmd = new PlayerCommand();
        cmd.setCommandTooltip(message);
        cmd.setCommandReceiver(command);
        commandMap.put(key, cmd);
    }

    /**
     * GameActor checkAndRunCommand
     * 
     * @param pressedKey String
     */
    public void checkAndRunCommand(String pressedKey)
    {
        Man man = (Man) getOneIntersectingObject(Man.class);
        if (man != null)
        {
            String command = pressedKey.toUpperCase();
            IPlayerCommand currentCommand = commandMap.getOrDefault(command, null);
            if (currentCommand != null)
            {
                currentCommand.runCommand(man);
            }
        }
    }

    /**
     * GameActor command tooltip
     * 
     * @return String
     */
    public String getCommandTooltips()
    {
        if (commandMap.isEmpty() == true)
        {
            return "";
        }
        StringBuffer sBuf = new StringBuffer();

        for (Map.Entry<String,IPlayerCommand> entry : commandMap.entrySet())
        {
            sBuf.append("[" + entry.getKey() + "]" + "   ");
            sBuf.append(entry.getValue().getCommandTooltip());
            sBuf.append("\n");
        }
        return sBuf.toString();
    }
    
    /**
     * GameActor set Actor Title
     * 
     * @param t String
     */
    protected void setActorTitle(String t) { actorTitle = t; }

    /**
     * GameActor actor getter
     * 
     * @return String
     */
    public String getActorTitle() { return actorTitle; }
}