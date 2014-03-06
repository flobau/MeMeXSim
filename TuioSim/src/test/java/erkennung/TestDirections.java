package erkennung;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
	public void TestIfSouthWorks() {
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

	@Test
	public void TestIfNorthToEastCurveWorks() {
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		String[] northtoeast = { "East", "SouthEast" };

		coordinates.add(new Coordinate(0, 10));
		coordinates.add(new Coordinate(1, 10));
		coordinates.add(new Coordinate(2, 10));
		coordinates.add(new Coordinate(3, 9));
		coordinates.add(new Coordinate(4, 9));
		coordinates.add(new Coordinate(5, 9));
		coordinates.add(new Coordinate(6, 8));
		coordinates.add(new Coordinate(7, 7));
		coordinates.add(new Coordinate(8, 6));
		coordinates.add(new Coordinate(9, 5));
		coordinates.add(new Coordinate(10, 0));

		Buchstabenerkennung b = new Buchstabenerkennung();
		b.getCoordinates(coordinates);

		Assert.assertEquals(true, b.check(northtoeast));
	}

	@Test
	public void TestIfEastToSouthCurveWorks() {
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		String[] easttosouth = { "South", "SouthWest" };
		
		coordinates.add(new Coordinate(10, 10));
		coordinates.add(new Coordinate(10, 9));
		coordinates.add(new Coordinate(10, 8));
		coordinates.add(new Coordinate(9, 7));
		coordinates.add(new Coordinate(9, 6));
		coordinates.add(new Coordinate(8, 5));
		coordinates.add(new Coordinate(7, 4));
		coordinates.add(new Coordinate(6, 3));
		coordinates.add(new Coordinate(5, 2));
		coordinates.add(new Coordinate(4, 1));
		coordinates.add(new Coordinate(0, 0));
		
		Buchstabenerkennung b = new Buchstabenerkennung();
		b.getCoordinates(coordinates);
		
		Assert.assertEquals(true, b.check(easttosouth));
	}
	
	@Test
	public void TestIfSouthToWestCurveWorks() {
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		String[] southtowest = { "West", "NorthWest" };
		
		coordinates.add(new Coordinate(10, 0));
		coordinates.add(new Coordinate(9, 0));
		coordinates.add(new Coordinate(8, 1));
		coordinates.add(new Coordinate(7, 1));
		coordinates.add(new Coordinate(6, 2));
		coordinates.add(new Coordinate(5, 2));
		coordinates.add(new Coordinate(4, 3));
		coordinates.add(new Coordinate(3, 4));
		coordinates.add(new Coordinate(2, 5));
		coordinates.add(new Coordinate(1, 6));
		coordinates.add(new Coordinate(0, 10));
		
		Buchstabenerkennung b = new Buchstabenerkennung();
		b.getCoordinates(coordinates);
		
		Assert.assertEquals(true, b.check(southtowest));
	}
	
	@Test
	public void TestIfWestToNortCurveWorks() {
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		String[] westtonorth = { "North", "NorthEast" };
		
		coordinates.add(new Coordinate(0, 0));
		coordinates.add(new Coordinate(0, 1));
		coordinates.add(new Coordinate(1, 2));
		coordinates.add(new Coordinate(1, 3));
		coordinates.add(new Coordinate(2, 4));
		coordinates.add(new Coordinate(2, 5));
		coordinates.add(new Coordinate(3, 6));
		coordinates.add(new Coordinate(4, 7));
		coordinates.add(new Coordinate(5, 8));
		coordinates.add(new Coordinate(6, 9));
		coordinates.add(new Coordinate(10, 10));
		
		Buchstabenerkennung b = new Buchstabenerkennung();
		b.getCoordinates(coordinates);
		
		Assert.assertEquals(true, b.check(westtonorth));
	}
}
