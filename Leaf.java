public class Leaf implements FiniteSet {
	Leaf () {}
	
	@Override public String toString() {
		return "new Leaf()";
	}

	public int cardinality() {
		return 0;
	}

	public Boolean isEmptyHuh() {
		return true;
	}

	public Boolean member(int x) {
		return false;
	}

	public FiniteSet add(int x) {
		return new Branch (this, x, this);
	}

	public FiniteSet remove(int x) {
		throw new RuntimeException("Leaf has no value or children");
	}
}