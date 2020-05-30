package battleship;

public class Battleship {
	private static int col = -1;

	// Print about info
	private static void printAbout() {
		original();
		System.out.println("Computer Strategy Column LeftRight © 2020 Julen Etxaniz");
	}
	
	// Increment and return column
	private static int calculateCol() {
		if (col == Grid.NUM_COLS - 1) {
			col = 0;
		} else {
			col++;
		}
		return col;
	}
}