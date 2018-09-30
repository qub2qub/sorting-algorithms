package by.den.algorithms.examples;

import by.den.algorithms.core.SortAlgorithm;
import by.den.algorithms.core.SortArray;
import by.den.algorithms.core.AbstractSortAlgorithm;

/**
 * Sorts by swapping the next unsorted item into the correct position in the sorted subarray.
 * The correct position is determined using binary search instead of linear search.
 * The time complexity is in <var>O</var>(<var>n</var><sup>2</sup>).
 */
public final class InsertionSortBinarySearch extends AbstractSortAlgorithm {
	
	// The singleton instance.
	public static final SortAlgorithm INSTANCE = new InsertionSortBinarySearch();

	public void sort(SortArray array) {
		int length = array.length();
		array.setRange(0, length, SortArray.ElementState.INACTIVE);
		for (int i = 0; i < length; i++) {
			int index = binarySearch(array, i, 0, i);
			for (int j = i; j - 1 >= index; j--)
				array.swap(j, j - 1);
		}
		array.setRange(0, length, SortArray.ElementState.DONE);
	}

	private static int binarySearch(SortArray array, int index, int start, int end) {
		while (start != end) {
			int mid = (start + end) / 2;
			int temp = array.compare(index, mid);
			if (temp < 0)
				end = mid;
			else if (temp > 0)
				start = mid + 1;
			else
				return mid;
		}
		return start;
	}

	// Private constructor.
	private InsertionSortBinarySearch() {
		super("Insertion sort (binary search)");
	}
	
}
