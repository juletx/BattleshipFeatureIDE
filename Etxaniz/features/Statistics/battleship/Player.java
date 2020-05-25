package battleship;

public class Player {
	public void printStatistics() {
		System.out.println("STATISTICS:");

		int shots = playerGrid.getHits() + playerGrid.getMisses();
		int hits = playerGrid.getHits();
		int misses = playerGrid.getMisses();
		double hitsRate = 0;
		double missesRate = 0;
		if (shots > 0) {
			hitsRate = (double) hits / shots * 100;
			missesRate = (double) misses / shots * 100;
		}
		int hitsRateInt = (int) hitsRate;
		int missesRateInt = (int) missesRate;

		System.out.println("You have made " + shots + " shots, " + hits + " hits (" + hitsRateInt + "%) and " + misses
				+ " misses (" + missesRateInt + "%).");

		int hit = 0;
		int sunk = 0;
		int locate = 0;
		for (Ship s : ships) {
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
		int hitRateInt = (int) hitRate;
		int sunkRateInt = (int) sunkRate;
		int locateRateInt = (int) locateRate;

		System.out.println("You have hit " + hit + " ships (" + hitRateInt + "%).");
		System.out.println("You have sunk " + sunk + " ships (" + sunkRateInt + "%).");
		System.out.println("You have to locate " + locate + " ships (" + locateRateInt + "%).");
	}
}