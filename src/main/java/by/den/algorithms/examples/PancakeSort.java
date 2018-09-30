package by.den.algorithms.examples;

import by.den.algorithms.core.AbstractSortAlgorithm;
import by.den.algorithms.core.SortAlgorithm;
import by.den.algorithms.core.SortArray;

public final class PancakeSort extends AbstractSortAlgorithm {
	
	// The singleton instance.
	public static final SortAlgorithm INSTANCE = new PancakeSort();

	public void sort(SortArray array) {
		for (int i = array.length() - 1; i >= 0; i--) {
			int maxIndex = 0;
			for (int j = 1; j <= i; j++) {
				if (array.compare(j, maxIndex) > 0)
					maxIndex = j;
			}
			reverse(array, 0, maxIndex + 1);
			reverse(array, 0, i + 1);
			array.setElement(i, SortArray.ElementState.DONE);
		}
	}

	// Reverses the elements in the array subrange of [start, end).
	private static void reverse(SortArray array, int start, int end) {
		for (end--; start < end; start++, end--)
			array.swap(start, end);
	}

	// Private constructor.
	private PancakeSort() {
		super("Pancake sort");
	}
	
}
