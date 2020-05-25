package battleship;

public class Battleship {
	public static void main(String[] args) {
		original(args);
	}
	
	private static void playGamePlayer2(Player player1, Player player2) {
		System.out.println("\nComputer IS MAKING GUESS...");
		compMakeGuess(player2, player1);
	}
	
	private static void compMakeGuess(Player comp, Player user) {
		int row = calculateRow();
		int col = calculateCol();

		// While computer already guessed this position, make a new guess
		while (comp.oppGrid.alreadyGuessed(row, col)) {
			col = calculateCol();
			if (comp.oppGrid.alreadyGuessed(row, col)) {
				row = calculateRow();
			}
		}

		markResult(comp, user, row, col, convertIntToLetter(row), convertCompColToRegular(col));
		
		user.printStatistics();
		System.out.println("\nYOUR BOARD...PRESS ENTER TO CONTINUE...");
		reader.nextLine();
		user.playerGrid.printCombined();
		System.out.println("\nPRESS ENTER TO CONTINUE...");
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