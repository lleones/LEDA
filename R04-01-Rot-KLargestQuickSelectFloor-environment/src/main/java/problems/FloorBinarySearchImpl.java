package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		if (array == null || array.length <= 0 || x == null) {
			return null;
		}
		return metodoRecurssivo(array, x, 0, array.length - 1);
	}

	private int buscaBinaria(Integer[] array, Integer x, int leftIndex, int rightIndex) {
		int meio = (leftIndex + rightIndex) / 2;
		Util.swap(array, leftIndex, meio);
		int localizacao = leftIndex;
		Integer pivot = array[leftIndex];

		for (int i = localizacao; i <= rightIndex; i++) {
			if (array[i].compareTo(pivot) < 0) {
				localizacao++;
				Util.swap(array, localizacao, i);
			}
		}
		Util.swap(array, leftIndex, localizacao);

		return localizacao;

	}

	private Integer metodoRecurssivo(Integer[] array, Integer x, int leftIndex, int rightIndex) {

		if (contem(array, x)) {
			return x;
		}

		if (rightIndex <= 0) {
			if (array[leftIndex] > x) {
				return null;
			}
			return array[leftIndex];
		}

		if ((rightIndex - leftIndex) == 1) {

			if (array[rightIndex] > x) {
				return array[leftIndex];
			} else {
				return array[rightIndex];
			}
		}

		int indexPivot = buscaBinaria(array, x, leftIndex, rightIndex);
		if (x < array[indexPivot]) {
			return metodoRecurssivo(array, x, leftIndex, indexPivot - 1);
		}
		return metodoRecurssivo(array, x, indexPivot, rightIndex);
	}

	private boolean contem(Integer[] array, Integer x) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(x)) {
				return true;
			}

		}
		return false;
	}
}