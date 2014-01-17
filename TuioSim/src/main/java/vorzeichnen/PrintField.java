package vorzeichnen;

import game.Game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class PrintField extends JFrame {

	private String letter = "";
	private Game game;
	private Rectangle tuio;

	public PrintField(String letter, Game g) {
		setTitle("PrintField");
		setSize(450, 450);
		setLocation(450, 0);
		setVisible(true);
		this.letter = letter;
		this.game = g;
		this.tuio = new Rectangle(4 * 50 + 5, 4 * 50 + 5, 40, 40);
	}

	public void paint(Graphics g) {
		super.paint(g);
		buildOrUpdateField(g);
	}

	public void buildOrUpdateField(Graphics g) {
		// Stellt das fahrende TUIO dar.
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(4.0f));

		g2.setPaint(Color.white);
		g2.clearRect(0, 0, 0, 0);

		g2.setColor(Color.black);
		g2.draw(tuio);
		g2.setColor(Color.white);
		g2.fill(tuio);

	}
}
