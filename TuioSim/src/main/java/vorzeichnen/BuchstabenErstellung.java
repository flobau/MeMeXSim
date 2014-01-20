package vorzeichnen;

import java.io.*;
import java.util.ArrayList;

import erkennung.Coordinate;

//- [ ] buildLetter fertig implementieren
//- [ ] Config erweitern

public class BuchstabenErstellung {

	public BuchstabenErstellung() {
	}

	public String[] getConfigLetter(char letter) {
		String[] a = null;
		try {
			FileReader fr = new FileReader("letterConfig.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			if (line.charAt(0) == letter) {
				line = (String) line.subSequence(11, line.length());
				a = line.split("/");
			}
			br.close();
		} catch (IOException e) {

		}
		return a;
	}

	public Coordinate getConfigStartPosition(char letter) {
		Coordinate c = null;
		try {
			FileReader fr = new FileReader("letterConfig.txt");
			BufferedReader br = new BufferedReader(fr);
			c = new Coordinate();
			String[] a = null;
			String line = br.readLine();
			if (line.charAt(0) == letter) {
				line = (String) line.subSequence(3, 10);
				a = line.split("/");
				c.setFirst(Integer.parseInt(a[0]));
				c.setSecond(Integer.parseInt(a[1]));
			}
			br.close();
		} catch (IOException e) {
		}
		return c;
	}

	public ArrayList<Coordinate> buildLetter(String[] a, Coordinate c) {
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		Coordinate lastcoord = c;
		Coordinate newcoord = lastcoord;
		for (int i = 0; i < a.length; i++) {
			if (a[i].equals("S")) {
				for (int j = 0; j < 10; j++) {
					newcoord.setSecond(lastcoord.getSecond() + 3);
					coordinates.add(new Coordinate(newcoord.getFirst(), newcoord.getSecond()));
					lastcoord = newcoord;
				}
			}
		}
		return coordinates;
	}

	// Nur für Testzwecke!
	public static void main(String[] args) throws IOException {
	}
}
