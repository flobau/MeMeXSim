package erkennung;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class TestBuchstaben {

	@Test
	public void TestI() {
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		String[] I = { "North" };

		for (int i = 0; i <= 1000; i++) {
			coordinates.add(new Coordinate(0, i));
		}

		Buchstabenerkennung b = new Buchstabenerkennung();
		b.getCoordinates(coordinates);

		Assert.assertEquals(true, b.check(I));
	}

	@Test
	public void TestL() {
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		String[] L = { "South", "East" };

		for (int i = 700; i >= 0; i--) {
			coordinates.add(new Coordinate(0, i));
		}
		for (int i = 0; i <= 350; i++) {
			coordinates.add(new Coordinate(i, 0));
		}

		Buchstabenerkennung b = new Buchstabenerkennung();
		b.getCoordinates(coordinates);

		Assert.assertEquals(true, b.check(L));
	}

	@Test
	public void TestE() {
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		String[] E = { "South", "East" };

		for (int i = 700; i >= 0; i--) {
			coordinates.add(new Coordinate(0, i));
		}
		for (int i = 0; i <= 350; i++) {
			coordinates.add(new Coordinate(i, 700));
		}
		for (int i = 0; i <= 250; i++) {
			coordinates.add(new Coordinate(i, 350));
		}
		for (int i = 0; i <= 350; i++) {
			coordinates.add(new Coordinate(i, 0));
		}

		Buchstabenerkennung b = new Buchstabenerkennung();
		b.getCoordinates(coordinates);

		Assert.assertEquals(true, b.check(E));
	}

	@Test
	public void TestF() {
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		String[] F = { "South", "East" };

		for (int i = 700; i >= 0; i--) {
			coordinates.add(new Coordinate(0, i));
		}
		for (int i = 0; i <= 350; i++) {
			coordinates.add(new Coordinate(i, 700));
		}
		for (int i = 0; i <= 250; i++) {
			coordinates.add(new Coordinate(i, 350));
		}

		Buchstabenerkennung b = new Buchstabenerkennung();
		b.getCoordinates(coordinates);

		Assert.assertEquals(true, b.check(F));
	}

	@Test
	public void TestT() {
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		String[] T = { "South", "East" };

		for (int i = 700; i >= 0; i--) {
			coordinates.add(new Coordinate(100, i));
		}
		for (int i = -150; i <= 150; i++) {
			coordinates.add(new Coordinate(i, 700));
		}

		Buchstabenerkennung b = new Buchstabenerkennung();
		b.getCoordinates(coordinates);

		Assert.assertEquals(true, b.check(T));
	}

	@Test
	public void TestH() {
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		String[] H = { "South", "East", "South" };

		for (int i = 700; i >= 0; i--) {
			coordinates.add(new Coordinate(0, i));
		}
		for (int i = 1; i <= 300; i++) {
			coordinates.add(new Coordinate(i, 350));
		}
		for (int i = 700; i >= 0; i--) {
			coordinates.add(new Coordinate(302, i));
		}

		Buchstabenerkennung b = new Buchstabenerkennung();
		b.getCoordinates(coordinates);

		Assert.assertEquals(true, b.check(H));
	}
}