package list;

import org.junit.Test;

public class LinkedListDLNodeTest {
	
	LinkedListDLNode lld = new LinkedListDLNode();
	{
		for (int i = 1; i < 5; i++) {
			lld.insertFirst(i);
		}
		print();
	}
	
	private void print() {
		System.out.println("0--------------------");
		Iterator it = lld.elements();
		while(!it.isDone()) {
			System.out.println(it.currentItem());
			it.next();
		}
		System.out.println("1--------------------");
	}
	
	@Test
	public void testGetSize() {
		System.out.println(lld.getSize());
	}

	@Test
	public void testIsEmpty() {
		System.out.println(lld.isEmpty());
		for (int i = 1; i < 5; i++) {
			lld.removeFirst();
		}
		System.out.println(lld.isEmpty());
	}

	@Test
	public void testFirst() {
		System.out.println(lld.first().getData());
		System.out.println(lld.last().getData());
	}

	@Test
	public void testGetNext() {
		Node d = lld.first();
		System.out.println(lld.getNext(d).getData());
	}

	@Test
	public void testGetPre() {
		Node d = lld.last();
		System.out.println(lld.getPre(d).getData());
	}


	@Test
	public void testInsertLast() {
		for (int i = 5; i < 10; i++) {
			lld.insertLast(i);
		}
		print();
	}

	@Test
	public void testInsertAfter() {
		Node d = lld.first();
		lld.insertAfter(d, 100);
		lld.insertBefore(d, 200);
		print();
	}

	@Test
	public void testRemove() {
		Node d = lld.first();
		lld.remove(d);
		lld.removeLast();
		lld.replace(lld.first(),55);
		print();
	}

}
