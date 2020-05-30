package battleship;

public class Battleship {
	// Print about info
	private static void printAbout() {
		original();
		System.out.println("Computer Strategy Column RandomColumn © 2020 Julen Etxaniz");
	}
	
	// Calculate and return random column
	private static int calculateCol() {
		return Randomizer.nextInt(0, Grid.NUM_COLS - 1);
	}
}