package vorzeichnen;

import java.io.*;
import java.util.ArrayList;

import erkennung.Coordinate;

//- [ ] buildLetter fertig implementieren

public class BuchstabenErstellung {

	public BuchstabenErstellung() {

	}

	public String[] getConfigLetter(char letter) throws IOException {
		FileReader fr = new FileReader("letterConfig.txt");
		BufferedReader br = new BufferedReader(fr);
		String[] a = null;
		String line = br.readLine();
		if (line.charAt(0) == letter) {
			line = (String) line.subSequence(3, line.length());
			a = line.split("/");
		}
		br.close();
		return a;
	}

	public void buildLetter(String[] a) {
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		Coordinate lastcoord = new Coordinate(0, 0);
		for (int i = 0; i < a.length; i++) {
			if (a[i].equals("S")) {
				System.out.println("s");
				coordinates.add(new Coordinate(0, 0));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BuchstabenErstellung b = new BuchstabenErstellung();
		b.buildLetter(b.getConfigLetter('I'));
	}
}
