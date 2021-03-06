package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Shipping5972 {
	
	static class Node {
		int v,d;
		
		public Node (int v, int d) {
			this.v = v;
			this.d = d;
		}
	}
	
	static int N,M;
	static int INF = Integer.MAX_VALUE;
	static ArrayList<Node>[] map;
	static int[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stk = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		
		visited = new int[M+1];
		map = new ArrayList[N+1];
		
		for (int i = 0; i <= N; i++) {
			map[i] = new ArrayList<Node>();
		}
		
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine()," ");
			
			int u = Integer.parseInt(stk.nextToken());
			int v = Integer.parseInt(stk.nextToken());
			int w = Integer.parseInt(stk.nextToken());
			
			map[u].add(new Node(v,w));
			map[v].add(new Node(u,w));
		}
		
		dijkstra();
		
		bw.write(visited[N] + "");
		bw.close();
		br.close();
		
	}
	
	
	static void dijkstra() {
		
		for (int i = 0; i <= N; i++) {
			visited[i] = INF;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				
				if (n1.d > n2.d) return -1;
				else if (n2.d > n1.d) return 1;
				else return 0;
			}
		});
		
		pq.offer(new Node(1,0));
		visited[1] = 0;
		
		while(!pq.isEmpty()) {
			int cur_v = pq.peek().v;
			int cur_d = pq.peek().d;
			
			pq.poll();
			
			if (visited[cur_v] < cur_d) continue;
			
			for (int i = 0; i < map[cur_v].size(); i++) {
				int next_v = map[cur_v].get(i).v;
				int next_d = map[cur_v].get(i).d;
				
				if (visited[next_v] > cur_d + next_d) {
					visited[next_v] = cur_d + next_d;
					pq.offer(new Node(next_v, visited[next_v]));
				}
			}
		}	
	}
}
