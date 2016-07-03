package tree;

import list.Iterator;
import list.LinkedList;
import list.LinkedListDLNode;
import list.List;
import list.ListArray;
import strategy.DefaultStrategy;
import strategy.Strategy;

public class HuffmanTreeLinked extends BinaryTreeLinked {
	public HuffmanTreeLinked(HuffmanTreeNode[] nodes) {
		this(nodes, new DefaultStrategy());
	}

	public HuffmanTreeLinked(HuffmanTreeNode[] nodes, Strategy strategy) {
		super(buildHuffmanTree(nodes), strategy);
		generateHuffmanCode(getRoot());
	}

	public HuffmanTreeNode getRoot() {
		return (HuffmanTreeNode) super.getRoot();
	}

	// 返回Huffman的所有叶子结点
	public Iterator getAllLeafs() {
		LinkedList list = new LinkedListDLNode();
		getLeafs(getRoot(), list);
		return list.elements();
	}

	private void getLeafs(HuffmanTreeNode root, LinkedList list) {
		if (root == null) 
			return;
		if (root.isLeaf()) 
			list.insertLast(root);
		getLeafs(root.getLChild(), list);
		getLeafs(root.getRChild(), list);
	}

	// 递归生成Huffman编码
	private static void generateHuffmanCode(HuffmanTreeNode root) {
		if (root == null)
			return;
		if (root.hasParent()) {
			if (root.isLChild())
				root.setCoding(root.getParent().getCoding() + "0");
			else if (root.isRChild())
				root.setCoding(root.getParent().getCoding() + "1");
		}
		generateHuffmanCode(root.getLChild());
		generateHuffmanCode(root.getRChild());
	}

	// 通过结点数组生成Huffman树
	private static HuffmanTreeNode buildHuffmanTree(HuffmanTreeNode[] nodes) {
		if (nodes.length < 2)
			return nodes[0];
		List l = new ListArray();
		for (int i = 0; i < nodes.length; i++) {
			insertToList(l, nodes[i]);
		}
		for (int i = 1; i < nodes.length; i++) {
			HuffmanTreeNode min1 = (HuffmanTreeNode) l.remove(l.getSize() - 1);
			HuffmanTreeNode min2 = (HuffmanTreeNode) l.remove(l.getSize() - 1);
			HuffmanTreeNode NewNode = new HuffmanTreeNode(min1.getWeight()
					+ min2.getWeight());
			NewNode.setLChild(min1);
			NewNode.setRChild(min2);
			insertToList(l, NewNode);
		}
		return (HuffmanTreeNode) l.get(0);
	}

	// 将结点按照weight从大到小的顺序插入线性表
	private static void insertToList(List l, HuffmanTreeNode node) {
		for (int i = 0; i < l.getSize(); i++) {
			if (node.getWeight() > ((HuffmanTreeNode) l.get(i)).getWeight()) {
				l.insert(i, node);
				return;
			}
		}
		l.insert(l.getSize(), node);
	}
}
