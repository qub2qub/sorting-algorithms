package by.den.algorithms.examples;

import by.den.algorithms.core.AbstractSortAlgorithm;
import by.den.algorithms.core.SortAlgorithm;
import by.den.algorithms.core.SortArray;

/**
 * Sorts by scanning forward and swapping inverted adjacent elements.
 * The time complexity is in <var>O</var>(<var>n</var><sup>2</sup>).
 */
public final class BubbleSort extends AbstractSortAlgorithm {
	
	// The singleton instance.
	public static final SortAlgorithm INSTANCE = new BubbleSort();

	public void sort(SortArray array) {
		for (int i = array.length(); i >= 1; i--) {
			for (int j = 0; j < i - 1; j++)
				array.compareAndSwap(j, j + 1);
			array.setElement(i - 1, SortArray.ElementState.DONE);
		}
	}

	// Private constructor.
	private BubbleSort() {
		super("Bubble sort");
	}
	
}
