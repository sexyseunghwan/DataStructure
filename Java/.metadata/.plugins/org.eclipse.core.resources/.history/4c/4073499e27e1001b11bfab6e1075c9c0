package com.test.algorithm;

import java.util.LinkedList;

public class HashTableTest {
	
	//노드 클래스 생성
	class Node {
		
		String key;
		String value;
		
		//생성
		public Node(String key, String value) {
			this.key = key;
			this.value = value;
		}
		
		String value() {
			return value;
		}
		void value(String value) {
			this.value = value;
		}
		
	}
	
	LinkedList<Node>[] data;
	
	//hashtable 생성자 -> 초반에 길이를 지정해준다.
	HashTableTest(int size) {
		this.data = new LinkedList[size];
	}
	
	//키를받아서 해시코드로 변환하는 함수역할
	int getHashCode(String key) {
		int hashcode = 0;
		for (char c : key.toCharArray()) {
			hashcode += c;
		}
		return hashcode;
	}
	
	int convertToIndex(int hashcode) {
		return hashcode % data.length;
	}
	
	Node searchKey(LinkedList<Node> list,String key) {
		if (list == null) return null;
		for (Node node : list) {
			if(node.key.equals(key)) {
				return node;
			}
		}
		return null;
	}
	
	void put(String key, String value) {
		int hashcode = getHashCode(key);//key를 가지고 해시코드를 받아온다.
		int index = convertToIndex(hashcode);//받아온 해시코드로 저장할 배열방 번호를 받아온다.
		LinkedList<Node> list = data[index];//배열방번호를 이용하여 기존 배열방에 있는 데이터를 가져와준다.
		System.out.println(key + ", hashcode(" + hashcode + "), index(" + index + ")");
		//배열방이 null이라면....
		if (list == null) {
			list = new LinkedList<Node>();
			data[index] = list;
		}
		Node node = searchKey(list,key);
		if (node == null) { //데이터가 없다는 뜻이다.
			list.addLast(new Node(key,value));
		} else {
			//키값을 대체하는것으로써 중복키 처리
			node.value(value);
		}
	}
	
	//최종적으로 가져오는 구조를 말하는것
	String get(String key) {
		int hashcode = getHashCode(key);//key를 가지고 해시코드를 받아온다.
		int index = convertToIndex(hashcode);//받아온 해시코드로 저장할 배열방 번호를 받아온다.
		LinkedList<Node> list = data[index];//배열방번호를 이용하여 기존 배열방에 있는 데이터를 가져와준다.
		Node node = searchKey(list,key);
		
		return node == null?"not found" : node.value();
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		HashTableTest h = new HashTableTest(3);
		h.put("sung", "she is pretty");
		h.put("jin", "she is a model");
		h.put("hee", "she is an angel");
		h.put("min", "she is cute");
		
		
		System.out.println(h.get("sung"));
		System.out.println(h.get("jin"));
		System.out.println(h.get("hee"));
		System.out.println(h.get("min"));
		
	}
	

}
