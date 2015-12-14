package CardGame;

/* *********************************************************************
* Name: Eric Segally, Kristelle Lucero
* Class: IOOP
* Date: 14 December 2015
* **********************************************************************
* ID: Lab #07
* Purpose: Stimulates two sets of decks to be used in the cardgame. One
* deck serves as the deck to draw from, while the other serves as a
* discard pile.
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
		shuffle(full);

	}
	
	//Insert a discarded card into the scrap deck.
	public void insertCard(String card){
		scrap.add(card);
	}
	
	//Return the first card on the deck. If the deck is empty, swap the deck with
	//the scrap deck before returning a card.
	public String drawCard(){
		String card;
		if(full.isEmpty()){
			swapDecks();
		}
		card = full.get(0);
		full.remove(full.get(0));
		return card;

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
	//display the cards in the deck for debugging purposes
	public void printDeck(){
		for(String card: full){
			System.out.println(card);
		}
	}
}
