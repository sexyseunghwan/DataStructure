package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;


public class Networking9694 {
	
	static ArrayList<ArrayList<Node>> map;
	static int[] visit;
	static int[] prev;
	static int T,N,M;
	static int INF = Integer.MAX_VALUE;
	static int CASE = 1;
	
	static class Node {
		int r,w;
		
		public Node(int r, int w) {
			this.r = r;
			this.w = w;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			String[] inputs = br.readLine().split(" ");
			
			N = Integer.parseInt(inputs[0]);//관계의 개수
			M = Integer.parseInt(inputs[1]);//정치인의 수
			
			prev = new int[M];
			visit = new int[M];
			map = new ArrayList<ArrayList<Node>>();
			
			for (int i = 0; i < M; i++) {
				ArrayList<Node> arr = new ArrayList<Node>();
				map.add(arr);
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
		
		visit[0] = 0;
		pq.offer(new Node(0,0));
		
		while(!pq.isEmpty()) {
			Node nd = pq.poll();
			int cur = nd.r;
			int curW = -nd.w;
			
			clean();
			
			if (visit[cur] < curW) continue;
			
			for (int i = 0; i < map.get(cur).size(); i++) {
				int next =  map.get(cur).get(i).r;
				int nextW =  map.get(cur).get(i).w;
				
				if (visit[next] > curW + nextW) {
					visit[next] = curW + nextW;
					pq.offer(new Node(next,-visit[next]));
					prev[next] = cur;
				}
			}
		}//while
		
		if (visit[M-1] == INF) System.out.printf("Case #%d: -1\n",CASE++);
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
			visit[i] = INF;
			prev[i] = -1;
		}
	}
	

}
