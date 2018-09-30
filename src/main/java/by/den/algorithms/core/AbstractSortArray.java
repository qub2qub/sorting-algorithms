package by.den.algorithms.core;

import java.util.Random;

/**
 * A convenience abstract base class that manages an array and implements most of the methods.
 */
public abstract class AbstractSortArray implements SortArray {

	protected int[] values;

	public AbstractSortArray(int size) {
		if (size < 0)
			throw new IllegalArgumentException();

		// Initialize in order: [0, 1, 2, ..., size-1]
		values = new int[size];
		for (int i = 0; i < values.length; i++)
			values[i] = i;
	}

	/* Field getters */
	
	public int length() {
		return values.length;
	}

	/* Comparison and swapping */
	
	public int compare(int i, int j) {
		if (i < 0 || j < 0 || i >= values.length || j >= values.length)
			throw new IndexOutOfBoundsException();
		return Integer.compare(values[i], values[j]);
	}

	public void swap(int i, int j) {
		if (i < 0 || j < 0 || i >= values.length || j >= values.length)
			throw new IndexOutOfBoundsException();
		int temp = values[i];
		values[i] = values[j];
		values[j] = temp;
	}

	public boolean compareAndSwap(int i, int j) {
		if (compare(j, i) < 0) {
			swap(i, j);
			return true;
		} else
			return false;
	}

	public void shuffle() {
		// Durstenfeld shuffle algorithm
		for (int i = length() - 1; i > 0; i--)
			swap(i, random.nextInt(i + 1));
	}

	/* Sorting progress visualization */
	
	// Does nothing by default; can be overridden.
	public void setElement(int index, SortArray.ElementState state) {}
	
	// Does nothing by default; can be overridden.
	public void setRange(int start, int end, SortArray.ElementState state) {}

	/*---- Static utilities ----*/
	
	public static final Random random = new Random();
	
}
