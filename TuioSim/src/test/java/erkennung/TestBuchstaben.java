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

	@Test
	public void TestW() {
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		String[] W = { "SouthEast", "NorthEast", "SouthEast", "NorthEast" };

		// 0/1000
		for (int i = 1000, j = 0; j <= 500; i--, j++) {
			coordinates.add(new Coordinate(j, i));
			i--;
		}
		// 500/0
		for (int i = 500, j = 0; j <= 1000; i++, j++) {
			coordinates.add(new Coordinate(i, j));
			j++;
		}
		// 1000/1000
		for (int i = 1000, j = 1000; i <= 1500; i++, j--) {
			coordinates.add(new Coordinate(i, j));
			j--;
		}
		// 1500/0
		for (int i = 500, j = 0; j <= 1000; i++, j++) {
			coordinates.add(new Coordinate(i, j));
			j++;
		}

		Buchstabenerkennung b = new Buchstabenerkennung();
		b.getCoordinates(coordinates);

		Assert.assertEquals(true, b.check(W));
	}

	@Test
	public void TestZ() {
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		String[] Z = { "East", "SouthWest", "East" };

		for (int i = 0; i <= 500; i++) {
			coordinates.add(new Coordinate(i, 1000));
		}
		for (int i = 500, j = 1000; j >= 0; i--, j--) {
			coordinates.add(new Coordinate(i, j));
			j--;
		}
		for (int i = 0; i <= 500; i++) {
			coordinates.add(new Coordinate(i, 0));
		}

		Buchstabenerkennung b = new Buchstabenerkennung();
		b.getCoordinates(coordinates);

		Assert.assertEquals(true, b.check(Z));
	}

	@Test
	public void TestK() {
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		String[] K = { "South", "NorthEast", "SouthEast" };

		for (int i = 1000; i >= 0; i--) {
			coordinates.add(new Coordinate(0, i));
		}
		for (int i = 0; i <= 1000; i++) {
			coordinates.add(new Coordinate(i, i));
		}
		for (int i = 1000, j = 0; j <= 1000; i--, j++) {
			coordinates.add(new Coordinate(j, i));
		}

		Buchstabenerkennung b = new Buchstabenerkennung();
		b.getCoordinates(coordinates);

		Assert.assertEquals(true, b.check(K));
	}

	@Test
	public void TestA() {
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		String[] A = { "NorthEast", "SouthEast", "West" };

		for (int i = 0, j = 0; i <= 1000; i++, j++) {
			coordinates.add(new Coordinate(j, i));
			i++;
		}
		for (int i = 1000, j = 500; j <= 1000; i--, j++) {
			coordinates.add(new Coordinate(j, i));
			i--;
		}
		for (int i = 700; i >= 400; i--) {
			coordinates.add(new Coordinate(i, 350));
		}

		Buchstabenerkennung b = new Buchstabenerkennung();
		b.getCoordinates(coordinates);

		Assert.assertEquals(true, b.check(A));
	}

	@Test
	public void TestY() {
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		String[] Y = { "SouthEast", "South", "NorthEast" };

		for (int i = 1000, j = 0; j <= 500; i--, j++) {
			coordinates.add(new Coordinate(j, i));
		}
		for (int i = 500; i >= 0; i--) {
			coordinates.add(new Coordinate(500, i));
		}
		for (int i = 500; i <= 1000; i++) {
			coordinates.add(new Coordinate(i, i));
		}

		Buchstabenerkennung b = new Buchstabenerkennung();
		b.getCoordinates(coordinates);

		Assert.assertEquals(true, b.check(Y));
	}

	@Test
	public void TestX() {
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		String[] X = { "SouthEast", "NorthEast" };

		for (int i = 1000, j = 0; j <= 1000; i--, j++) {
			coordinates.add(new Coordinate(j, i));
		}
		for (int i = 0; i <= 1000; i++) {
			coordinates.add(new Coordinate(i, i));
		}

		Buchstabenerkennung b = new Buchstabenerkennung();
		b.getCoordinates(coordinates);

		Assert.assertEquals(true, b.check(X));
	}

	@Test
	public void TestV() {
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		String[] V = { "SouthEast", "NorthEast" };

		for (int i = 1000, j = 0; j <= 1000; i--, j++) {
			coordinates.add(new Coordinate(j, i));
			i--;
		}
		for (int i = 0, j = 500; i <= 1000; i++, j++) {
			coordinates.add(new Coordinate(i, j));
			i++;
		}

		Buchstabenerkennung b = new Buchstabenerkennung();
		b.getCoordinates(coordinates);

		Assert.assertEquals(true, b.check(V));
	}

	@Test
	public void TestN() {
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		String[] N = { "North", "SouthEast", "North" };

		for (int i = 0; i <= 1000; i++) {
			coordinates.add(new Coordinate(0, i));
		}
		for (int i = 1000, j = 0; j <= 1000; i--, j++) {
			coordinates.add(new Coordinate(j, i));
			i--;
		}
		for (int i = 0; i <= 1000; i++) {
			coordinates.add(new Coordinate(500, i));
		}

		Buchstabenerkennung b = new Buchstabenerkennung();
		b.getCoordinates(coordinates);

		Assert.assertEquals(true, b.check(N));
	}

	@Test
	public void TestM() {
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		String[] M = { "North", "SouthEast", "NorthEast", "South" };

		for (int i = 0; i <= 1000; i++) {
			coordinates.add(new Coordinate(0, i));
		}
		for (int i = 1000, j = 0; j <= 1000; i--, j++) {
			coordinates.add(new Coordinate(j, i));
			i--;
		}
		for (int i = 0, j = 500; i <= 1000; i++, j++) {
			coordinates.add(new Coordinate(j, i));
			i++;
		}
		for (int i = 1000; i >= 0; i--) {
			coordinates.add(new Coordinate(0, i));
		}

		Buchstabenerkennung b = new Buchstabenerkennung();
		b.getCoordinates(coordinates);

		Assert.assertEquals(true, b.check(M));
	}
}