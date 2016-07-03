package queue;

import org.junit.Test;

public class QueueArrayTest {
	QueueArray qa = new QueueArray();
	{
		for (int i = 1; i <= 15; i++) {
			qa.enqueue(i);
		}
	}
	
	void print() {
		System.out.println("0*****************");
		while (!qa.isEmpty()) {
			System.out.println(qa.dequeue());
		}
		System.out.println("1*****************");
	}
	
	@Test
	public void testGetSize() {
		System.out.println(qa.getSize());
		print();
		System.out.println(qa.getSize());
	}

	@Test
	public void testPeek() {
		for (int i = 0; i < 8; i++) {
			System.out.println(qa.peek());
		}
	}

}
