package tree;

import static org.junit.Assert.fail;
import list.Iterator;

import org.junit.Test;

public class HuffmanTreeLinkedTest {

	HuffmanTreeLinked hfl;
	{
		HuffmanTreeNode[] nodes = { new HuffmanTreeNode(1),
				new HuffmanTreeNode(2), new HuffmanTreeNode(3),
				new HuffmanTreeNode(4), new HuffmanTreeNode(5),
				new HuffmanTreeNode(6) };
		hfl = new HuffmanTreeLinked(nodes);
	}

	@Test
	public void testGetRoot() {
		System.out.println(hfl.getRoot().getWeight());
	}

	@Test
	public void testGetAllLeafs() {
		Iterator it = hfl.getAllLeafs();
		while (!it.isDone()) {
			HuffmanTreeNode n = (HuffmanTreeNode)it.currentItem();
//			System.out.println((n.getWeight());
			System.out.println(n.getWeight()+"--"+n.getCoding());
			it.next();
		}
	}

}
