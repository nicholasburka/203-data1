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
		if (this.getParent() != null) {
			newBSTNode.setParent(this.getParent());
		}
		if (this.getLeft() != null) {
			newBSTNode.setLeft(this.getLeft());
		}
		if (this.getRight() != null) {
			newBSTNode.setRight(this.getRight());
		}
		newBSTNode.setKey(this.getKey());
		/*System.out.println(newBSTNode);
		System.out.println(newBSTNode.getKey());*/
		return newBSTNode;
	}

	//resembles recursive algorithm for pre-order tree walk
	public void cloneChildrenTreeWalk() {
		BSTNode left = this.getLeft();
		BSTNode right = this.getRight();

		if (left != null) {
			this.setLeft(left);
			this.getLeft().cloneChildrenTreeWalk();
		}
		if (right != null) {
			this.setRight(right);
			this.getRight().cloneChildrenTreeWalk();
		}
	}

	public BSTNode getParent() {
		return this.parent;
	}

	public BSTNode getLeft() {
		return this.left;
	}

	public BSTNode getRight() {
		return this.right;
	}

	public int getKey() {
		return this.key;
	}

	//is cloning in the setters unnecessary since it's at the level of
	//BSTree's where purity matters?
	public void setParent(BSTNode parent) {
		this.parent = parent.clone();
	}

	public void setLeft(BSTNode left) {
		this.left = left.clone();
	}

	public void setRight(BSTNode right) {
		this.right = right.clone();
		/*System.out.println("Set this.right to " + this.right);
		System.out.println("Let's see what the right is..." + this.getRight());*/
	}

	public void setKey(int key) {
		this.key = key;
	}
 }