package CardGame;

import java.util.Scanner;

public class Game {
	
	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the first players name!");
		String playerOne = scan.nextLine();
		System.out.println("Enter the first players name!");
		String playerTwo = scan.nextLine();
		
		int target = (int)(Math.random() * 40) + 10;
		System.out.println("The target score is " + target);
		
		Player player_one = new Player(playerOne, target);
		Player player_two = new Player(playerTwo, target);
		
		do{
			
		}while(Player.completeTurn());
	}
}
