package battleship;

public class Battleship {
	private static int row = Grid.NUM_ROWS;

	public static void main(String[] args) {
		original(args);
	}

	private static void printAbout() {
		original();
		System.out.println("Computer Strategy Row BottomUp © 2020 Julen Etxaniz");
	}

	private static int calculateRow() {
		if (row == 0) {
			row = Grid.NUM_ROWS - 1;
		} else {
			row--;
		}
		return row;
	}
}