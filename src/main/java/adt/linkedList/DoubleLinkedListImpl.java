package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {
		this.head = new DoubleLinkedListNode<>();
		this.last = (DoubleLinkedListNode<T>) this.head;
	}

	@Override
	public void insert(T element) {
		if (element != null) {

			DoubleLinkedListNode<T> newLast = new DoubleLinkedListNode<>();
			newLast.setData(element);
			newLast.setPrevious(this.getLast());
			newLast.setNext(new DoubleLinkedListNode<>());

			this.getLast().setNext(newLast);

			if (this.getLast().isNIL()) {
				this.setHead(newLast);
			}

			this.setLast(newLast);
		}
	}

	@Override
	public void insertFirst(T element) {

		if (element != null) {
			DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode();
			;
			newHead.setData(element);
			newHead.setNext(this.getHead());
			newHead.setPrevious(new DoubleLinkedListNode<>());
			this.setHead(newHead);
			((DoubleLinkedListNode) this.getHead()).setPrevious(newHead);

			if (this.getHead().isNIL()) {
				this.setLast(newHead);
			}
			this.setHead(newHead);
		}

	}

	@Override
	public void removeFirst() {

		if (!this.getHead().isNIL()) {
			this.setHead(this.getHead().getNext());

			if (this.getHead().isNIL()) {
				this.setLast((DoubleLinkedListNode<T>) this.getHead());
			}
			((DoubleLinkedListNode<T>) this.getHead()).setPrevious(new DoubleLinkedListNode<>());
		}
	}

	@Override
	public void removeLast() {

		if (!this.getLast().isNIL()) {
			this.setLast(this.getLast().getPrevious());

			if (this.getLast().isNIL()) {
				this.setHead(this.getLast());
			}
		}

		this.getLast().setNext(new DoubleLinkedListNode<>());

	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
