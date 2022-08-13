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
		
		
//		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
//			@Override
//			public int compare(Integer n1,Integer n2) {
//				
//				if (n1 > n2) return -1;
//				else if (n2 > n1) return 1;
//				else return 0;
//			}
//		});
	
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		

		
		PriorityQueue<Integer>[] pqi = new PriorityQueue[11];
		
		pqi[0] = new PriorityQueue<Integer>();
		
		pqi[0].add(3);
		pqi[0].add(4);
		
		System.out.println(pqi[0].poll());
		System.out.println(pqi[0].poll());
		
	
	}
	
	
	
	
	
	

}
