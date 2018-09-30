package by.den.algorithms.visual;

import java.util.Arrays;

import by.den.algorithms.examples.*;
import by.den.algorithms.core.SortAlgorithm;

/**
 * The main class for the sort demo desktop GUI application.
 *
 * Color legend:  <br>
 * - Blue: Normal  <br>
 * - Green: In final position  <br>
 * - Yellow: Comparing  <br>
 * - Gray: Inactive  <br>
 */
public final class RunVisualSortDemoGUI {
	
	// Run with no command line arguments.
	public static void main(String[] args) {
		// Set up list of algorithms and go
		SortAlgorithm[] algos = {
			BubbleSort.INSTANCE,
			CocktailSort.INSTANCE,
			CombSort.INSTANCE,
			SelectionSort.INSTANCE,
			PancakeSort.INSTANCE,
			QuasiPancakeSort.INSTANCE,
			GnomeSort.INSTANCE,
			InsertionSort.INSTANCE,
			InsertionSortBinarySearch.INSTANCE,
			RotationMergeSort.INSTANCE,
			ShellSort.INSTANCE,
			HeapSort.INSTANCE,
			QuickSortDoubleEnded.INSTANCE,
			QuickSortSliding.INSTANCE,
			SlowSort.INSTANCE,
			StoogeSort.INSTANCE,
			StupidSort.INSTANCE,
			BozoSort.INSTANCE,
		};
		new LaunchFrame(Arrays.asList(algos));
	}
	
}
