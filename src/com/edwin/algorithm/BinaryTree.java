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

		// ����������Ķ�����ɽڵ����ʽ
		for (int i = 0; i < datas.length; i++) {
			Node node = new Node(datas[i]);
			list.add(node);
		}

		// �ڵ��������
		for (int index = 0; index < list.size() / 2 - 1; index++) {
			list.get(index).setLeft(list.get(index * 2 + 1));
			// ���Ϊn�Ľڵ��������ӽڵ���Ϊ2*n ���ӽڵ���Ϊ2*n+1 ������Ϊlist��0��ʼ��ţ����Ի�Ҫ+1
			list.get(index).setRight(list.get(index * 2 + 2)); // ����ͬ��
		}

		// �����������һ�����ڵ� ,list.size()/2-1�������ã����ⵥ�������
		int index = list.size() / 2 - 1;
		list.get(index).setLeft(list.get(index * 2 + 1));
		if (list.size() % 2 == 1)
			// ������������ڵ㣬���һ�����ڵ�������ӽڵ�
			list.get(index).setRight(list.get(index * 2 + 2));

	}

	/**
	 * �ݹ�ǰ����� ����������̣� ��1�����ʸ��ڵ㣻 ��2����������ݹ������������ ��3����������ݹ������������
	 * 
	 * @param node
	 */
	public void preTraversal(Node node) {
		if (node == null) // ����Ҫ��������� ������Ҷ�ӽڵ�����ֹͣ���±���
			return;
		System.out.print(node.getValue() + " ");
		preTraversal(node.getLeft());
		preTraversal(node.getRight());
	}

	/**
	 * �ݹ�������� ��������� ��1��������������������� ��2�����ʸ��ڵ㣻 ��3�������������������
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
	 * �ݹ������� ��������� ��1�����ú���ݹ������������ ��2�����ú���ݹ������������ ��3�����ʸ��ڵ㣻
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
	 * �ǵݹ�ǰ�����
	 * 
	 * ������ԭ����ǵ�ѭ���е�p��Ϊ��ʱ���Ͷ�ȡp��ֵ�������ϸ���pΪ�����ӽڵ㣬�����϶�ȡ���ӽڵ㣬ֱ��һ��֦�ڵ��������ӽڵ㣬
	 * �ټ���������һ�����ȡֵ
	 * 
	 * @param node
	 */
	public void preOrderTraversalbyLoop(Node node) {
		Stack<Node> stack = new Stack();
		Node p = node;
		while (p != null || !stack.isEmpty()) {
			while (p != null) {
				// ��p��Ϊ��ʱ���Ͷ�ȡp��ֵ�������ϸ���pΪ�����ӽڵ㣬�����϶�ȡ���ӽڵ�
				System.out.print(p.getValue() + " ");
				stack.push(p); // ��p��ջ
				p = p.getLeft();
			}
			if (!stack.isEmpty()) {
				p = stack.pop();
				p = p.getRight();
			}
		}
	}

	/**
	 * �ǵݹ��������
	 * 
	 * 
	 * ���ǵ�ѭ���е�p��Ϊ��ʱ���Ͷ�ȡp��ֵ�������ϸ���pΪ�����ӽڵ㣬�����м����ʱ���ܽ�����������벻�϶�ȡ���ӽڵ㣬ֱ��һ��֦�ڵ��������ӽڵ�
	 * ��Ȼ��ÿ�δ�ջ���ó�һ��Ԫ�أ��ͽ���������ټ���������һ�����ȡֵ
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
	 * �ǵݹ�������
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
				// ֻ���ó���ջ�����ֵ����û�н���ɾ��
				if (temp == null || temp == prev) {
					// �ڵ�û�����ӽڵ���ߵ�����ڵ㡾���ǵ����һ�������
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
	 * ������ȱ���
	 * 
	 * @param root
	 */
	public void bfs(Node root) {
		if (root == null)
			return;
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.offer(root); // ���Ƚ����ڵ�������
		// ����������ֵʱ��ÿ��ȡ�����׵�node��ӡ����ӡ֮���ж�node�Ƿ����ӽڵ㣬���У����ӽڵ�������
		while (queue.size() > 0) {
			Node node = queue.peek();
			queue.poll(); // ȡ������Ԫ�ز���ӡ
			System.out.print(node.getValue() + " ");
			if (node.left != null) { // ��������ӽڵ㣬����������
				queue.offer(node.left);
			}
			if (node.right != null) { // ��������ӽڵ㣬����������
				queue.offer(node.right);
			}
		}
	}
	/**
	 * ������ȱ���
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
			 * ���ｫlist����rst��ʱ������ֱ�ӽ�list���룬����ͨ���½�һ��list��ʵ�֣�
			 * ��Ϊ���ֱ����list�Ļ�������remove��ʱ��Ҳ�Ὣ�����һ����Ľڵ�ɾ��
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
