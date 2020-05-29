package battleship;

public class Battleship {
	public static void main(String[] args) {
		original(args);
	}
	
	private static void printAbout() {
		original();
		System.out.println("PlayerNames © 2020 Julen Etxaniz");
	}
	
	private static void setPlayer1Name(Player player1) {
		System.out.print("\nType Player1 name: ");
		String name = reader.next();
		player1.setName(name);
	}
	
	private static void setPlayer2Name(Player player2) {
		System.out.print("\nType Player2 name: ");
		String name = reader.next();
		player2.setName(name);
	}
}