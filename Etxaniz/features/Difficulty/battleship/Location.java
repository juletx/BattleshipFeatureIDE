package battleship;

public class Location {
	// Global Vars
	public static final int UNGUESSED = 0;
	public static final int HIT = 1;
	public static final int MISSED = 2;

	// Instance Variables
	private boolean hasShip;
	private int status;
	private int lengthOfShip;
	private int directionOfShip;
	private int numberOfShip;

	// Location constructor.
	public Location() {
		// Set initial values
		status = 0;
		hasShip = false;
		lengthOfShip = -1;
		directionOfShip = -1;
		numberOfShip = -1;
	}

	// Was this Location a hit?
	public boolean checkHit() {
		if (status == HIT)
			return true;
		else
			return false;
	}

	// Was this location a miss?
	public boolean checkMiss() {
		if (status == MISSED)
			return true;
		else
			return false;
	}

	// Was this location unguessed?
	public boolean isUnguessed() {
		if (status == UNGUESSED)
			return true;
		else
			return false;
	}

	// Mark this location a hit.
	public void markHit() {
		setStatus(HIT);
	}

	// Mark this location a miss.
	public void markMiss() {
		setStatus(MISSED);
	}

	// Return whether or not this location has a ship.
	public boolean hasShip() {
		return hasShip;
	}

	// Set the value of whether this location has a ship.
	public void setShip(boolean val) {
		this.hasShip = val;
	}

	// Set the status of this Location.
	public void setStatus(int status) {
		this.status = status;
	}

	// Get the status of this Location.
	public int getStatus() {
		return status;
	}

	// Get the length of the ship at this location
	public int getLengthOfShip() {
		return lengthOfShip;
	}

	// Set the length of the ship at this location
	public void setLengthOfShip(int val) {
		lengthOfShip = val;
	}

	// Get the direction of the ship at this location
	public int getDirectionOfShip() {
		return directionOfShip;
	}

	// Set the direction of the ship at this location
	public void setDirectionOfShip(int val) {
		directionOfShip = val;
	}
	
	// Get the number of the ship at this location
	public int getNumberOfShip() {
		return numberOfShip;
	}

	// Set the number of the ship at this location
	public void setNumberOfShip(int val) {
		numberOfShip = val;
	}
}