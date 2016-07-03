package tree;

import list.Node;

public class BinTreeNode implements Node {

	private Object data; // 数据域
	private BinTreeNode parent; // 父结点
	private BinTreeNode lChild; // 左孩子
	private BinTreeNode rChild; // 右孩子
	private int height; // 以该结点为根的子树的高度
	private int size; // 该结点子孙数（包括结点本身）

	public BinTreeNode() {
		this(null);
	}

	public BinTreeNode(Object e) {
		data = e;
		parent = lChild = rChild = null;
		height = 0;
		size = 1;
	}

	@Override
	public Object getData() {
		return data;
	}

	@Override
	public void setData(Object obj) {
		data = obj;
	}

	public boolean hasParent() {
		return parent != null;
	}

	// 判断是否有左孩子
	public boolean hasLChild() {
		return lChild != null;
	}

	// 判断是否有右孩子
	public boolean hasRChild() {
		return rChild != null;
	}

	// 判断是否为叶子结点
	public boolean isLeaf() {
		return !hasLChild() && !hasRChild();
	}

	// 判断是否为某结点的左孩子
	public boolean isLChild() {
		return hasParent() && this == parent.lChild;
	}

	// 判断是否为某结点的右孩子
	public boolean isRChild() {
		return hasParent() && this == parent.rChild;
	}

	/****** 与height相关的方法 ******/
	// 取结点的高度,即以该结点为根的树的高度
	public int getHeight() {
		return height;
	}

	// 更新当前结点及其祖先的高度
	public void updateHeight() {
		int a = 0, b = 0, NH = 0;
		if (hasLChild())
			a = lChild.getHeight() + 1;
		if (hasRChild())
			b = rChild.getHeight() + 1;
		NH = a > b ? a : b;
		if (NH == height)
			return;
		height = NH;
		if (hasParent())
			parent.updateHeight();
	}

	/****** 与size相关的方法 ******/
	// 取以该结点为根的树的结点数
	public int getSize() {
		return size;
	}

	// 更新当前结点及其祖先的子孙数
	public void updateSize() {
		size = 1;
		if (hasLChild())
			size += lChild.getSize();
		if (hasRChild())
			size += rChild.getSize();
		if (hasParent())
			parent.updateSize();
	}

	/****** 与parent相关的方法 ******/
	// 取父结点
	public BinTreeNode getParent() {
		return parent;
	}

	// 断开与父亲的关系
	public void sever() {
		if (!hasParent())
			return;
		if (isLChild())
			parent.lChild = null;
		else
			parent.rChild = null;
		parent.updateHeight();
		parent.updateSize();
		parent = null;
	}

	/****** 与lChild相关的方法 ******/
	// 取左孩子
	public BinTreeNode getLChild() {
		return lChild;
	}

	// 设置当前结点的左孩子,返回原左孩子
	public BinTreeNode setLChild(BinTreeNode lc) {
		BinTreeNode oldLC = lChild;
		if (this.hasLChild())
			lChild.sever();
		if (lc != null) {
			lc.sever();
			lChild = lc;
			lc.parent = this;
			updateHeight();
			updateSize();
		}
		return oldLC;
	}

	/****** 与rChild相关的方法 ******/
	// 取右孩子
	public BinTreeNode getRChild() {
		return rChild;
	}

	// 设置当前结点的右孩子,返回原右孩子
	public BinTreeNode setRChild(BinTreeNode rc) {
		BinTreeNode oldRc = rChild;
		if (this.hasRChild()) 
			rChild.sever();
		if (rc != null) {
			rc.sever();
			rChild = rc;
			rc.parent = this;
			updateHeight();
			updateSize();
		}
		return oldRc;
	}

	@Override
	public String toString() {
		return "BinTreeNode [data=" + data + "]";
	}
	
}





