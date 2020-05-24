package battleship;

public class Grid {
	private Location[][] grid;

	public Grid() {
		grid = new Location[NUM_ROWS][NUM_COLS];

		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				Location tempLoc = new Location();
				grid[row][col] = tempLoc;
			}
		}
	}

	// Mark a hit in this location by calling the markHit method
	// on the Location object.
	public void markHit(int row, int col) {
		grid[row][col].markHit();
	}

	// Mark a miss on this location.
	public void markMiss(int row, int col) {
		grid[row][col].markMiss();
	}

	// Set the status of this location object.
	public void setStatus(int row, int col, int status) {
		grid[row][col].setStatus(status);
	}

	// Get the status of this location in the grid
	public int getStatus(int row, int col) {
		return grid[row][col].getStatus();
	}

	// Return whether or not this Location has already been guessed.
	public boolean alreadyGuessed(int row, int col) {
		return !grid[row][col].isUnguessed();
	}

	// Set whether or not there is a ship at this location to the val
	public void setShip(int row, int col, boolean val) {
		grid[row][col].setShip(val);
	}

	// Return whether or not there is a ship here
	public boolean hasShip(int row, int col) {
		return grid[row][col].hasShip();
	}

	public int getNumber(int row, int col) {
		return grid[row][col].getNumberOfShip();
	}

	public void setNumber(int row, int col, int val) {
		grid[row][col].setNumberOfShip(val);
	}

	// Get the Location object at this row and column position
	public Location get(int row, int col) {
		return grid[row][col];
	}

	// Return the number of rows in the Grid
	public int numRows() {
		return NUM_ROWS;
	}

	// Return the number of columns in the grid
	public int numCols() {
		return NUM_COLS;
	}

	public void printStatus() {
		generalPrintMethod(0);
	}

	public void printShips() {
		generalPrintMethod(1);
	}

	public void printCombined() {
		generalPrintMethod(2);
	}

	public void addShip(Ship s) {
		int row = s.getRow();
		int col = s.getCol();
		int length = s.getLength();
		int dir = s.getDirection();
		int number = s.getNumber();

		if (!(s.isDirectionSet()) || !(s.isLocationSet()))
			throw new IllegalArgumentException("ERROR! Direction or Location is unset/default");

		// 0 - hor; 1 - ver
		if (dir == 0) // Hortizontal
		{
			for (int i = col; i < col + length; i++) {
				// System.out.println("DEBUG: row = " + row + "; col = " + i);
				grid[row][i].setShip(true);
				grid[row][i].setLengthOfShip(length);
				grid[row][i].setDirectionOfShip(dir);
				grid[row][i].setNumberOfShip(number);
			}
		} else if (dir == 1) // Vertical
		{
			for (int i = row; i < row + length; i++) {
				// System.out.println("DEBUG: row = " + row + "; col = " + i);
				grid[i][col].setShip(true);
				grid[i][col].setLengthOfShip(length);
				grid[i][col].setDirectionOfShip(dir);
				grid[i][col].setNumberOfShip(number);
			}
		}
	}

	// Type: 0 for status, 1 for ships, 2 for combined
	private void generalPrintMethod(int type) {
		System.out.println();
		// Print columns (HEADER)
		System.out.print("  ");
		for (int i = 1; i <= NUM_COLS; i++) {
			System.out.print(i + " ");
		}
		System.out.println();

		// Print rows
		for (int i = 0; i < NUM_ROWS; i++) {
			char theChar = convertIntToLetter(i);
			System.out.print(theChar + " ");

			for (int j = 0; j < NUM_COLS; j++) {
				// type == 0; status
				if (type == 0) {
					if (grid[i][j].isUnguessed()) {
						System.out.print("- ");
					} else if (grid[i][j].checkMiss()) {
						System.out.print("O ");
					} else if (grid[i][j].checkHit()) {
						System.out.print("X ");
					}
					if (j >= 9) {
						System.out.print(" ");
					}
					// type == 1; ships
				} else if (type == 1) {
					if (grid[i][j].hasShip()) {
						// System.out.print("X ");
						if (grid[i][j].getLengthOfShip() == 2) {
							System.out.print("A ");
						} else if (grid[i][j].getLengthOfShip() == 3) {
							System.out.print("B ");
						} else if (grid[i][j].getLengthOfShip() == 4) {
							System.out.print("C ");
						} else if (grid[i][j].getLengthOfShip() == 5) {
							System.out.print("D ");
						} else if (grid[i][j].getLengthOfShip() == 6) {
							System.out.print("E ");
						} else if (grid[i][j].getLengthOfShip() == 7) {
							System.out.print("F ");
						} else if (grid[i][j].getLengthOfShip() == 8) {
							System.out.print("G ");
						}
					} else if (!(grid[i][j].hasShip())) {
						System.out.print("- ");
					}
					if (j >= 9) {
						System.out.print(" ");
					}
					// type == 2; combined
				} else {
					if (grid[i][j].checkMiss())
						System.out.print("O ");
					else if (grid[i][j].checkHit())
						System.out.print("X ");
					else if (grid[i][j].hasShip()) {
						// System.out.print("X ");
						if (grid[i][j].getLengthOfShip() == 2) {
							System.out.print("A ");
						} else if (grid[i][j].getLengthOfShip() == 3) {
							System.out.print("B ");
						} else if (grid[i][j].getLengthOfShip() == 4) {
							System.out.print("C ");
						} else if (grid[i][j].getLengthOfShip() == 5) {
							System.out.print("D ");
						} else if (grid[i][j].getLengthOfShip() == 6) {
							System.out.print("E ");
						} else if (grid[i][j].getLengthOfShip() == 7) {
							System.out.print("F ");
						} else if (grid[i][j].getLengthOfShip() == 8) {
							System.out.print("G ");
						}
					} else if (!(grid[i][j].hasShip())) {
						System.out.print("- ");
					}
					if (j >= 9) {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
	}

	private static char convertIntToLetter(int val) {
		if (val < 0 || val >= NUM_ROWS) {
			return 'Z';
		} else {
			int value = val + 65;
			char letter = (char) value;
			return letter;
		}
	}
}