package tree;

import static org.junit.Assert.fail;
import list.Iterator;

import org.junit.Test;

public class BinaryTreeLinkedTest {
	
	BinaryTreeLinked tree;
	{
		BinTreeNode b1 = new BinTreeNode(1);
		BinTreeNode b2 = new BinTreeNode(2);
		BinTreeNode b3 = new BinTreeNode(3);
		BinTreeNode b4 = new BinTreeNode(4);
		BinTreeNode b5 = new BinTreeNode(5);
		BinTreeNode b6 = new BinTreeNode(6);
		BinTreeNode b7 = new BinTreeNode(7);
		
		b1.setLChild(b2);
		b1.setRChild(b3);
		b2.setLChild(b4);
		b2.setRChild(b5);
		b3.setLChild(b6);
		b3.setRChild(b7);
		tree = new BinaryTreeLinked(b1);        //construct a full binary tree....
	}
	
	@Test
	public void testGetSize() {
		System.out.println(tree.getSize());
	}

	@Test
	public void testIsEmpty() {
		System.out.println(tree.isEmpty());
	}

	@Test
	public void testGetRoot() {
		System.out.println(tree.getRoot());
	}

	@Test
	public void testGetHeight() {
		System.out.println(tree.getHeight());
	}

	@Test
	public void testFind() {
		BinTreeNode b = tree.find(3);
		System.out.println(b);
	}

	@Test
	public void testPreOrder() {
		Iterator it = tree.preOrder();
		while (!it.isDone()) {
			System.out.println(it.currentItem());
			it.next();
		}
	}

	@Test
	public void testInOrder() {
		Iterator it = tree.inOrder();
		while (!it.isDone()) {
			System.out.println(it.currentItem());
			it.next();
		}
	}

	@Test
	public void testPostOrder() {
		Iterator it = tree.postOrder();
		while (!it.isDone()) {
			System.out.println(it.currentItem());
			it.next();
		}
	}

	@Test
	public void testLevelOrder() {
		Iterator it = tree.levelOrder();
		while (!it.isDone()) {
			System.out.println(it.currentItem());
			it.next();
		}
	}

}
