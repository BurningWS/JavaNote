package stack;

import exception.StackEmptyException;

public class StackArray implements Stack {

	private final int LEN = 4;
	private Object[] elements;
	private int top;

	public StackArray() {
		elements = new Object[LEN];
		top = -1;
	}

	@Override
	public int getSize() {
		return top + 1;
	}

	@Override
	public boolean isEmpty() {
		return top < 0;
	}

	private void expandSpace() {
		Object[] a = new Object[elements.length * 2];
		for (int i = 0; i < elements.length; i++) {
			a[i] = elements[i];
		}
		elements = a;
	}

	@Override
	public void push(Object e) {
		if (getSize() >= elements.length) {
			expandSpace();
		}
		elements[++top] = e;
	}

	@Override
	public Object pop() throws StackEmptyException {
		if (isEmpty()) {
			throw new StackEmptyException("stack is empty...");
		}
		Object obj = elements[top];
		elements[top--] = null;
		return obj;
	}

	@Override
	public Object peek() throws StackEmptyException {
		if (isEmpty()) {
			throw new StackEmptyException("stack is empty...");
		}
		return elements[top];
	}

}
