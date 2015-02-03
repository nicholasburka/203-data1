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

	public FiniteSet insert(int x) {
		return new Branch (this, x, this);
	}
}