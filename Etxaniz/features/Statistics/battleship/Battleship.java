package battleship;

public class Battleship {
	public static void main(String[] args) {
		original(args);
	}
	
	private static void printAbout() {
		original();
		System.out.println("Statistics © 2020 Julen Etxaniz");
	}
	
	private static void playGamePlayer1(Player player1, Player player2) {
		original(player1, player2);
		player2.printStatistics();
	}
	
	private static void playGamePlayer1(Player player1, Player player2) {
		original(player1, player2);
		player1.printStatistics();
	}
}