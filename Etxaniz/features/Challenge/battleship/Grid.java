package battleship;

public class Grid {
	public static final int NUM_SHOTS = 25;

	// Mark a hit in this location by calling the markHit method
	// on the Location object.
	public void markHit(int row, int col) {
		original(row, col);
	}

	// Mark a miss on this location.
	public void markMiss(int row, int col) {
		original(row, col);
	}
}
