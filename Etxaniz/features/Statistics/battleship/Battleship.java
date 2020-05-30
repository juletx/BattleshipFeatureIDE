package battleship;

public class Battleship {
	// Print about info
	private static void printAbout() {
		original();
		System.out.println("Statistics © 2020 Julen Etxaniz");
	}

	// Print statistics at the end of player 1 turn
	private static void playGamePlayer1(Player player1, Player player2) {
		original(player1, player2);
		player1.printStatistics(player2);
	}

	// Print statistics at the end of player 2 turn
	private static void playGamePlayer2(Player player1, Player player2) {
		original(player1, player2);
		player2.printStatistics(player1);
	}
}