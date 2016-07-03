package stack;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackSLinkedTest {

	StackSLinked s = new StackSLinked();
	{
		for (int i = 1; i <= 8; i++) {
			s.push(i);
		}
	}

	private void print() {
		System.out.println("0-------------------");
		while (!s.isEmpty()) {
			System.out.println(s.pop());
		}
		System.out.println("1-------------------");
	}

	@Test
	public void testGetSize() {
		System.out.println(s.getSize());
		print();
		System.out.println(s.getSize());
		
	}

	@Test
	public void testPeek() {
		for (int i = 1; i <= 8; i++) {
			System.out.println(s.peek());
		}
	}

}
