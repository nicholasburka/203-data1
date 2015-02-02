public class BSTNode {
	private BSTNode parent;
	private BSTNode left;
	private BSTNode right;
	private int key;

	public BSTNode (int key) {
		this.key = key;
	}

	public BSTNode () {
		this.key = 0;
	}

	public BSTNode (BSTNode parent, BSTNode left, BSTNode right, int key) {
		this.parent = parent;
		this.left = left;
		this.right = right;
		this.key = key;
	}

	public BSTNode (BSTNode left, BSTNode right, int key) {
		this.left = left;
		this.right = right;
		this.key = key;
	}

	public BSTNode getParent() {
		return this.parent;
	}

	public BSTNode getLeft() {
		return this.left;
	}

	public BSTNode getRight() {
		return this.left;
	}

	public int getKey() {
		return this.key;
	}

	public void setParent(BSTNode parent) {
		this.parent = parent;
	}

	public void setLeft(BSTNode left) {
		this.left = left;
	}

	public void setRight(BSTNode right) {
		this.right = right;
	}

	public void setKey(int key) {
		this.key = key;
	}
 }