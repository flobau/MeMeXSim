package Sim.UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JComboBox.KeySelectionManager;

public class SimulationPanel extends JPanel implements KeyListener {
	
	Dimension rect;
	int x,y;

	
	public SimulationPanel(){
		x=1;
		y=1;
	
		rect = new Dimension();
	
		addKeyListener(this);
	}
	
	public void paint(Graphics g){
		g.drawRect(x,y,50,50);
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyChar());
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
