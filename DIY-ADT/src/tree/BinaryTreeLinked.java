package tree;

import queue.Queue;
import queue.QueueArray;
import stack.Stack;
import stack.StackSLinked;
import strategy.DefaultStrategy;
import strategy.Strategy;
import list.Iterator;
import list.LinkedList;
import list.LinkedListDLNode;

public class BinaryTreeLinked implements BinTree {

	protected BinTreeNode root;
	protected Strategy strategy;

	public BinaryTreeLinked() {
		this(null);
	}

	public BinaryTreeLinked(BinTreeNode root) {
		this(root, new DefaultStrategy());
	}

	public BinaryTreeLinked(BinTreeNode root, Strategy strategy) {
		this.root = root;
		this.strategy = strategy;
	}

	@Override
	public int getSize() {
		return isEmpty() ? 0 : root.getSize();
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public BinTreeNode getRoot() {
		return root;
	}

	@Override
	public int getHeight() {
		return root.getHeight();
	}

	@Override
	public BinTreeNode find(Object e) {
		return searchE(root, e);
	}

	// 递归查找元素e
	private BinTreeNode searchE(BinTreeNode rt, Object e) {
		if (rt == null)
			return null;
		if (strategy.equal(rt.getData(), e))
			return rt;
		BinTreeNode v = searchE(rt.getLChild(), e);
		if (v == null)
			v = searchE(rt.getRChild(), e);
		return v;
	}

	@Override
	public Iterator preOrder() {
		LinkedList list = new LinkedListDLNode();
		preOrderRecursion(root, list);
		return list.elements();
	}

	// 先序遍历的递归算法
	private void preOrderRecursion(BinTreeNode rt, LinkedList list) {
		if (rt == null)
			return;
		list.insertLast(rt);
		preOrderRecursion(rt.getLChild(), list);
		preOrderRecursion(rt.getRChild(), list);
	}

	@SuppressWarnings("unused")
	private void preOrderTraverse(BinTreeNode rt, LinkedList list) {
		if (rt == null)
			return;
		Stack s = new StackSLinked();
		BinTreeNode p = rt;
		while (p != null) {
			while (p != null) {
				list.insertLast(p);
				if (p.hasRChild()) {
					s.push(p.getRChild());
				}
				p = p.getLChild();
			}
			if (!s.isEmpty())
				p = (BinTreeNode) s.pop();
		}
	}

	@Override
	public Iterator inOrder() {
		LinkedList list = new LinkedListDLNode();
		inOrderRecursion(root, list);
		return list.elements();
	}

	private void inOrderRecursion(BinTreeNode rt, LinkedList list) {
		if (rt == null)
			return;
		inOrderRecursion(rt.getLChild(), list);
		list.insertLast(rt);
		inOrderRecursion(rt.getRChild(), list);
	}

	@SuppressWarnings("unused")
	private void inOrderTraverse(BinTreeNode rt, LinkedList list) {
		if (rt == null)
			return;
		Stack s = new StackSLinked();
		BinTreeNode p = rt;
		while (p != null && !s.isEmpty()) {
			while (p != null) {
				s.push(p);
				p = p.getLChild();
			}
			if (!s.isEmpty()) {
				p = (BinTreeNode) s.pop();
				list.insertLast(p);
				p = p.getRChild();
			}
		}
	}

	@Override
	public Iterator postOrder() {
		LinkedList list = new LinkedListDLNode();
		postOrderRecursion(root, list);
		return list.elements();
	}

	private void postOrderRecursion(BinTreeNode rt, LinkedList list) {
		if (rt == null)
			return;
		postOrderRecursion(rt.getLChild(), list);
		postOrderRecursion(rt.getRChild(), list);
		list.insertLast(rt);
	}

	@SuppressWarnings("unused")
	private void postOrderTraverse(BinTreeNode rt, LinkedList list) {
		if (rt == null)
			return;
		Stack s = new StackSLinked();
		BinTreeNode p = rt;
		while (p != null && !s.isEmpty()) {
			while (p != null) {
				s.push(p);
				if (p.hasLChild())
					p = p.getLChild();
				else
					p = p.getRChild();
			}
			if (!s.isEmpty()) {
				p = (BinTreeNode) s.pop();
				list.insertLast(p);
			}
			if (!s.isEmpty() && s.peek() == p) {
				p = (BinTreeNode) s.pop();
				list.insertLast(p);
			}
			if (!s.isEmpty())
				p = ((BinTreeNode) s.peek()).getRChild();
			else
				p = null;
		}
	}

	@Override
	public Iterator levelOrder() {
		LinkedList list = new LinkedListDLNode();
		levelOrderTraverse(root, list);
		return list.elements();
	}

	// 使用对列完成二叉树的按层遍历
	private void levelOrderTraverse(BinTreeNode rt, LinkedList list) {
		if (rt == null)
			return;
		Queue q = new QueueArray();
		BinTreeNode p = rt;
		q.enqueue(p);
		while (!q.isEmpty()) {
			p = (BinTreeNode) q.dequeue();
			list.insertLast(p);
			if (p.hasLChild()) 
				q.enqueue(p.getLChild());
			if (p.hasRChild()) 
				q.enqueue(p.getRChild());
		}
	}
}









