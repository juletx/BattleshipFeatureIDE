package battleship;

public class Player {
	private int points = 0;
	
	// Get number of points
	public int getPoints() {
		return points;
	}
	
	// Add points to player
	public void addPoints(int val) {
		points += val;
	}
	
	// Check if player has shots left
	public boolean hasShots() {
		return oppGrid.getShots() < Grid.NUM_SHOTS;
	}
	
	// Get number of shots left
	public int numShotsLeft() {
		return Grid.NUM_SHOTS - oppGrid.getShots();
	}
}