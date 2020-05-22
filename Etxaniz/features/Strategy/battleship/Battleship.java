package battleship;

public class Battleship {
	public static void main(String[] args) {
		original(args);
	}
	
	private static void compMakeGuess(Player comp, Player user) {
		int row = calculateRow();
		int col = calculateCol();

		// While computer already guessed this position, make a new random guess
		while (comp.oppGrid.alreadyGuessed(row, col)) {
			row = calculateRow();
			col = calculateCol();
		}

		if (user.playerGrid.hasShip(row, col)) {
			comp.oppGrid.markHit(row, col);
			user.playerGrid.markHit(row, col);
			System.out.println("COMP HIT AT " + convertIntToLetter(row) + convertCompColToRegular(col));
		} else {
			comp.oppGrid.markMiss(row, col);
			user.playerGrid.markMiss(row, col);
			System.out.println("COMP MISS AT " + convertIntToLetter(row) + convertCompColToRegular(col));
		}

		System.out.println("\nYOUR BOARD...PRESS ENTER TO CONTINUE...");
		reader.nextLine();
		user.playerGrid.printCombined();
		System.out.println("PRESS ENTER TO CONTINUE...");
		reader.nextLine();
	}
	
	private static int convertCompColToRegular(int val) {
		if (val < 0 || val >= Grid.NUM_COLS) {
			return -1;
		} else {
			return val + 1;
		}
	}
}