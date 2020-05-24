package battleship;

public class Player {
	private int points = 0;
	
	public int getPoints() {
		return points;
	}
	
	public void addPoints(int val) {
		points += val;
	}
	
	public boolean hasShots() {
		return oppGrid.getShots() < Grid.NUM_SHOTS;
	}
	
	public int numShotsLeft() {
		return Grid.NUM_SHOTS - oppGrid.getShots();
	}
}