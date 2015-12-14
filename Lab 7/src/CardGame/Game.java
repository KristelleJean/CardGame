package CardGame;

/* ********************************************************************
* Name: Eric Segally, Kristelle Lucero
* Class: IOOP
* Date: 14 December 2015
* **********************************************************************
* ID: Lab #07
* Purpose: Using a standard deck of cards, develop a game for two 
* players that start the players with 0 cards. At the start of the 
* game, a number between 10 and 50 is randomly generated as the target 
* for this game. On each turn the player can determine whether they 
* would like to pick up a card from the deck or drop a card. The player 
* can have a maximum of 5 cards in their hand at any time. The goal is 
* for the player to hold a collection of cards that reaches the target 
* through sum or product. The target cannot be reached by the sum or 
* product of a subset of the player's cards. For a player's turn, if 
* they choose to draw a card the player adds the first card from the 
* deck to their hand and their turn is complete. The top card on the 
* deck is hidden, so the player does not know what card they will be 
* picking up before they do. If the player drops a card for their turn, 
* you must ask the player which card they would like to drop from their 
* hand and their hand is updated accordingly. Once one player achieves 
* the target, the other player has one more turn. If the other player 
* achieves the target in the final turn, display that the game results 
* in a tie. Otherwise, display which player has won and their hand. At 
* any time if the deck becomes empty, the collection of dropped cards 
* is shuffled and replaces the empty deck. Normal rules apply: a non 
* face card gets the value of the card, a face card is 10, and an Ace 
* is 1 or 11 (you will have to ask the user which they would like it 
* to be).
* *********************************************************************
*/
package CardGame;

import java.util.Scanner;

public class Game {
	
	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		boolean noWinner = true, p1Result = false, p2Result = false;
		
		//Ask for players name.
		System.out.println("Enter the first players name!");
		String playerOne = scan.nextLine();
		System.out.println("Enter the second players name!");
		String playerTwo = scan.nextLine();
		
		//Create random target. (10-50)
		int target = (int)(Math.random() * 40) + 10;
		System.out.println("The target score is " + target + ".");
		
		Player player_one = new Player(playerOne, target);
		Player player_two = new Player(playerTwo, target);
		
		do{
			player_one.takeTurn();
			player_two.takeTurn();
			p1Result = player_one.completeTurn();
			p2Result = player_two.completeTurn();
			
			if(p1Result){
				noWinner= false;
			}else if (p2Result){
				noWinner= false;
			}
		}while(noWinner);
		
		System.out.println("Player one's hand:");
		player_one.displayHand();
		System.out.println("\nPlayer two's hand:");
		player_two.displayHand();
		if(p1Result){
			System.out.println("\nPlayer one wins!");
		}else if (p2Result){
			System.out.println("\nPlayer one wins!");
		}
		
		System.out.println("End of the Game!");
	}
}
