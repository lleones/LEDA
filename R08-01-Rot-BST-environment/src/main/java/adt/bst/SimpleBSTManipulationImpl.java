package adt.bst;

/**
 * - Esta eh a unica classe que pode ser modificada
 * 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		boolean iguais = false;
		if (tree1 != null && tree2 != null) {
			iguais = equals((BSTNode<T>) tree1.getRoot(), ((BSTNode<T>) tree2.getRoot()));
		}
		return iguais;
	}

	private boolean equals(BSTNode<T> node1, BSTNode<T> node2) {
		boolean retorno = false;
		if (node1.isEmpty() && node2.isEmpty()) {
			retorno = true;
		} else if (node1.getData().equals(node2.getData())) {
			boolean iguaisEsquerda = equals((BSTNode<T>) node1.getLeft(), (BSTNode<T>) node2.getLeft());
			boolean iguaisDireita = equals((BSTNode<T>) node1.getRight(), (BSTNode<T>) node2.getRight());
			retorno = iguaisEsquerda && iguaisDireita;
		}
		return retorno;

	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		boolean similares = false;
		if (tree1 != null && tree2 != null) {
			similares = isSimilar((BSTNode<T>) tree1.getRoot(), ((BSTNode<T>) tree2.getRoot()));
		}
		return similares;
	}

	private boolean isSimilar(BSTNode<T> node1, BSTNode<T> node2) {
		boolean retorno = false;
		if (node1.isEmpty() && node2.isEmpty()) {
			retorno = true;
		} else if (!node1.isEmpty() && !node2.isEmpty()) {
			boolean iguaisEsquerda = isSimilar((BSTNode<T>) node1.getLeft(), (BSTNode<T>) node2.getLeft());
			boolean iguaisDireita = isSimilar((BSTNode<T>) node1.getRight(), (BSTNode<T>) node2.getRight());
			retorno = iguaisEsquerda && iguaisDireita;
		}
		return retorno;
	}

	@Override
	public T orderStatistic(BST<T> tree, int k) {
		T elemento = null;
		if(tree != null && k >= 1 && k <= tree.size()){
			elemento = this.orderStatistic(tree, tree.minimum(), k, 1);
		}
		return elemento;
	}

	private T orderStatistic(BST<T> tree, BSTNode<T> node, int k, int index) {
		T retorno = null;
		if(k == index){
			retorno = node.getData();
		}else{
			retorno = this.orderStatistic(tree, tree.sucessor(node.getData()), k, index + 1);
		}
		return retorno;
	}

}
