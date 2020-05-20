package battleship;

public class Battleship {
	public static void main(String[] args) {
		original(args);
		System.out.println("Computer SETUP...DONE...PRESS ENTER TO CONTINUE...");
		reader.nextLine();
		reader.nextLine();
		Player computer = new Player();
		setupComputer(computer);
		System.out.println("\nCOMPUTER GRID (FOR DEBUG)...");
		computer.playerGrid.printShips();
	}
	
	private static void setupComputer(Player p) {
		System.out.println();
		int counter = 1;
		int normCounter = 0;

		while (p.numOfShipsLeft() > 0) {
			for (Ship s : p.ships) {
				int row = Randomizer.nextInt(0, Grid.NUM_ROWS - 1);
				int col = Randomizer.nextInt(0, Grid.NUM_COLS - 1);
				int dir = Randomizer.nextInt(0, 1);

				// System.out.println("DEBUG: row-" + row + "; col-" + col + "; dir-" + dir);

				while (hasErrorsComp(row, col, dir, p, normCounter)) // while the random nums make error, start again
				{
					row = Randomizer.nextInt(0, Grid.NUM_ROWS - 1);
					col = Randomizer.nextInt(0, Grid.NUM_COLS - 1);
					dir = Randomizer.nextInt(0, 1);
					// System.out.println("AGAIN-DEBUG: row-" + row + "; col-" + col + "; dir-" +
					// dir);
				}

				// System.out.println("FURTHER DEBUG: row = " + row + "; col = " + col);
				p.ships[normCounter].setLocation(row, col);
				p.ships[normCounter].setDirection(dir);
				p.playerGrid.addShip(p.ships[normCounter]);

				normCounter++;
				counter++;
			}
		}
	}
	
	private static boolean hasErrorsComp(int row, int col, int dir, Player p, int count) {
		// System.out.println("DEBUG: count arg is " + count);

		int length = p.ships[count].getLength();

		// Check if off grid - Horizontal
		if (dir == 0) {
			int checker = length + col;
			// System.out.println("DEBUG: checker is " + checker);
			if (checker > 10) {
				return true;
			}
		}

		// Check if off grid - Vertical
		if (dir == 1) // VERTICAL
		{
			int checker = length + row;
			// System.out.println("DEBUG: checker is " + checker);
			if (checker > 10) {
				return true;
			}
		}

		// Check if overlapping with another ship
		if (dir == 0) // Hortizontal
		{
			// For each location a ship occupies, check if ship is already there
			for (int i = col; i < col + length; i++) {
				// System.out.println("DEBUG: row = " + row + "; col = " + i);
				if (p.playerGrid.hasShip(row, i)) {
					return true;
				}
			}
		} else if (dir == 1) // Vertical
		{
			// For each location a ship occupies, check if ship is already there
			for (int i = row; i < row + length; i++) {
				// System.out.println("DEBUG: row = " + row + "; col = " + i);
				if (p.playerGrid.hasShip(i, col)) {
					return true;
				}
			}
		}

		return false;
	}
}