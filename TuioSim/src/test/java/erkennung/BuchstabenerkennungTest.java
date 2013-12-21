package erkennung;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class BuchstabenerkennungTest {

	@Test
	public void TestIfNorthWorks() {
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		String[] north = { "North" };

		Coordinate c0 = new Coordinate(0, 0);
		Coordinate c1 = new Coordinate(0, 1);
		Coordinate c2 = new Coordinate(0, 2);
		Coordinate c3 = new Coordinate(0, 3);
		Coordinate c4 = new Coordinate(0, 4);
		Coordinate c5 = new Coordinate(0, 5);
		Coordinate c6 = new Coordinate(0, 6);
		Coordinate c7 = new Coordinate(0, 7);
		Coordinate c8 = new Coordinate(0, 8);
		Coordinate c9 = new Coordinate(0, 9);
		Coordinate c10 = new Coordinate(0, 10);
		Coordinate c11 = new Coordinate(0, 11);
		Coordinate c12 = new Coordinate(0, 12);

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
		coordinates.add(c12);

		Buchstabenerkennung b = new Buchstabenerkennung();
		b.getCoordinates(coordinates);

		Assert.assertEquals(true, b.check(north));
	}

	@Test
	public void TestIfEasthWorks() {
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		String[] east = { "East" };

		Coordinate c0 = new Coordinate(0, 0);
		Coordinate c1 = new Coordinate(1, 0);
		Coordinate c2 = new Coordinate(2, 0);
		Coordinate c3 = new Coordinate(3, 0);
		Coordinate c4 = new Coordinate(4, 0);
		Coordinate c5 = new Coordinate(5, 0);
		Coordinate c6 = new Coordinate(6, 0);
		Coordinate c7 = new Coordinate(7, 0);
		Coordinate c8 = new Coordinate(8, 0);
		Coordinate c9 = new Coordinate(9, 0);
		Coordinate c10 = new Coordinate(10, 0);
		Coordinate c11 = new Coordinate(11, 0);
		Coordinate c12 = new Coordinate(12, 0);

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
		coordinates.add(c12);

		Buchstabenerkennung b = new Buchstabenerkennung();
		b.getCoordinates(coordinates);

		Assert.assertEquals(true, b.check(east));
	}

	@Test
	public void TestIfSouthhWorks() {
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		String[] south = { "South" };

		Coordinate c0 = new Coordinate(0, 12);
		Coordinate c1 = new Coordinate(0, 11);
		Coordinate c2 = new Coordinate(0, 10);
		Coordinate c3 = new Coordinate(0, 9);
		Coordinate c4 = new Coordinate(0, 8);
		Coordinate c5 = new Coordinate(0, 7);
		Coordinate c6 = new Coordinate(0, 6);
		Coordinate c7 = new Coordinate(0, 5);
		Coordinate c8 = new Coordinate(0, 4);
		Coordinate c9 = new Coordinate(0, 3);
		Coordinate c10 = new Coordinate(0, 2);
		Coordinate c11 = new Coordinate(0, 1);
		Coordinate c12 = new Coordinate(0, 0);

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
		coordinates.add(c12);

		Buchstabenerkennung b = new Buchstabenerkennung();
		b.getCoordinates(coordinates);

		Assert.assertEquals(true, b.check(south));
	}

	@Test
	public void TestIfWestWorks() {
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		String[] west = { "West" };

		Coordinate c0 = new Coordinate(12, 0);
		Coordinate c1 = new Coordinate(11, 0);
		Coordinate c2 = new Coordinate(10, 0);
		Coordinate c3 = new Coordinate(9, 0);
		Coordinate c4 = new Coordinate(8, 0);
		Coordinate c5 = new Coordinate(7, 0);
		Coordinate c6 = new Coordinate(6, 0);
		Coordinate c7 = new Coordinate(5, 0);
		Coordinate c8 = new Coordinate(4, 0);
		Coordinate c9 = new Coordinate(3, 0);
		Coordinate c10 = new Coordinate(2, 0);
		Coordinate c11 = new Coordinate(1, 0);
		Coordinate c12 = new Coordinate(0, 0);

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
		coordinates.add(c12);

		Buchstabenerkennung b = new Buchstabenerkennung();
		b.getCoordinates(coordinates);

		Assert.assertEquals(true, b.check(west));
	}
}