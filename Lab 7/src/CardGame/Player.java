package CardGame;

/* ********************************************************************
* Name: Eric Segally, Kristelle Lucero
* Class: IOOP
* Date: 14 December 2015
* **********************************************************************
* ID: Lab #07
* Purpose: Simulates a player in the cardgame. Each player contains a
* a name, a hand, and a shared deck. Each player may take a turn
* which consists of drawing or discarding a card. 
* *********************************************************************
*/

import java.util.Scanner;

public class Player {
	private String player;
	private Hand playerHand;
	private static Deck deck;
	private int target;
	
	//Creates a player object with an empty hand and no name
	public Player() {
		playerHand = new Hand();
		player = "";
		deck = new Deck();
		takeTurn();
	}
	
	//Creates a player object with an empty hand and name *name*
	public Player(String name, int target) {
		playerHand = new Hand();
		player = name;
		deck = new Deck();
		this.target = target;
		takeTurn();
	}
	
	/* Display the player's hand. If empty: draw a card. 
	If full: drop a card. Return a boolean indicating if 
	the player's hand meets the target. */	
	public void takeTurn() {
		System.out.println("");
		
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
	public void displayHand() {
		playerHand.displayHand();
	}
	
	//Get the player's name.
	public void getName() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the name of the player: ");
		player = scan.nextLine();
	}

	//Determine if the player wants to pick up or drop a card
	//Make sure their input is valid
	private void pickUpOrDrop() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		System.out.println("The target is "+target+". Would you like to pickup or drop a card? (Pickup / Drop)");
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
		String newCard = deck.drawCard();
		System.out.println("The card you picked up was " + newCard + ".");
		playerHand.addCard(newCard);
	}
	/*
	* TEST SUITE
	* *********************************************************************
	* Normal Cases
	* Input: 
	* 	Hand:[3,5,7] 
	* 	Which card would you like to drop: 3
	* Output: 	
	*	Hand:[3,5]
	* Input: 
	* 	Hand:[J,2,3,4,5] 
	* 	Which card would you like to drop: 3
	* Output: 	
	*	Hand:[J,2,4,5]
	* 
	* Boundary Cases
	*
	* Input:
	* 	Hand:[1]
	* 	Which card would you like to drop: 1 
	* Output: 	
	*	Hand: This hand is empty.
	* 
	* Extreme Cases
	* Input: 
	* 	Hand: is empty
	* Output: 	
	*	A new card should be drawn
	* *********************************************************************
	*/
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
	/*
	* TEST SUITE
	* *********************************************************************
	* Normal Cases
	* Input: 
	* 	Hand:[3,5,7] Target: 45
	* Output: 	
	*	False	
	* Input: 
	* 	Hand:[2,8,5] Target: 15
	* Output: 	
	*	True
	* Input: 
	* 	Hand:[A,5,8] Target: 40
	* 	Would you like this A to represent 11 or 1: 1 
	* Output: 	
	*	True
	* 
	* Boundary Cases
	* Input:
	* 	Hand:[A] Target: 11
	* 	Would you like this A to represent 11 or 1: 11
	* Output: 	
	*	True
	* 
	* Extreme Cases
	* Input: 
	* 	Hand: is empty
	* Output: 	
	*	A new card should be drawn
	* *********************************************************************
	*/
	//Return true if player's hand reaches target sum through sum or product
	//Otherwise, false
	public boolean completeTurn() {
		boolean result = false;
		int sum, product;
		int[] sumAndProduct = new int[2];
		
		sumAndProduct = playerHand.sumAndProduct();
		sum = sumAndProduct[0];
		product = sumAndProduct[1];
		
		if(sum == target || product == target){
			result = true;
		}
		
		return result;
	}
}