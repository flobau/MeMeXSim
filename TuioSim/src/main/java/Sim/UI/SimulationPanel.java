package Sim.UI;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class SimulationPanel extends JPanel implements MouseListener {

	private boolean mouseDown = false;
	public TrackCoords tc = new TrackCoords(this);
	private int x;
	private int y;

	public SimulationPanel() {
		super(new GridLayout());

		addMouseListener(this);
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			mouseDown = true;
			initThread();
		}
	}

	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			mouseDown = false;
		}
	}

	private boolean isRunning = false;

	private synchronized boolean checkAndMark() {
		if (isRunning)
			return false;
		isRunning = true;
		return true;
	}

	private void initThread() {
		if (checkAndMark()) {
			new Thread() {
				public void run() {
					do {
						tc.track();
					} while (mouseDown);
					isRunning = false;
				}
			}.start();
		}
	}

	public void paint(Graphics g) {
		g.drawRect(x, y, 50, 50);
		repaint();
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
}
