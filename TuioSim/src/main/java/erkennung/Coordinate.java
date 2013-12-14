package erkennung;

public class Coordinate {
	public int o1;
	public int o2;

	public Coordinate(int o1, int o2) {
		this.o1 = o1;
		this.o2 = o2;
	}

	public static boolean same(int o1, int o2) {
		if(Math.abs(o1)-Math.abs(o2) == 0) return true;
		return false;
	}

	Object getFirst() {
		return o1;
	}

	Object getSecond() {
		return o2;
	}

	void setFirst(int o) {
		o1 = o;
	}

	void setSecond(int o) {
		o2 = o;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Coordinate))
			return false;
		Coordinate p = (Coordinate) obj;
		return same(p.o1, this.o1) && same(p.o2, this.o2);
	}

	public String toString() {
		return "Pair{" + o1 + ", " + o2 + "}";
	}

}
