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
			//No children: this branch --> leaf
			if (this.cardinality() == 1) {
				return new Leaf();
			} else {
				//One child: replace this Branch with its child
				if (this.left.cardinality() == 0) {
					return this.right;
				} else if (this.right.cardinality() == 0) {
					return this.left;
				} else {
					//Two children: complicated stuff
					return new Leaf();
				}
			}
		} else if (x > this.key) {
			return new Branch(this.left, this.key, this.right.remove(x));
		} else {
			return new Branch(this.left.remove(x), this.key, this.right);
		}
	}

}