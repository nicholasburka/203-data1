public class Branch implements FiniteSet {
	private FiniteSet left;
	private int key;
	private FiniteSet right;

	public Branch (FiniteSet left, int key, FiniteSet right) {
		this.left = left;
		this.key = key;
		this.right = right;
	}

	public int cardinality() {
		return 1 + this.left.cardinality() + this.right.cardinality();
	}

	public Boolean isEmptyHuh() {
		return false;
	}
	
	public FiniteSet insert (int x) {
		if (x == this.key) {
			return this;
		} else if (x > this.key) {
			return new Branch(this.left, this.key, this.right.insert(x));
		} else {
			return new Branch(this.left.insert(x), this.key, this.right);
		}
	}

	public FiniteSet remove (int x) {
		return null;
	}

}