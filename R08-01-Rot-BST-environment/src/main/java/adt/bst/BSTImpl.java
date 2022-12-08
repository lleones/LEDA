package adt.bst;

import java.util.ArrayList;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(this.root);
	}

	private int height(BSTNode<T> node) {
		int altura = -1;
		if (!node.isEmpty()) {
			altura = 1 + Math.max(height((BSTNode<T>) node.getLeft()), height((BSTNode<T>) node.getRight()));
		}
		return altura;
	}

	@Override
	public BSTNode<T> search(T element) {
		return this.search(this.root, element);
	}

	private BSTNode<T> search(BSTNode<T> node, T element) {
		BSTNode<T> retorno = new BSTNode<>();

		if (!node.isEmpty()) {
			if (node.getData().equals(element)) {
				retorno = node;
			} else {
				if (node.getData().compareTo(element) > 0) {
					retorno = this.search((BSTNode<T>) node.getLeft(), element);
				} else {
					retorno = this.search((BSTNode<T>) node.getRight(), element);
				}
			}
		}

		return retorno;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (this.isEmpty()) {
				this.root = new BSTNode<T>();
				this.root.setData(element);
				this.root.setLeft(new BSTNode<T>());
				this.root.setRight(new BSTNode<T>());
				this.root.getRight().setParent(root);
				this.root.getLeft().setParent(root);

			} else {
				BSTNode<T> node = new BSTNode<T>();
				node.setData(element);
				node.setLeft(new BSTNode<T>());
				node.setRight(new BSTNode<T>());
				insert(this.getRoot(), node);
			}
		}
	}

	private void insert(BSTNode<T> root, BSTNode<T> node) {
		BSTNode<T> iterator = root;
		if (iterator.getData().compareTo(node.getData()) < 0) {
			if (iterator.getRight().isEmpty()) {
				iterator.setRight(node);
				node.setParent(iterator);
			} else {
				insert((BSTNode<T>) iterator.getRight(), node);
			}
		} else {
			if (iterator.getLeft().isEmpty()) {
				iterator.setLeft(node);
				node.setParent(iterator);
			} else {
				insert((BSTNode<T>) iterator.getLeft(), node);
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {
		return this.maximum(this.root);
	}

	private BSTNode<T> maximum(BSTNode<T> node) {
		BSTNode<T> retorno = null;

		if (!this.isEmpty()) {
			if (node.getRight().isEmpty()) {
				retorno = node;
			} else {
				retorno = this.maximum((BSTNode<T>) node.getRight());
			}
		}

		return retorno;
	}

	@Override
	public BSTNode<T> minimum() {
		return minimum(this.root);
	}

	private BSTNode<T> minimum(BSTNode<T> node) {
		BSTNode<T> retorno = null;

		if (!this.isEmpty()) {
			if (node.getLeft().isEmpty()) {
				retorno = node;
			} else {
				retorno = this.minimum((BSTNode<T>) node.getLeft());
			}
		}

		return retorno;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> answer = null;
		BSTNode<T> node = search(element);

		if (!node.isEmpty()) {
			if (!node.getRight().isEmpty())
				answer = minimum((BSTNode<T>) node.getRight());
			else {
				BSTNode<T> parent = (BSTNode<T>) node.getParent();

				while (parent != null && node.equals(parent.getRight())) {
					node = parent;
					parent = (BSTNode<T>) node.getParent();
				}

				answer = parent;
			}
		}

		return answer;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> answer = null;
		BSTNode<T> node = search(element);

		if (!node.isEmpty()) {
			if (!node.getLeft().isEmpty())
				answer = maximum((BSTNode<T>) node.getLeft());
			else {
				BSTNode<T> parent = (BSTNode<T>) node.getParent();

				while (parent != null && node.equals(parent.getLeft())) {
					node = parent;
					parent = (BSTNode<T>) node.getParent();

				}

				answer = parent;
			}
		}

		return answer;
	}

	@Override
	public void remove(T element) {
		if (element != null && !this.isEmpty()) {
			BSTNode<T> node = search(element);
			remove(node);
		}
	}

	private void remove(BSTNode<T> node) {
		if (node != null && !node.isEmpty()) {
			if (node.isLeaf())
				node.setData(null);
			else if (hasOnlyChild(node)) {

				if (node.getParent() != null && !node.getParent().isEmpty()) {
					if (node.getParent().getData().compareTo(node.getData()) > 0) {
						if (!node.getLeft().isEmpty()) {
							node.getParent().setLeft(node.getLeft());
							node.getLeft().setParent(node.getParent());
						} else {
							node.getParent().setLeft(node.getRight());
							node.getRight().setParent(node.getParent());
						}
					} else {
						if (!node.getLeft().isEmpty()) {
							node.getParent().setRight(node.getLeft());
							node.getLeft().setParent(node.getParent());
						} else {
							node.getParent().setRight(node.getRight());
							node.getRight().setParent(node.getParent());
						}
					}

				} else {
					if (node.getLeft().isEmpty()) {
						root = (BSTNode<T>) node.getRight();
						root.setParent(null);
					} else {
						root = (BSTNode<T>) node.getLeft();
						root.setParent(null);
					}
				}

			} else {
				BSTNode<T> sucessor = sucessor(node.getData());
				node.setData(sucessor.getData());
				remove(sucessor);
			}
		}

	}

	private boolean hasOnlyChild(BSTNode<T> node) {
		return (node.getLeft().isEmpty() && !node.getRight().isEmpty()) ||
				(!node.getLeft().isEmpty() && node.getRight().isEmpty());
	}

	private boolean isLeaf(BSTNode<T> node) {
		return (node.getLeft().isEmpty() && node.getRight().isEmpty());
	}

	@Override
	public T[] preOrder() {
		ArrayList<T> array = new ArrayList<>();
		if (!this.isEmpty()) {
			preOrder(this.root, array, 0);
		}
		return (T[]) array.toArray(new Comparable[0]);
	}

	private void preOrder(BSTNode<T> node, ArrayList<T> array, int iterador) {
		array.add(node.getData());
		if (!node.getLeft().isEmpty()) {
			preOrder((BSTNode<T>) node.getLeft(), array, ++iterador);

		}
		if (!node.getRight().isEmpty()) {
			preOrder((BSTNode<T>) node.getRight(), array, iterador);
		}
	}

	@Override
	public T[] order() {
		ArrayList<T> array = new ArrayList<>();
		if (!this.isEmpty()) {
			order(this.root, array, 0);
		}
		return (T[]) array.toArray(new Comparable[0]);
	}

	private void order(BSTNode<T> node, ArrayList<T> array, int iterador) {
		if (!node.getLeft().isEmpty()) {
			order((BSTNode<T>) node.getLeft(), array, iterador + 1);
		}

		array.add(node.getData());

		if (!node.getRight().isEmpty()) {
			order((BSTNode<T>) node.getRight(), array, iterador + 2);
		}
	}

	@Override
	public T[] postOrder() {
		ArrayList<T> array = new ArrayList<>();
		if (!this.isEmpty()) {
			postOrder(this.root, array, 0);
		}
		return (T[]) array.toArray(new Comparable[0]);
	}

	private void postOrder(BSTNode<T> node, ArrayList<T> array, int iterador) {
		if (!node.getLeft().isEmpty()) {
			postOrder((BSTNode<T>) node.getLeft(), array, iterador + 1);
		}

		if (!node.getRight().isEmpty()) {
			postOrder((BSTNode<T>) node.getRight(), array, iterador + 2);
		}

		array.add(node.getData());
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
