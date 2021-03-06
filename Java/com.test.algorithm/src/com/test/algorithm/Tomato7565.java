package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Tomato7565 {
	
	static int N,M;
	static int[][] map;
	static int[][] visit;
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	static Queue<Node> queue = new ArrayDeque<>(); 
	
	static class Node {
		int r,c,day;
		
		public Node(int r,int c,int day) {
			this.r = r;
			this.c = c;
			this.day = day;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);
		
		map = new int[M][N];
		visit = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			String[] nums = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(nums[j]);
				map[i][j] = num;
				if (num == 1) queue.offer(new Node(i,j,0));
			}
		}//for
		
		int result = bfs();
		
		bw.write(result + "");
		bw.close();
		br.close();
		
	}
	
	static int bfs() {
		
		while(!queue.isEmpty()) {
			Node nd = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = nd.r + dr[i];
				int nc = nd.c + dc[i];
				
				if (nr < 0 || nc < 0 || nr >= M || nc >= N) continue;
				
				if (map[nr][nc] == 0) {
					queue.offer(new Node(nr,nc,nd.day+1));
					map[nr][nc] = 1;
					visit[nr][nc] = nd.day + 1;
				}
			}
		}//while
		
		int maxDay = Integer.MIN_VALUE;
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					return -1;
				}
				else {
					maxDay = visit[i][j] > maxDay ? visit[i][j] : maxDay;
				}
			}
		}
		
		return maxDay;
		
	}//bfs
}
