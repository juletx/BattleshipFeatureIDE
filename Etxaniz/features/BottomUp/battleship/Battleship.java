package battleship;

public class Battleship {
	private static int row = Grid.NUM_ROWS;

	// Print about info
	private static void printAbout() {
		original();
		System.out.println("Computer Strategy Row BottomUp © 2020 Julen Etxaniz");
	}

	// Decrement and return row
	private static int calculateRow() {
		if (row == 0) {
			row = Grid.NUM_ROWS - 1;
		} else {
			row--;
		}
		return row;
	}
}