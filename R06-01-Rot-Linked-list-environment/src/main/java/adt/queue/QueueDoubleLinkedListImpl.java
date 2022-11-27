package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	protected DoubleLinkedList<T> list;
	protected int size;

	public QueueDoubleLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (this.isFull()) {
			throw new QueueOverflowException();
		}
		if (element != null) {
			this.list.insert(element);
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (this.list.isEmpty()) {
			throw new QueueUnderflowException();
		}
		T retorno = this.list.toArray()[0];
		this.list.removeFirst();
		return retorno;
	}

	@Override
	public T head() {
		T retorno;
		if (this.isEmpty())
			retorno = null;
		else {
			retorno = list.toArray()[0];
		}
		return retorno;
	}

	@Override
	public boolean isEmpty() {
		return this.list.toArray().length == 0;
	}

	@Override
	public boolean isFull() {
		return this.size == this.list.size();
	}

}
