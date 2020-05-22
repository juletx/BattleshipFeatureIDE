package battleship;

import Ship.ShipType;

public class Ship {
	enum ShipType {
		PATROL, SUBMARINE, DESTROYER, CRUISER;
	}

	public Ship(int length, int number) {
		switch (length) {
		case 2:
			type = ShipType.PATROL;
			break;
		case 3:
			type = ShipType.SUBMARINE;
			break;
		case 4:
			type = ShipType.DESTROYER;
			break;
		case 5:
			type = ShipType.CRUISER;
			break;
		}
	}
}