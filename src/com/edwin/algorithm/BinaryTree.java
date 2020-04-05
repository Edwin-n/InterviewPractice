package com.edwin.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {
	public static void main(String[] args) {
		int[] datas = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		List<Node> list = new ArrayList<Node>();
		create(datas, list);
		BinaryTree binaryTree = new BinaryTree();

		// binaryTree.preOrderTraversalbyLoop(Node );

	}

	public static void create(int[] datas, List<Node> list) {

		// 将数组里面的东西变成节点的形式
		for (int i = 0; i < datas.length; i++) {
			Node node = new Node(datas[i]);
			list.add(node);
		}

		// 节点关联成树
		for (int index = 0; index < list.size() / 2 - 1; index++) {
			list.get(index).setLeft(list.get(index * 2 + 1));
			// 编号为n的节点他的左子节点编号为2*n 右子节点编号为2*n+1 但是因为list从0开始编号，所以还要+1
			list.get(index).setRight(list.get(index * 2 + 2)); // 与上同理
		}

		// 单独处理最后一个父节点 ,list.size()/2-1进行设置，避免单孩子情况
		int index = list.size() / 2 - 1;
		list.get(index).setLeft(list.get(index * 2 + 1));
		if (list.size() % 2 == 1)
			// 如果有奇数个节点，最后一个父节点才有右子节点
			list.get(index).setRight(list.get(index * 2 + 2));

	}

	/**
	 * 递归前序遍历 先序遍历过程： （1）访问根节点； （2）采用先序递归遍历左子树； （3）采用先序递归遍历右子树；
	 * 
	 * @param node
	 */
	public void preTraversal(Node node) {
		if (node == null) // 很重要，必须加上 当遇到叶子节点用来停止向下遍历
			return;
		System.out.print(node.getValue() + " ");
		preTraversal(node.getLeft());
		preTraversal(node.getRight());
	}

	/**
	 * 递归中序遍历 中序遍历： （1）采用中序遍历左子树； （2）访问根节点； （3）采用中序遍历右子树
	 * 
	 * @param node
	 */
	public void midTraversal(Node node) {
		if (node == null)
			return;
		midTraversal(node.getLeft());
		System.out.print(node.getValue() + " ");
		midTraversal(node.getRight());
	}

	/**
	 * 递归后序遍历 后序遍历： （1）采用后序递归遍历左子树； （2）采用后序递归遍历右子树； （3）访问根节点；
	 * 
	 * @param node
	 */
	public void postTraversal(Node node) {
		if (node == null)
			return;
		postTraversal(node.getLeft());
		postTraversal(node.getRight());
		System.out.print(node.getValue() + " ");
	}

	/**
	 * 非递归前序遍历
	 * 
	 * 基本的原理就是当循环中的p不为空时，就读取p的值，并不断更新p为其左子节点，即不断读取左子节点，直到一个枝节到达最后的子节点，
	 * 再继续返回上一层进行取值
	 * 
	 * @param node
	 */
	public void preOrderTraversalbyLoop(Node node) {
		Stack<Node> stack = new Stack();
		Node p = node;
		while (p != null || !stack.isEmpty()) {
			while (p != null) {
				// 当p不为空时，就读取p的值，并不断更新p为其左子节点，即不断读取左子节点
				System.out.print(p.getValue() + " ");
				stack.push(p); // 将p入栈
				p = p.getLeft();
			}
			if (!stack.isEmpty()) {
				p = stack.pop();
				p = p.getRight();
			}
		}
	}

	/**
	 * 非递归中序遍历
	 * 
	 * 
	 * 就是当循环中的p不为空时，就读取p的值，并不断更新p为其左子节点，但是切记这个时候不能进行输出，必须不断读取左子节点，直到一个枝节到达最后的子节点
	 * ，然后每次从栈中拿出一个元素，就进行输出，再继续返回上一层进行取值
	 * 
	 * @param node
	 */
	public void inOrderTraversalbyLoop(Node node) {
		Stack<Node> stack = new Stack();
		Node p = node;
		while (p != null || !stack.isEmpty()) {
			while (p != null) {
				stack.push(p);
				p = p.getLeft();
			}
			if (!stack.isEmpty()) {
				p = stack.pop();
				System.out.print(p.getValue() + " ");
				p = p.getRight();
			}
		}
	}

	/**
	 * 非递归后序遍历
	 * 
	 * @param node
	 */
	public void postOrderTraversalbyLoop(Node node) {

		Stack<Node> stack = new Stack<Node>();
		Node p = node, prev = node;
		while (p != null || !stack.isEmpty()) {
			while (p != null) {
				stack.push(p);
				p = p.getLeft();
			}
			if (!stack.isEmpty()) {
				Node temp = stack.peek().getRight();
				// 只是拿出来栈顶这个值，并没有进行删除
				if (temp == null || temp == prev) {
					// 节点没有右子节点或者到达根节点【考虑到最后一种情况】
					p = stack.pop();
					System.out.print(p.getValue() + " ");
					prev = p;
					p = null;
				} else {
					p = temp;
				}
			}
		}
	}

	/**
	 * 广度优先遍历
	 * 
	 * @param root
	 */
	public void bfs(Node root) {
		if (root == null)
			return;
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.offer(root); // 首先将根节点存入队列
		// 当队列里有值时，每次取出队首的node打印，打印之后判断node是否有子节点，若有，则将子节点加入队列
		while (queue.size() > 0) {
			Node node = queue.peek();
			queue.poll(); // 取出队首元素并打印
			System.out.print(node.getValue() + " ");
			if (node.left != null) { // 如果有左子节点，则将其存入队列
				queue.offer(node.left);
			}
			if (node.right != null) { // 如果有右子节点，则将其存入队列
				queue.offer(node.right);
			}
		}
	}
	/**
	 * 深度优先遍历
	 * @param node
	 * @param rst
	 * @param list
	 */
	public void dfs(Node node, List<List<Integer>> rst, List<Integer> list) {
		if (node == null)
			return;
		if (node.left == null && node.right == null) {
			list.add(node.getValue());
			/*
			 * 这里将list存入rst中时，不能直接将list存入，而是通过新建一个list来实现，
			 * 因为如果直接用list的话，后面remove的时候也会将其最后一个存的节点删掉
			 */
			rst.add(new ArrayList<>(list));
			list.remove(list.size() - 1);
		}
		list.add(node.getValue());
		dfs(node.left, rst, list);
		dfs(node.right, rst, list);
		list.remove(list.size() - 1);
	}

}
