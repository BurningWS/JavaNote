package list;

import strategy.DefaultStrategy;
import strategy.Strategy;
import exception.OutOfBoundaryException;

public class ListSLinked implements List {

	private SLNode head;
	private int size;
	private Strategy strategy;

	public ListSLinked() {
		this(new DefaultStrategy());
	}

	public ListSLinked(Strategy stategy) {
		this.strategy = stategy;
		head = new SLNode(); // but don't save element...
		size = 0;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return head.getNext() == null;
	}

	@Override
	public boolean contains(Object e) {
		SLNode s = head.getNext();
		while (s != null) {
			if (strategy.equal(s.getData(), e)) {
				return true;
			}
			s = s.getNext();
		}
		return false;
	}

	@Override
	public int indexOf(Object e) {
		SLNode s = head.getNext();
		int i = 0;
		while (s != null) {
			if (strategy.equal(s.getData(), e)) {
				return i;
			}
			i++;
			s = s.getNext();
		}
		return -1;
	}

	/*********************************
	 * subsidiary method
	 ********************************/
	private SLNode getPreNode(Object e) {
		SLNode s = head;
		for (SLNode t=s.getNext(); t!=null; t=t.getNext()) {
			if (strategy.equal(t.getData(), e)) {
				return s;
			}
			s = t;
		}
		return null;
	}

	private SLNode getPreNode(int i) {
		SLNode s = head;
		for (; i > 0; i--) {
			s = s.getNext();
		}
		return s;
	}
	
	private SLNode getNode(int i) {
		if (i < 0 || i > size) {
			throw new OutOfBoundaryException("indexOutOfBoundary");
		}
		SLNode s = head.getNext();
		for (;i>0;i--) {
			s = s.getNext();
		}
		return s;
	}
	/**********************************/
	
	@Override
	public void insert(int i, Object e) throws OutOfBoundaryException {
		if (i < 0 || i > size) {
			throw new OutOfBoundaryException("indexOutOfBoundary");
		}
		SLNode s = getPreNode(i);
		SLNode t = new SLNode(e, s.getNext());
		s.setNext(t);
		size++;
	}

	@Override
	public boolean insertBefore(Object obj, Object e) {
		SLNode s = getPreNode(obj);
		if (s == null) {
			return false;
		}
		SLNode t = new SLNode(e, s.getNext());
		s.setNext(t);
		size++;
		return true;
	}

	@Override
	public boolean insertAfter(Object obj, Object e) {
		SLNode s = head.getNext();
		for (; s!=null; s=s.getNext()) {
			if (strategy.equal(s.getData(), obj)) {
				SLNode t = new SLNode(e, s.getNext());
				s.setNext(t);
				size++;
				return true;
			}
		}
		return false;
	}

	@Override
	public Object remove(int i) throws OutOfBoundaryException {
		if (i < 0 || i >= size) {
			throw new OutOfBoundaryException("indexOutOfBoundary");
		}
		SLNode s = getPreNode(i);
		SLNode d = s.getNext();
		Object ele = d.getData();
		
		s.setNext(d.getNext());
		d = null;
		size--;
		return ele;
	}

	@Override
	//delete the first element like e in list...
	public boolean remove(Object e) {
		SLNode s = getPreNode(e);
		if (s == null) {
			return false;
		}
		SLNode d = s.getNext();
		s.setNext(d.getNext());
		d = null;
		size--;
		return true;
	}

	@Override
	public Object replace(int i, Object e) throws OutOfBoundaryException {
		if (i < 0 || i >= size) {
			throw new OutOfBoundaryException("indexOutOfBoundary");
		}
		SLNode s = getNode(i);
		Object obj = s.getData();
		s.setData(e);
		
		return obj;
	}

	@Override
	public Object get(int i) throws OutOfBoundaryException {
		return getNode(i).getData();
	}

}
