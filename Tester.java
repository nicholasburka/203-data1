import java.util.Random;

/*
	Test suite for data1
*/

public class Tester {
	private final int NUM_TIMES = 10;
	private final int UPPER_BOUND = 1000;
	private int numElements = 100;

	public Tester () {}

	public static void main (String[] args) {
		Tester t = new Tester();
		System.out.println("Beginning tests!");
		if (t.Test()) {
			System.out.println("\nAll tests passed!");
		} else {
			System.out.println("\nTest(s) failed.");
		}
	}


	//needs revisions on printouts
	public Boolean Test() {
		Boolean passed = true;

		setUpTest();
		MakeSet m = new MakeSet();
		m.procedure(NUM_TIMES, UPPER_BOUND, numElements);
		printTest(m.testDescription, m.passed);
		passed &= m.passed;

		setUpTest();
		Cardinality c = new Cardinality();
		c.procedure(NUM_TIMES, UPPER_BOUND, numElements);
		printTest(c.testDescription, c.passed);
		passed &= c.passed;

		setUpTest();
		Empty e = new Empty();
		e.procedure(NUM_TIMES, UPPER_BOUND, numElements);
		printTest(e.testDescription, e.passed);
		passed &= e.passed;

		return passed;
	}

	public void setUpTest() {
		System.out.println("");
	}

	public void printTest(String str, Boolean boole) {
		System.out.println(str);
		System.out.println("Test result was " + boole);
	}
}

abstract class Test {
	public static String testDescription;
	public static Boolean passed;

	//should update passed at end of procedure
	public abstract Boolean procedure(int numTimes, int upperBound, int numElements);

	//generates a FiniteSet with numElements number of UNIQUE elements
	public FiniteSet generateFiniteSet(int upperBound, int numElements) {
		if (upperBound < numElements) {
			throw new RuntimeException("Need a larger upperBound to fit desired numElements");
		} else {
			FiniteSet set = new Leaf();
			Random rand = new Random();
			int next = 0;
			for (int i = 0; i < numElements; i++) {
				next = rand.nextInt(upperBound);

				//ensures uniqueness of added value
				while (set.member(next)) {
					next = rand.nextInt(upperBound);
				}

				//REMEMBER TO ASSIGN SET TO RESULT OF EXPRESSION, because there's no mutation!
				set = set.add(next);
			}
			return set;
		}
	}
}

class MakeSet extends Test {
	public String testDescription = "Check that a FiniteSet contains all the elements added to it";

	MakeSet() {}

	public Boolean procedure(int numTimes, int upperBound, int numElements) {
		FiniteSet set = new Leaf();
		int[] nums = new int[numElements];
		Random rand = new Random();
		Boolean passed = true;
		for (int h = 0; h < numTimes; h++) {
			for (int i = 0; i < numElements; i++) {
				nums[i] = rand.nextInt(upperBound);
			}
			for (int j = 0; j < nums.length; j++) {
				set = set.add(nums[j]);
			}
			for (int e = 0; e < nums.length; e++) {
				passed &= set.member(nums[e]);
				if (!passed) {
					System.out.println("Element " + nums[e] + " was not a member of the set");
					System.out.println(set);
				}
			}
		}
		MakeSet.passed = passed;
		return passed;
	}
}

class Cardinality extends Test {
	public String testDescription = "Check that a FiniteSet has the number of unique elements added to it";

	Cardinality() {}

	public Boolean procedure(int numTimes, int upperBound, int numElements) {
		FiniteSet set;
		for (int i = 0; i < numTimes; i++) {
			set = generateFiniteSet(upperBound, numElements);
			this.passed = set.cardinality() == numElements;
			if (!passed) {
				System.out.println("Cardinality of set " + set + " was not " + numElements);
			}
		}
		return this.passed;
	}
}

class Empty extends Test {
	public String testDescription = "Check that empty sets are empty, and non-empty sets are not";

	Empty() {}

	public Boolean procedure(int numTimes, int upperBound, int numElements) {
		FiniteSet set;
		for (int i = 0; i < numTimes; i++) {
			set = new Leaf();
			this.passed = set.isEmptyHuh();
			if (!passed) {
				System.out.println("Empty set " + set + " was not empty");
			}

			set = generateFiniteSet(upperBound, 1);
			this.passed = !(set.isEmptyHuh());
			if (!passed) {
				System.out.println("Nonempty set " + set + " was empty");
			}

			set = generateFiniteSet(upperBound, numElements);
			this.passed = !(set.isEmptyHuh());
			if (!passed) {
				System.out.println("Nonempty set " + set + " was empty");
			}
		}
		return this.passed;
	}
}
