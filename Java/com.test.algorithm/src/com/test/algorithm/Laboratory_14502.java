package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Laboratory_14502 {
	
	static int[][] matrix;
	static int N,M;
	static int maxCount = 0;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	static class Virus {
		int x,y;
		
		Virus(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);
		
		matrix = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String[] col = br.readLine().split(" ");
			
			for (int j = 0; j < M; j++) {
				matrix[i][j] = Integer.parseInt(col[j]) ;
			}
		}
		
		dfs(0);
		
		bw.write(maxCount + "");
		bw.close();
		br.close();
	}
	
	
	static void dfs(int cnt) {
		
		if (cnt == 3) {
			bfs();
			return;
		}//if
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][j] = 1;
					dfs(cnt+1);
					matrix[i][j] = 0;
				}
			}
		}
	}//dfs
	
	static void bfs() {
		
		int[][] virusArr = new int[N][M];
		Queue<Virus> q = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				virusArr[i][j] = matrix[i][j];
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (virusArr[i][j] == 2) {
					q.offer(new Virus(i,j));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Virus virus = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int newX = virus.x + dx[i];
				int newY = virus.y + dy[i];
				
				if (newX >= 0 && newY >= 0 && newX < N && newY < M && virusArr[newX][newY] == 0) {
					virusArr[newX][newY] = 2;
					q.offer(new Virus(newX,newY));
				}
			}
			
		}//while
		
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (virusArr[i][j] == 0) count++;
			}
		}
		
		maxCount = Math.max(count, maxCount);
		
	}
	
	
	
	
}
