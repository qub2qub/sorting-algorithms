package by.den.algorithms.core;

import org.junit.Assert;


/**
 * A simple array, not supporting graphics, for the purpose of testing correct sorting.
 */
final class TestSortArray extends AbstractSortArray {
	
	/*---- Constructors ----*/
	
	public TestSortArray(int size) {
		super(size);
	}
	
	
	/*---- Methods ----*/
	
	// Reverses the order of the current state of the array.
	public void reverse() {
		for (int i = 0, j = values.length - 1; i < j; i++, j--)
			swap(i, j);
	}
	
	
	// Tests whether the array is in sorted order, either returning silently or throwing AssertionError.
	public void assertSorted() {
		for (int i = 0; i < values.length - 1; i++)
			Assert.assertTrue(values[i] <= values[i + 1]);
	}
	
}
