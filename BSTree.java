/*
TODO: fix cardinality issues
*/

public class BSTree implements Cloneable {
 	private BSTNode root;
 	private int count;

 	public BSTree () {
 	}

 	public BSTree (BSTNode root) {
 		this.root = root;//.clone();
 		this.count = 1;
 	}

 	public BSTree clone () {
 		BSTree newBSTree = new BSTree(this.root.clone());
 		newBSTree.getRoot().cloneChildrenTreeWalk();
 		return newBSTree;
 	}

 	//probably not good practice to have this method
 	public BSTNode getRoot() {
 		return this.root;
 	}

 	public void insert (BSTNode node) {
 		if (this.root == null) {
 			this.root = node;
 		} else {
 			BSTNode current = this.root;
 			BSTNode last = current;

 			while (current != null) {
 				//note that this tree abides by 
 				//nodes in the left subtree will be <= parent nodes
 				last = current;
 				if (current.getKey() >= node.getKey()) {
 					current = current.getLeft();
 				} else {
 					current = current.getRight();
 				}
 			}

 			if (last.getKey() >= node.getKey()) {
 				last.setLeft(node);
 			} else {
 				last.setRight(node);
 			}

 			node.setParent(last);
 		}

 		this.count++;
 	}

 	public void insert (int key) {
 		if (this.root == null) {
 			this.root = new BSTNode(key);
 		} else {
 			BSTNode current = this.clone().root; //insures purity
 			BSTNode last = current;

 			while (current != null) {
 				//note that this tree abides by greater than or equal
 				//nodes as the right child
 				last = current;
 				if (current.getKey() >= key) {
 					current = current.getLeft();
 				} else {
 					current = current.getRight();
 				}
 			}

 			BSTNode newb = new BSTNode(key);

 			if (last.getKey() >= key) {
 				last.setLeft(newb);
 			} else {
 				last.setRight(newb);
 			}

 			newb.setParent(last);
 		}

 		this.count++;
 	}

 	public void remove (int key) {
 		if (this.root == null) {
 			System.out.println("Error, empty tree");
 		} else {
 			BSTNode current = this.clone().root; //insures purity
 			BSTNode last = current;

 			while (current.getKey() != key && current != null) {

 				last = current;
 				if (current.getKey() >= key) {
 					current = current.getLeft();
 				} else {
 					current = current.getRight();
 				}
 			}

 			String direction = "";
 			if (last.getKey() > key) {
 				direction = "left";
 			} else {
 				direction = "right";
 			}

 			if (current == null) {
 				System.out.println("Key is not present in the tree.");
 			} else {
 				switch (current.numChildren()) {
 				case 0:
 					if (direction.equals("left")) {
 						last.setLeft(null);
 					} else {
 						last.setRight(null);
 					}
 					break;
 				case 1:
 					if (direction.equals("left")) {
 						if (current.hasLeft()) {
 							last.setLeft(current.getLeft());
 							current.getLeft().setParent(last);
 						} else {
 							last.setRight(current.getRight());
 							current.getRight().setParent(last);
 						}
 					} else if (current.hasLeft()) {
 						last.setRight(current.getLeft());
 						current.getLeft().setParent(last);
 					} else {
 						last.setRight(current.getRight());
 						current.getRight().setParent(last);
 					}
 					break;
 				case 2:
 					//complicated procedure here
 					break;

 				}
 			}

 		}

 		this.count--;
 	}

 	public Boolean search (int key) {
 		if (this.root == null) {
 			return false;
 		} else {
 			BSTNode current = this.root;

 			while (current.getKey() != key && current != null) {

 				if (current.getKey() >= key) {
 					current = current.getLeft();
 				} else {
 					current = current.getRight();
 				}
 			}

 			if (current == null) {
 				return false;
 			} else {
 				return true;
 			}
 		}
 	}

 }