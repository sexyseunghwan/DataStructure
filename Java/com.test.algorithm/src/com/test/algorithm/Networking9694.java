package com.test.algorithm;

import java.io.*;
import java.util.*;

public class Networking9694 {
	
	static ArrayList<ArrayList<Node>> map;
	static int[] answer;
	static int[] prev;
	static int T,N,M;
	static int INF = Integer.MAX_VALUE;
	static int CASE = 1;
	
	static class Node {
		int o,w;
		
		public Node(int o, int w) {
			this.o = o;
			this.w = w;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			//String[] inputs = br.readLine().split(" ");
			
			//N = Integer.parseInt(inputs[0]);//관계의 개수
			//M = Integer.parseInt(inputs[1]);//정치인의 수
			StringTokenizer stk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stk.nextToken());//관계의 개수
			M = Integer.parseInt(stk.nextToken());//정치인의 수
			
			
			prev = new int[M];
			answer = new int[M];
			map = new ArrayList<ArrayList<Node>>();
			
			clean();
			
			for (int i = 0; i < M; i++) {
				map.add(new ArrayList<>());
			}
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				
				map.get(r).add(new Node(c,w));
				map.get(c).add(new Node(r,w));
			}
			
			dijkstra();
			
		}//while
	}//main()
	
	static void dijkstra() {
		
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				
				if (n1.w > n2.w) return -1;
				else if (n2.w > n1.w) return 1;
				else return 0;
			}
		});
		
		answer[0] = 0;
		pq.offer(new Node(0,0));
		
		while(!pq.isEmpty()) {
			Node nd = pq.poll();
			int cur = nd.o;
			int curW = -nd.w;
			
			if (answer[cur] < curW) continue;
			
			for (int i = 0; i < map.get(cur).size(); i++) {
				int next =  map.get(cur).get(i).o;
				int nextW =  map.get(cur).get(i).w;
				
				if (answer[next] > curW + nextW) {
					answer[next] = curW + nextW;
					pq.offer(new Node(next,-answer[next]));
					prev[next] = cur;
				}
			}
		}//while
		
		
		if (answer[M-1] == INF) System.out.printf("Case #%d: -1\n",CASE++);
		else {
			Stack<Integer> stack = new Stack<>();
			
			for (int i = (M-1); i > 0;) {
				stack.push(i = prev[i]);
			}

			System.out.printf("Case #%d:",CASE++);
			
			while(!stack.empty()) {
				System.out.printf(" %d",stack.pop());
			}
			
			System.out.printf(" %d\n",M-1);
		}
		
		
	}//dijsktra()
	
	static void clean() {
		for (int i = 0; i < M; i++) {
			answer[i] = INF;
			prev[i] = -1;
		}
	}
	

}