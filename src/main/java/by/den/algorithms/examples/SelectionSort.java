package by.den.algorithms.examples;

import by.den.algorithms.core.AbstractSortAlgorithm;
import by.den.algorithms.core.SortAlgorithm;
import by.den.algorithms.core.SortArray;

/**
 * Sorts by finding the smallest element in the unsorted subarray
 * and swapping it to end of the sorted subarray.
 * The time complexity is in <var>O</var>(<var>n</var><sup>2</sup>).
 */
public final class SelectionSort extends AbstractSortAlgorithm {
	
	// The singleton instance.
	public static final SortAlgorithm INSTANCE = new SelectionSort();

	public void sort(SortArray array) {
		int length = array.length();
		for (int i = 0; i < length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < length; j++) {
				if (array.compare(j, minIndex) < 0)
					minIndex = j;
			}
			array.swap(i, minIndex);
			array.setElement(i, SortArray.ElementState.DONE);
		}
	}

	// Private constructor.
	private SelectionSort() {
		super("Selection sort");
	}
	
}
