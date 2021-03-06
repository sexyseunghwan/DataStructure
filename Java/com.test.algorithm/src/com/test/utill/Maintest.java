package com.test.utill;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Maintest {
	
	static int N,R,M;
	static int INF = Integer.MAX_VALUE;
	static int CASE = 1;
	static int[] provIndex;
	static int[] visit;
	static ArrayList<ArrayList<Node>> map;
	
	static class Node {
		int v,w;
		
		public Node (int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	static void reset() {
		for (int i = 0; i < M; i++) {
			provIndex[i] = -1;
			visit[i] = INF;
		}
	}
	
	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				
				if (n1.w > n2.w) return -1;
				else if (n2.w > n1.w) return 1;
				else return 0;
			}
		});
		
		pq.offer(new Node(0,0));
		visit[0] = 0;
		
		while(!pq.isEmpty()) {
			int cur = pq.peek().v;
			int curW = -pq.peek().w;
			
			pq.poll();
			
			if (visit[cur] < curW) continue;
			
			for (int i = 0; i < map.get(cur).size(); i++) {
				int next = map.get(cur).get(i).v;
				int nextW = map.get(cur).get(i).w;
				
				if (visit[next] > curW + nextW) {
					visit[next] = curW + nextW;
					provIndex[next] = cur;
					pq.offer(new Node(next,-visit[next]));
				}
			}
		}//while
		
		if (visit[M-1] == INF) System.out.printf("Case #%d: -1\n",CASE++);
		else {
			Stack<Integer> stack = new Stack<Integer>();
			
			for (int i = (M-1); i > 0;) {
				stack.push(i = provIndex[i]);
			}
			
			System.out.printf("Case #%d:",CASE++);
			while(!stack.isEmpty()) {
				System.out.printf(" %d",stack.pop());
			}
			
			System.out.printf(" %d\n",M-1);
		}
		
	}
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		while(N-- > 0) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			R = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new ArrayList<ArrayList<Node>>();
			visit = new int[M];
			provIndex = new int[M];
			
			reset();
			
			for (int i = 0; i < M; i++) {
				map.add(new ArrayList<Node>());
			}
			
			for (int i= 0; i < R; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				
				int r = Integer.parseInt(stk.nextToken());
				int c = Integer.parseInt(stk.nextToken());
				int w = Integer.parseInt(stk.nextToken());
	
				map.get(r).add(new Node(c,w));
				map.get(c).add(new Node(r,w));
			}
			
			dijkstra();
			
		}//
		
		
	}
	
}
