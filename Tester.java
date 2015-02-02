/*
	Test suite for data1
*/

public class Tester {

	public static void main (String[] args) {
		BSTNodeTest();
	}

	public static Boolean BSTNodeTest() {
		Boolean passed = true;

		BSTNode node1 = new BSTNode (1);
		passed &= (node1.getKey() == 1);
		System.out.println(passed);

		BSTNode node2 = new BSTNode (2);
		node1.setRight(node2);
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


		return passed;
	}
}