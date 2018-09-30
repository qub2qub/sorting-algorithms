package by.den.algorithms.core;

import org.junit.Test;


/**
 * Adds test cases involving large arrays, which are appropriate for fast sort algorithms that run in
 * O(n log n) time. Actual sort algos need to extend this abstract base class for this to be useful.
 */
public abstract class FastSortAlgorithmTest extends SortAlgorithmTest {
	
	@Test public void testRandom1e3() {
		testSorting(1 * 1000, ArrayOrder.RANDOM);
	}
	
	@Test public void testRandom1e4() {
		testSorting(10 * 1000, ArrayOrder.RANDOM);
	}
	
	@Test public void testRandom1e5() {
		testSorting(100 * 1000, ArrayOrder.RANDOM);
	}
	
}
