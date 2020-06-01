package battleship;

public class Battleship {
	private static int col = Grid.NUM_COLS;
	
	// Print about info
	private static void printAbout() {
		original();
		System.out.println("Computer Strategy Column RightLeft © 2020 Julen Etxaniz");
	}
	
	// Decrement and return column
	private static int calculateCol() {
		if (col == 0) {
			col = Grid.NUM_COLS - 1;
		} else {
			col--;
		}
		return col;
	}
}