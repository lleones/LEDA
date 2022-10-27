package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (rightIndex >= array.length || leftIndex >= rightIndex) {
			return;
		}
		if (leftIndex >= rightIndex) {
			return;
		} else {

			int meio = (leftIndex + rightIndex) / 2;
			sort(array, leftIndex, meio);
			sort(array, meio + 1, rightIndex);
			
			merge(array, leftIndex, rightIndex, meio);
		}

	}

	public void merge(T[] array, int leftIndex, int rightIndex, int meio) {

		T[] helper = (T[]) new Comparable[array.length];
		for (int i = leftIndex; i <= rightIndex; i++) {
			helper[i] = array[i];
		}

		int k = leftIndex;
		int i = leftIndex;
		int j = meio + 1;

		
		while (i <= meio && j <= rightIndex) {
			if (helper[i].compareTo(helper[j]) > 0) {
				array[k++] = helper[j++];
			} else {
				array[k++] = helper[i++];
			}
			
		}

		while (i <= meio) {
			array[k++] = helper[i++];
		}

		while (j <= rightIndex) {
			array[k++] = helper[j++];
		}
	}
}
