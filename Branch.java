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

	//Returns the superset that contains this set and set s
	public FiniteSet union (FiniteSet s) {
		//We can't access the properties of s, so instead use s
		//as the basis of the union (by calling methods on s)
		//Luckily this isn't mutation because "add" does not mutate
		return s.add(this.key).union(this.left).union(this.right);
	}

	//Returns things that are in both sets (the intersection)
	public FiniteSet inter (FiniteSet s) {
		if (s.member(this.key)) {
			return new Branch (this.left.inter(s), this.key, this.right.inter(s));
		} else {
			return this.remove(this.key).inter(s);
		}
	}

	//Returns the things in this that are not in s
	public FiniteSet diff (FiniteSet s) {
		if (s.member(this.key)) {
			//remove this if it's in s
			return this.remove(this.key).diff(s);
		} else {
			//check both branches if it's not
			return new Branch (this.left.diff(s), this.key, this.right.diff(s));
		}
	}

	public Boolean equal (FiniteSet s) {
		return this.subset(s) && s.subset(this);
	}

	public Boolean subset (FiniteSet s) {
		return s.member(this.key) 
			&& (this.left.isEmptyHuh() || this.left.subset(s)) 
			&& (this.right.isEmptyHuh() || this.right.subset(s));
	}



}