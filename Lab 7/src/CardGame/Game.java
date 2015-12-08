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
		
		Player player_one = new Player(playerOne);
		Player player_two = new Player(playerTwo);
		
		do{
			
		}while(Player.completeTurn());
	}
}
