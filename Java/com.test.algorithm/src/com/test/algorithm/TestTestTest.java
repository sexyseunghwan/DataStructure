package com.test.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;


public class TestTestTest {
	
	
	static class Node {
		int v, w;
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				
				if (n1.w > n2.w) return 1;
				else if (n2.w > n1.w) return -1;
				else return 0;
			}
		});
	
		pq.offer(new Node(1,31));
		pq.offer(new Node(2,43));
		pq.offer(new Node(3,66));
		
		System.out.println(pq.peek().v + " " + pq.peek().w);
	
	}
	
	
	
	
	
	

}
