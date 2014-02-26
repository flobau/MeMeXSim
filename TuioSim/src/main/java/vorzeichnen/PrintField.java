package vorzeichnen;

import erkennung.Coordinate;
import game.Game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class PrintField extends JDialog implements KeyListener {

	private static final long serialVersionUID = 119678133234225947L;
	private Game game;
	private BuchstabenErstellung bs = new BuchstabenErstellung();
	private Rectangle tuio;
	private ArrayList<Coordinate> coordinates;

	public PrintField(String letter, Game g) {
		JFrame frame = new JFrame();
		frame.setTitle("Hier wird Vorgezeichnet");
		frame.setSize(450, 450);
		frame.setLocation(450, 0);
		frame.setVisible(true);
		frame.addKeyListener(this);
		
		//JDialog dialog = new JDialog(frame, "Mein erster Dialog", true);
		JDialog dialog = new JDialog(frame);
		dialog.setModal(true);
		dialog.setVisible(true);
		this.setGame(g);
		Coordinate c = bs.getConfigStartPosition('G');
		coordinates = bs.buildLetter(bs.getConfigLetter('G'),
				bs.getConfigStartPosition('G'));
		this.tuio = new Rectangle(c.getFirst(), c.getSecond(), 40, 40);
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

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			// System.out.println("SPACE");
			if (coordinates.size() > 1) {
				tuio.setLocation(coordinates.get(0).getFirst(), coordinates
						.get(0).getSecond());
				repaint();
				coordinates.remove(0);
			} else {
				setVisible(false);
				dispose();
			}
		}

	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
}
