package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de
 * contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o indexMaior valor de
 * entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a
 * ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros
 * negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (!(array == null || rightIndex >= array.length || leftIndex >= rightIndex || leftIndex < 0)) {
			int indexMaior = leftIndex;
			for (int i = leftIndex + 1; i <= rightIndex; i++) {
				if (array[i] > array[indexMaior]) {
					indexMaior = i;
				}
			}

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

	}
}
