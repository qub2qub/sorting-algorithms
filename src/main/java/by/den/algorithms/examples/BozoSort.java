package by.den.algorithms.examples;

import by.den.algorithms.core.AbstractSortAlgorithm;
import by.den.algorithms.core.AbstractSortArray;
import by.den.algorithms.core.SortAlgorithm;
import by.den.algorithms.core.SortArray;

/**
 * Sorts by randomly selecting two elements and swapping them
 * if they are in inverted order, until the array is sorted.
 * The time complexity is in <var>O</var>(<var>n</var><sup>3</sup> log <var>n</var>).
 */
public final class BozoSort extends AbstractSortAlgorithm {
	
	// The singleton instance.
	public static final SortAlgorithm INSTANCE = new BozoSort();

	public void sort(SortArray array) {
		int length = array.length();
		while (!isSorted(array)) {
			int i = AbstractSortArray.random.nextInt(length);
			int j = AbstractSortArray.random.nextInt(length);
			array.compareAndSwap(Math.min(i, j), Math.max(i, j));
		}
		array.setRange(0, length, SortArray.ElementState.DONE);
	}

	// Tests whether the entire array is in non-decreasing order.
	private static boolean isSorted(SortArray array) {
		for (int i = 0; i < array.length() - 1; i++) {
			if (array.compare(i, i + 1) > 0)
				return false;
		}
		return true;
	}

	// Private constructor.
	private BozoSort() {
		super("Bozo sort");
	}
	
}
