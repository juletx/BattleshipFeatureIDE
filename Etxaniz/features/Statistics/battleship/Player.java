package battleship;

public class Player {
	public void printStatistics(Player opp) {
		System.out.println("STATISTICS:");

		int shots = oppGrid.getHits() + oppGrid.getMisses();
		int hits = oppGrid.getHits();
		int misses = oppGrid.getMisses();
		double hitsRate = 0;
		double missesRate = 0;
		if (shots > 0) {
			hitsRate = (double) hits / shots * 100;
			missesRate = (double) misses / shots * 100;
		}
		int hitsRateInt = (int) Math.round(hitsRate);
		int missesRateInt = (int) Math.round(missesRate);

		System.out.println(name + " has made " + shots + " shots, " + hits + " hits (" + hitsRateInt + "%) and "
				+ misses + " misses (" + missesRateInt + "%).");

		int hit = 0;
		int sunk = 0;
		int locate = 0;
		
		for (Ship s : opp.ships) {
			if (s.isHit()) {
				hit++;
			} else if (s.isSunk()) {
				sunk++;
			} else if (s.isLocate()) {
				locate++;
			}
		}

		double hitRate = (double) hit / NUM_OF_SHIPS * 100;
		double sunkRate = (double) sunk / NUM_OF_SHIPS * 100;
		double locateRate = (double) locate / NUM_OF_SHIPS * 100;
		int hitRateInt = (int) Math.round(hitRate);
		int sunkRateInt = (int) Math.round(sunkRate);
		int locateRateInt = (int) Math.round(locateRate);

		System.out.println(name + " has hit " + hit + " ships (" + hitRateInt + "%), has sunk " + sunk + " ships ("
				+ sunkRateInt + "%) and has to locate " + locate + " ships (" + locateRateInt + "%).");
		
		int counter;
		for (Ship.ShipType type: Ship.ShipType.values()) {
			hit = 0;
			sunk = 0;
			locate = 0;
			counter = 0;
			
			for (Ship s : opp.ships) {
				if (s.getType() == type) {
					if (s.isHit()) {
						hit++;
					} else if (s.isSunk()) {
						sunk++;
					} else if (s.isLocate()) {
						locate++;
					}
					counter++;
				}
			}
			
			hitRate = (double) hit / counter * 100;
			sunkRate = (double) sunk / counter * 100;
			locateRate = (double) locate / counter * 100;
			hitRateInt = (int) Math.round(hitRate);
			sunkRateInt = (int) Math.round(sunkRate);
			locateRateInt = (int) Math.round(locateRate);
			
			System.out.println(name + " has hit " + hit + " " + type + "s (" + hitRateInt + "%), has sunk " + sunk + " " + type + "s ("
					+ sunkRateInt + "%) and has to locate " + locate + " " + type + "s (" + locateRateInt + "%).");
		}
	}
}