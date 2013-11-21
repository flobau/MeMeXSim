package Sim.UI;

import java.applet.Applet;
import javax.swing.JFrame;

public class SimulationFrame extends JFrame {

	public static void main(String[] args) {
		createFrame();
	}

	public static void createFrame() {
		JFrame frame = new JFrame("MeMeX");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Applet applet = new SimulationApplet();
		frame.add("Center", applet);
		applet.init();
		frame.pack();
		frame.setSize(800, 500);
		frame.setVisible(true);
	}
}
