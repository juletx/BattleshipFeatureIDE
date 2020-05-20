package battleship;

public class Battleship {
	public static void main(String[] args) {
		original(args);
	}
	
	private static void printAbout() {
		original();
		System.out.println("Computer Strategy Column RandomColumn © 2020 Julen Etxaniz");
	}
	
	private static int calculateCol() {
		return Randomizer.nextInt(0, Grid.NUM_COLS - 1);
	}
}