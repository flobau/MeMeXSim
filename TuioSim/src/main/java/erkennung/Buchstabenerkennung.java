package erkennung;

import java.util.ArrayList;

public class Buchstabenerkennung {
	
	//TODO 	Schau das der IndexOutOfBound fehler weg geht
	//		Ich denke das lässt sich lösen wenn ich die geprüften Koordinaten lösche.

	public ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
	private boolean allCoordsDone = false;
	private final String[] I = { "Nord" };

	public boolean check(String[] letter) {
		ArrayList<String> parts = new ArrayList<String>();
		int i = 0;
		while (allCoordsDone == false) {
			parts.add(getDirection(makePartsofCoordinates()));
			i++;
		}
		if (parts.get(i) == letter[0])
			return true;
		return false;
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
					if (Math.abs(coordinates.get(i).getFirst() - average) <= 2) {
						System.out.println("?");
					}if(Math.abs(coordinates.get(i).getFirst() - average) > 2){
						System.out.println("!");
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

		coordinates.add(c0);
		coordinates.add(c1);
		coordinates.add(c2);
		coordinates.add(c3);
		coordinates.add(c4);
		coordinates.add(c5);
		coordinates.add(c6);
		return coordinates;
	}

	public static void main(String[] args) {
		Buchstabenerkennung b = new Buchstabenerkennung();
		b.getTestCoordinates();
		if (b.check(b.I) == true)
			System.out.println("stimmt");
		// b.isNorthDirection(b.coordinates);
	}
}
