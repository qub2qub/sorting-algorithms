package by.den.algorithms;

import by.den.algorithms.core.SortAlgorithm;
import by.den.algorithms.examples.*;

public final class RunSimpleDemo {
	
	private static final SortAlgorithm[] ALGORITHMS = {
		HeapSort.INSTANCE,
		QuickSortDoubleEnded.INSTANCE,
		QuickSortSliding.INSTANCE,
		ShellSort.INSTANCE,
		RotationMergeSort.INSTANCE,
		BubbleSort.INSTANCE,
		CocktailSort.INSTANCE,
		CombSort.INSTANCE,
		SelectionSort.INSTANCE,
		GnomeSort.INSTANCE,
		InsertionSort.INSTANCE,
		InsertionSortBinarySearch.INSTANCE,
		PancakeSort.INSTANCE,
		QuasiPancakeSort.INSTANCE,
		StoogeSort.INSTANCE,
		StupidSort.INSTANCE,
		BozoSort.INSTANCE,
		SlowSort.INSTANCE,
	};
	
	private static final int DEFAULT_SIZE = 300;
	
	public static void main(String[] args) {
		// Handle command line arguments
		int size;
		if (args.length == 0)
			size = DEFAULT_SIZE;
		else if (args.length == 1)
			size = Integer.parseInt(args[0]);
		else {
			System.err.println("Usage: java RunSimpleDemo [ArraySize]");
			System.exit(1);
			return;
		}
		if (size <= 0)
			throw new IllegalArgumentException("Array size must be positive");

		// Sort with each algorithm, and print statistics
		System.err.println("Algorithm name,Number of comparisons,Number of swaps");
		SimpleSortArray referenceArray = new SimpleSortArray(size);
		for (SortAlgorithm algorithm : ALGORITHMS) {
			SimpleSortArray array = referenceArray.clone();
			algorithm.sort(array);
			System.err.printf("%s,%d,%d%n", algorithm.getName(), array.comparisonCount, array.swapCount);
		}
	}
	
}
