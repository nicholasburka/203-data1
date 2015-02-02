/*
	Test suite for data1
*/

public class Tester {

	public static void main (String[] args) {
		if (Test()) {
			System.out.println("All tests passed!");
		} else {
			System.out.println("Test(s) failed.");
		}
	}


	//needs revisions on printouts
	public static Boolean Test() {
		Boolean passed = true;

		BSTNode node1 = new BSTNode (1);
		passed &= (node1.getKey() == 1);
		System.out.println(passed);

		BSTNode node2 = new BSTNode (2);
		node1.setRight(node2.clone());
		passed &= (node1.getRight() != node2);
		System.out.println(passed);

		/*System.out.println(node1);
		System.out.println(node1.getKey());
		System.out.println(node1.clone());
		System.out.println(node1.clone().getKey());

		System.out.println(node1.getRight());
		System.out.println(node1.getRight().getKey());*/
		passed &= (node1.getRight().getKey() == node2.getKey());
		System.out.println(passed);


		BSTree tree1 = new BSTree (node1);
		passed &= (tree1.getRoot() == node1);
		System.out.println(passed);

		passed &= (tree1.getRoot().getKey() == node1.getKey());
		System.out.println(passed);

		BSTree tree2 = tree1.clone();
		passed &= (tree1 != tree2);
		System.out.println(passed);
		passed &= (tree1.getRoot().getKey() == tree2.getRoot().getKey());
		System.out.println(passed);
		passed &= (tree1.getRoot().getRight() != tree2.getRoot().getRight());
		System.out.println(passed);
		passed &= (tree1.getRoot().getRight().getKey() == tree2.getRoot().getRight().getKey());
		System.out.println(passed);

		return passed;
	}
}
/*
public abstract class Test {
	public String testName;

	public abstract Boolean procedure();
}
*/