package by.den.algorithms.examples;

import by.den.algorithms.core.AbstractSortAlgorithm;
import by.den.algorithms.core.SortAlgorithm;
import by.den.algorithms.core.SortArray;

/**
 * Sorts by swapping the first adjacent inversion and going back to the beginning, until the array is sorted.
 * The time complexity is in <var>O</var>(<var>n</var><sup>3</sup>). Insertion sort is the optimized form.
 */
public final class StupidSort extends AbstractSortAlgorithm {
	
	// The singleton instance.
	public static final SortAlgorithm INSTANCE = new StupidSort();

	public void sort(SortArray array) {
		int length = array.length();
		array.setRange(0, length, SortArray.ElementState.INACTIVE);
		int i = 0;
		while (i < length - 1) {
			if (array.compareAndSwap(i, i + 1))
				i = 0;
			else
				i++;
		}
		array.setRange(0, length, SortArray.ElementState.DONE);
	}

	// Private constructor.
	private StupidSort() {
		super("Stupid sort");
	}
	
}
