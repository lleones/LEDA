package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do
 * intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até
 * A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do
 * pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (rightIndex >= array.length || leftIndex >= rightIndex) {
			return;
		}
		if (leftIndex < rightIndex) {
			int meio = (rightIndex + leftIndex) / 2;
			T[] selecionados = (T[]) new Comparable[] { array[leftIndex], array[meio], array[rightIndex] };

			quickSort(selecionados, 0, 2);

			T pivot = selecionados[1];
			int indicePivot = buscaIndice(array, pivot);

			Util.swap(array, indicePivot, leftIndex);

			quickSort(array, leftIndex, rightIndex);
		}

	}

	public void quickSort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int pivot = particiona(array, leftIndex, rightIndex);
			quickSort(array, leftIndex, pivot - 1);
			quickSort(array, pivot + 1, rightIndex);
		}

	}

	public int particiona(T[] array, int leftIndex, int rightIndex) {
		T pivot = array[leftIndex];
		int localizacao = leftIndex;

		for (int i = localizacao; i <= rightIndex; i++) {
			if (array[i].compareTo(pivot) < 0) {
				localizacao++;
				Util.swap(array, localizacao, i);
			}
		}
		Util.swap(array, leftIndex, localizacao);

		return localizacao;
	}

	public int buscaIndice(T[] array, T elemento) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(elemento)) {
				return i;
			}
		}

		return -1;
	}
}
