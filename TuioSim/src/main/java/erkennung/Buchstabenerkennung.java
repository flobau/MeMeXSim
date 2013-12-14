package erkennung;

import java.util.ArrayList;

public class Buchstabenerkennung {

	public ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
	public boolean allCoordsDone = false;
	public static final String[] I = { "Nord" };

	public ArrayList<String> check() {
		while (allCoordsDone == false) {
			ArrayList<Coordinate> coordinates = makePartsofCoordinates();
		}
		return null;
	}

	public ArrayList<Coordinate> makePartsofCoordinates() {
		ArrayList<Coordinate> part = new ArrayList<Coordinate>();
		int count = 5;
		if (coordinates.size() < 5) {
			count = coordinates.size() - 1;
			allCoordsDone = true;
		}

		for (int i = 0; i < count; i++) {
			part.add(coordinates.get(0));
			coordinates.remove(0);
		}
		return part;
	}

	public ArrayList<Coordinate> getTestCoordinates() {
		Coordinate c0 = new Coordinate(0, 0);
		Coordinate c1 = new Coordinate(0, 1);
		Coordinate c2 = new Coordinate(1, 2);
		Coordinate c3 = new Coordinate(0, 3);
		Coordinate c4 = new Coordinate(0, 4);
		Coordinate c5 = new Coordinate(0, 5);

		coordinates.add(c0);
		coordinates.add(c1);
		coordinates.add(c2);
		coordinates.add(c3);
		coordinates.add(c4);
		coordinates.add(c5);
		return coordinates;
	}

	public static void main(String[] args) {
		Buchstabenerkennung b = new Buchstabenerkennung();
		b.getTestCoordinates();
		b.check();
	}
}
