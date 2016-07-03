package list;

import exception.OutOfBoundaryException;

public class LinkedListIterator implements Iterator {

	private LinkedList list;
	private Node current;

	public LinkedListIterator(LinkedList list) {
		this.list = list;
		if (list.isEmpty())
			current = null;
		else
			current = list.first();
	}

	@Override
	public void first() {
		if (list.isEmpty())
			current = null;
		else
			current = list.first();
	}

	@Override
	public void next() {
		if (isDone()) {
			throw new OutOfBoundaryException("there aren't more elements...");
		}
		if (current == list.last()) {
			current = null;
		} else
			current = list.getNext(current);
	}

	@Override
	public boolean isDone() {
		return current == null;
	}

	@Override
	public Object currentItem() {
		return current.getData();
	}

}
