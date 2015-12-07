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
import java.util.ArrayList;
import java.util.Scanner;

public class Hand {
	private ArrayList<String> hand;
	
	public Hand(){
		hand = new ArrayList<String>(0);
	}
	//Display the player’s hand. If the hand is empty display a message
	//indicating so. 
	public void displayHand(){
		if(hand.isEmpty()){
			System.out.println("There are no cards in this hand.");
		} else {
			System.out.println(hand.toString());
		}
	}
	//Returns true if the hand is empty, false otherwise
	public boolean isEmpty(){
		boolean result = false;
		if(hand.isEmpty()){
			result = true;
		}
		return result;
	}
	//Returns true if the hand contains 5 cards, false otherwise.
	public boolean isFull(){
		boolean result = false;
		if(hand.size()==5){
			result = true;
		}
		return result;
	}
	//Inserts a card into the array of cards.
	public void addCard(String card){
		hand.add(card);
	}
	//Drops the card at position index. Swap the last card in
	//the array with this position to keep all cards in the front of the array. 
	public void dropCard(int index){
		hand.remove(index+1);
	}
	//returns the sum and product of the hand
	public int[] sumAndProduct() {
		int[] result = new int[2];
		int sum = 0, product = 1;

		//calculate the sum
		for (int i = 0; i < hand.size(); i++) {
			if (hand.get(i).equals("A")) {
				sum += aceValue();
			} else if (hand.get(i).equals("J")||hand.get(i).equals("Q")||hand.get(i).equals("K")) {
				sum += 10;
			} else {
				sum += Integer.parseInt(hand.get(i));
			}
			result[0]=sum;
		}
		
		//calculate the product
		for (int i = 0; i < hand.size(); i++) {
			if (hand.get(i).equals("A")) {
				sum *= aceValue();
			} else if (hand.get(i).equals("J")||hand.get(i).equals("Q")||hand.get(i).equals("K")) {
				sum *= 10;
			} else {
				sum *= Integer.parseInt(hand.get(i));
			}
			result[1]=product;
		}
		
		return result;
	}
	//Returns the index of the card in the array if the card is in the hand, -1
	//otherwise.
	public int containsCard(String card){
		int index = -1;
		for(int i = 0; i < hand.size(); i++){
			if(hand.get(i).equals(card)){
				index = i;
			}
		}
		return index;
	}
	//Determines if the user would like their ace represented by
	//a 1 or 11. Makes sure that the user enters valid data.
	private int aceValue() {
		Scanner scan = new Scanner(System.in);
		int input;

		do {
			System.out.println("Would you like this ace card to represent an 11 or a 1?");
			input = scan.nextInt();

			if (input != 1 && input != 11) {
				System.out.println("That is not a valid option");
			}
		} while (input == 1 || input == 11);

		return input;
	}
}
