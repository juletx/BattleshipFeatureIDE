package battleship;

public class Grid {
	private int hits = 0;
	private int misses = 0;

	// Mark a hit in this location by calling the markHit method
	// on the Location object.
	public void markHit(int row, int col) {
		grid[row][col].markHit();
		hits++;
	}

	// Mark a miss on this location.
	public void markMiss(int row, int col) {
		original(row, col);
		misses++;
	}
	
	// Get hit number
	public int getHits() {
		return hits;
	}
	
	// Get miss number
	public int getMisses() {
		return misses;
	}
}
