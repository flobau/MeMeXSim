package Sim.UI;

import javax.swing.JPanel;

public class SimulationPanel extends JPanel {
	
	Tuio t1;
	Tuio t2;
	
	public SimulationPanel() {
		initPanel();
	}
	
	private void initPanel() {
		t1 = new Tuio(10,10);
		t2 = new Tuio(50,50);
		
		this.add(t1);
		this.add(t2);
		
		setVisible(true);
	}
	

}
