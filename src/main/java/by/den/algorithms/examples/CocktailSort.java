package by.den.algorithms.examples;

import by.den.algorithms.core.AbstractSortAlgorithm;
import by.den.algorithms.core.SortAlgorithm;
import by.den.algorithms.core.SortArray;

public final class CocktailSort extends AbstractSortAlgorithm {
	
	// The singleton instance.
	public static final SortAlgorithm INSTANCE = new CocktailSort();

	public void sort(SortArray array) {
		int left = 0;
		int right = array.length();
		int i = left;
		while (left < right) {
			// Scan right
			for (; i + 1 < right; i++)
				array.compareAndSwap(i, i + 1);
			array.setElement(i, SortArray.ElementState.DONE);
			right--;
			i--;
			if (left == right)
				break;

			// Scan left
			for (; i > left; i--)
				array.compareAndSwap(i - 1, i);
			array.setElement(i, SortArray.ElementState.DONE);
			left++;
			i++;
		}
	}

	// Private constructor.
	private CocktailSort() {
		super("Cocktail sort");
	}
	
}
