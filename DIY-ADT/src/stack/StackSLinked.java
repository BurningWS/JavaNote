package stack;

import list.SLNode;
import exception.StackEmptyException;

public class StackSLinked implements Stack {

	private SLNode top;
	private int size;

	public StackSLinked() {
		top = null;
		size = 0;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void push(Object e) {
		top = new SLNode(e, top);
		size++;
	}

	@Override
	public Object pop() throws StackEmptyException {
		if (isEmpty()) {
			throw new StackEmptyException("stack is empty..");
		}
		Object obj = top.getData();
		top = top.getNext();
		size--;
		return obj;
	}

	@Override
	public Object peek() throws StackEmptyException {
		if (isEmpty()) {
			throw new StackEmptyException("stack is empty..");
		}
		return top.getData();
	}
}
