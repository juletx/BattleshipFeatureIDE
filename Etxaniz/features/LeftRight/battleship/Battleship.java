package battleship;

public class Battleship {
	private static int col = -1;
	
	public static void main(String[] args) {
		original(args);
	}
	
	private static void printAbout() {
		original();
		System.out.println("Computer Strategy Column LeftRight © 2020 Julen Etxaniz");
	}
	
	private static int calculateCol() {
		if (col == Grid.NUM_COLS - 1) {
			col = 0;
		} else {
			col++;
		}
		return col;
	}
}