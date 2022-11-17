package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
		int size = 0;

		SingleLinkedListNode<T> node;
		node = this.getHead();

		while (!(node.isNIL())) {
			size++;
			node = node.getNext();
		}

		return size;

	}

	@Override
	public T search(T element) {
		if (this.isEmpty()) {
			return this.head.getData();
		}

		SingleLinkedListNode<T> node;
		node = this.getHead();

		while (!(node.isNIL())) {
			if (node.getData().equals(element)) {
				return node.getData();
			}
			node = node.getNext();
		}

		return null;

	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (!(this.isEmpty())) {
				SingleLinkedListNode<T> aux = new SingleLinkedListNode<>(element, new SingleLinkedListNode<>());

				SingleLinkedListNode<T> node;
				node = this.getHead();

				while (!(node.getNext().isNIL())) {
					node = node.getNext();
				}

				node.setNext(aux);
			} else {
				this.head = new SingleLinkedListNode<>(element, new SingleLinkedListNode<>());
			}

		}
	}

	@Override
	public void remove(T element) {
		if (element != null && !(this.isEmpty())) {
			SingleLinkedListNode<T> node;
			node = this.getHead();

			while (!(node.isNIL()) && !(node.getNext().getData().equals(element))) {
				node = node.getNext();
			}
			node.setNext(node.getNext().getNext());

		}
	}

	@Override
	public T[] toArray() {
		T[] retorno = (T[]) new Comparable[this.size()];

		SingleLinkedListNode<T> node;
		node = this.getHead();

		int i = 0;
		while (!(node.isNIL())) {
			retorno[i] = node.getData();
			node = node.getNext();
			i++;
		}

		return retorno;

	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
