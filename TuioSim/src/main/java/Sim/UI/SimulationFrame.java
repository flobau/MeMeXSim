package Sim.UI;

import java.awt.Container;

import javax.swing.JFrame;

public class SimulationFrame extends JFrame {
	
	SimulationPanel panel;
	
	public SimulationFrame(){
		setSize(800,600);
		setLocationRelativeTo(null);
		
		panel = new SimulationPanel();
		
		Container cp = getContentPane();
		cp.add(panel);
		
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	

	public static void main(String[] args) {
		new SimulationFrame();

	}

}
