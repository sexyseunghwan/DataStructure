package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Algospot1261 {
	
	static int N,M;
	static int INF = Integer.MAX_VALUE;
	static int[][] map;
	static int[][] visit;
	static int[] dr = {0,0,-1,1};
	static int[] dc = {1,-1,0,0};
	
	
	static class Node {
		int r,c,crash;
		
		public Node (int r, int c, int crash) {
			this.r = r;
			this.c = c;
			this.crash = crash;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stk = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		
		map = new int[M][N];
		visit = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			String[]  inputs = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(inputs[j]);
				visit[i][j] = INF;
			}
		}
		
		dijkstra();
		
		bw.write(visit[M-1][N-1] + "");
		bw.close();
		br.close();
	}
	
	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				
				if (n1.crash > n2.crash) return 1;
				else if (n2.crash > n1.crash) return -1;
				else return 0;
			}
		});
		
		pq.offer(new Node(0,0,0));
		visit[0][0] = 0;
		
		while(!pq.isEmpty()) {
			int curR = pq.peek().r;
			int curC = pq.peek().c;
			int curCrash = pq.peek().crash;
			
			pq.poll();
			
			for (int i = 0; i < 4; i++) {
				int newR = curR + dr[i];
				int newC = curC + dc[i];
				
				if (newR >= 0 && newC >= 0 && newR < M && newC < N) {
					if (visit[newR][newC] > curCrash + map[newR][newC]) {
						visit[newR][newC] = curCrash + map[newR][newC];
						pq.offer(new Node(newR,newC,visit[newR][newC] ));
					}
				}
			}	
		}
	}
}
