package stack;

import org.junit.Test;

public class StackArrayTest {
	
	StackArray s = new StackArray();
	{
		for (int i = 1; i <= 8; i++) {
			s.push(i);
		}
	}
	
	private void print() {
		System.out.println("0-----------------");
		while (!s.isEmpty()) {
			System.out.println(s.pop());
		}
		System.out.println("1-----------------");
	}
	
	@Test
	public void testGetSize() {
		System.out.println(s.getSize());
		System.out.println(s.isEmpty());
		print();
		System.out.println(s.getSize());
		System.out.println(s.isEmpty());
	}

	@Test
	public void testPeek() {
		for (int i = 0; i < 5; i++) {
			System.out.println(s.peek());
		}
	}
}
