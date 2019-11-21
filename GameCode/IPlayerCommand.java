/**
 * Write a description of class IPlayerCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IPlayerCommand  
{

    /**
     * Run the command
     * 
     * @param  player   The target of the action
     */
    void runCommand(Man player);
    
    /**
     * Set the command
     * 
     * @param  command The target command
     */
    void setCommandReceiver(IPlayerCommandTarget t);
    
    /**
     * Set the command tooltip to display
     * 
     * @param  msg   The command tooltip message
     */
    void setCommandTooltip(String msg);
    
    /**
     * Display the command tooltip
     * 
     * @return  The command tooltip message
     */
    String getCommandTooltip();
}
