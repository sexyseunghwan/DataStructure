package com.test.algorithm;

//트리구조를 "클래스 형식"으로 만들어 보는 연습.

//노드 class 지정
class Node {
	int data;
	Node left;
	Node right;
}

//Tree class
class Tree {
	
	public Node root;
	
	public void setRoot(Node node) {
		this.root = node;
	}
	
	public Node getRoot() {
		return root;
	}
	
	public Node createNode(Node left, int data, Node right) {
		Node node = new Node();
		node.data = data;
		node.left = left;
		node.right = right;
		
		return node;
	}
	
	//전위 순회 방식 Root -> Left -> Right
	//1 -> 2 -> 4 -> 5 -> 3
	//재귀적 방식이니 이해를 잘 해봐야 한다.
	public void preOrder(Node node) {
		if (node != null) {
			System.out.println(node.data);
			preOrder(node.left);
			preOrder(node.right);
		}
	}//preOrder
	
	
	//중위 순회방식
	public void inOrder(Node node) {
		if (node != null) {
			inOrder(node.left);
			System.out.println(node.data);
			inOrder(node.right);
		}
	}
	
	//후위 순회방식
	public void postOrder(Node node) {
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.println(node.data);
		}
	}
}


public class Tree1 {
	public static void main(String[] args) {
		
		//트리구조 : sql 의 인덱스와 비슷한 개념이라고 보면 되는데, 뭔가 탐색을 좀 더 빠르게 하기 위해 해주는 것이다.
		
		Tree t = new Tree();
		Node n4 = t.createNode(null, 4, null);
		Node n5 = t.createNode(null, 5, null);
		Node n3 = t.createNode(null, 3, null);
		Node n2 = t.createNode(n4, 2, n5);
		Node n1 = t.createNode(n2, 1, n3);
		
		//위와 같이 포인터 형식으로 만든걸 볼 수 있다.
		
		t.setRoot(n1);
		//1.전위순회 방식
		//t.preOrder(t.getRoot());
		
		//2.중위순회 방식
		t.inOrder(t.getRoot());
		
		//3.후위순회 방식
		//t.postOrder(t.getRoot());
		
		
		
	}

}
