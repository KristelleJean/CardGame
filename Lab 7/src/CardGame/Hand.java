package CardGame;

/* *********************************************************************
* Name: Eric Segally, Kristelle Lucero
* Class: IOOP
* Date: 14 December 2015
* **********************************************************************
* ID: Lab #07
* Purpose: Simluates the hand of a player in the cardgame. The hand may
* contain a max of 5 cards and a min of 1 card. Players may choose to 
* draw from the deck and add to their current hand or discard a card 
* of their choice. The sum of each card in the hand must be determined
* along with the product of each card in the hand.
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
		hand.remove(index-1);
	}
	/*
	* TEST SUITE
	* *********************************************************************
	* Normal Cases
	* 	* Input: 
	* 	Hand: [3,J,A]
	* Output: 	
	*	*would you like this A to represent an 11 or 1?* (based on user input.)
	*	Sum is 24 (assuming user put in 11 for A)
	*	Product is 330 (assuming user put in 11 for A)
	* 
	* Boundary Cases
	* Input: 
	* 	Hand: [7]
	* Output: 	
	*	Sum is 7
	*	Product is 7
	* Input: 
	* 	Hand: [Q,4,K,3,5]
	* Output: 	
	* 	Sum is 32
	* 	Product is 6000
	*
	* Extreme Cases
	* Input:
	*  Hand is empty
	* Output: 
	*	A new card is drawn
	* *********************************************************************
	*/
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
				product *= aceValue();
			} else if (hand.get(i).equals("J")||hand.get(i).equals("Q")||hand.get(i).equals("K")) {
				product *= 10;
			} else {
				product *= Integer.parseInt(hand.get(i));
			}
			result[1]=product;
		}
		
		return result;
	}
	
	//Returns the index of the card in the array if the card is in the hand, -1
	//otherwise.
	private int containsCard(String card){
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
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int input;

		System.out.println("Would you like this ace card to represent an 11 or a 1?");
		input = scan.nextInt();

		if (input != 1 && input != 11) {
			System.out.println("That is not a valid option");
			aceValue();
		}

		return input;
	}
}
