package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.linearSorting.CountingSort;
import sorting.linearSorting.ExtendedCountingSort;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;

	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });

		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		// TODO O aluno deve instanciar sua implementação abaixo ao invés de
		// null
		// this.implementation = new CountingSort();
		this.implementation = new ExtendedCountingSort();
		// Assert.fail("Implementation not provided");
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if (array.length > 0) {
			copy1 = Arrays.copyOf(array, array.length);
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
	}

	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */

	@Test
	public void testSort10() {
		Integer[] array = new Integer[] { -3, -6, -1 };
		this.implementation.sort(array, 0, 2);
		Assert.assertArrayEquals(new Integer[] { -6, -3, -1 }, array);
	}

	@Test
	public void testSort11() {
		Integer[] array = new Integer[] { 0, -1, 8 };
		this.implementation.sort(array, 0, 2);
		Assert.assertArrayEquals(new Integer[] { -1, 0, 8 }, array);
	}

	@Test
	public void testSort12() {
		Integer[] array = new Integer[] { 5, 3, 2 };
		this.implementation.sort(array, 0, 2);
		Assert.assertArrayEquals(new Integer[] { 2, 3, 5 }, array);
	}

	@Test
	public void testSort13() {
		Integer[] array = new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 };
		this.implementation.sort(array, 3, 5);
		Assert.assertArrayEquals(new Integer[] { 30, 28, 7, 11, 26, 29, 4, 22, 23, 31 }, array);
	}

	@Test
	public void testSort14() {
		Integer[] array = new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 };
		this.implementation.sort(array, 3, 3);
		Assert.assertArrayEquals(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 }, array);
	}

	@Test
	public void testSort15() {
		Integer[] array = new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 };
		this.implementation.sort(array, 5, 3);
		Assert.assertArrayEquals(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 }, array);
	}

	@Test
	public void testSort16() {
		Integer[] array = new Integer[] {};
		this.implementation.sort(array, 3, 4);
		Assert.assertArrayEquals(new Integer[] {}, array);
	}

	@Test
	public void testSort17() {
		Integer[] array = new Integer[] {};
		this.implementation.sort(array, 0, 0);
		Assert.assertArrayEquals(new Integer[] {}, array);
	}

	@Test
	public void testSort18() {
		Integer[] array = new Integer[] { 30 };
		this.implementation.sort(array, 0, 1);
		Assert.assertArrayEquals(new Integer[] { 30 }, array);
	}

	@Test
	public void testSort19() {
		Integer[] array = new Integer[] { 30, 28 };
		this.implementation.sort(array, 0, 1);
		Assert.assertArrayEquals(new Integer[] { 28, 30 }, array);
	}

	@Test
	public void testSort20() {
		Integer[] array = new Integer[] { 30, 28 };
		this.implementation.sort(array, 0, 0);
		Assert.assertArrayEquals(new Integer[] { 30, 28 }, array);
	}
}