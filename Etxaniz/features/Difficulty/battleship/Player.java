package battleship;

public class Player {
	public Ship[] ships;
	public Grid playerGrid;
	public Grid oppGrid;
	private String name;

	public Player() {
		ships = new Ship[NUM_OF_SHIPS];
		for (int i = 0; i < NUM_OF_SHIPS; i++) {
			Ship tempShip = new Ship(SHIP_LENGTHS[i], i + 1);
			ships[i] = tempShip;
		}

		playerGrid = new Grid();
		oppGrid = new Grid();
	}

	public void addShips() {
		for (Ship s : ships) {
			playerGrid.addShip(s);
		}
	}

	public int numOfShipsLeft() {
		int counter = NUM_OF_SHIPS;
		for (Ship s : ships) {
			if (s.isLocationSet() && s.isDirectionSet())
				counter--;
		}

		return counter;
	}

	public void chooseShipLocation(Ship s, int row, int col, int direction) {
		s.setLocation(row, col);
		s.setDirection(direction);
		playerGrid.addShip(s);
	}
	
	public boolean hasLost() {
		for (Ship s : ships) {
			if (!s.isSunk()) {
				return false;
			}
		}
		return true;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String val) {
		name = val;
	}
}