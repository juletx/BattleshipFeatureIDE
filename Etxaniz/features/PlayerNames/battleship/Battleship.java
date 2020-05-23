package battleship;

public class Battleship {
	public static void main(String[] args) {
		original(args);
	}
	
	private static void printAbout() {
		original();
		System.out.println("PlayerNames © 2020 Julen Etxaniz");
	}
	
	private static void setup(Player p) {
		System.out.print("Type player name: ");
		String name = reader.next();
		p.setName(name);
		original(p);
	}
}