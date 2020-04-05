package com.edwin.algorithm;

public class Node {

	private int value;        //�ڵ��ֵ
	private Node node;        //�˽ڵ㣬��������ΪNode
	Node left;        //�˽ڵ�����ӽڵ㣬��������ΪNode
	Node right;       //�˽ڵ�����ӽڵ㣬��������ΪNode
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node(int value) {
		this.value=value;
		this.left=null;
		this.right=null;
	}
	public String toString() {         //�Զ����toString������Ϊ�˷���֮������
		return this.value+" ";
	}

}
