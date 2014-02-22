package game;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import vorzeichnen.PrintField;
import erkennung.Buchstabenerkennung;
import erkennung.InputField;

public class Game {

	private String[][] playfield;
	Buchstabenerkennung b = new Buchstabenerkennung();
	Player player1;
	Player player2;
	ScoreField sf = null;

	public void buildField(int height, int width) {
		String[][] field = new String[height][width];
		String[] list = new String[height * width];
		boolean onetime = false;
		boolean done = false;
		for (int i = 0; i < (height * width); i++) {
			Random r = new Random();
			char c = (char) (r.nextInt(26) + 'a');
			String d = "" + c;
			done = false;
			for (int j = 0; j <= i; j++) {
				if (i >= 2 && done == false) {
					if (!list[j].equals(d)) {
						list[i] = d.toUpperCase();
						list[i + 1] = d.toUpperCase();
						done = true;
						i++;
					}
				}
				if (onetime == false) {
					list[i] = d.toUpperCase();
					list[i + 1] = d.toUpperCase();
					onetime = true;
					i++;
				}
			}
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
		new PlayField(height, width, this);
	}

	public void openCard(int height, int width) {
		String letter = playfield[height][width];
		new PrintField(letter, this);
		setCards(letter);
		sf.setKarte(letter);
		printPlayerCards();
	}

	public void initGame() {
		buildField(4, 4);
		player1 = new Player();
		player2 = new Player();
		player1.setCard1("*");
		player1.setCard2("*");
		player2.setCard1("*");
		player2.setCard2("*");
		sf = new ScoreField(this);
		sf.setStatus("Bewegen Sie das TUIO auf eine Karte und drücken Sie SPACE");
	}

	private void setCards(String card) {
		if (player1.getCard1().equals("*")) {
			sf.setPlayer("1");
			player1.setCard1(card);
		} else {
			if (player1.getCard2().equals("*")) {
				player1.setCard2(card);
				if (player1.getCard1().equals(player1.getCard2())) {
					// zwei gleiche
					System.out.println("Zwei gleiche!");
					playerPrintLetter();
					player1.setCard1("*");
					player1.setCard2("*");
				} else {
					player2.setCard1("*");
					player2.setCard2("*");
				}
			} else {
				if (player2.getCard1().equals("*")) {
					sf.setPlayer("2");
					player2.setCard1(card);
				} else {
					if (player2.getCard2().equals("*")) {
						player2.setCard2(card);
						if (player2.getCard1().equals(player2.getCard2())) {
							// zwei gleiche
							System.out.println("Zwei gleiche!");
							playerPrintLetter();
							player2.setCard1("*");
							player2.setCard2("*");
						} else {
							player1.setCard1("*");
							player1.setCard2("*");
						}
					}
				}
			}
		}
	}

	public boolean playerPrintLetter() {
		new InputField(this);
		return false;
	}

	// Nur zu Testzwecken!
	public void printPlayerCards() {
		System.out.println("Player 1 / Card 1 : " + player1.getCard1());
		System.out.println("Player 1 / Card 2 : " + player1.getCard2());
		System.out.println("Player 2 / Card 1 : " + player2.getCard1());
		System.out.println("Player 2 / Card 2 : " + player2.getCard2());
	}

	public static void main(String[] args) {
		Game g = new Game();
		g.initGame();
	}
}
