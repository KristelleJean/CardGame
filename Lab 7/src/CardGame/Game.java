package CardGame;

import java.util.Scanner;

public class Game {
	
	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
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
			
		}while(player_one.completeTurn());
		
		player_one.displayHand();
		player_two.displayHand();
		
		System.out.println("End of the Game!");
	}
}
