package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Party1238 {
	
	static class Node {
		int e,w;
		
		public Node(int e, int w) {
			this.e = e;
			this.w = w;
		}
	}
	
	static int N,M,X;
	static int[] visit;
	static int maxVal = Integer.MIN_VALUE;
	static int INF = Integer.MAX_VALUE;
	static ArrayList<ArrayList<Node>> map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stk = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		X = Integer.parseInt(stk.nextToken());
		
		map = new ArrayList<ArrayList<Node>>();
		visit = new int[N+1];
		
		for (int i = 0; i <= N; i++) {
			map.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			int s,e,w;
			StringTokenizer stks = new StringTokenizer(br.readLine()," ");
			
			s = Integer.parseInt(stks.nextToken());
			e = Integer.parseInt(stks.nextToken());
			w = Integer.parseInt(stks.nextToken());
			
			map.get(s).add(new Node(e,w));
		}
		
		for (int i = 1; i <= N; i++) {
			if (i != X) {
				int goDist = dijkstra(i,X);
				int returnDist = dijkstra(X,i);
				
				int totalDist = goDist + returnDist;
				
				maxVal = maxVal > totalDist ? maxVal : totalDist;
			}
		}
		
		
		bw.write(maxVal + "");
		bw.close();
		br.close();
		
		
	}
	
	static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				
				if (n1.w > n2.w) return 1;
				else if (n2.w > n1.w) return -1;
				else return 0;
			}
		});
		
		init();
		pq.offer(new Node(start,0));
		visit[start] = 0;
		
		while(!pq.isEmpty()) {
			int curP = pq.peek().e;
			int curW = pq.peek().w;
			
			pq.poll();
			
			if (visit[curP] < curW) continue;
			
			for (int i = 0; i < map.get(curP).size(); i++) {
				int newP = map.get(curP).get(i).e;
				int newW = map.get(curP).get(i).w;
				
				if (visit[newP] > newW + curW) {
					visit[newP] = newW + curW;
					pq.offer(new Node(newP,visit[newP]));
				}
			}
		}
		
		return visit[end];
		
	}
	
	static void init() {
		for (int i = 1; i <= N; i++) {
			visit[i] = INF;
		}
	}

}
