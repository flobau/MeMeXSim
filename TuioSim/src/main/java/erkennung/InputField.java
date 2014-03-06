package erkennung;

import javax.swing.JFrame;

import game.Game;

public class InputField extends JFrame{
	
	private static final long serialVersionUID = 2399507823383479157L;

	public InputField(Game g){
		setTitle("Hier wird Gezeichnet");
		setSize(450, 450);
		setLocation(900, 0);
		setVisible(true);
	}
}
