package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	@Override
	public boolean isEmpty() {
		return this.data == null;
	}

	@Override
	public int size() {
		if (this.isEmpty()) {
			return 0;
		} else {
			return 1 + this.next.size();
		}
	}

	@Override
	public T search(T element) {
		T retorno = null;
		if (!this.isEmpty()) {
			if (this.data.equals(element)) {
				retorno = this.data;
			} else {
				retorno = this.next.search(element);
			}
		}

		return retorno;
	}

	@Override
	public void insert(T element) {
		if (this.isEmpty()) {
			this.data = element;
			this.setNext(new RecursiveSingleLinkedListImpl<>());
		} else {
			this.getNext().insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if (!this.isEmpty()) {
			if (this.data.equals(element)) {
				this.data = this.next.getData();
				this.next = this.next.getNext();
			} else {
				this.next.remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] retorno = (T[]) new Comparable[this.size()];
		this.toArrayRecursivo(0, retorno, this);
		return retorno;
	}

	public void toArrayRecursivo(int i, T[] retorno, RecursiveSingleLinkedListImpl<T> node) {
		if (!node.isEmpty()) {
			retorno[i] = node.getData();
			toArrayRecursivo(i + 1, retorno, node.getNext());
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
