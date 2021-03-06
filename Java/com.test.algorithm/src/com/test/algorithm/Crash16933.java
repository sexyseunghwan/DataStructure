package com.test.algorithm;

import java.io.*;
import java.util.*;

public class Crash16933 {
	
	static int N,M,C;
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	static int[][] map;
	static boolean[][][] visit;
	
	static class Node {
		int r,c,step,crash,day;
		
		public Node(int r,int c, int step, int crash, int day) {
			this.r = r;
			this.c = c;
			this.step = step;
			this.crash = crash;
			this.day = day;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] nmc = br.readLine().split(" ");
		N = Integer.parseInt(nmc[0]);
		M = Integer.parseInt(nmc[1]);
		C = Integer.parseInt(nmc[2]);
		
		map = new int[N][M];
		visit = new boolean[N][M][11];
	
		for (int i = 0; i < N; i++) {
			String[] rc = br.readLine().split("");
			for (int j = 0; j <M; j++) {
				map[i][j] = Integer.parseInt(rc[j]);
			}
		}
		
		int result = bfs();
		
		bw.write(result + "");
		bw.close();
		br.close();
		
		
	}
	
	static int bfs() {
		Queue<Node> queue = new ArrayDeque<>(); 
		queue.offer(new Node(0,0,1,0,1));
		visit[0][0][0] = true;
		
		while(!queue.isEmpty()) {
			Node nd = queue.poll();
			
			if (nd.r == N-1 && nd.c == M- 1) return nd.step;
			
			for (int i = 0; i < 4; i++) {
				int nr = nd.r + dr[i];
				int nc = nd.c + dc[i];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				
				if (map[nr][nc] == 0 && !visit[nr][nc][nd.crash]) {
					queue.offer(new Node(nr,nc,nd.step+1,nd.crash,-1*nd.day));
					visit[nr][nc][nd.crash] = true;
				}
				
				if (map[nr][nc] == 1 && nd.crash < C &&!visit[nr][nc][nd.crash+1]) {
					if (nd.day == 1) {
						queue.offer(new Node(nr,nc,nd.step+1,nd.crash+1,-1*nd.day));
						visit[nr][nc][nd.crash+1] = true;
					} else {
						queue.offer(new Node(nd.r,nd.c,nd.step+1,nd.crash,-1*nd.day));
					}
				}
			}
		}//while
		
		return -1;
	}
}
