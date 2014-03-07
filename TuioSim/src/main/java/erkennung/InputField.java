package erkennung;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import game.Game;

public class InputField extends JFrame implements MouseMotionListener,
		MouseListener, KeyListener {

	private static final long serialVersionUID = 2399507823383479157L;
	private Rectangle tuio;
	private int difX;
	private int difY;
	private ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
	private String letter;

	public InputField(Game g, String letter) {
		setTitle("Hier wird Gezeichnet");
		setSize(450, 450);
		setLocation(450, 0);
		setVisible(false);
		this.letter = letter;
		this.tuio = new Rectangle(50, 50, 40, 40);
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
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

	public void updateLocation(MouseEvent e) {
		tuio.setLocation(difX + e.getX(), difY + e.getY());
		repaint();
	}
	
	public void setLetter(String letter){
		
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			// Das Fenster soll geschlossen werden und die Zeichnung soll
			// überprüft werden!
		}
	}

	public void mousePressed(MouseEvent e) {
		difX = tuio.x - e.getX();
		difY = tuio.y - e.getY();

		if (tuio.contains(e.getX(), e.getY())) {
			updateLocation(e);
		}
	}

	public void mouseReleased(MouseEvent e) {
		if (tuio.contains(e.getX(), e.getY())) {
			updateLocation(e);
		}
	}

	public void mouseDragged(MouseEvent e) {
		updateLocation(e);
		coordinates.add(new Coordinate((int) tuio.getX(), (int) tuio.getY()));
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseMoved(MouseEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}
}
