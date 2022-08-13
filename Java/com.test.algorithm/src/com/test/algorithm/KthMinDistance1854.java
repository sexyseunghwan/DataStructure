package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import com.test.algorithm.Shipping_2_5972.Node;

public class KthMinDistance1854 {
	
	static class Node implements Comparable<Node> {
		
		int v,d;
		
		public Node(int v, int d) {
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
	
	static int N,M,K;
	static ArrayList<ArrayList<Node>> map;
	static PriorityQueue<Integer>[] pqi;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stk = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());
		
		map = new ArrayList<ArrayList<Node>>();
		pqi = new PriorityQueue[N+1];
		
		for (int i = 0; i <= N; i++) {
			map.add(new ArrayList<Node>());
			pqi[i] = new PriorityQueue<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine()," ");
			
			int u = Integer.parseInt(stk.nextToken());
			int v = Integer.parseInt(stk.nextToken());
			int d = Integer.parseInt(stk.nextToken());
			
			map.get(u).add(new Node(v,d));
		}
		
		dijkstra();
		
		for (int i = 1; i <=N; i++) {
			if (pqi[i].size() != K) System.out.println(-1);
			else System.out.println(-pqi[i].poll());
		}
	}
	
	static void dijkstra() {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pqi[1].add(0);
		pq.add(new Node(1,0));
		
		while(!pq.isEmpty()) {
			
			int cur_v = pq.peek().v;
			int cur_d = pq.peek().d;
			
			pq.poll();
			
			for (int i = 0; i < map.get(cur_v).size(); i++) {
				int new_v =  map.get(cur_v).get(i).v;
				int new_d =  map.get(cur_v).get(i).d + cur_d;
				
				if (pqi[new_v].size() < K) {
					pqi[new_v].add(-new_d);
					pq.offer(new Node(new_v,new_d));
				} else {
					if (-pqi[new_v].peek() > new_d) {
						pqi[new_v].poll();
						pqi[new_v].add(-new_d);
						pq.offer(new Node(new_v,new_d));
					}
				}
			}//for
		}//while
	}
	
}
