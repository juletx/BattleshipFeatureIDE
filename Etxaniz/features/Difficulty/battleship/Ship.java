package battleship;

public class Ship {
	/* Instance Variables */
	private int row;
	private int col;
	private int length;
	private int direction;
	private int number;
	private ShipType type;
	private int hits;

	// Direction Constants
	public static final int UNSET = -1;
	public static final int HORIZONTAL = 0;
	public static final int VERTICAL = 1;

	// Constructor
	public Ship(int length, int number) {
		this.length = length;
		this.row = -1;
		this.col = -1;
		this.direction = UNSET;
		this.number = number;
		this.hits = 0;
	}

	// Has the location been init
	public boolean isLocationSet() {
		if (row == -1 || col == -1)
			return false;
		else
			return true;
	}

	// Has the direction been init
	public boolean isDirectionSet() {
		if (direction == UNSET)
			return false;
		else
			return true;
	}

	// Set the location of the ship
	public void setLocation(int row, int col) {
		this.row = row;
		this.col = col;
	}

	// Set the direction of the ship
	public void setDirection(int direction) {
		if (direction != UNSET && direction != HORIZONTAL && direction != VERTICAL)
			throw new IllegalArgumentException("Invalid direction. It must be -1, 0, or 1");
		this.direction = direction;
	}

	// Getter for the row value
	public int getRow() {
		return row;
	}

	// Getter for the column value
	public int getCol() {
		return col;
	}

	// Getter for the length of the ship
	public int getLength() {
		return length;
	}

	// Getter for the direction
	public int getDirection() {
		return direction;
	}

	// Getter for the number
	public int getNumber() {
		return number;
	}

	// Getter for the type
	public ShipType getType() {
		return type;
	}
	
	// Increment hits
	public void addHit() {
		hits++;
	}

	// Check if ship is hit
	public boolean isHit() {
		return hits > 0 && hits < length;
	}

	// Check if ship is sunk
	public boolean isSunk() {
		return hits == length;
	}

	// Check if ship is sunk
	public boolean isLocate() {
		return hits == 0;
	}

	// Helper method to get a string value from the direction
	private String directionToString() {
		if (direction == UNSET)
			return "UNSET";
		else if (direction == HORIZONTAL)
			return "HORIZONTAL";
		else
			return "VERTICAL";
	}

	// toString value for this Ship
	public String toString() {
		return "Ship: " + getRow() + ", " + getCol() + " with length " + getLength() + " and direction "
				+ directionToString();
	}
}