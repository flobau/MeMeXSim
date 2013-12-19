package erkennung;

import java.util.ArrayList;

public class Buchstabenerkennung {

	// TODO Die restlichen Direction ausprogrammieren!

	public ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
	private boolean allCoordsDone = false;
	private final String[] I = { "North" };

	public boolean check(String[] letter) {
		ArrayList<String> parts = new ArrayList<String>();
		boolean erkannt = false;
		while (allCoordsDone == false) {
			parts.add(getDirection(makePartsofCoordinates()));
		}

		parts = orderSegments(parts);

		System.out.println(parts.size());
		System.out.println(letter.length);

		// check if there is the same number of parts

		if (parts.size() != letter.length)
			return false;

		for (int i = 0; i < letter.length; i++) {
			if (parts.get(i).equals(letter[i]) == true) {
				System.out.println("Das " + (i + 1)
						+ ". Segment wurde richtig erkannt!");
				erkannt = true;
			}
			if (parts.get(i).equals(letter[i]) == false) {
				System.out.println("Das " + (i + 1)
						+ ". Segment wurde falsch erkannt!");
				erkannt = false;
			}
		}
		return erkannt;
	}

	private ArrayList<String> orderSegments(ArrayList<String> parts) {
		ArrayList<String> orderdparts = new ArrayList<String>();
		String lastString = parts.get(0);
		orderdparts.add(lastString);
		for (int i = 1; i < parts.size(); i++) {
			if (lastString.equals(parts.get(i))) {
			}
			if (lastString.equals(parts.get(i)) == false
					&& parts.get(i).equals("Error") == false) {
				orderdparts.add(parts.get(i));
				lastString = parts.get(i);
			}
		}
		return orderdparts;
	}

	private String getDirection(ArrayList<Coordinate> coordinates) {
		if (isNorthDirection(coordinates) == true)
			return "North";
		if (isNorthEastDirection(coordinates) == true)
			return "NorthEast";
		if (isEastDirection(coordinates) == true)
			return "East";
		if (isSouthEastDirection(coordinates) == true)
			return "SouthEast";
		if (isSouthDirection(coordinates) == true)
			return "South";
		if (isSouthWestDirection(coordinates) == true)
			return "SouthWest";
		if (isWestDirection(coordinates) == true)
			return "West";
		if (isNorthWestDirection(coordinates) == true)
			return "NorthWest";
		return "Error";
	}

	public boolean isNorthDirection(ArrayList<Coordinate> coordinates) {
		// Startpoint
		Coordinate first = coordinates.get(0);
		// Endpoint
		Coordinate last = coordinates.get(coordinates.size() - 1);
		// The average between Start and End on the x axis.
		double average = (first.getFirst() + last.getFirst()) / 2;

		// check if line between start and end point is north
		if (first.getSecond() < last.getSecond()) {
			for (int i = 1; i <= coordinates.size() - 2; i++) {
				if (first.getSecond() <= coordinates.get(i).getSecond()
						&& coordinates.get(i).getSecond() <= last.getSecond()) {
					if (Math.abs(coordinates.get(i).getFirst() - average) > 2) {
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}

	private boolean isNorthEastDirection(ArrayList<Coordinate> coordinates) {
		return false;
	}

	private boolean isEastDirection(ArrayList<Coordinate> coordinates) {
		return false;
	}

	private boolean isSouthEastDirection(ArrayList<Coordinate> coordinates) {
		return false;
	}

	private boolean isSouthDirection(ArrayList<Coordinate> coordinates) {
		return false;
	}

	private boolean isSouthWestDirection(ArrayList<Coordinate> coordinates) {
		return false;
	}

	private boolean isWestDirection(ArrayList<Coordinate> coordinates) {
		return false;
	}

	private boolean isNorthWestDirection(ArrayList<Coordinate> coordinates) {
		return false;
	}

	public ArrayList<Coordinate> makePartsofCoordinates() {
		ArrayList<Coordinate> part = new ArrayList<Coordinate>();
		int count = 5;
		if (this.coordinates.size() < 5) {
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
		Coordinate c6 = new Coordinate(-1, 6);
		Coordinate c7 = new Coordinate(1, 7);
		Coordinate c8 = new Coordinate(0, 8);
		Coordinate c9 = new Coordinate(0, 9);
		Coordinate c10 = new Coordinate(1, 10);
		Coordinate c11 = new Coordinate(-1, 11);

		coordinates.add(c0);
		coordinates.add(c1);
		coordinates.add(c2);
		coordinates.add(c3);
		coordinates.add(c4);
		coordinates.add(c5);
		coordinates.add(c6);
		coordinates.add(c7);
		coordinates.add(c8);
		coordinates.add(c9);
		coordinates.add(c10);
		coordinates.add(c11);
		return coordinates;
	}

	public static void main(String[] args) {
		Buchstabenerkennung b = new Buchstabenerkennung();
		b.getTestCoordinates();
		b.check(b.I);
	}
}
