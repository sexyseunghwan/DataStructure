package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Laboratory_14502_3 {
	
	static int[][] map;
	static int N,M;
	static int maxCount = 0;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] inputs = br.readLine().split(" ");
		
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);
		
		map = new int[N][M];//지도 초기화
		
		//지도내에 벽,공백,바이러스 넣어주기
		for (int i = 0; i < N; i++) {
			String[] vals = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(vals[j]);
			}
		}
		
		dfs(0,0);
		
		bw.write(maxCount + "");
		bw.close();
		br.close();
		
	}
	
	static void dfs(int cnt, int index) {
		
		if (cnt == 3) {
			bfs();
			return;
		}
		
		for (int i = index; i < N*M; i++) {
			if (map[i/M][i%M] == 0) {
				map[i/M][i%M] = 1;
				dfs(cnt+1,i);
				map[i/M][i%M] = 0;
			}
		}
		
	}
	
	static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		int[][] virusMap = new int[N][M];//map 행렬 복사
		
		
		for (int i = 0; i < N*M; i++) {
			virusMap[i/M][i%M] = map[i/M][i%M];
			if (virusMap[i/M][i%M] == 2) {
				int[] cor = {i/M,i%M};
				queue.offer(cor);
			}
		}
		
		while(!queue.isEmpty()) {
			int[] pair = queue.poll();
			int x = pair[0];
			int y = pair[1];
			
			for (int i = 0; i < 4; i++) {
				int newX = x + dx[i];
				int newY = y + dy[i];
				
				if (newX >= 0 && newY >= 0 && newX < N && newY < M && virusMap[newX][newY] == 0) {
					virusMap[newX][newY] = 2;
					queue.offer(new int[]{newX,newY});
				}
			}
		}
		
		int count = 0;
		
		for (int i = 0; i < N*M; i++) {
			if(virusMap[i/M][i%M] == 0) count++;
		}
		
		maxCount = Math.max(maxCount, count);
		
	}
	
	
	
	
}
