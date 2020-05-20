package battleship;

public class Battleship {
	private static int col = Grid.NUM_COLS;
	
	public static void main(String[] args) {
		original(args);
	}
	
	private static void printAbout() {
		original();
		System.out.println("Computer Strategy Column RightLeft © 2020 Julen Etxaniz");
	}
	
	private static int calculateRow() {
		if (col == 0) {
			col = Grid.NUM_COLS - 1;
		} else {
			col--;
		}
		return col;
	}
}