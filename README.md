# Project 2-1 Dice Chess

In this application the user can play a game of Dice chess against a computer agent.
The game is a variant of classic Chess, which adds a random factor to the strategy. 

The following list describes all differences of the rules:
There is no check or checkmate, it is allowed to move the king to a square attacked by opponent's piece. The goal is to capture opponent's king.
A die is rolled for every move. The die is displayed under to the game board and the number determines which piece can be used to make the move. 1 - pawn, 2 - knight, 3 - bishop, 4 - rook, 5 - queen, 6 - king. (https://brainking.com/en/GameRules?tp=95)

We present to you three different AIs:
- MonteCarlo tree search with Logistic Regression
- ExpectiMiniMax
- Goal-based agent

To select sides and the chosen AIs there is a setting page in the application. All the settings are saved so whenever you open the application again you will have everyithin you chose already!

Have Fun!

**How to run this project:**
ExpectiThis application is using gradle. To run the program execute "gradle build" and "gradle run -x test" in the command line.


**Java version:** Amazon Corretto 16

**Gradle version:** 6.8.3
