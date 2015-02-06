public class Branch implements FiniteSet {
	private FiniteSet left;
	private int key;
	private FiniteSet right;

	public Branch (FiniteSet left, int key, FiniteSet right) {
		this.left = left;
		this.key = key;
		this.right = right;
	}

	@Override public String toString() {
		return "new Branch(" + this.left + "," + this.key + "," + this.right + ")";
	}

	public int cardinality() {
		return 1 + this.left.cardinality() + this.right.cardinality();
	}

	public Boolean isEmptyHuh() {
		return false;
	}

	public Boolean member(int x) {
		if (x == this.key) {
			return true;
		} else if (x > this.key) {
			return this.right.member(x);
		} else {//if (x < this.key)
			return this.left.member(x);
		}
	}
	
	public FiniteSet add (int x) {
		if (x == this.key) {
			return this;
		} else if (x > this.key) {
			return new Branch(this.left, this.key, this.right.add(x));
		} else {
			return new Branch(this.left.add(x), this.key, this.right);
		}
	}

	/*public FiniteSet successor*/

	public FiniteSet remove (int x) {
		if (x == this.key) {
			return this.left.union(this.right);
		} else if (x > this.key) {
			return new Branch (this.left, this.key, this.right.remove(x));
		} else {
			return new Branch (this.left.remove(x), this.key, this.right.remove(x));
		}
	}

	public FiniteSet union (FiniteSet s) {
		//We can't access the properties of s, so instead use s
		//as the basis of the union (by calling methods on s)
		//Luckily this isn't mutation because "add" does not mutate
		return s.add(this.key).union(this.left).union(this.right);
	}

	public FiniteSet inter (FiniteSet s) {
		if (s.member(this.key)) {
			return new Branch (this.left.inter(s), this.key, this.right.inter(s));
		} else {
			return this.remove(this.key).inter(s);
		}
	}

	public FiniteSet diff (FiniteSet s) {
		//To Be Implemented (later)
		return this;

		//remove all elements of s from this
	}

}