import greenfoot.*;
/**
 * Write a description of class TreasureFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TreasureFactory  
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class TreasureFactory
     */
    public TreasureFactory()
    {
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public Treasure getTreasure(int no)
    {
        // put your code here
       int randomNumber = Greenfoot.getRandomNumber(3); 
       if(randomNumber == 0)
       {
            return new BlueTreasure(); 
       }
       else if(randomNumber == 1)
       {
           return new RedTreasure();
       }
       else
       {
           return new GoldenTreasure();
        }
    }
    
    
}
