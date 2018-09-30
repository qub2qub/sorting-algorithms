package by.den.algorithms.examples;

import by.den.algorithms.core.AbstractSortAlgorithm;
import by.den.algorithms.core.SortAlgorithm;
import by.den.algorithms.core.SortArray;

public final class GnomeSort extends AbstractSortAlgorithm {
	
	// The singleton instance.
	public static final SortAlgorithm INSTANCE = new GnomeSort();

	public void sort(SortArray array) {
		int length = array.length();
		array.setRange(0, length, SortArray.ElementState.INACTIVE);
		for (int i = 0; i < length - 1; ) {
			if (!array.compareAndSwap(i, i + 1) || i == 0)
				i++;
			else
				i--;
		}
		array.setRange(0, length, SortArray.ElementState.DONE);
	}

	// Private constructor.
	private GnomeSort() {
		super("Gnome sort");
	}
	
}
