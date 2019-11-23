# Team Hackathon Project
## Design Notes:
### The game "Warriors of the Keep" is developed using the Greenfoot Java Framework and involves the extensive use of design patterns which are discussed as following:
* Travelling between screens across the game map has been implemented using the **State** pattern. As the player moves through any of the portals on a screen, the state machine (WorldManager) switches to the next Greenfoot world depending on the current state. 
* Player stats such as hit points, gold possessed, weapon being held, and progress through the game are maintained by a **Singleton** pattern (Scoreboard). This Scoreboard class is also a subject to **Observers** of player objects.
![uml class diagram](https://github.com/nguyensjsu/fa19-202-los-jefes/blob/master/GameCode/documents/FinalObserverSingletonPattern.png)
* A **Factory Method** is used to generalize the spawning of monsters in an extendible way for map screens with monster battles.
* A Nested **Factory Method** is also used to randomly and dynamically generate different treasure chests (Factory #1) containing different weapons (Factory #2). With this, any chest can contain any randomly selected weapon.
* A **Command** pattern binds game actions to specific objects (Actors) to enable dynamic customization of interactions with the game player and Actors.

### Current Status
To Use:

Right Click "WorldManager" -> getNewInstance()
Navigation bound to [I,J,K,L] for now
