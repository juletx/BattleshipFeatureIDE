package battleship;

public class Grid {
	private int shots = 0;
	private int hits = 0;
	private int misses = 0;

	// Mark a hit in this location by calling the markHit method
	// on the Location object.
	public void markHit(int row, int col) {
		original(row, col);
		shots++;
		hits++;
	}

	// Mark a miss on this location.
	public void markMiss(int row, int col) {
		original(row, col);
		shots++;
		misses++;
	}
	
	public void printStatistics() {
		System.out.println("STATISTICS:");
		System.out.println("You have made " + shots + " shots, " + hits + " hits and " + misses + " misses.");
		System.out.println("You have hit.");
		System.out.println("You have sunk.");
		System.out.println("You have to locate.");
	}
}
