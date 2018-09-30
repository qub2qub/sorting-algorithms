package by.den.algorithms.examples;

import by.den.algorithms.core.AbstractSortAlgorithm;
import by.den.algorithms.core.SortAlgorithm;
import by.den.algorithms.core.SortArray;

public final class QuasiPancakeSort extends AbstractSortAlgorithm {
	
	// The singleton instance.
	public static final SortAlgorithm INSTANCE = new QuasiPancakeSort();

	public void sort(SortArray array) {
		int length = array.length();
		for (int i = 1; i < length; i++) {
			int j = i;
			while (j >= 1 && array.compare(j - 1, i) > 0)
				j--;
			reverse(array, j, i);
			reverse(array, j, i + 1);
		}
		array.setRange(0, length, SortArray.ElementState.DONE);
	}

	// Reverses the elements in the array subrange of [start, end).
	private static void reverse(SortArray array, int start, int end) {
		for (end--; start < end; start++, end--)
			array.swap(start, end);
	}

	// Private constructor.
	private QuasiPancakeSort() {
		super("Quasi-pancake sort");
	}
	
}
