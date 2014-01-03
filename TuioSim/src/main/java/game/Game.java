package game;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

import erkennung.Buchstabenerkennung;

//- [ ] Es können noch mehrere gleiche Buchstaben am Spielfeld sein.
//- [ ] OpenCard fertig implementieren
//- [ ] Quasi ActionListener für das 90° Drehen
public class Game {

	private HashMap<String, String[]> letters = new HashMap<String, String[]>();
	private String[][] playfield;
	Buchstabenerkennung b = new Buchstabenerkennung();
	boolean theGameIsRunning = true;
	Player player1;
	Player player2;

	public void buildField(int height, int width) {
		String[][] field = new String[height][width];
		String[] list = new String[height * width];
		for (int i = 0; i < (height * width); i++) {
			Random r = new Random();
			char c = (char) (r.nextInt(26) + 'a');
			String d = "" + c;
			list[i] = d.toUpperCase();
			list[i + 1] = d.toUpperCase();
			i++;
		}
		Collections.shuffle(Arrays.asList(list));
		int s = 0;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				field[i][j] = list[s];
				s++;
			}
		}
		this.playfield = field;
	}

	public String openCard(int height, int width) {
		String letter = playfield[height][width];

		System.out.println(letter);
		return letter;
	}

	public void initHashMap() {
		letters.put("A", new String[] { "Error" });
		letters.put("B", new String[] { "Error" });
		letters.put("C", new String[] { "Error" });
		letters.put("D", new String[] { "Error" });
		letters.put("E", new String[] { "Error" });
		letters.put("F", new String[] { "Error" });
		letters.put("G", new String[] { "Error" });
		letters.put("H", new String[] { "Error" });
		letters.put("I", new String[] { "Error" });
		letters.put("J", new String[] { "Error" });
		letters.put("K", new String[] { "Error" });
		letters.put("L", new String[] { "Error" });
		letters.put("M", new String[] { "Error" });
		letters.put("N", new String[] { "Error" });
		letters.put("O", new String[] { "Error" });
		letters.put("P", new String[] { "Error" });
		letters.put("Q", new String[] { "Error" });
		letters.put("R", new String[] { "Error" });
		letters.put("S", new String[] { "Error" });
		letters.put("T", new String[] { "Error" });
		letters.put("U", new String[] { "Error" });
		letters.put("V", new String[] { "Error" });
		letters.put("W", new String[] { "Error" });
		letters.put("X", new String[] { "Error" });
		letters.put("Y", new String[] { "Error" });
		letters.put("Z", new String[] { "Error" });
	}

	public void initGame() {
		buildField(2, 2);
		player1 = new Player();
		player2 = new Player();
		player2.setCard1("*");
		player2.setCard2("*");
		startGame();
	}

	private void startGame() {
		String x = "";
		while (theGameIsRunning) {
		}

	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.initGame();
		// g.openCard(0, 0);
		// g.openCard(0, 1);
		// g.openCard(1, 0);
		// g.openCard(1, 1);
	}

}
