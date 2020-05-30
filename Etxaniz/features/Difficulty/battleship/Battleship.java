package battleship;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Battleship {
	public static Scanner reader = new Scanner(System.in);

	// Application main method
	public static void main(String[] args) {
		System.out.println("JAVA BATTLESHIP\n");
		original(args);

		Player player1 = setupPlayer1();
		Player player2 = setupPlayer2();

		playGame(player1, player2);
	}

	// Setup player 1
	private static Player setupPlayer1() {
		Player player1 = new Player();
		setPlayer1Name(player1);
		setup(player1);
		return player1;
	}

	// Setup player 2
	private static Player setupPlayer2() {
		Player player2 = new Player();
		setPlayer2Name(player2);
		setup(player2);
		return player2;
	}

	// Set player 1 name
	private static void setPlayer1Name(Player player1) {
		player1.setName("Player1");
	}

	// Set player 2 name
	private static void setPlayer2Name(Player player2) {
		player2.setName("Player2");
	}

	// Play game until any player loses
	private static void playGame(Player player1, Player player2) {
		while (true) {
			playGamePlayer1(player1, player2);
			playGamePlayer2(player1, player2);
			if (player2.hasLost() && player1.hasLost()) {
				System.out.println(player1.getName() + " and " + player2.getName() + " DRAW!");
				break;
			} else if (player2.hasLost()) {
				System.out.println(player1.getName() + " WINS! " + player2.getName() + " LOSES!");
				break;
			} else if (player1.hasLost()) {
				System.out.println(player2.getName() + " WINS! " + player1.getName() + " LOSES!");
				break;
			}
		}
	}

	// Play game player 1
	private static void playGamePlayer1(Player player1, Player player2) {
		askForGuess(player1, player2);
	}

	// Play game player 2
	private static void playGamePlayer2(Player player1, Player player2) {
		askForGuess(player2, player1);
	}

	// Setup player ships
	private static void setup(Player p) {
		System.out.println("\n" + p.getName() + " SETUP:");
		p.playerGrid.printShips();
		System.out.println();
		while (p.numOfShipsLeft() > 0) {
			for (Ship s : p.ships) {
				System.out.println(p.getName() + " has " + p.numOfShipsLeft() + " remaining ships to place.\n");
				System.out.println("Ship #" + s.getNumber() + ": " + s.getType() + " (Length=" + s.getLength() + ")");
				int row = -1;
				int col = -1;
				int dir = -1;
				while (true) {
					System.out.print("Type in row (A-" + convertIntToLetter(Grid.NUM_ROWS - 1) + "): ");
					String userInputRow = reader.next();
					userInputRow = userInputRow.toUpperCase();
					row = convertLetterToInt(userInputRow);

					try {
						System.out.print("Type in column (1-" + Grid.NUM_COLS + "): ");
						col = reader.nextInt();
						col = convertUserColToProCol(col);

						System.out.print("Type in direction (0-H, 1-V): ");
						dir = reader.nextInt();
					} catch (InputMismatchException e) {
						col = -1;
						dir = -1;
					}

					// System.out.println("DEBUG: " + row + col + dir);

					if (col >= 0 && col <= Grid.NUM_COLS - 1 && row != -1 && dir != -1) // Check valid input
					{
						if (!hasErrors(row, col, dir, p, s.getLength())) // Check if errors will produce
						{
							break;
						}
					}

					System.out.println("Invalid location!");
				}

				// System.out.println("FURTHER DEBUG: row = " + row + "; col = " + col);
				s.setLocation(row, col);
				s.setDirection(dir);
				p.playerGrid.addShip(s);
				p.playerGrid.printShips();
				System.out.println();
			}
		}
	}

	// Check if ship location has errors
	private static boolean hasErrors(int row, int col, int dir, Player p, int length) {
		if (shipNotFit(row, col, dir, length)) {
			System.out.println("SHIP DOES NOT FIT");
			return true;
		}

		if (overlappingShip(row, col, dir, length, p)) {
			System.out.println("THERE IS ALREADY A SHIP AT THAT LOCATION");
			return true;
		}

		if (touchingShip(row, col, dir, length, p)) {
			System.out.println("THERE IS A TOUCHING SHIP");
			return true;
		}

		return false;
	}

	// Check if ship is off grid
	private static boolean shipNotFit(int row, int col, int dir, int length) {
		// Horizontal
		if (dir == 0) {
			int checker = length + col;
			// System.out.println("DEBUG: checker is " + checker);
			if (checker > Grid.NUM_COLS) {
				return true;
			}
		}
		// Vertical
		if (dir == 1) {
			int checker = length + row;
			// System.out.println("DEBUG: checker is " + checker);
			if (checker > Grid.NUM_ROWS) {
				return true;
			}
		}
		return false;
	}

	// Check if overlapping with another ship
	private static boolean overlappingShip(int row, int col, int dir, int length, Player p) {
		// Hortizontal
		if (dir == 0) {
			// For each location a ship occupies, check if ship is already there
			for (int i = col; i < col + length; i++) {
				// System.out.println("DEBUG: row = " + row + "; col = " + i);
				if (p.playerGrid.hasShip(row, i)) {
					return true;
				}
			}
		} else if (dir == 1) { // Vertical
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

	// Check if touching with another ship
	private static boolean touchingShip(int row, int col, int dir, int length, Player p) {
		if (dir == 0) // Hortizontal
		{
			// For each location a ship occupies, check if another ship is touching
			for (int i = col; i < col + length; i++) {
				// System.out.println("DEBUG: row = " + row + "; col = " + i);
				for (int j = i - 1; j <= i + 1; j++) {
					for (int k = row - 1; k <= row + 1; k++) {
						if (k >= 0 && k < Grid.NUM_ROWS && j >= 0 && j < Grid.NUM_COLS && p.playerGrid.hasShip(k, j)) {
							return true;
						}
					}
				}
			}
		} else if (dir == 1) // Vertical
		{
			// For each location a ship occupies, check if another ship is touching
			for (int i = row; i < row + length; i++) {
				// System.out.println("DEBUG: row = " + row + "; col = " + i);
				for (int j = i - 1; j <= i + 1; j++) {
					for (int k = col - 1; k <= col + 1; k++) {
						if (j >= 0 && j < Grid.NUM_ROWS && k >= 0 && k < Grid.NUM_COLS && p.playerGrid.hasShip(j, k)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	// Ask player for guess
	private static void askForGuess(Player p, Player opp) {
		System.out.println("\n" + p.getName() + " MAKE GUESS:");
		p.oppGrid.printStatus();

		int row = -1;
		int col = -1;

		String oldRow = "Z";
		int oldCol = -1;

		while (true) {
			System.out.print("\nType in row (A-" + convertIntToLetter(Grid.NUM_ROWS - 1) + "): ");
			String userInputRow = reader.next();
			userInputRow = userInputRow.toUpperCase();
			oldRow = userInputRow.substring(0, 1);
			row = convertLetterToInt(userInputRow);

			try {
				System.out.print("Type in column (1-" + Grid.NUM_COLS + "): ");
				col = reader.nextInt();
				oldCol = col;
				col = convertUserColToProCol(col);
			} catch (InputMismatchException e) {
				col = -1;
			}

			// System.out.println("DEBUG: " + row + col);

			if (col >= 0 && col <= Grid.NUM_COLS - 1 && row != -1) {
				if (!p.oppGrid.alreadyGuessed(row, col)) {
					break;
				} else {
					System.out.println("Location already guessed!");
				}
			} else {
				System.out.println("Invalid location!");
			}
		}

		markResult(p, opp, row, col, oldRow, oldCol);
	}

	// Mark guess result
	private static void markResult(Player p, Player opp, int row, int col, String oldRow, int oldCol) {
		if (opp.playerGrid.hasShip(row, col)) {
			markHit(p, opp, row, col, oldRow, oldCol);
		} else {
			markMiss(p, opp, row, col, oldRow, oldCol);
		}
	}

	// Mark and print hit result
	private static void markHit(Player p, Player opp, int row, int col, String oldRow, int oldCol) {
		p.oppGrid.markHit(row, col);
		opp.playerGrid.markHit(row, col);
		int number = opp.playerGrid.getNumber(row, col);
		Ship s = opp.ships[number - 1];
		s.addHit();
		if (s.isHit()) {
			System.out.println("\n" + p.getName() + " HIT AT " + oldRow + oldCol);
		} else {
			System.out.println("\n" + p.getName() + " HIT AND SUNK " + s.getType() + " AT " + oldRow + oldCol);
		}
	}

	// Mark and print miss result
	private static void markMiss(Player p, Player opp, int row, int col, String oldRow, int oldCol) {
		p.oppGrid.markMiss(row, col);
		opp.playerGrid.markMiss(row, col);
		System.out.println("\n" + p.getName() + " MISS AT " + oldRow + oldCol);
	}

	// Convert ascii letter to int
	private static int convertLetterToInt(String val) {
		char letter = val.charAt(0);
		int value = (int) letter - 65;
		if (value < 0 || value >= Grid.NUM_ROWS) {
			return -1;
		} else {
			return value;
		}
	}

	// Convert int to ascii letter
	private static String convertIntToLetter(int val) {
		if (val < 0 || val >= Grid.NUM_ROWS) {
			return "Z";
		} else {
			int value = val + 65;
			String letter = (char) value + "";
			return letter;
		}
	}

	// Convert user column to program column
	private static int convertUserColToProCol(int val) {
		if (val < 1 || val > Grid.NUM_COLS) {
			return -1;
		} else {
			return val - 1;
		}
	}
}