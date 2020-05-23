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
	
	public int getShots() {
		return shots;
	}
	
	public int getHits() {
		return hits;
	}
	
	public int getMisses() {
		return misses;
	}
}
