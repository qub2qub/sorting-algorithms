package by.den.algorithms.examples;

import by.den.algorithms.core.AbstractSortAlgorithm;
import by.den.algorithms.core.SortAlgorithm;
import by.den.algorithms.core.SortArray;

/**
 * Sorts by swapping the next unsorted item into the correct position in the sorted subarray.
 * The time complexity is in <var>O</var>(<var>n</var><sup>2</sup>).
 */
public final class InsertionSort extends AbstractSortAlgorithm {
	
	// The singleton instance.
	public static final SortAlgorithm INSTANCE = new InsertionSort();

	public void sort(SortArray array) {
		int length = array.length();
		array.setRange(0, length, SortArray.ElementState.INACTIVE);
		for (int i = 0; i < length; i++) {
			for (int j = i; j >= 1 && array.compareAndSwap(j - 1, j); j--);
		}
		array.setRange(0, length, SortArray.ElementState.DONE);
	}

	// Private constructor.
	private InsertionSort() {
		super("Insertion sort");
	}
	
}
