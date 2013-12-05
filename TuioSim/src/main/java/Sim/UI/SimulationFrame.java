package Sim.UI;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimulationFrame extends JFrame {
	
	SimulationPanel panel;
	

	public static void main(String[] args) {
		new SimulationFrame();
	}

	public SimulationFrame() {
		setTitle("MeMeX");
		setSize(800, 500);
		
		panel = new SimulationPanel();
		
		
		getContentPane().add(panel);
		
		
		
		//pack();
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
