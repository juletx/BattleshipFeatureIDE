package battleship;

public class Ship {
	enum ShipType {
		PATROL, SUBMARINE, DESTROYER, CRUISER, BATTLECRUISER, BATTLESHIP, CARRIER;
	}

	// Set ship type depending on length
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
		case 6:
			type = ShipType.BATTLECRUISER;
			break;
		case 7:
			type = ShipType.BATTLESHIP;
			break;
		case 8:
			type = ShipType.CARRIER;
			break;
		}
	}
}