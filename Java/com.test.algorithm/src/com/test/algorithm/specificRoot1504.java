package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class specificRoot1504 {
	
	static class Node {
		int v,d;
		
		public Node(int v, int d) {
			this.v = v;
			this.d = d;
		}
	}
	
	static int N,E;
	static int[] visited;
	static int INF = 987654321;
	static ArrayList<ArrayList<Node>> map;
	static int sToV1, sToV2, v1ToN, v2ToN, v1ToV2;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		StringTokenizer stk = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(stk.nextToken());
		E = Integer.parseInt(stk.nextToken());
		
		visited = new int[N+1];
		map = new ArrayList<ArrayList<Node>>();
		
		for (int i = 0; i <= N; i++) {
			map.add(new ArrayList<Node>());
		}
		
		for (int i = 0; i < E; i++) {
			
			int s,e,d;
			
			stk = new StringTokenizer(br.readLine()," ");
			
			s = Integer.parseInt(stk.nextToken());
			e = Integer.parseInt(stk.nextToken());
			d = Integer.parseInt(stk.nextToken());
			
			map.get(s).add(new Node(e,d));
			map.get(e).add(new Node(s,d));
			
		}
		
		
		
		int v1,v2;
		stk = new StringTokenizer(br.readLine()," ");
		
		v1 = Integer.parseInt(stk.nextToken());
		v2 = Integer.parseInt(stk.nextToken());
		
		int result = INF;
		
		dijkstra(1);
		sToV1 = visited[v1];
		sToV2 = visited[v2];
		
		dijkstra(v1);
		v1ToN = visited[N];
		v1ToV2 = visited[v2];
		
		dijkstra(v2);
		v2ToN = visited[N];
	
		
		result = Math.min(result, sToV1 + v1ToV2 + v2ToN);
		result = Math.min(result, sToV2 + v1ToV2 + v1ToN);
		
		if (v1ToV2 == INF || result == INF) result = -1;
		
		
		bw.write(result + "");
		bw.close();
		br.close();
		
		
	}	
	
	static void dijkstra(int start) {
			
		
		for (int i = 0; i <= N; i++) {
			visited[i] = INF;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				
				if (n1.d > n2.d) return 1;
				else if (n2.d > n1.d) return -1;
				else return 0;
			}
		});
		
		pq.offer(new Node(start,0));
		visited[start] = 0;
		
		while(!pq.isEmpty()) {
			int curV = pq.peek().v;
			int curD = pq.peek().d;
			
			pq.poll();
			
			
			if (visited[curV] < curD) continue;
			
			for (int i = 0; i < map.get(curV).size(); i++) {
				int newV = map.get(curV).get(i).v;
				int newD = map.get(curV).get(i).d;
				
				if (visited[newV] > newD + curD) {
					visited[newV] = newD + curD;
					pq.offer(new Node(newV,visited[newV]));
				}
			}
		}
		
		
	}
}
