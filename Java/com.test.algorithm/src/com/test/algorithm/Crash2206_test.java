package com.test.algorithm;

import java.io.*;
import java.util.*;

public class Crash2206_test {
	
	static int N,M;
	static int[][] map;
	static boolean[][][] visit;
	static int[] dr = {0,0,-1,1};
	static int[] dc = {1,-1,0,0};
	
	static class Node {
		int r,c,step,crush;
		
		public Node(int r,int c,int step,int crush) {
			this.r = r;
			this.c = c;
			this.step = step;
			this.crush = crush;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] inputs = br.readLine().split(" ");
		
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);
		
		map = new int[N][M];
		visit = new boolean[N][M][3];
		
		for (int i = 0; i < N; i++) {
			String[] cols = br.readLine().split(""); 
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(cols[j]);
			}
		}
		
		int result = bfs();
		
		bw.write(result + "");
		bw.close();
		br.close();
		
	}
	
	
	static int bfs() {
		
		Queue<Node> queue = new ArrayDeque<>(); 
		visit[0][0][0] = true;
		queue.offer(new Node(0,0,1,0));
		
		while(!queue.isEmpty()) {
			Node nod = queue.poll();

			if (nod.r == N-1 && nod.c == M-1) {
				return nod.step;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = nod.r + dr[i];
				int nc = nod.c + dc[i];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				
				//벽이 없는 경우
				if (map[nr][nc] == 0 && !visit[nr][nc][nod.crush] ) {
					queue.offer(new Node(nr,nc,nod.step+1,nod.crush));
					visit[nr][nc][nod.crush] = true;
				} 
				
				if (map[nr][nc] == 1 && nod.crush < 1 && !visit[nr][nc][nod.crush+1]) {
					queue.offer(new Node(nr,nc,nod.step+1,nod.crush+1));
					visit[nr][nc][nod.crush+1] = true;
				}
				
			}			
		}//while
		
		return -1;
	}
	
}
