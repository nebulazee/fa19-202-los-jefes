/**
 * Write a description of class IPlayerCommandTarget here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IPlayerCommandTarget  
{
    /**
     * run the target command
     * @param player The object on which to act
     */
    void act(Man player);
}
