/**
 * Write a description of class PlayerCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerCommand implements IPlayerCommand
{
    IPlayerCommandTarget target;
    String tooltip;

    /**
     * Run the command
     * 
     * @param  player   The target of the action
     */
    public void runCommand(Man player)
    {
        target.act(player);
    }
    
    /**
     * Set the command
     * 
     * @param  command The target command
     */
    public void setCommandReceiver(IPlayerCommandTarget t)
    {
        target = t;
    }
    
    /**
     * Set the command tooltip to display
     * 
     * @param  msg   The command tooltip message
     */
    void setCommandTooltip(String msg)
    {
        tooltip = msg;
    }
    
    /**
     * Display the command tooltip
     * 
     * @return  The command tooltip message
     */
    String getCommandTooltip()
    {
        return tooltip;
    }
}

