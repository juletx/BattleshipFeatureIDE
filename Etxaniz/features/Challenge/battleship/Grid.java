package battleship;

public class Grid {
	private int shots = 0;
	private int hits = 0;

	// Mark a hit in this location by calling the markHit method
	// on the Location object.
	public void markHit(int row, int col) {
		grid[row][col].markHit();
		shots++;
		hits++;
	}

	// Mark a miss on this location.
	public void markMiss(int row, int col) {
		original(row, col);
		shots++;
	}
	
	// Get number of shots
	public int getShots() {
		return shots;
	}
	
	// Get number of hits
	public int getHits() {
		return hits;
	}
}
