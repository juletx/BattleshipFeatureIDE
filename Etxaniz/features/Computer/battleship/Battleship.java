package battleship;

public class Battleship {
	public static void main(String[] args) {
		original(args);
	}
	
	private static Player setupPlayer2() {
		System.out.println("Computer SETUP...DONE...PRESS ENTER TO CONTINUE...");
		reader.nextLine();
		Player computer = new Player();
		setupComputer(computer);
		System.out.println("\nCOMPUTER GRID (FOR DEBUG)...");
		computer.playerGrid.printShips();
		return computer;
	}

	private static void setupComputer(Player p) {
		while (p.numOfShipsLeft() > 0) {
			for (Ship s : p.ships) {
				int row = Randomizer.nextInt(0, Grid.NUM_ROWS - 1);
				int col = Randomizer.nextInt(0, Grid.NUM_COLS - 1);
				int dir = Randomizer.nextInt(0, 1);

				// System.out.println("DEBUG: row-" + row + "; col-" + col + "; dir-" + dir);

				while (hasErrorsComp(row, col, dir, p, s.getLength())) // while the random nums make error, start again
				{
					row = Randomizer.nextInt(0, Grid.NUM_ROWS - 1);
					col = Randomizer.nextInt(0, Grid.NUM_COLS - 1);
					dir = Randomizer.nextInt(0, 1);
					// System.out.println("AGAIN-DEBUG: row-" + row + "; col-" + col + "; dir-" +
					// dir);
				}

				// System.out.println("FURTHER DEBUG: row = " + row + "; col = " + col);
				s.setLocation(row, col);
				s.setDirection(dir);
				p.playerGrid.addShip(s);
			}
		}
	}

	private static boolean hasErrorsComp(int row, int col, int dir, Player p, int length) {
		if (shipNotFit(row, col, dir, length)) {
			return true;
		}

		if (overlappingShip(row, col, dir, length, p)) {
			return true;
		}

		if (touchingShip(row, col, dir, length, p)) {
			return true;
		}

		return false;
	}
}