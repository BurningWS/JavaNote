package queue;

import list.SLNode;
import exception.QueueEmptyException;

public class QueueSLinked implements Queue {
	
	private SLNode front;
	private SLNode rear;
	private int size;
	
	public QueueSLinked() {
		front = rear = new SLNode();
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
	public void enqueue(Object e) {
		SLNode s = new SLNode(e, null);
		rear.setNext(s);
		rear = s;
		size++;
	}

	@Override
	public Object dequeue() throws QueueEmptyException {
		if (isEmpty()) {
			throw new QueueEmptyException("queue is empty...");
		}
		size--;
		SLNode s = front.getNext(); 
		front.setNext(s.getNext());
		if (size <= 0) {
			rear = front;
		}
		return s.getData();
	}

	@Override
	public Object peek() throws QueueEmptyException {
		if (isEmpty()) {
			throw new QueueEmptyException("queue is empty...");
		}
		return front.getNext().getData();
	}

}
