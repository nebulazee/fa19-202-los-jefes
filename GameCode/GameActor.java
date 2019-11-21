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
    
    GameActor()
    {
        createCommandBindings();
    }
    
    public void createCommandBindings(){}

    protected void newCommandBinding(String key, String message, IPlayerCommandTarget command)
    {
        PlayerCommand cmd = new PlayerCommand();
        cmd.setCommandTooltip(message);
        cmd.setCommandReceiver(command);
        commandMap.put(key, cmd);
    }

    protected void checkAndRunCommand(String pressedKey)
    {
        Man man = (Man) getOneIntersectingObject(Man.class);
        if (man != null)
        {
            IPlayerCommand currentCommand = commandMap.get(pressedKey);
            if (currentCommand != null)
            {
                currentCommand.runCommand(man);
            }
        }
    }

    public String getCommandTooltips()
    {
        StringBuffer sBuf = new StringBuffer();

        for (Map.Entry<String,IPlayerCommand> entry : commandMap.entrySet())
        {
            sBuf.append("[" + entry.getKey() + "]" + "\t");
            sBuf.append(entry.getValue().getCommandTooltip());
            sBuf.append("\n");
        }
        return sBuf.toString();
    }
}