package by.den.algorithms.core;

import java.util.Objects;
import org.junit.Test;


/**
 * A suite of test cases that are appropriate for all sorting algorithms.
 * Each sort algorithm needs to extend this common base class and implement {@link #getInstance()}.
 */
public abstract class SortAlgorithmTest {
	
	// Returns an instance of the sorting algorithm to be tested.
	public abstract SortAlgorithm getInstance();
	
	
	/*---- Test cases ----*/
	
	@Test public void testRandom10() {
		testSorting(10, ArrayOrder.RANDOM);
	}
	
	@Test public void testRandom30() {
		testSorting(30, ArrayOrder.RANDOM);
	}
	
	@Test public void testRandom100() {
		testSorting(100, ArrayOrder.RANDOM);
	}
	
	
	@Test public void testForward100() {
		testSorting(100, ArrayOrder.FORWARD);
	}
	
	@Test public void testReverse100() {
		testSorting(100, ArrayOrder.REVERSE);
	}
	
	
	@Test public void testRandomSizes() {
		final int trials = 100;
		for (int i = 0; i < trials; i++) {
			int size = AbstractSortArray.random.nextInt(trials) + 1;
			testSorting(size, ArrayOrder.RANDOM);
		}
	}
	
	
	
	/*---- Utilities ----*/
	
	protected void testSorting(int size, ArrayOrder type) {
		// Check arguments
		if (size < 0)
			throw new IllegalArgumentException();
		Objects.requireNonNull(type);
		
		// Create array
		TestSortArray arr = new TestSortArray(size);
		switch (type) {
			case FORWARD:  break;
			case REVERSE:  arr.reverse();  break;
			case RANDOM :  arr.shuffle();  break;
			default:  throw new AssertionError();
		}
		
		// Sort and check
		getInstance().sort(arr);
		arr.assertSorted();
	}
	
	
	protected enum ArrayOrder {
		FORWARD, REVERSE, RANDOM;
	}
	
}
