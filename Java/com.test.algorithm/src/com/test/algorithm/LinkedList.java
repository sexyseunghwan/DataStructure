package com.test.algorithm;


public class LinkedList {
	
	
	private Node head;//가장 첫번째 노드를 지목하는 포인터
	private Node tail;//가장 마지막 노드를 지목하는 포인터
	private int size;//LinkedList의 길이를 나타냄
	
	public int getSize() {
		return this.size;
	}
	
	
	//노드 객체
	private class Node {
		private Node next;//자기 다음차례의 노드 포인터
		private Object data;//데이터
		
		public Node(Object input) {
			this.data = input;
			this.next = null;
		}
		
		public String toString() {
			return String.valueOf(data);
		}
	}
	
	//index 번째 Node의 값을 가져와주는 역할을 수행한다.
	public Node node(int index) {
		
		Node x = head;
		
		for (int i = 0; i < index; i++) {
			x = x.next;
		}
		return x;
	}
	
	
	//첫번째 순서에 데이터를 넣어주는 작업
	public void addFirst(Object input) {
		
		Node newNode = new Node(input);
		
		newNode.next = head;
		head = newNode;
		size++;
		
		if (head.next == null) {
			tail = newNode;
		}
		
	}
	
	//마지막 순서에 데이터를 넣어주는 작업
	public void addLast(Object input) {
		
		Node newNode = new Node(input);
		
		if (size == 0) {
			addFirst(input);
		} else {
			tail.next = newNode;
			tail = newNode;
			size++;
		}
	}
	
	//원하는 위치에 데이터를 넣어주는 작업
	public void add(int index, Object input) {
		
		if(index == 0) {
			addFirst(input);
		} else {
			
			Node temp1 = node(index-1);
			Node temp2 = node(index);
			Node newNode = new Node(input);
			
			temp1.next = newNode;
			newNode.next = temp2;
			size++;
			
			if(newNode.next == null) {
				tail = newNode;
			}
			
		}
		
	}
	
	
	
	
	
	
	
	

}
