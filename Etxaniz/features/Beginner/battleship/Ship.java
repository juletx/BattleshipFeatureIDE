package battleship;

public class Ship {
	enum ShipType {
		PATROL, SUBMARINE, DESTROYER;
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
		}
	}
}