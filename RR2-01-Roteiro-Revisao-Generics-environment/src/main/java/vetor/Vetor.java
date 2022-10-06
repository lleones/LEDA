package vetor;

import java.util.Comparator;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 * @param <T>
 *
 */
public class Vetor<T> {

	// O array interno onde os objetos manipulados são guardados
	private T[] arrayInterno;

	// O tamanho que o array interno terá
	private int tamanho;

	// Indice que guarda a proxima posição vazia do array interno
	private int indice;

	// O Comparators a serem utilizados
	private Comparator comparadorMaximo;
	private Comparator comparadorMinimo;

	public Vetor(int tamanho) {
		super();
		this.tamanho = tamanho;
		this.indice = -1;
	}

	public void setComparadorMaximo(Comparator comparadorMaximo) {
		this.comparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator comparadorMinimo) {
		this.comparadorMinimo = comparadorMinimo;
	}

	// Insere um objeto no vetor
	public <T> void inserir(T o) {
		this.arrayInterno[this.indice] = o;
		indice++;
	}

	// Remove um objeto do vetor
	public T remover(T o) {
		T resultado = null;
		for (int i = 0; i < arrayInterno.length; i++) {
			if (arrayInterno[i].equals(0)) {
				resultado = o;
				while (true) {
					if (i + 1 < this.arrayInterno.length) {
						this.arrayInterno[i] = null;
						break;
					} else {
						arrayInterno[i] = arrayInterno[i + 1];
					}
				}
			}
		}
		return resultado;
	}

	// Procura um elemento no vetor
	public T procurar(T o) {
		for (int i = 0; i < arrayInterno.length; i++) {
			if (this.arrayInterno[i].equals(o)) {
				return this.arrayInterno[i];
			}
		}
		return null;
	}

	// Diz se o vetor está vazio
	public boolean isVazio() {
		// TODO Remove the exception and implement your code
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	// Diz se o vetor está cheio
	public boolean isCheio() {
		// TODO Remove the exception and implement your code
		throw new UnsupportedOperationException("Not implemented yet!");
	}

}
