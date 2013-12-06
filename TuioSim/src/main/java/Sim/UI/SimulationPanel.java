package Sim.UI;

import javax.swing.JButton;
import javax.swing.JPanel;

import Sim.Tuio.Tuio;

public class SimulationPanel extends JPanel {
	
	private Tuio t1;
	private	Tuio t2;
	
	private JButton button1;
	
	public SimulationPanel() {
		initPanel();
	}
	
	private void initPanel() {
		button1 = new JButton("TestButton");
		
		t1 = new Tuio(10,10);
		t2 = new Tuio(50,50);
		
		
		//this.add(t1);
		this.add(t2);
		this.add(button1);
	}
	

}
