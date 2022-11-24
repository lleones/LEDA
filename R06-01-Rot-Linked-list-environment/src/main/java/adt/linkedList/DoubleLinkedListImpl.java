package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	@Override
	public void insert(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(element, new DoubleLinkedListNode<T>(),
					this.last);

			if (!(this.isEmpty())) {
				this.last.setNext(newNode);
			} else {
				this.head = newNode;
			}
			this.last = newNode;

		}
	}

	@Override
	public void remove(T element) {
		if (element != null && !(this.isEmpty())) {
			DoubleLinkedListNode<T> node = (DoubleLinkedListNode<T>) this.getHead();

			while (!(node.isNIL()) && !(node.getData().equals(element))) {
				node = (DoubleLinkedListNode<T>) node.getNext();
			}

			node.getPrevious().setNext(node.getNext());
			((DoubleLinkedListNode<T>) node.getNext()).setPrevious(node.getPrevious());

		}
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> no = new DoubleLinkedListNode<T>(element, new DoubleLinkedListNode<T>(),
					new DoubleLinkedListNode<T>());

			if (this.isEmpty()) {
				super.setHead(no);
			} else {
				no.setNext(this.head);
				((DoubleLinkedListNode<T>) head).setPrevious(no);
				head = no;
			}
		}
	}

	@Override
	public void removeFirst() {
		if (!this.isEmpty()) {
			if (!head.isNIL()) {
				this.head = this.head.getNext();
			} else if (this.head.isNIL()) {
				this.last = (DoubleLinkedListNode<T>) this.head;
			} else {
				((DoubleLinkedListNode<T>) this.head).setPrevious(new DoubleLinkedListNode<T>());
			}
		}
	}

	@Override
	public void removeLast() {
		if (!this.isEmpty()) {
			if (!this.last.isNIL()) {
				this.last = this.last.getPrevious();
			}
			if (this.last.isNIL()) {
				this.head = this.last;
			} else {
				this.last.setNext(new DoubleLinkedListNode<T>());
			}
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
