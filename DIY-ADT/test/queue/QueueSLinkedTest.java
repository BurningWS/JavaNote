package queue;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueSLinkedTest {

	QueueSLinked qs = new QueueSLinked();
	{
		for (int i = 1; i <= 15; i++) {
			qs.enqueue(i);
		}
	}

	void print() {
		System.out.println("0****************");
		while (!qs.isEmpty()) {
			System.out.println(qs.dequeue());
		}
		System.out.println("0****************");
	}

	@Test
	public void testGetSize() {
		System.out.println(qs.getSize());
		print();
		System.out.println(qs.getSize());
	}

	@Test
	public void testPeek() {
		for (int i = 0; i < 5; i++) {
			System.out.println(qs.peek());
		}
	}

}
