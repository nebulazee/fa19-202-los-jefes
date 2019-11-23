# Team Hackathon Project

## Design Notes:

### The game "Warriors of the Keep" is developed using the Greenfoot Java Framework and involves the extensive use of design patterns which are discussed as following:

- Travelling between screens across the game map has been implemented using the **State** pattern. As the player moves through any of the portals on a screen, the state machine (WorldManager) switches to the next Greenfoot world depending on the current state.
  ![uml class diagram](https://github.com/nguyensjsu/fa19-202-los-jefes/blob/master/GameCode/documents/StateMachineClassDiagram.png)
- Player stats such as hit points, gold possessed, weapon being held, and progress through the game are maintained by a **Singleton** pattern (Scoreboard). This Scoreboard class is also a subject to **Observers** of player objects.
  ![uml class diagram](https://github.com/nguyensjsu/fa19-202-los-jefes/blob/master/GameCode/documents/ObserverPattern_singletonClassDiagram.png)
- A **Factory Method** is used to generalize the spawning of monsters in an extendible way for map screens with monster battles.
  ![uml class diagram](https://github.com/nguyensjsu/fa19-202-los-jefes/blob/master/GameCode/documents/UpdatedMonsterFactorClassDiagram.png)
- A Nested **Factory Method** is also used to randomly and dynamically generate different treasure chests (Factory #1) containing different weapons (Factory #2). With this, any chest can contain any randomly selected weapon.
  ![uml class diagram](https://github.com/nguyensjsu/fa19-202-los-jefes/blob/master/GameCode/documents/Nested_Factory_Method_Design_Pattern_of_Treasure_and_Weapon.svg)
- A **Command** pattern binds game actions to specific objects (Actors) to enable dynamic customization of interactions with the game player and Actors.
  ![uml class diagram](https://github.com/nguyensjsu/fa19-202-los-jefes/blob/master/GameCode/documents/CommandPattern.svg)

## Agile

### Task Division

#### Aashay Mokadam

World Manager (State Pattern), Textbox Commands (Command Pattern)

#### Aishwarya Rastogi

Scoreboard (Singleton Pattern), Monster Generation (Factory Method)

#### Harsh Trivedi

Start Screen, State Machine Assistance, Scoreboard (Observer)

#### Samkit Sheth

Actor Movement and Interactions, Text Tooltips (Singleton, Observer), Game End Logic

#### Varshit Shah

Treasure and Weapon Generation (Nested Factory Method)

### Team Burndown

![agile burndown chart](https://github.com/nguyensjsu/fa19-202-los-jefes/blob/master/GameCode/documents/Agile-Burndown.png)
