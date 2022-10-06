package produto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Classe que representa um repositório de produtos usando ArrayList como
 * estrutura sobrejacente. Alguns métodos (atualizar, remover e procurar) ou
 * executam com sucesso ou retornam um erro. Para o caso desde exercício, o erro
 * será representado por uma RuntimeException que não precisa ser declarada na
 * clausula "throws" do mos metodos.
 *
 * @author Adalberto
 */
public class RepositorioProdutoArrayList {

	/**
	 * A estrutura onde os produtos sao mantidos. Voce nao precisa se preocupar
	 * por enquanto com o uso de generics em ArrayList.
	 */
	private ArrayList<Produto> produtos;

	/**
	 * A posicao do ultimo elemento inserido no array de produtos. o valor
	 * inicial é -1 para indicar que nenhum produto foi ainda guardado no array.
	 */
	private int index = -1;

	public RepositorioProdutoArrayList(int size) {
		super();
		this.produtos = new ArrayList<Produto>();
	}

	/**
	 * Recebe o codigo do produto e devolve o indice desse produto no array ou
	 * -1 caso ele nao se encontre no array. Esse método é util apenas na
	 * implementacao com arrays por questoes de localizacao. Outras classes que
	 * utilizam outras estruturas internas podem nao precisar desse método.
	 * 
	 * @param codigo
	 * @return
	 */
	private int procurarIndice(int codigo) {
		for (int i = 0; i < this.produtos.size(); i++) {
			if (this.produtos.get(i).getCodigo() == codigo) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Recebe o codigo e diz se tem produto com esse codigo armazenado
	 * 
	 * @param codigo
	 * @return
	 */
	public boolean existe(int codigo) {
		for (int i = 0; i < this.produtos.size(); i++) {
			if (this.produtos.get(i).getCodigo() == codigo) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Insere um novo produto (sem se preocupar com duplicatas)
	 */
	public void inserir(Produto produto) {
		this.produtos.add(produto);
	}

	
	/**
	 * Atualiza um produto armazenado ou retorna um erro caso o produto nao
	 * esteja no array. Note que, para localizacao, o código do produto será
	 * utilizado.
	 */
	public void atualizar(Produto produto) {
		int localizacao = this.procurarIndice(produto.getCodigo());
		if (localizacao == -1) {
			throw new NoSuchElementException();
		}
		this.produtos.set(localizacao, produto);
	}

	/**
	 * Remove produto com determinado codigo, se existir, ou entao retorna um
	 * erro, caso contrário. Note que a remoção NÃO pode deixar "buracos" no
	 * array.
	 * 
	 * @param codigo
	 */
	public void remover(int codigo) {
		int indice = this.procurarIndice(codigo);
		if (indice == -1) {
			throw new IllegalArgumentException();
		}

		this.produtos.remove(indice);
		this.produtos.removeAll(Arrays.asList("", null));
	}

	/**
	 * Retorna um produto com determinado codigo ou entao um erro, caso o
	 * produto nao esteja armazenado
	 * 
	 * @param codigo
	 * @return
	 */
	public Produto procurar(int codigo) {
		int indice = this.procurarIndice(codigo);
		if (indice == -1) {
			return null;
		}
		return this.produtos.get(indice);
	}
}