package by.den.algorithms.examples;

import by.den.algorithms.core.AbstractSortAlgorithm;
import by.den.algorithms.core.SortAlgorithm;
import by.den.algorithms.core.SortArray;

/**
 * A silly but simple, recursive sorting algorithm.
 * The time complexity is in <var>O</var>(<var>n</var><sup>2.71</sup>).
 */
public final class StoogeSort extends AbstractSortAlgorithm {
	
	// The singleton instance.
	public static final SortAlgorithm INSTANCE = new StoogeSort();

	public void sort(SortArray array) {
		sort(array, 0, array.length());
		array.setRange(0, array.length(), SortArray.ElementState.DONE);
	}

	private static void sort(SortArray array, int start, int end) {
		array.setRange(start, end, SortArray.ElementState.ACTIVE);
		array.compareAndSwap(start, end - 1);
		array.setRange(start, end, SortArray.ElementState.INACTIVE);
		int length = end - start;
		if (length < 3)
			return;

		int third = length / 3;
		sort(array, start, end - third);
		sort(array, start + third, end);
		sort(array, start, end - third);
	}

	// Private constructor.
	private StoogeSort() {
		super("Stooge sort");
	}
	
}
