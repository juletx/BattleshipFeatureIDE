package battleship;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Battleship {
	public static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		original(args);
		System.out.println("\nJAVA BATTLESHIP - ** Yuval Marcus **");

		System.out.println("\nPlayer SETUP:");
		Player userPlayer = new Player();
		setup(userPlayer);

		System.out.println("Computer SETUP...DONE...PRESS ENTER TO CONTINUE...");
		reader.nextLine();
		reader.nextLine();
		Player computer = new Player();
		setupComputer(computer);
		System.out.println("\nCOMPUTER GRID (FOR DEBUG)...");
		computer.playerGrid.printShips();

		String result = "";
		while (true) {
			System.out.println(result);
			computer.printStatistics();
			System.out.println("\nUSER MAKE GUESS:");
			result = askForGuess(userPlayer, computer);

			if (userPlayer.playerGrid.hasLost()) {
				System.out.println("COMP HIT!...USER LOSES");
				break;
			} else if (computer.playerGrid.hasLost()) {
				System.out.println("HIT!...COMPUTER LOSES");
				break;
			}

			System.out.println("\nCOMPUTER IS MAKING GUESS...");

			compMakeGuess(computer, userPlayer);
		}
	}

	private static void setup(Player p) {
		p.playerGrid.printShips();
		System.out.println();
		int counter = 0;
		while (p.numOfShipsLeft() > 0) {
			for (Ship s : p.ships) {
				System.out.println("\nShip #" + s.getNumber() + ": " + s.getType() + " (Length=" + s.getLength() + ")");
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
						if (!hasErrors(row, col, dir, p, counter)) // Check if errors will produce (out of bounds)
						{
							break;
						}
					}

					System.out.println("Invalid location!");
				}

				// System.out.println("FURTHER DEBUG: row = " + row + "; col = " + col);
				p.ships[counter].setLocation(row, col);
				p.ships[counter].setDirection(dir);
				p.playerGrid.addShip(p.ships[counter]);
				p.playerGrid.printShips();
				System.out.println();
				System.out.println("You have " + p.numOfShipsLeft() + " remaining ships to place.");

				counter++;
			}
		}
	}

	private static boolean hasErrors(int row, int col, int dir, Player p, int count) {
		// System.out.println("DEBUG: count arg is " + count);

		int length = p.ships[count].getLength();

		// Check if off grid - Horizontal
		if (dir == 0) {
			int checker = length + col;
			// System.out.println("DEBUG: checker is " + checker);
			if (checker > Grid.NUM_COLS) {
				System.out.println("SHIP DOES NOT FIT");
				return true;
			}
		}

		// Check if off grid - Vertical
		if (dir == 1) // VERTICAL
		{
			int checker = length + row;
			// System.out.println("DEBUG: checker is " + checker);
			if (checker > Grid.NUM_ROWS) {
				System.out.println("SHIP DOES NOT FIT");
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
					System.out.println("THERE IS ALREADY A SHIP AT THAT LOCATION");
					return true;
				}
			}
		} else if (dir == 1) // Vertical
		{
			// For each location a ship occupies, check if ship is already there
			for (int i = row; i < row + length; i++) {
				// System.out.println("DEBUG: row = " + row + "; col = " + i);
				if (p.playerGrid.hasShip(i, col)) {
					System.out.println("THERE IS ALREADY A SHIP AT THAT LOCATION");
					return true;
				}
			}
		}

		return false;
	}

	private static String askForGuess(Player p, Player opp) {
		System.out.println("Viewing My Guesses:");
		p.oppGrid.printStatus();

		int row = -1;
		int col = -1;

		String oldRow = "Z";
		int oldCol = -1;

		while (true) {
			System.out.print("Type in row (A-" + convertIntToLetter(Grid.NUM_ROWS - 1) + "): ");
			String userInputRow = reader.next();
			userInputRow = userInputRow.toUpperCase();
			oldRow = userInputRow;
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

		if (opp.playerGrid.hasShip(row, col)) {
			p.oppGrid.markHit(row, col);
			opp.playerGrid.markHit(row, col);
			int number = opp.playerGrid.getNumber(row, col);
			Ship s = opp.ships[number - 1];
			s.addHit();
			if (s.isHit()) {
				return "** USER HIT AT " + oldRow + oldCol + " **";
			} else {
				return "** USER HIT AND SUNK " + s.getType() + " AT " + oldRow + oldCol + " **";
			}
		} else {
			p.oppGrid.markMiss(row, col);
			opp.playerGrid.markMiss(row, col);
			return "** USER MISS AT " + oldRow + oldCol + " **";
		}
	}

	/* HELPER METHODS */
	private static int convertLetterToInt(String val) {
		char letter = val.charAt(0);
		int value = (int) letter - 65;
		if (value < 0 || value >= Grid.NUM_ROWS) {
			return -1;
		} else {
			return value;
		}
	}

	private static String convertIntToLetter(int val) {
		if (val < 0 || val >= Grid.NUM_ROWS) {
			return "Z";
		} else {
			int value = val + 65;
			String letter = (char) value + "";
			return letter;
		}
	}

	private static int convertUserColToProCol(int val) {
		if (val < 1 || val > Grid.NUM_COLS) {
			return -1;
		} else {
			return val - 1;
		}
	}
}