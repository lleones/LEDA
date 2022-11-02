package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;
import sorting.divideAndConquer.MergeSort;
import util.Util;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de
 * forma
 * que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados.
 * E a cada chamada
 * interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 * INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	@Override
	public void sort(T[] array) {
		MERGESORT_APPLICATIONS = 0;
		INSERTIONSORT_APPLICATIONS = 0;
		sort(array, 0, array.length - 1);
	}

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= rightIndex || rightIndex >= array.length) {
			return;
		}
		if (rightIndex - leftIndex + 1 <= SIZE_LIMIT) {
			this.insertionSort(array, leftIndex, rightIndex);
			INSERTIONSORT_APPLICATIONS++;

		} else {
			this.mergeSort(array, leftIndex, rightIndex);
			MERGESORT_APPLICATIONS++;

		}
	}

	private void mergeSort(T[] array, int leftIndex, int rightIndex) {
		int meio = (leftIndex + rightIndex) / 2;
		sort(array, leftIndex, meio);
		sort(array, meio + 1, rightIndex);

		merge(array, leftIndex, rightIndex, meio);
	}

	private void insertionSort(T[] array, int leftIndex, int rightIndex) {
		for (int i = leftIndex + 1; i < rightIndex + 1; i++) {
			int j = i;
			while (j > leftIndex && array[j].compareTo(array[j - 1]) < 0) {
				Util.swap(array, j, --j);
			}
		}
	}

	private void merge(T[] array, int leftIndex, int rightIndex, int meio) {

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
