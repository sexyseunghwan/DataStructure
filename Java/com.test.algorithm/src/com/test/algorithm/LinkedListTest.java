package com.test.algorithm;


public class LinkedListTest {
	
	private Node head;
	private Node tail;
	private int size;
	
	//크기를 출력해주는 메서드
	public int size() {
		return size;
	}
	
	private class Node{
		private Node next;
		private Object data;
		
		public Node(Object input) {
			this.data = input;
			this.next = null;
		}
		
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	
	public Node node(int index) {
		Node x = head;
		for (int i = 0; i < index; i++) {
			x = x.next;
		}
		return x;
	}
	
	public void addFirst(Object input) {
		Node newNode = new Node(input);
		
		newNode.next = head;
		head = newNode;
		size++;
		
		if(head.next == null) {//size == 0일때로 지정하는 오류를 범함
			tail = head;
		}
	}
	
	public void addLast(Object input) {
		Node newNode = new Node(input);
		
		if(size == 0) {
			addFirst(input);
		} else {
			tail.next = newNode;
			tail = newNode;
			size++;
		}
	}
	
	public void add(int index,Object input) {
		
		if(index == 0) {
			addFirst(input);
		} else {
			Node newNode = new Node(input);
			Node temp1 = node(index-1);
			Node temp2 = node(index);
			
			temp1.next = newNode;
			newNode.next = temp2;
			size++;
			
			if(newNode.next == null) {
				tail = newNode;
			}
			
		}
	}
	
	//이쁘게 출력시켜 주기 위한 메서드
	public String toString() {
		
		if(head == null) {
			return "[]";
		} 
		
		Node temp = head;
		String str = "[";
		
		while(temp.next != null) {
			str += temp.data + ", ";
			temp = temp.next;//다음노드로 보내주는것이다.
		}
		
		str += temp.data;
		
		return str + "]";
	}
	
	//데이터를 삭제하는 방법 -> 삭제를 했을때 삭제된 놈을 반환해준다.
	public Object removeFirst() {
		Node temp = head;
		head = head.next;
		Object returnData = temp.data;
		temp = null;
		size--;
		
		return returnData;
	}
	
	public Object remove(int index) {
		
		if(index == 0) {
			return removeFirst();
		}
		
		Node temp = node(index-1);
		Node todoDeleted = temp.next;//삭제하고자 하는 노드를 뜻한다.
		temp.next = temp.next.next;
		Object returnData = todoDeleted.data;
		
		//삭제하려는 노드가 꼬리노드라면
		if (todoDeleted == tail) {
			tail = temp;
		}
		
		todoDeleted = null;
		size--;
		
		return returnData;
		
	}
	
	public Object removeLast() {
		return remove(size-1);
	}
	
	
	public Object get(int index) {
		Node temp = node(index);
		
		return temp.data;
	}
	
	public int indexOf(Object data) {
		
		Node temp = head;
		int index = 0;//찾고자하는 위치값
		
		while(temp.data != data) {
			temp = temp.next;
			index++;
			
			if(temp == null) {
				return -1;
			}
		}
		
		return index;
	}
	
	
}
