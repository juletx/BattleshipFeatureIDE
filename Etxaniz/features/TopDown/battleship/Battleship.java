package battleship;

public class Battleship {
	private static int row = -1;

	// Print about info
	private static void printAbout() {
		original();
		System.out.println("Computer Strategy Row TopDown © 2020 Julen Etxaniz");
	}

	// Increment and return row
	private static int calculateRow() {
		if (row == Grid.NUM_ROWS - 1) {
			row = 0;
		} else {
			row++;
		}
		return row;
	}
}