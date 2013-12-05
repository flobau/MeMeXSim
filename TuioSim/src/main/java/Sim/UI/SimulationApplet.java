package Sim.UI;

import java.awt.BorderLayout;
import java.awt.Label;
import javax.swing.JApplet;

public class SimulationApplet extends JApplet {
	static protected Label label = new Label("Klicken Sie bitte das Viereck an!");

	public void init() {

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(new Tuios());
		getContentPane().add("South", label);
	}
}