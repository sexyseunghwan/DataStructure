package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SeokangGround14938 {
	
	static class Node {
		int v,w;
		
		public Node (int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	static int N,M,R;
	static int[] items;
	static int[] visited;
	static int INF = Integer.MAX_VALUE;
	static int maxCnt = Integer.MIN_VALUE;
	static ArrayList<ArrayList<Node>> map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stk = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		R = Integer.parseInt(stk.nextToken());
		
		map = new  ArrayList<ArrayList<Node>>();
		items = new int[N+1];
		visited = new int[N+1];
		
		for (int i = 0; i <= N; i++) {
			map.add(new ArrayList<Node>());
		}
		
		stk = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 1; i <= N; i++) {
			items[i] = Integer.parseInt(stk.nextToken());
		}
		
		for (int i = 0; i < R; i++) {
			stk = new StringTokenizer(br.readLine()," ");
			
			int s = Integer.parseInt(stk.nextToken());
			int e = Integer.parseInt(stk.nextToken());
			int w = Integer.parseInt(stk.nextToken());
			
			map.get(s).add(new Node(e,w));
			map.get(e).add(new Node(s,w));
		}
		
		
		for (int i = 1; i <= N; i++) {
			int result = dijkstra(i);
			maxCnt = Math.max(maxCnt, result);
		}
		
		bw.write(maxCnt + "");
		bw.close();
		br.close();
	
	}
	
	static int dijkstra(int start) {
		
		for (int i = 0; i <=N; i++) {
			visited[i] = INF;
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
		visited[start] = 0;
		
		while(!pq.isEmpty()) {
			int curV = pq.peek().v;
			int curW = pq.peek().w;
			
			pq.poll();
			
			if (visited[curV] < curW) continue;
			
			
			for (int i = 0; i < map.get(curV).size(); i++) {
				int nextV = map.get(curV).get(i).v;
				int nextW =  map.get(curV).get(i).w;
				
				if (visited[nextV] > nextW + curW) {
					visited[nextV] = nextW + curW;
					pq.offer(new Node(nextV,visited[nextV]));
				}
			}
			
		}
		
		int count = 0;
		
		for (int i = 1; i <= N; i++) {
			if (visited[i] <= M) count += items[i];
		}
		
		
		return count;
	}
}	
