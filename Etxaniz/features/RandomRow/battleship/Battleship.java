package battleship;

public class Battleship {
	public static void main(String[] args) {
		original(args);
	}
	
	private static void printAbout() {
		original();
		System.out.println("Computer Strategy Row RandomRow © 2020 Julen Etxaniz");
	}
	
	private static int calculateRow() {
		return Randomizer.nextInt(0, Grid.NUM_ROWS - 1);
	}
}