package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Repeat {
	
	static int[] parent;
	static ArrayList<Node> nodeList = new ArrayList<Node>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		
		for (int i = 1; i < N+1; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			String[] inputs = br.readLine().split(" ");
			nodeList.add(new Node(Integer.parseInt(inputs[0]),Integer.parseInt(inputs[1]),Integer.parseInt(inputs[2])));
		}
		
		Collections.sort(nodeList,new ListSort());//정렬에는 문제 없음
		
		int count = 0;
		int weight = 0;
		for (int i = 0; i < M; i++) {
			
			if (count == N-1) break; 
			
			Node node = nodeList.get(i);
			if (equalsParent(node.x, node.y) == 0) {
				unionParent(node.x,node.y);
				weight += node.w;
				count++;
			}
		}
		
		bw.write(weight + "");
		bw.close();
		br.close();
		
	}
	
	static class ListSort implements Comparator<Node> {

		@Override
		public int compare(Node n1, Node n2) {
			
			if (n1.w > n2.w) return 1;
			else if (n1.w < n2.w) return -1;
			else return 0;
		}
		
	}
	
	static class Node {
		public int x;
		public int y;
		public int w;
		
		public Node(int x,int y,int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}
	}
	
	static int findParent(int x) {
		if (parent[x] == x) return x;
		else return findParent(parent[x]);
	}
	
	static void unionParent(int x,int y) {
		int newX = findParent(x);
		int newY = findParent(y);
		
		if (newX > newY) parent[newX] = y;
		else parent[newY] = x;
	}
	
	static int equalsParent(int x,int y) {
		x = findParent(x);
		y = findParent(y);
		
		return x == y ? 1 : 0;
	}
	
	
}
