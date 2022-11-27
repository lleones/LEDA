package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (this.isEmpty()) {
				this.data = element;
				this.setNext(new RecursiveDoubleLinkedListImpl<>());
				this.setPrevious(new RecursiveDoubleLinkedListImpl<>());
			} else {
				this.getNext().insert(element);
			}
		}
	}

	@Override
	public void insertFirst(T element) {
		if (!(element == null)) {
			if (isEmpty()) {
				this.setData(element);
			} else {
				RecursiveDoubleLinkedListImpl<T> aux = new RecursiveDoubleLinkedListImpl();
				aux.setData(this.getData());
				aux.setNext(this.getNext());
				aux.setPrevious(this);
				this.setNext(aux);
				this.setData(element);
			}
		}
	}

	@Override
	public void removeFirst() {
		if (!this.isEmpty()) {
			this.setData(this.getNext().getData());
			this.setNext(this.getNext().getNext());
			((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(this);
		}
	}

	@Override
	public void removeLast() {
		if (this.getNext().isEmpty()) {
			this.setData(null);
		}else{
			((DoubleLinkedList<T>) this.getNext()).removeLast();
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
