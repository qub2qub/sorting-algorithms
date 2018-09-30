package by.den.algorithms.examples;

import by.den.algorithms.core.AbstractSortAlgorithm;
import by.den.algorithms.core.SortAlgorithm;
import by.den.algorithms.core.SortArray;

/**
 * Sorts by scanning the array linearly, comparing and swapping
 * elements between a gap, and repeating with decreasing gaps.
 * The time complexity is in <var>O</var>(<var>n</var><sup>2</sup>) or better.
 */
public final class CombSort extends AbstractSortAlgorithm {
	
	// The singleton instance.
	public static final SortAlgorithm INSTANCE = new CombSort();

	public void sort(SortArray array) {
		// Comb sort with exponentially decreasing gaps
		int length = array.length();
		for (int step = length; step > 1; step = step * 10 / 13) {
			for (int i = 0; i + step < length; i++)
				array.compareAndSwap(i, i + step);
		}

		// Regular bubble sort (step = 1) to ensure correctness
		int end = length;
		while (true) {
			boolean changed = false;
			for (int i = 0; i + 1 < length; i++)
				changed |= array.compareAndSwap(i, i + 1);
			if (!changed)
				break;
			end--;
			if (end >= 0)
				array.setRange(end, length, SortArray.ElementState.DONE);
		}
		array.setRange(0, length, SortArray.ElementState.DONE);
	}

	// Private constructor.
	private CombSort() {
		super("Comb sort");
	}
	
}
