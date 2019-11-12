/**
 * Write a description of class ISubject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface ISubject  
{
  public void notifyObservers(ISubject s);
  
  public void addObservers(ISubject s);
     
  public void die(ISubject s);
    
  public void causeDamage(ISubject a);
  
  public void updateDamage(ISubject s);
}
