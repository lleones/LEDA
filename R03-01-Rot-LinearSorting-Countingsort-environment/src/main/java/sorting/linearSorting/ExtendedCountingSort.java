package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (rightIndex >= array.length || leftIndex >= rightIndex || array == null) {
			return;
		}

		int indexMaior = indexMaior(array, leftIndex, rightIndex);
		int indexMenor = indexMenor(array, leftIndex, rightIndex);

		int[] c = new int[array[indexMaior] + Math.abs(array[indexMenor]) + 1];

		// Ocorrencias:
		for (int i = leftIndex; i <= rightIndex; i++) {
			c[array[i] + Math.abs(array[indexMenor])]++;
		}

		// Cumulativa:
		for (int i = 1; i < c.length; i++) {
			c[i] += c[i - 1];
		}

		// Clonando a em b:
		int[] b = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			b[i] = array[i];
		}

		for (int i = rightIndex; i >= leftIndex; i--) {
			b[c[array[i] + Math.abs(array[indexMenor])] - 1 + leftIndex] = array[i];
			c[array[i] + Math.abs(array[indexMenor])]--;
		}

		for (int i = 0; i < b.length; i++) {
			array[i] = b[i];
		}

	}

	public void countingSort(Integer[] array, int leftIndex, int rightIndex) {
		if (rightIndex >= array.length || leftIndex >= rightIndex || array == null) {
			return;
		}

		int indexMaior = indexMaior(array, leftIndex, rightIndex);

		int[] c = new int[array[indexMaior] + 1];
		for (int i = leftIndex; i <= rightIndex; i++) {
			c[array[i]]++;
		}

		for (int i = 1; i < c.length; i++) {
			c[i] += c[i - 1];
		}

		int[] b = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			b[i] = array[i];
		}

		for (int i = rightIndex; i >= leftIndex; i--) {
			b[c[array[i]] + leftIndex - 1] = array[i];
			c[array[i]]--;
		}

		for (int i = 0; i < b.length; i++) {
			array[i] = b[i];
		}

	}

	private int indexMaior(Integer[] array, int leftIndex, int rightIndex) {
		int indexMaior = leftIndex;
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (array[i] > array[indexMaior]) {
				indexMaior = i;
			}
		}

		return indexMaior;
	}

	private int indexMenor(Integer[] array, int leftIndex, int rightIndex) {
		int indexMenor = leftIndex;
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (array[i] < array[indexMenor]) {
				indexMenor = i;
			}
		}

		return indexMenor;
	}
}
