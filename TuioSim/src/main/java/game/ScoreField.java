package game;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

//- [ ] Anzeigen der Scores
public class ScoreField extends JFrame {

	private static final long serialVersionUID = -6689940424395721802L;
	private JLabel karte = new JLabel("Karte: ");

	public ScoreField(Game game) {
		setTitle("MemeX");
		setSize(450, 100);
		setLocation(0, 450);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		add(karte);
	}

	public void setKarte(String letter) {
		karte.setText("Karte: " + letter);
	}

}
