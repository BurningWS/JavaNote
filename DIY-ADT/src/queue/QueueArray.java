package queue;

import exception.QueueEmptyException;

public class QueueArray implements Queue {
	/*
	 * 在 QueueArray 类中成员变量 CAP 是用来以默认大小生成队列，由于我们采用损失一个存储单元来区分队列空与满的两种不同状态，
	 * 因此实际的数组大小要比队列 最大容量大 1。 为了代码的简洁， 在 QueueArray 类中引入成员变量 capacity 表示数组的大小， 即
	 * capacity = elements.length。
	 */
	private static final int CAP = 7;
	private Object[] elements;
	private int front;
	private int rear;
	private int capacity;

	public QueueArray() {
		this(CAP);
	}

	public QueueArray(int cap) {
		capacity = cap + 1;
		elements = new Object[capacity];
		front = rear = 0;
	}

	@Override
	public int getSize() {
		return (rear - front + capacity) % capacity;
	}

	@Override
	public boolean isEmpty() {
		return getSize() == 0;
	}

	private void expandSpace() {
		Object[] a = new Object[capacity * 2];
		int i = front;
		int index = 0;
		while (index < getSize()) {
			a[index++] = elements[i];
			i = (i + 1) % capacity;
		}
		elements = a;
		front = 0;
		rear = index;
		capacity = elements.length;
	}

	@Override
	public void enqueue(Object e) {
		if (getSize() >= capacity - 1) {
			expandSpace();
		}
		elements[rear] = e;
		rear = (rear + 1) % capacity;
	}

	@Override
	public Object dequeue() throws QueueEmptyException {
		if (isEmpty()) {
			throw new QueueEmptyException("queue is empty...");
		}
		Object obj = elements[front];
		elements[front] = null;
		front = (front + 1) % capacity;
		return obj;
	}

	@Override
	public Object peek() throws QueueEmptyException {
		if (isEmpty()) {
			throw new QueueEmptyException("queue is empty...");
		}
		return elements[front];
	}

}
