package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MinRoot1753 {
	
	static class Node {
		int v,w;
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	static int INF = Integer.MAX_VALUE;
	static int V,E,startV;
	static ArrayList<ArrayList<Node>> map;
	static int[] visit;
	//static int ;
	
	static void init() {
		for (int i = 1;  i <= V; i++) {
			visit[i] = INF;
		}
	}
	
	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				
				if (n1.w > n2.w) return 1;
				else if (n2.w > n1.w) return -1;
				else return 0;
			}
		});
		
		pq.offer(new Node(startV,0));
		visit[startV] = 0;
		
		while(!pq.isEmpty()) {
			int curV = pq.peek().v;
			int curW = pq.peek().w;
			
			pq.poll();
			
			if (visit[curV] < curW) continue;
			
			for (int i = 0; i < map.get(curV).size(); i++) {
				int newV =  map.get(curV).get(i).v;
				int newW =  map.get(curV).get(i).w;
				
				if (visit[newV] > curW + newW) {
					visit[newV] = curW + newW;
					pq.offer(new Node(newV,visit[newV]));
				}
				
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception{ 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer stk = new StringTokenizer(br.readLine()," ");
		
		V = Integer.parseInt(stk.nextToken());
		E = Integer.parseInt(stk.nextToken());
		
		startV = Integer.parseInt(br.readLine());
		map = new ArrayList<ArrayList<Node>>();
		visit = new int[V+1];
		
		for (int i = 0; i <= V; i++) {
			map.add(new ArrayList<Node>());
		}
		
		init();
		
		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			map.get(r).add(new Node(c,w));
		}
		
		dijkstra();
		
		for (int i = 1; i <= V; i++) {
			if (visit[i] == INF) sb.append("INF\n");
			else sb.append(visit[i] + "\n");
		}
		
		bw.write(sb.toString() + "");
		bw.close();
		br.close();
		
	}
}
