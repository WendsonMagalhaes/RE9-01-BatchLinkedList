package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.getHead().isNIL();
	}

	@Override
	public int size() {

		int result = 0;
		SingleLinkedListNode<T> auxHead = this.getHead();

		while (!auxHead.isNIL()) {
			result++;
			auxHead = auxHead.getNext();
		}

		return result;

	}

	@Override
	public T search(T element) {

		SingleLinkedListNode<T> result = this.head;

		while (!result.isNIL() && !result.getData().equals(element)) {
			result = result.getNext();
		}
		return result.getData();
	}

	@Override
	public void insert(T element) {

		if (element != null) {
			SingleLinkedListNode<T> auxHead = this.getHead();

			if (this.getHead().isNIL()) {

				this.getHead().setData(element);
				this.getHead().setNext(new SingleLinkedListNode());

			} else {
				while (!auxHead.getNext().isNIL()) {
					auxHead = auxHead.getNext();
				}

				SingleLinkedListNode newNode = new SingleLinkedListNode(element, auxHead.next);
				auxHead.setNext(newNode);
			}
		}
	}

	@Override
	public void remove(T element) {

		if (this.getHead().getData().equals(element)) {
			this.setHead(this.getHead().getNext());
		} else {

			SingleLinkedListNode<T> auxHead = this.getHead();
			SingleLinkedListNode<T> previous = new SingleLinkedListNode<>();

			while (!auxHead.isNIL() && !auxHead.getData().equals(element)) {

				previous = auxHead;
				auxHead = auxHead.next;
			}
			if (!auxHead.isNIL()) {
				previous.setNext(auxHead.getNext());
			}
		}
	}

	@Override
	public T[] toArray() {

		T[] result = (T[]) new Object[this.size()];
		SingleLinkedListNode<T> auxHead = this.getHead();
		int i = 0;

		while (!auxHead.isNIL()) {
			result[i] = auxHead.getData();
			auxHead = auxHead.getNext();
			i++;
		}
		return result;

	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
