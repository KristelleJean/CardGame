package CardGame;

/* *********************************************************************
* Name: 
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
* TEST SUITE
* *********************************************************************
* Normal Cases
* 
* Input: 
* Output: 	
*
* Input: 
* Output: 	
*
* Input: 
* Output: 
* 
* 
* Boundary Cases
* 
* Input: 
* Output: 	
*
* Input: 
* Output: 
*
* Input: 
* Output: 
* 
* 
* Extreme Cases
* 
* Input: 
* Output: 
* *********************************************************************
*/

import java.util.Scanner;

public class Player {
	private static String player;
	private static Hand playerHand;
	private static Deck deck;
	private static int target;
	
	//Creates a player object with an empty hand and no name
	public Player() {
		playerHand = new Hand();
		player = "";
		deck = new Deck();
		target = (int)(Math.random() * 40) + 10;
	}
	
	//Creates a player object with an empty hand and name *name*
	public Player(String name) {
		playerHand = new Hand();
		player = name;
		deck = new Deck();
		target = (int)(Math.random() * 40) + 10;
		takeTurn();
	}
	
	/* Display the player's hand. If empty: draw a card. 
	If full: drop a card. Return a boolean indicating if 
	the player's hand meets the target. */	
	public void takeTurn() {
		System.out.println(player + ": ");
		displayHand();
		
		if(playerHand.isEmpty()) {
			pickup();
		} else if(playerHand.isFull()) {
			drop();
		} else {
			pickUpOrDrop();
		}
	}
	
	//Display the players hand.
	private static void displayHand() {
		playerHand.displayHand();
	}
	
	//Get the player's name.
	public static void getName() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the name of the player:");
		player = scan.nextLine();
	}
	
	//Determine if the player wants to pick up or drop a card
	//Make sure their input is valid
	private void pickUpOrDrop() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Would you like to pickup or drop a card? (Pickup / Drop)");
		String answer = scan.next();
		answer.toLowerCase();
		
		if(answer.contains("pickup")) {
			pickup();
		} else if(answer.contains("drop")) {
			drop();
		} else {
			System.out.println("Error. Try again!");
			pickUpOrDrop();
		}
	}
	
	//Draw a card from the deck, display drawn card, then add to hand
	private void pickup() {
		//Get random card
		String newCard = deck.drawCard();
		
		//Display the card.
		System.out.println("The card you picked up was " + newCard);
		//Add to hand.
		playerHand.addCard(newCard);
	}
	
	//Allow user to select which card they would like to drop
	//Make sure they select a card they are holding
	private void drop() {
		//Pick card from hand to drop
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Which card would you like to drop?");
		int answer = scan.nextInt();
		playerHand.dropCard(answer);
	}
	
	//Return true if player's hand reaches target sum through sum or product
	//Otherwise, false
	public static boolean completeTurn() {
		boolean result = false;
		int sum, product;
		int[] sumAndProduct = new int[2];
		
		sumAndProduct = playerHand.sumAndProduct();
		sum = sumAndProduct[0];
		product = sumAndProduct[1];
		
		if(sum==target||product==target){
			result = true;
		}
		return result;
	}
}