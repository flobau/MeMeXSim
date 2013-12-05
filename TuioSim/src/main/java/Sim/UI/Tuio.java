package Sim.UI;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Tuios extends Canvas implements MouseListener, MouseMotionListener {
	
	Rectangle tuio1 = new Rectangle(0, 0, 50, 50);
	Rectangle tuio2 = new Rectangle(0, 0, 50, 50);

	Graphics2D g2;

	int preX, preY;

	boolean isFirstTime = true;

	Rectangle area;

	boolean pressOut = false;

	public Tuios() {
		setBackground(Color.white);
		addMouseMotionListener(this);
		addMouseListener(this);
	}

	public void mousePressed(MouseEvent e) {
		preX = tuio1.x - e.getX();
		preY = tuio1.y - e.getY();

		if (tuio1.contains(e.getX(), e.getY()))
			updateLocation(e);
		else {
			SimulationApplet.label.setText("Klicken Sie bitte das Viereck an!");
			pressOut = true;
		}
	}

	public void mouseDragged(MouseEvent e) {
		if (!pressOut)
			updateLocation(e);
		else
			SimulationApplet.label.setText("Klicken Sie bitte das Viereck an!");
	}

	public void mouseReleased(MouseEvent e) {
		if (tuio1.contains(e.getX(), e.getY()))
			updateLocation(e);
		else {
			SimulationApplet.label.setText("Klicken Sie bitte das Viereck an!");
			pressOut = false;
		}
	}

	public void mouseMoved(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void updateLocation(MouseEvent e) {
		tuio1.setLocation(preX + e.getX(), preY + e.getY());

		if (checkRect()) {
			SimulationApplet.label.setText((int) tuio1.getX() + ", " +(int) tuio1.getY());
		} else {
			SimulationApplet.label.setText("Zeichnen Sie bitte inerhalb der Fläche!");
		}

		repaint();
	}

	public void paint(Graphics g) {
		update(g);
	}

	public void update(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Dimension dim = getSize();
		int w = (int) dim.getWidth();
		int h = (int) dim.getHeight();
		g2.setStroke(new BasicStroke(8.0f));

		if (isFirstTime) {
			area = new Rectangle(dim);
			tuio1.setLocation(w / 2 - 100, h / 2 - 25);
			tuio2.setLocation(w / 2 + 100, h / 2 - 25);
			isFirstTime = false;
		}

		// Clears the rectangle that was previously drawn.
		g2.setPaint(Color.white);
		g2.fillRect(0, 0, w, h);

		g2.setColor(Color.black);
		g2.draw(tuio1);
		g2.setColor(Color.white);
		g2.fill(tuio1);
		
		g2.setColor(Color.black);
		g2.draw(tuio2);
		g2.setColor(Color.white);
		g2.fill(tuio2);
	}

	boolean checkRect() {
		if (area == null) {
			return false;
		}

		if (area.contains(tuio1.x, tuio1.y, 50, 50)) {
			return true;
		}
		int new_x = tuio1.x;
		int new_y = tuio1.y;

		if ((tuio1.x + 50) > area.getWidth()) {
			new_x = (int) area.getWidth() - 49;
		}
		if (tuio1.x < 0) {
			new_x = -1;
		}
		if ((tuio1.y + 50) > area.getHeight()) {
			new_y = (int) area.getHeight() - 49;
		}
		if (tuio1.y < 0) {
			new_y = -1;
		}
		tuio1.setLocation(new_x, new_y);
		return false;
	}
}