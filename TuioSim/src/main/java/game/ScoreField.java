package game;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//- [ ] Anzeigen der Scores
public class ScoreField extends JFrame {

	private static final long serialVersionUID = -6689940424395721802L;
	private JLabel karte = new JLabel("Karte: ");
	private JLabel player = new JLabel("Spieler: 1");
	private JLabel status = new JLabel("");
	private JPanel panel = new JPanel();

	public ScoreField(Game game) {
		setTitle("MemeX");
		setSize(450, 100);
		setLocation(0, 450);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		buildPanel();
		add(status, BorderLayout.PAGE_START);
		add(panel, BorderLayout.PAGE_END);
	}
	
	public void buildPanel(){
		panel.setLayout(new FlowLayout());
		panel.add(karte);
		panel.add(player);
	}

	public void setKarte(String letter) {
		karte.setText("Karte: " + letter);
	}
	
	public void setPlayer(String player) {
		this.player.setText("Spieler: " + player);
	}
	
	public void setStatus(String msg){
		status.setText(msg);
	}
}
