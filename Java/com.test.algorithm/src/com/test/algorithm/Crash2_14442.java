package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Crash2_14442 {
	
	static int N,M,R;
	static int[][] map;
	static boolean[][][] visit;
	static int[] dr = {0,0,-1,1};
	static int[] dc = {1,-1,0,0};
	
	static class Nods {
		int r,c,step,crash;
		
		public Nods(int r, int c, int step,int crash) {
			this.r = r;
			this.c = c;
			this.step = step;
			this.crash = crash;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);
		R = Integer.parseInt(inputs[2]);
		
		map = new int[N][M];
		visit = new boolean[N][M][R+1];
		
		for (int i = 0; i < N; i++) {
			String[] puts = br.readLine().split("");
 			for (int j= 0 ;j < M; j++) {
				map[i][j] = Integer.parseInt(puts[j]);
			}
		}

		int result = bfs();
		
		bw.write(result + "");
		bw.close();
		br.close();
	}
	
	static int bfs() {
		
		Nods nd = new Nods(0,0,1,0);
		Queue<Nods> queue = new ArrayDeque<>(); 
		visit[0][0][0] = true;
		queue.offer(nd);
		
		
		while(!queue.isEmpty()) {
			
			Nods ns = queue.poll();
			
			if (ns.r == N-1 && ns.c == M-1) {
				return ns.step;
			}
			
			for (int i  = 0; i < 4; i++) {
				int nr = ns.r + dr[i];
				int nc = ns.c + dc[i];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= M ) continue;
				
				if (map[nr][nc] == 0 && !visit[nr][nc][ns.crash]) {
					queue.offer(new Nods(nr,nc,ns.step + 1,ns.crash));
					visit[nr][nc][ns.crash] = true;
				} 
				
			   if (map[nr][nc] == 1 &&  ns.crash < R && !visit[nr][nc][ns.crash+1]) {
				   queue.offer(new Nods(nr,nc,ns.step + 1,ns.crash + 1));
				   visit[nr][nc][ns.crash + 1] = true;
			   }	
			}	 
		}
		
		return -1;
	}
}
