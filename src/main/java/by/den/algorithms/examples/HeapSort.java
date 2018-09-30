package by.den.algorithms.examples;

import by.den.algorithms.core.AbstractSortAlgorithm;
import by.den.algorithms.core.SortAlgorithm;
import by.den.algorithms.core.SortArray;

/**
 * Sorts by building a binary max-heap, then repeatedly extracting the maximum element
 * and prepending it to the sorted subarray at the end of the array.
 * The time complexity is in <var>O</var>(<var>n</var> log <var>n</var>).
 */
public final class HeapSort extends AbstractSortAlgorithm {
	
	// The singleton instance.
	public static final SortAlgorithm INSTANCE = new HeapSort();

	public void sort(SortArray array) {
		// Heapify
		int length = array.length();
		array.setRange(0, length, SortArray.ElementState.INACTIVE);
		for (int i = length - 1; i >= 0; i--)
			siftDown(array, i, length);

		// Extract maximum repeatedly
		for (int i = length - 1; i >= 0; i--) {
			array.swap(0, i);
			array.setElement(i, SortArray.ElementState.DONE);
			siftDown(array, 0, i);
		}
	}

	private static void siftDown(SortArray array, int node, int end) {
		while (node * 2 + 1 < end) {
			int child = node * 2 + 1;
			if (child + 1 < end && array.compare(child + 1, child) > 0)
				child++;
			if (!array.compareAndSwap(child, node))
				break;
			node = child;
		}
	}

	// Private constructor.
	private HeapSort() {
		super("Heap sort");
	}
	
}
