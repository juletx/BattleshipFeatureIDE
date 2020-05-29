package battleship;

public class Battleship {
	public static void main(String[] args) {
		original(args);
	}
	
	private static void playGamePlayer2(Player player1, Player player2) {
		compMakeGuess(player2, player1);
	}
	
	private static void compMakeGuess(Player comp, Player user) {
		System.out.println("\n" + comp.getName() + " IS MAKING GUESS...");
		user.playerGrid.printCombined();
		int row = calculateRow();
		int col = calculateCol();

		// While computer already guessed this position, change position
		while (comp.oppGrid.alreadyGuessed(row, col)) {
			col = calculateCol();
			// If computer already guessed this position, change row
			if (comp.oppGrid.alreadyGuessed(row, col)) {
				row = calculateRow();
			}
		}

		markResult(comp, user, row, col, convertIntToLetter(row), convertCompColToRegular(col));
	}
	
	private static int convertCompColToRegular(int val) {
		if (val < 0 || val >= Grid.NUM_COLS) {
			return -1;
		} else {
			return val + 1;
		}
	}
}