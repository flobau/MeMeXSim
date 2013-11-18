package Sim.UI;

import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Rectangle;

public class TrackCoords {
	
	private SimulationPanel panel;
	
	public TrackCoords(SimulationPanel panel){
		this.panel = panel;
	}
	
	public void track(){
		PointerInfo a = MouseInfo.getPointerInfo();
    	Point b = a.getLocation();
    	int x = (int) b.getX();
    	int y = (int) b.getY();
    	System.out.println(x + "/" + y);
    	panel.setX(x);
    	panel.setY(y);
	}
}
