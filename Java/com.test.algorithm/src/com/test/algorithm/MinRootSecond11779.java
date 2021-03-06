package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;


public class MinRootSecond11779 {
	
	static class Node {
		int v,w;
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	static int N,M,SV,EV;
	static int[] visit;
	static int[] history;
	static int INF = Integer.MAX_VALUE;
	static ArrayList<ArrayList<Node>> map; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		map = new ArrayList<ArrayList<Node>>();
		visit = new int[N+1];
		history = new int[N+1];
		
		for (int i = 0; i <= N; i++) {
			map.add(new ArrayList<Node>());
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine()," ");
			
			int s = Integer.parseInt(stk.nextToken());
			int e = Integer.parseInt(stk.nextToken());
			int w = Integer.parseInt(stk.nextToken());
			
			map.get(s).add(new Node(e,w));
		}
		
		StringTokenizer stks = new StringTokenizer(br.readLine()," "); 
		
		SV = Integer.parseInt(stks.nextToken());
		EV = Integer.parseInt(stks.nextToken());
		
		dijkstra(SV);
		
		
		Stack<Integer> st = new Stack<Integer>();
		
		for (int i = EV; i > 0;) {
			if (history[i] != 0) st.add(i = history[i]);
			else i = history[i];
		}
		
		sb.append(visit[EV] + "\n");
		sb.append((st.size()+1) + "\n");
		
		while(!st.empty()) {
			sb.append(st.pop());
			sb.append(" ");
		}
		
		sb.append(EV);
		
		
		bw.write(sb.toString() + "");
		bw.close();
		br.close();
		
	}

	static void dijkstra(int start) {
		
		
		for (int i = 0; i <= N; i++) {
			visit[i] = INF;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				
				if (n1.w > n2.w) return -1;
				else if (n2.w > n1.w) return 1;
				else return 0;
			}
		});
		
		pq.offer(new Node(start,0));
		visit[start] = 0;
		
		while(!pq.isEmpty()) {
			int curV = pq.peek().v;
			int curW = pq.peek().w;
			
			pq.poll();
			
			if (visit[curV] < curW) continue;
			
			for (int i = 0; i < map.get(curV).size(); i++) {
				int newV = map.get(curV).get(i).v;
				int newW = map.get(curV).get(i).w;
				
				if (visit[newV] > newW + curW) {
					visit[newV] = newW + curW;
					pq.offer(new Node(newV,visit[newV]));
					history[newV] = curV;
					
				}
			}
		}//while
		
	}
}
