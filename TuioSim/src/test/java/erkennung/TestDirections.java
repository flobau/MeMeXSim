package erkennung;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class TestDirections {

	@Test
	public void TestIfNorthWorks() {
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		String[] north = { "North" };

		for (int i = 0; i <= 1000; i++) {
			coordinates.add(new Coordinate(0, i));
		}

		Buchstabenerkennung b = new Buchstabenerkennung();
		b.getCoordinates(coordinates);

		Assert.assertEquals(true, b.check(north));
	}

	@Test
	public void TestIfEasthWorks() {
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		String[] east = { "East" };

		for (int i = 0; i <= 1000; i++) {
			coordinates.add(new Coordinate(i, 0));
		}

		Buchstabenerkennung b = new Buchstabenerkennung();
		b.getCoordinates(coordinates);

		Assert.assertEquals(true, b.check(east));
	}

	@Test
	public void TestIfSouthhWorks() {
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		String[] south = { "South" };

		for (int i = 1000; i >= 0; i--) {
			coordinates.add(new Coordinate(0, i));
		}

		Buchstabenerkennung b = new Buchstabenerkennung();
		b.getCoordinates(coordinates);

		Assert.assertEquals(true, b.check(south));
	}

	@Test
	public void TestIfWestWorks() {
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		String[] west = { "West" };

		for (int i = 1000; i >= 0; i--) {
			coordinates.add(new Coordinate(i, 0));
		}

		Buchstabenerkennung b = new Buchstabenerkennung();
		b.getCoordinates(coordinates);

		Assert.assertEquals(true, b.check(west));
	}

	@Test
	public void TestIfNorthEastWorks() {
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		String[] northeast = { "NorthEast" };

		for (int i = 0; i <= 1000; i++) {
			coordinates.add(new Coordinate(i, i));
		}

		Buchstabenerkennung b = new Buchstabenerkennung();
		b.getCoordinates(coordinates);

		Assert.assertEquals(true, b.check(northeast));
	}

	@Test
	public void TestIfSouthEastWorks() {
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		String[] southeast = { "SouthEast" };

		for (int i = 1000, j = 0; j <= 1000; i--, j++) {
			coordinates.add(new Coordinate(j, i));
		}

		Buchstabenerkennung b = new Buchstabenerkennung();
		b.getCoordinates(coordinates);

		Assert.assertEquals(true, b.check(southeast));
	}
	
	@Test
	public void TestIfSouthWestWorks() {
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		String[] southwest = { "SouthWest" };

		for (int i = 1000; i >= 0; i--) {
			coordinates.add(new Coordinate(i, i));
		}

		Buchstabenerkennung b = new Buchstabenerkennung();
		b.getCoordinates(coordinates);

		Assert.assertEquals(true, b.check(southwest));
	}
	
	@Test
	public void TestIfNorthWestWorks() {
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		String[] northwest = { "NorthWest" };

		for (int i = 1000, j = 0; j <= 1000; i--, j++) {
			coordinates.add(new Coordinate(i, j));
		}

		Buchstabenerkennung b = new Buchstabenerkennung();
		b.getCoordinates(coordinates);

		Assert.assertEquals(true, b.check(northwest));
	}
}
