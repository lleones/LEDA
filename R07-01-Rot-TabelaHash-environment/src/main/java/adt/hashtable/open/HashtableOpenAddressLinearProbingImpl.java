package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionOpenAddress;
import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if (element != null && this.search(element) == null) {

			int probe = 0;
			while (probe < this.table.length) {
				int hash = this.getHash(element, probe);

				if (this.table[hash] == null || this.table[hash].equals(new DELETED())) {
					this.table[hash] = element;
					this.elements++;
					break;
				} else {
					probe++;
					this.COLLISIONS++;
				}
			}

			if (probe == this.table.length) {
				throw new HashtableOverflowException();
			}

		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			int probe = 0;

			while (probe < this.table.length) {
				int hash = this.getHash(element, probe);

				if (this.table[hash] == null) {
					break;
				}

				if (this.table[hash].equals(element)) {
					this.table[hash] = new DELETED();
					this.elements--;
					break;
				}
				probe++;
			}

		}
	}

	@Override
	public T search(T element) {
		T retorno = null;
		if (element != null) {
			int probe = 0;

			while (probe < this.table.length) {
				int hash = this.getHash(element, probe);

				if (this.table[hash] == null) {
					break;
				}

				if (this.table[hash].equals(element)) {
					retorno = element;
					break;
				}
				probe++;
			}

		}
		return retorno;
	}

	@Override
	public int indexOf(T element) {
		int retorno = -1;
		if (element != null) {
			int probe = 0;

			while (probe < this.table.length) {
				int hash = this.getHash(element, probe);

				if (this.table[hash] == null) {
					break;
				}

				if (this.table[hash].equals(element)) {
					retorno = hash;
					break;
				}
				probe++;
			}

		}
		return retorno;
	}

	private int getHash(T element, int probe) {
		return ((HashFunctionOpenAddress<T>) this.hashFunction).hash(element, probe);
	}
}
