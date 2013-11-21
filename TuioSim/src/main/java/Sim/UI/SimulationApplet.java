package Sim.UI;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JApplet;

public class SimulationApplet extends JApplet {
	static protected Label label = new Label("Klicken Sie bitte das Viereck an!");

	public void init() {

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(new SimulationCanvas());
		getContentPane().add("South", label);
	}
}