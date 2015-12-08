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
import java.util.Collections;

public class Deck {
	private ArrayList<String> scrap;
	private ArrayList<String> full;
	
	public Deck(){
		scrap = new ArrayList<String>(0);
		full = new ArrayList<String>();
		
		//fill the deck with the 52 cards
		for (int i = 1; i <= 13; i++) {
			if (i == 1) {
				for (int j = 1; j <= 4; j++) {
					full.add("A");
				}
			} else if (i == 11) {
				for (int j = 1; j <= 4; j++) {
					full.add("J");
				}

			} else if (i == 12) {
				for (int j = 1; j <= 4; j++) {
					full.add("Q");
				}
			} else if (i == 13) {
				for (int j = 1; j <= 4; j++) {
					full.add("K");
				}
			} else {
				for (int j = 1; j <= 4; j++) {
					full.add(Integer.toString(i));
				}
			}
		}
		//printDeck();
		shuffle(full);

	}
	//Insert a discarded card into the scrap deck.
	public void insertCard(String card){
		scrap.add(card);
	}
	//Return the first card on the deck. If the deck is empty, swap the deck with
	//the scrap deck before returning a card.
	public String drawCard(){
		if(full.isEmpty()){
			swapDecks();
		}
		return full.get(0);
	}
	//Returns true if the deck to draw from is empty, false otherwise.
	public boolean isEmpty(){
		return full.isEmpty();
	}
	//Switch the deck and scrap deck. Shuffle the deck.
	public void swapDecks(){
		ArrayList<String> temp = new ArrayList<String>();
		for(String card: scrap){
			temp.add(card);
		}
		for(String card: full){
			scrap.add(card);
		}
		for(String card: temp){
			full.add(card);
		}
		
	}
	//shuffles the cards in the deck
	public void shuffle(ArrayList<String> deck){
		for(int i = 1; i<=3; i++){
			Collections.shuffle(deck);
		}
	}
	
	public void printDeck(){
		for(String card: full){
			System.out.println(card);
		}
	}
}
