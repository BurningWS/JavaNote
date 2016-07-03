package list;

import org.junit.Test;

public class ListSLinkedTest {
	
	ListSLinked lsl = new ListSLinked();
	{
		for (int i = 0; i < 5; i++) {
			lsl.insert(i, "ls"+i);
		}
		
	}
	
	private void output() {
		System.out.println("0-----------------");
		for (int i = 0; i < lsl.getSize(); i++) {
			System.out.println(lsl.get(i)+"---");
		}
		System.out.println("1-----------------");
	}
	
	@Test
	public void testInsert() {
		lsl.insert(8, "outofbounds");
	}
	
	@Test
	public void testGetSize() {
		System.out.println(lsl.getSize());
	}

	@Test
	public void testIsEmpty() {
		System.out.println(lsl.isEmpty());
		for (int i = lsl.getSize()-1; i >= 0; i--) {
			lsl.remove(i);
		}
		System.out.println(lsl.isEmpty());
	}

	@Test
	public void testContains() {
		
		System.out.println(lsl.contains("ls1"));
		System.out.println(lsl.contains("ls5"));
	}

	@Test
	public void testIndexOf() {
		System.out.println(lsl.indexOf("ls4"));
	}

	@Test
	public void testInsertBefore() {
		lsl.insertBefore("ls3", "ls666");
		output();
	}

	@Test
	public void testInsertAfter() {
		System.out.println(lsl.insertAfter("ls3", "ls8"));
		output();
	}

	@Test
	public void testRemoveInt() {
		lsl.remove(2);
		output();
	}

	@Test
	public void testRemoveObject() {
		lsl.remove("ls2");
		output();
	}

	@Test
	public void testReplace() {
		lsl.replace(3, "spark");
		output();
	}
}
