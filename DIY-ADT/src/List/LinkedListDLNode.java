package list;

import exception.InvalidNodeException;
import exception.OutOfBoundaryException;

public class LinkedListDLNode implements LinkedList {

	private DLNode head; // both head and tail are mute nodes..
	private DLNode tail;
	private int size;

	public LinkedListDLNode() {
		head = new DLNode();
		tail = new DLNode();
		head.setNext(tail);
		tail.setPre(head);
		size++;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return head.getNext() == tail;
	}

	@Override
	public Node first() throws OutOfBoundaryException {
		if (isEmpty())
			throw new OutOfBoundaryException("LinkedList is empty...");
		return head.getNext();
	}

	@Override
	public Node last() throws OutOfBoundaryException {
		if (isEmpty())
			throw new OutOfBoundaryException("LinkedList is empty...");
		return tail.getPre();
	}

	/******* subsidiary method ***********/
	// check whether the node is valid...
	private DLNode checkPosition(Node p) throws InvalidNodeException {
		if (p == null) {
			throw new InvalidNodeException("node is empty...");
		} else if (p == head) {
			throw new InvalidNodeException("node is headNode..");
		} else if (p == tail) {
			throw new InvalidNodeException("node is tailNode..");
		}

		return (DLNode) p;
	}

	/***********************************/
	@Override
	public Node getNext(Node p) throws InvalidNodeException,
			OutOfBoundaryException {
		DLNode d = checkPosition(p);
		DLNode n = d.getNext();
		if (n == tail) {
			throw new OutOfBoundaryException(
					"has been at the last node of the link..");
		}
		return n;
	}

	@Override
	public Node getPre(Node p) throws InvalidNodeException,
			OutOfBoundaryException {
		DLNode d = checkPosition(p);
		DLNode n = d.getPre();
		if (n == head) {
			throw new OutOfBoundaryException(
					"has been at the first node of the link..");
		}
		return n;
	}

	@Override
	public Node insertFirst(Object e) {
		DLNode d = new DLNode(e, head, head.getNext());
		head.getNext().setPre(d);
		head.setNext(d);
		size++;
		return d;
	}

	@Override
	public Node insertLast(Object e) {
		DLNode d = new DLNode(e, tail.getPre(), tail);
		tail.getPre().setNext(d);
		tail.setPre(d);
		size++;
		return d;
	}

	@Override
	public Node insertAfter(Node p, Object e) throws InvalidNodeException {
		DLNode t = checkPosition(p);
		DLNode s = new DLNode(e, t, t.getNext());
		t.getNext().setPre(s);
		t.setNext(s);
		size++;
		return s;
	}

	@Override
	public Node insertBefore(Node p, Object e) throws InvalidNodeException {
		DLNode t = checkPosition(p);
		DLNode s = new DLNode(e, t.getPre(), t);
		t.getPre().setNext(s);
		t.setPre(s);
		size++;
		return s;
	}

	@Override
	public Object remove(Node p) throws InvalidNodeException {
		DLNode t = checkPosition(p);
		t.getPre().setNext(t.getNext());
		t.getNext().setPre(t.getPre());
		Object obj = t.getData();
		size--;
		return obj;
	}

	@Override
	public Object removeFirst() throws OutOfBoundaryException {
		if (isEmpty()) {
			throw new OutOfBoundaryException("LinkedList is empty...");
		}
		return remove(head.getNext());
	}

	@Override
	public Object removeLast() throws OutOfBoundaryException {
		if (isEmpty()) {
			throw new OutOfBoundaryException("LinkedList is empty...");
		}
		return remove(tail.getPre());
	}

	@Override
	public Object replace(Node p, Object e) throws InvalidNodeException {
		DLNode t = checkPosition(p);
		Object obj = t.getData();
		t.setData(e);
		return obj;
	}

	@Override
	public Iterator elements() {
		return new LinkedListIterator(this);
	}
}
