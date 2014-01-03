package game;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class PlayField extends JFrame implements MouseMotionListener,
		MouseListener {

	private int reihen = 0;
	private int spalten = 0;
	private Rectangle tuio;
	private int difX;
	private int difY;
	private boolean pressOut = false;

	public PlayField(int reihen, int spalten) {
		setTitle("MemeX");
		setSize(450, 450);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.reihen = reihen;
		this.spalten = spalten;
		this.tuio = new Rectangle(reihen * 50 + 5, spalten * 50 + 5, 40, 40);
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public void paint(Graphics g) {
		super.paint(g);
		buildOrUpdateField(g);
	}

	public void buildOrUpdateField(Graphics g) {
		int x = 50;
		int y = 50;
		int width = 50;
		int height = 50;

		for (int j = 0; j < reihen; j++) {
			for (int i = 0; i < spalten; i++) {
				g.drawRect(x, y, width, height);
				x = x + 2 * width;
			}
			x = 50;
			y = y + 2 * height;
		}

		// Stellt das TUIO dar.
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2.0f));

		g2.setPaint(Color.white);
		g2.clearRect(0, 0, 0, 0);

		g2.setColor(Color.black);
		g2.draw(tuio);
		g2.setColor(Color.white);
		g2.fill(tuio);

	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		difX = tuio.x - e.getX();
		difY = tuio.y - e.getY();

		if (tuio.contains(e.getX(), e.getY())) {
			updateLocation(e);
		} else {
			pressOut = true;
		}
	}

	public void mouseReleased(MouseEvent e) {
		if (tuio.contains(e.getX(), e.getY())) {
			updateLocation(e);
		} else {
			pressOut = true;
		}
	}

	public void mouseDragged(MouseEvent e) {
		if (!pressOut) {
			updateLocation(e);
		}
	}

	public void mouseMoved(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void updateLocation(MouseEvent e) {
		tuio.setLocation(difX + e.getX(), difY + e.getY());
		repaint();
	}
}
