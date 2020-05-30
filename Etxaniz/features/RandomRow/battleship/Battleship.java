package battleship;

public class Battleship {
	// Print about info
	private static void printAbout() {
		original();
		System.out.println("Computer Strategy Row RandomRow © 2020 Julen Etxaniz");
	}
	
	// Calculate and return random column
	private static int calculateRow() {
		return Randomizer.nextInt(0, Grid.NUM_ROWS - 1);
	}
}