package by.den.algorithms.examples;

import by.den.algorithms.core.AbstractSortAlgorithm;
import by.den.algorithms.core.SortAlgorithm;
import by.den.algorithms.core.SortArray;

/**
 * A pessimal "multiply and surrender" algorithm with superpolynomial time complexity.
 */
public final class SlowSort extends AbstractSortAlgorithm {
	
	// The singleton instance.
	public static final SortAlgorithm INSTANCE = new SlowSort();

	public void sort(SortArray array) {
		array.setRange(0, array.length(), SortArray.ElementState.INACTIVE);
		sort(array, 0, array.length(), true);
	}

	private static void sort(SortArray array, int start, int end, boolean isMain) {
		int length = end - start;
		if (length >= 2) {
			int mid = start + length / 2;
			sort(array, start, mid, false);
			sort(array, mid, end, false);
			array.setRange(start, end, SortArray.ElementState.ACTIVE);
			array.compareAndSwap(mid - 1, end - 1);
			array.setRange(start, end, SortArray.ElementState.INACTIVE);
		}
		if (isMain)
			array.setElement(end - 1, SortArray.ElementState.DONE);
		if (length >= 2)
			sort(array, start, end - 1, isMain);
	}

	// Private constructor.
	private SlowSort() {
		super("Slow sort");
	}
	
}
