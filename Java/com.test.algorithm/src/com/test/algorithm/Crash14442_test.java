package com.test.algorithm;

import java.io.*;
import java.util.*;

public class Crash14442_test {
	
	static int N,M,C;
	static boolean[][][] visit;
	static int[][] map;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static class Nods {
		int r,c,step,crash;
		
		public Nods(int r, int c, int step, int crash) {
			this.r = r;
			this.c = c;
			this.step = step;
			this.crash = crash;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] rowCol = br.readLine().split(" ");
		N = Integer.parseInt(rowCol[0]);
		M = Integer.parseInt(rowCol[1]);
		C =  Integer.parseInt(rowCol[2]);
		
		map = new int[N][M];
		visit = new boolean[N][M][11];
		
		for (int i = 0; i < N; i++) {
			String[] inputs = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(inputs[j]);
			}
		}//for
		
		int result = bfs();
		
		bw.write(result + "");
		bw.close();
		br.close();
		
	}
	
	static int bfs() {
		Queue<Nods> queue = new ArrayDeque<>(); 
		queue.add(new Nods(0,0,1,0));
		visit[0][0][0] = true;
		
		while(!queue.isEmpty()) {
			Nods nd = queue.poll();
			
			if (nd.r == N-1 && nd.c == M-1) return nd.step;
			
			for (int i = 0; i < 4; i++) {
				int nr = nd.r + dr[i];
				int nc = nd.c + dc[i];
				
				if (nr <0 || nc <0 || nr >= N || nc >= M) continue;
				
				if (map[nr][nc] == 0 && !visit[nr][nc][nd.crash]) {
					queue.offer(new Nods(nr,nc,nd.step+1,nd.crash));
					visit[nr][nc][nd.crash] = true;
				}
				
				if (map[nr][nc] == 1 && nd.crash < C && !visit[nr][nc][nd.crash+1]) {
					queue.offer(new Nods(nr,nc,nd.step+1,nd.crash+1));
					visit[nr][nc][nd.crash+1] = true;
				}
				
			}//for
		}//while
		return -1;
	}
	
}
