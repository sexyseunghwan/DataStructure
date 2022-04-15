package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import com.test.algorithm.TestTestTest.Node;

public class ZeldaReview {
	
	static int N;
	static int[][] map;
	static int[][] visit;
	static int[] dr = {0,0,-1,1};
	static int[] dc = {1,-1,0,0};
	static int COUNT = 1;
	static int INF = Integer.MAX_VALUE;
	
	static class Node {
		int w,r,c;
		
		public Node(int w, int r, int c) {
			this.w = w;
			this.r = r;
			this.c = c;
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
		
		pq.offer(new Node(map[0][0],0,0));
		visit[0][0] = map[0][0];
		
		while(!pq.isEmpty()) {
			int curW = pq.peek().w;
			int curR = pq.peek().r;
			int curC = pq.peek().c;
			
			pq.poll();
			
			for (int i = 0; i < 4; i++) {
				int newR = curR + dr[i];
				int newC = curC + dc[i];
				
				if (newR >= 0 && newC >=0 && newR < N && newC < N) {
					if (visit[newR][newC] > curW + map[newR][newC]) {
						visit[newR][newC] = curW + map[newR][newC];
						pq.offer(new Node(visit[newR][newC],newR,newC));
					}
				}
			}
		}
	
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();	
		
		while(true) {
			N = Integer.parseInt(br.readLine());
			
			if (N == 0) break;
			
			map = new int[N][N];
			visit = new int[N][N];
			
			for (int i = 0; i <N*N; i++) {
				visit[i/N][i%N] = INF;
			}
			
			for (int i = 0; i < N; i++) {
				int j = 0; 
				StringTokenizer stk = new StringTokenizer(br.readLine()," ");
				
				while(stk.hasMoreTokens()) {
					map[i][j++] = Integer.parseInt(stk.nextToken());
				}
			}
			
			dijkstra();
			
			//System.out.println(visit[N-1][N-1]);
			String answer = String.format("Problem %d: %d\n", COUNT++,visit[N-1][N-1]);
			sb.append(answer);
			
		}
			
		bw.write(sb.toString() + "");
		bw.close();
		br.close();
			
		
	}

}
