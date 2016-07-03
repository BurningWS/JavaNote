package search;

import strategy.DefaultStrategy;
import strategy.Strategy;
import tree.BinTreeNode;
import tree.BinaryTreeLinked;
import list.Iterator;
import list.LinkedList;
import list.LinkedListDLNode;
import list.Node;

public class BSTree extends BinaryTreeLinked implements SearchTable {
	protected BinTreeNode startBN; // 在AVL树中重新平衡的起始结点

	// 构造方法
	public BSTree() {
		this(new DefaultStrategy());
	}

	public BSTree(Strategy strategy) {
		this.strategy = strategy;
		startBN = null;
	}

	@Override
	public int getSize() {
		return root.getSize();
	}

	@Override
	public boolean isEmpty() {
		return isEmpty();
	}

	@Override
	public Node search(Object ele) {
		return binTSearch(root, ele);
	}

	private Node binTSearch(BinTreeNode rt, Object ele) {
		if (rt == null)
			return null;
		switch (strategy.compare(ele, rt.getData())) {
		case -1:
			return binTSearch(rt.getLChild(), ele);
		case 0:
			return rt;
		default:
			return binTSearch(rt.getRChild(), ele);
		}
	}

	@Override
	public Iterator searchAll(Object ele) {
		LinkedList list = new LinkedListDLNode();
		binTSearchAll(root, ele, list);
		return list.elements();
	}

	public void binTSearchAll(BinTreeNode rt, Object ele, LinkedList list) {
		if (rt == null)
			return;
		binTSearch(rt.getLChild(), ele);
		if (strategy.compare(ele, rt.getData()) == 0)
			list.insertLast(rt);
		binTSearch(rt.getRChild(), ele);
	}

	@Override
	public void insert(Object ele) {
		BinTreeNode p = null;
		BinTreeNode current = root;
		int cmp = 0;
		while (current != null) {
			p = current;
			cmp = strategy.compare(ele, current.getData());
			if (cmp == 0)
				break;
			if (cmp < 0)
				current = current.getLChild();
			else
				current = current.getRChild();
		}
		startBN = p; // 待平衡出发点
		if (p == null) {
			root = new BinTreeNode(ele);
		} else {
			if (cmp < 0)
				p.setLChild(new BinTreeNode(ele));
			else
				p.setRChild(new BinTreeNode(ele));
		}

	}

	@Override
	public Object remove(Object ele) {
		// TODO Auto-generated method stub
		return null;
	}

	// 返回以v为根的二叉查找树中最小(大)元素的位置
	public Node min(BinTreeNode v) {
		if (v == null)
			return null;
		while (v.hasLChild())
			v = v.getLChild();
		return v;
	}

	public Node max(BinTreeNode v) {
		if (v == null)
			return null;
		while (v.hasRChild())
			v = v.getRChild();
		return v;
	}

	// 返回结点v在中序遍历序列中的前驱结点
	private BinTreeNode getPredecessor(BinTreeNode v) {
		if (v == null)
			return null;
		if (v.hasLChild())
			return (BinTreeNode) max(v.getLChild());
		while (v.isLChild()) {
			v = v.getParent();
		}
		return v.getParent();
	}

	// 返回结点v在中序遍历序列中的后续结点
	private BinTreeNode getSuccessor(BinTreeNode v) {
		if (v == null) 
			return null;
		if (v.hasRChild()) 
			return (BinTreeNode) min(v.getRChild());
		while (v.isRChild()) {
			v = v.getParent();
		}
		return v.getParent();
	}
}