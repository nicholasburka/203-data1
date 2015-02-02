//Does making all setters and constructors clone their arguments add "purity" to the implementation?

public class BSTNode implements Cloneable {
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
		this.parent = parent.clone();
		this.left = left.clone();
		this.right = right.clone();
		this.key = key;
	}

	public BSTNode (BSTNode left, BSTNode right, int key) {
		this.left = left.clone();
		this.right = right.clone();
		this.key = key;
	}

	@Override public BSTNode clone() {
		BSTNode newBSTNode = new BSTNode();
		newBSTNode.setParent(this.getParent());
		newBSTNode.setLeft(this.getLeft());
		newBSTNode.setRight(this.getRight());
		newBSTNode.setKey(this.getKey());
		return newBSTNode;
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
		this.parent = parent.clone();
	}

	public void setLeft(BSTNode left) {
		this.left = left.clone();
	}

	public void setRight(BSTNode right) {
		this.right = right.clone();
	}

	public void setKey(int key) {
		this.key = key;
	}
 }