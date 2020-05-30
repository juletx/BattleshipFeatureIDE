package battleship;

public class Battleship {
	// Print about info
	private static void printAbout() {
		original();
		System.out.println("Challenge © 2020 Julen Etxaniz");
	}

	// Play game until both players lose or no shots are left
	// The player with more points wins
	// If both players have the same number of points the one with more hits wins
	private static void playGame(Player player1, Player player2) {
		while (player1.hasShots() && !player2.hasLost() || player2.hasShots() && !player1.hasLost()) {
			if (player2.hasLost() && player1.hasLost()) {
				break;
			} else if (player2.hasLost()) {
				System.out.println(player1.getName() + " FINISHED!");
				playGamePlayer2(player1, player2);
			} else if (player1.hasLost()) {
				System.out.println(player2.getName() + " FINISHED!");
				playGamePlayer1(player1, player2);
			} else {
				playGamePlayer1(player1, player2);
				playGamePlayer2(player1, player2);
			}
		}
		int points1 = player1.getPoints();
		int points2 = player2.getPoints();
		if (points2 == points1) {
			int hits1 = player2.playerGrid.getHits();
			int hits2 = player1.playerGrid.getHits();
			if (hits1 == hits2) {
				System.out.println(player1.getName() + " (" + points1 + " points and " + hits1 + " hits) and "
						+ player2.getName() + " (" + points2 + " points and " + hits2 + " hits) DRAW!");
			} else if (hits1 > hits2) {
				System.out.println(player1.getName() + " (" + points1 + " points and " + hits1 + " hits) WINS! "
						+ player2.getName() + " (" + points2 + " points and " + hits2 + " hits) LOSES!");
			} else {
				System.out.println(player2.getName() + " (" + points2 + " points and " + hits2 + " hits) WINS! "
						+ player1.getName() + " (" + points1 + " points and " + hits1 + " hits) LOSES!");
			}
		} else if (points1 > points2) {
			System.out.println(player1.getName() + " (" + points1 + " points) WINS! " + player2.getName() + " ("
					+ points2 + " points) LOSES!");
		} else {
			System.out.println(player2.getName() + " (" + points2 + " points) WINS! " + player1.getName() + " ("
					+ points1 + " points) LOSES!");
		}
	}

	// Print number of points and shots left
	private static void markResult(Player p, Player opp, int row, int col, String oldRow, int oldCol) {
		original(p, opp, row, col, oldRow, oldCol);
		int points = p.getPoints();
		int shots = p.numShotsLeft();
		System.out.println(p.getName() + " has " + points + " points and " + shots + " shots left.\n");
	}

	// Mark and print hit result and points
	private static void markHit(Player p, Player opp, int row, int col, String oldRow, int oldCol) {
		p.oppGrid.markHit(row, col);
		opp.playerGrid.markHit(row, col);
		int number = opp.playerGrid.getNumber(row, col);
		Ship s = opp.ships[number - 1];
		if (s.isLocate()) {
			p.addPoints(2);
			s.addHit();
			System.out.println("\n" + p.getName() + " HIT AT " + oldRow + oldCol + " (" + 2 + " points)");
		} else {
			s.addHit();
			if (s.isHit()) {
				p.addPoints(1);
				System.out.println("\n" + p.getName() + " HIT AT " + oldRow + oldCol + " (" + 1 + " point)");
			} else {
				p.addPoints(s.getLength());
				System.out.println("\n" + p.getName() + " HIT AND SUNK " + s.getType() + " AT " + oldRow + oldCol + " ("
						+ s.getLength() + " points)");
			}
		}
	}

	// Mark and print miss result and points
	private static void markMiss(Player p, Player opp, int row, int col, String oldRow, int oldCol) {
		p.oppGrid.markMiss(row, col);
		opp.playerGrid.markMiss(row, col);
		System.out.println("\n" + p.getName() + " MISS AT " + oldRow + oldCol + " (" + 0 + " points)");
	}
}