package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (this.isFull()) {
			throw new StackOverflowException();
		}
		if (element != null) {
			this.top.insertFirst(element);
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (!this.isEmpty()) {
			T retorno = this.top.toArray()[0];
			this.top.removeFirst();
			return retorno;
		}
		throw new StackUnderflowException();
	}

	@Override
	public T top() {
		T retorno = null;
		if (!this.isEmpty()) {
			retorno = this.top.toArray()[0];
		}
		return retorno;
	}

	@Override
	public boolean isEmpty() {
		return this.top.toArray().length == 0;
	}

	@Override
	public boolean isFull() {
		return this.top.size() == this.size;
	}

}
