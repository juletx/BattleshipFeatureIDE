package battleship;

public class Battleship {
	public static void main(String[] args) {
		original(args);
	}

	private static void printAbout() {
		original();
		System.out.println("Challenge © 2020 Julen Etxaniz");
	}

	private static void playGame(Player player1, Player player2) {
		while (player1.hasShots() || player2.hasShots()) {
			if (player2.hasLost() && player1.hasLost()) {
				break;
			} else if (player2.hasLost()) {
				System.out.println("Player1 FINISHED!");
				playGamePlayer2(player1, player2);
			} else if (player1.hasLost()) {
				System.out.println("Player2 FINISHED!");
				playGamePlayer1(player1, player2);
			} else {
				playGamePlayer1(player1, player2);
				playGamePlayer2(player1, player2);
			}
		}
		int points1 = player1.getPoints();
		int points2 = player2.getPoints();
		if (points2 == points1) {
			System.out.println("Player1 (" + points1 + " points) and Player2 (" + points2 + " points) DRAW!");
		} else if (points2 < points1) {
			System.out.println("Player1 (" + points1 + " points) WINS! Player2 (" + points2 + " points) LOSES!");
		} else if (points1 < points2) {
			System.out.println("Player2 (" + points2 + " points) WINS! Player1 (" + points1 + " points) LOSES!");
		}
	}

	private static void markHit(Player p, Player opp, int row, int col, String oldRow, int oldCol) {
		p.oppGrid.markHit(row, col);
		opp.playerGrid.markHit(row, col);
		int number = opp.playerGrid.getNumber(row, col);
		Ship s = opp.ships[number - 1];
		if (s.isLocate()) {
			p.addPoints(2);
			s.addHit();
			System.out.println("\nPlayer HIT AT " + oldRow + oldCol + " (" + 2 + " points)");
		} else {
			s.addHit();
			if (s.isHit()) {
				p.addPoints(1);
				System.out.println("\nPlayer HIT AT " + oldRow + oldCol  + " (" + 1 + " point)");
			} else {
				p.addPoints(s.getLength());
				System.out.println("\nPlayer HIT AND SUNK " + s.getType() + " AT " + oldRow + oldCol + " (" + s.getLength() + " points)");
			}
		}
		int points = p.getPoints();
		int shots = p.numShotsLeft();
		System.out.println("Player has " + points + " points and " + shots + " shots left.\n" );
	}
}