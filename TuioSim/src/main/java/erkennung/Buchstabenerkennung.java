package erkennung;

import java.util.ArrayList;

public class Buchstabenerkennung {

	// TODO Count ist kritisch da ich selber Fehler rein mache!
	// TODO Standardt Abweichung implementieren!
	// TODO Möglicherweiße kann man überall mit einer Geraden arbeiten

	public ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
	private boolean allCoordsDone = false;

	public boolean check(String[] letter) {
		ArrayList<String> parts = new ArrayList<String>();
		boolean erkannt = false;
		while (allCoordsDone == false) {
			parts.add(getDirection(makePartsofCoordinates()));
		}

		parts = orderSegments(parts);

		// System.out.println(parts.size());
		// System.out.println(letter.length);

		// check if there is the same number of parts

		if (parts.size() != letter.length)
			return false;

		for (int i = 0; i < letter.length; i++) {
			if (parts.get(i).equals(letter[i]) == true) {
				erkannt = true;
			}
			if (parts.get(i).equals(letter[i]) == false) {
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
		// Check if there are at least 2 Coordinates
		if (coordinates.size() < 2)
			return false;
		// Startpoint
		Coordinate first = coordinates.get(0);
		// Endpoint
		Coordinate last = coordinates.get(coordinates.size() - 1);
		// The average between Start and End on the x axis.
		double average = (first.getFirst() + last.getFirst()) / 2;

		// check if line between start and end point is north
		if (first.getSecond() < last.getSecond()
				&& (last.getSecond() - first.getSecond()) < 50
				&& (Math.abs(first.getFirst() - last.getFirst())) < 5) {
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
		// Check if there are at least 2 Coordinates
		if (coordinates.size() < 2)
			return false;
		// Startpoint
		Coordinate first = coordinates.get(0);
		// Endpoint
		Coordinate last = coordinates.get(coordinates.size() - 1);
		// Create g ( y = m * x + q )
		float dx = Math.abs(first.getFirst() - last.getFirst());
		float dy = Math.abs(first.getSecond() - last.getSecond());
		float m = dy / dx;
		float q = first.getSecond() - m * first.getFirst();

		// check if the line is northeast
		if (first.getFirst() < last.getFirst()
				&& first.getSecond() < last.getSecond()) {
			for (int i = 1; i <= coordinates.size() - 2; i++) {
				if (first.getFirst() < coordinates.get(i).getFirst()
						&& first.getSecond() < coordinates.get(i).getSecond()
						&& coordinates.get(i).getFirst() < last.getFirst()
						&& coordinates.get(i).getSecond() < last.getSecond()) {
					if (Math.abs((m * coordinates.get(i).getFirst() + q)
							- coordinates.get(i).getSecond()) < 5) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean isEastDirection(ArrayList<Coordinate> coordinates) {
		// Check if there are at least 2 Coordinates
		if (coordinates.size() < 2)
			return false;
		// Startpoint
		Coordinate first = coordinates.get(0);
		// Endpoint
		Coordinate last = coordinates.get(coordinates.size() - 1);
		// The average between Start and End on the y axis.
		double average = (first.getSecond() + last.getSecond()) / 2;

		// check if line between start and end point is east
		if (first.getFirst() < last.getFirst()
				&& (last.getFirst() - first.getFirst() < 50)
				&& (Math.abs(first.getSecond() - last.getSecond())) < 2) {
			for (int i = 1; i <= coordinates.size() - 2; i++) {
				if (first.getFirst() <= coordinates.get(i).getFirst()
						&& coordinates.get(i).getFirst() <= last.getFirst()) {
					if (Math.abs(coordinates.get(i).getSecond() - average) > 2) {
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}

	private boolean isSouthEastDirection(ArrayList<Coordinate> coordinates) {
		// Check if there are at least 2 Coordinates
		if (coordinates.size() < 2)
			return false;
		// Startpoint
		Coordinate first = coordinates.get(0);
		// Endpoint
		Coordinate last = coordinates.get(coordinates.size() - 1);
		// Create g ( y = m * x + q )
		float dx = Math.abs(first.getFirst() - last.getFirst());
		float dy = Math.abs(first.getSecond() - last.getSecond());
		float m = dy / dx;
		float q = first.getSecond() - m * first.getFirst();

		// check if the line is southeast
		if (first.getFirst() < last.getFirst()
				&& first.getSecond() > last.getSecond()) {
			for (int i = 1; i <= coordinates.size() - 2; i++) {
				if (first.getFirst() < coordinates.get(i).getFirst()
						&& coordinates.get(i).getFirst() < last.getFirst()
						&& last.getSecond() < coordinates.get(i).getSecond()
						&& coordinates.get(i).getSecond() < first.getSecond()) {
					if (Math.abs((m * coordinates.get(i).getFirst() + q)
							- coordinates.get(i).getSecond()) < 5) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean isSouthDirection(ArrayList<Coordinate> coordinates) {
		// Check if there are at least 2 Coordinates
		if (coordinates.size() < 2)
			return false;
		// Startpoint
		Coordinate first = coordinates.get(0);
		// Endpoint
		Coordinate last = coordinates.get(coordinates.size() - 1);
		// The average between Start and End on the x axis.
		double average = (first.getFirst() + last.getFirst()) / 2;

		// check if line between start and end point is south
		if (first.getSecond() > last.getSecond()
				&& (first.getSecond() - last.getSecond() < 50)
				&& (Math.abs(first.getFirst() - last.getFirst())) < 2) {
			for (int i = 1; i <= coordinates.size() - 2; i++) {
				if (first.getSecond() >= coordinates.get(i).getSecond()
						&& coordinates.get(i).getSecond() >= last.getSecond()) {
					if (Math.abs(coordinates.get(i).getFirst() - average) > 2) {
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}

	private boolean isSouthWestDirection(ArrayList<Coordinate> coordinates) {
		// Check if there are at least 2 Coordinates
		if (coordinates.size() < 2)
			return false;
		// Startpoint
		Coordinate first = coordinates.get(0);
		// Endpoint
		Coordinate last = coordinates.get(coordinates.size() - 1);
		// Create g ( y = m * x + q )
		float dx = Math.abs(first.getFirst() - last.getFirst());
		float dy = Math.abs(first.getSecond() - last.getSecond());
		float m = dy / dx;
		float q = first.getSecond() - m * first.getFirst();

		// check if the line is southwest
		if (first.getFirst() > last.getFirst()
				&& first.getSecond() > last.getSecond()) {
			for (int i = 1; i <= coordinates.size() - 2; i++) {
				if (first.getFirst() > coordinates.get(i).getFirst()
						&& coordinates.get(i).getFirst() > last.getFirst()
						&& first.getSecond() > coordinates.get(i).getSecond()
						&& coordinates.get(i).getSecond() > last.getSecond()) {
					if (Math.abs((m * coordinates.get(i).getFirst() + q)
							- coordinates.get(i).getSecond()) < 5) {
						return true;
					}
				}
			}
		}

		return false;
	}

	private boolean isWestDirection(ArrayList<Coordinate> coordinates) {
		// Check if there are at least 2 Coordinates
		if (coordinates.size() < 2)
			return false;
		// Startpoint
		Coordinate first = coordinates.get(0);
		// Endpoint
		Coordinate last = coordinates.get(coordinates.size() - 1);
		// The average between Start and End on the y axis.
		double average = (first.getSecond() + last.getSecond()) / 2;

		// check if line between start and end point is west
		if (first.getFirst() > last.getFirst()
				&& (first.getFirst() - last.getFirst() < 50)
				&& (Math.abs(first.getSecond() - last.getSecond())) < 2) {
			for (int i = 1; i <= coordinates.size() - 2; i++) {
				if (first.getFirst() >= coordinates.get(i).getFirst()
						&& coordinates.get(i).getFirst() >= last.getFirst()) {
					if (Math.abs(coordinates.get(i).getSecond() - average) > 2) {
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}

	private boolean isNorthWestDirection(ArrayList<Coordinate> coordinates) {
		// Check if there are at least 2 Coordinates
		if (coordinates.size() < 2)
			return false;
		// Startpoint
		Coordinate first = coordinates.get(0);
		// Endpoint
		Coordinate last = coordinates.get(coordinates.size() - 1);
		// Create g ( y = m * x + q )
		float dx = Math.abs(first.getFirst() - last.getFirst());
		float dy = Math.abs(first.getSecond() - last.getSecond());
		float m = dy / dx;
		float q = first.getSecond() - m * first.getFirst();

		// check if the line is northhwest
		if (first.getFirst() > last.getFirst()
				&& first.getSecond() < last.getSecond()) {
			for (int i = 1; i <= coordinates.size() - 2; i++) {
				if (first.getFirst() > coordinates.get(i).getFirst()
						&& coordinates.get(i).getFirst() > last.getFirst()
						&& first.getSecond() < coordinates.get(i).getSecond()
						&& coordinates.get(i).getSecond() < last.getSecond()) {
					if (Math.abs((m * coordinates.get(i).getFirst() + q)
							- coordinates.get(i).getSecond()) < 5) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public ArrayList<Coordinate> makePartsofCoordinates() {
		ArrayList<Coordinate> part = new ArrayList<Coordinate>();
		int count = 50;
		if (coordinates.size() - 1 < count) {
			count = coordinates.size() - 1;
			allCoordsDone = true;
		}

		for (int i = 0; i < count; i++) {
			part.add(coordinates.get(0));
			coordinates.remove(0);
		}
		return part;
	}

	public void getCoordinates(ArrayList<Coordinate> coord) {
		this.coordinates = coord;
	}
}
