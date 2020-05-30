package battleship;

public class Battleship {
	private static void printAbout() {
		original();
		System.out.println("PlayerNames © 2020 Julen Etxaniz");
	}
	
	// Set player 1 name typed by user
	private static void setPlayer1Name(Player player1) {
		System.out.print("\nType Player1 name: ");
		String name = reader.next();
		player1.setName(name);
	}
	
	// Set player 2 name typed by user
	private static void setPlayer2Name(Player player2) {
		System.out.print("\nType Player2 name: ");
		String name = reader.next();
		player2.setName(name);
	}
}