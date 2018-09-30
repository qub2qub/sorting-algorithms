package by.den.algorithms.examples;

import by.den.algorithms.core.AbstractSortAlgorithm;
import by.den.algorithms.core.SortAlgorithm;
import by.den.algorithms.core.SortArray;

/**
 * Sorts by running a sequence of insertion sorts with varying gaps.
 * The time complexity is in <var>O</var>(<var>n</var><sup>1.3</sup>).
 */
public final class ShellSort extends AbstractSortAlgorithm {
	
	// The singleton instance.
	public static final SortAlgorithm INSTANCE = new ShellSort();

	private static int[] GAP_SEQUENCE = {1750, 701, 301, 132, 57, 23, 10, 4, 1};

	public void sort(SortArray array) {
		int length = array.length();
		for (int step : GAP_SEQUENCE) {
			array.setRange(0, length, SortArray.ElementState.INACTIVE);

			// Do an insertion sort with this step size
			for (int j = 0; j < length; j++) {
				for (int k = j; k >= step && array.compareAndSwap(k - step, k); k -= step);
			}
		}
		array.setRange(0, length, SortArray.ElementState.DONE);
	}

	// Private constructor.
	private ShellSort() {
		super("Shell sort");
	}
	
}
