/*
	What properties are you testing in the data1 assignment?


	-purity: set inputted must not be equal to set outputted (==)
	    --> deep copying by defensive copying in BSTNode, BSTree constructors
*/

public interface FiniteSet {
	public int cardinality();

	public Boolean isEmptyHuh();

	public Boolean member(int x);

	public FiniteSet add(int x);

	public FiniteSet remove(int x);

	public FiniteSet union(FiniteSet s);

	public FiniteSet inter(FiniteSet s);

	public FiniteSet diff(FiniteSet s);

	public Boolean equal(FiniteSet s);

	public Boolean subset(FiniteSet s);

	/*


	public FiniteSet minimum();*/

}