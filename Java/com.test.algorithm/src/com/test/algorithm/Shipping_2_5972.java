package com.test.algorithm;

import java.io.*;
import java.util.*;


public class Shipping_2_5972 {
	
	static class Node implements Comparable<Node> {
		int v,d;
		
		public Node (int v, int d) {
			this.v = v;
			this.d = d;
		}
		
		@Override
        public int compareTo(Node o) {
            if (this.d < o.d) {
                return -1;
            }
            return 1;
        }
		
	}
	
	static int N,M;
	static int INF = Integer.MAX_VALUE;
	static ArrayList<ArrayList<Node>>  map;
	static int[] visited = new int[50002];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stk = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		
		map = new ArrayList<>();
		
		for (int i = 0; i <= N; i++) {
			map.add(new ArrayList<Node>());
		}
		
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine()," ");
			
			int u = Integer.parseInt(stk.nextToken());
			int v = Integer.parseInt(stk.nextToken());
			int w = Integer.parseInt(stk.nextToken());
			
			map.get(u).add(new Node(v,w));
			map.get(v).add(new Node(u,w));	
		}
		
		Arrays.fill(visited, INF);
		
		dijkstra();
		
		bw.write(visited[N] + "");
		bw.close();
		br.close();
		
	}
	
	
	static void dijkstra() {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.offer(new Node(1,0));
		visited[1] = 0;
		
		while(!pq.isEmpty()) {
			int cur_v = pq.peek().v;
			int cur_d = pq.peek().d;
			
			pq.poll();
			
			if (visited[cur_v] < cur_d) continue;
			
			for (int i = 0; i < map.get(cur_v).size(); i++) {
				int next_v = map.get(cur_v).get(i).v;
				int next_d = map.get(cur_v).get(i).d;
				
				if (visited[next_v] > cur_d + next_d) {
					visited[next_v] = cur_d + next_d;
					pq.offer(new Node(next_v, visited[next_v]));
				}
			}
		}
	}
}
