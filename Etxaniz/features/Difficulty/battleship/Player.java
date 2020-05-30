package battleship;

public class Player {
	public Ship[] ships;
	public Grid playerGrid;
	public Grid oppGrid;
	private String name;

	public Player() {
		ships = new Ship[numOfShips()];
		for (int i = 0; i < numOfShips(); i++) {
			Ship tempShip = new Ship(SHIP_LENGTHS[i], i + 1);
			ships[i] = tempShip;
		}

		playerGrid = new Grid();
		oppGrid = new Grid();
	}

	// Add ships to player grid
	public void addShips() {
		for (Ship s : ships) {
			playerGrid.addShip(s);
		}
	}
	
	// Get number of ships
	public int numOfShips() {
		return SHIP_LENGTHS.length;
	}

	// Get number of ships left
	public int numOfShipsLeft() {
		int counter = numOfShips();
		for (Ship s : ships) {
			if (s.isLocationSet() && s.isDirectionSet())
				counter--;
		}

		return counter;
	}

	// Choose ship location
	public void chooseShipLocation(Ship s, int row, int col, int direction) {
		s.setLocation(row, col);
		s.setDirection(direction);
		playerGrid.addShip(s);
	}
	
	// Check is player has lost
	public boolean hasLost() {
		for (Ship s : ships) {
			if (!s.isSunk()) {
				return false;
			}
		}
		return true;
	}
	
	// Get player name
	public String getName() {
		return name;
	}
	
	// Set player name
	public void setName(String val) {
		name = val;
	}
}