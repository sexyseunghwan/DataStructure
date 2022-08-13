package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class GreedyPandas1937 {
	
	static int N,maxCount;
	static int[][] matrix;
	static int[][] dp;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		matrix = new int[N][N];
		dp = new int[N][N];
		
		
		for (int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		for (int i = 0; i < N*N; i++) {
			maxCount = Math.max(maxCount, dynamicPro(i/N, i%N));
		}
		
		bw.write(maxCount + "");
		br.close();
		bw.close();
		
	}
	
	static int dynamicPro(int r, int c) {
		
		if (dp[r][c] != 0 ) return dp[r][c]; 
		dp[r][c] = 1;
		
		for (int i = 0; i < 4; i++) {
			int newR = r + dr[i];
			int newC = c + dc[i];
			
			if (newR >= 0 && newC >= 0 && newR < N && newC < N && matrix[newR][newC] > matrix[r][c]) {
				dp[r][c] = Math.max(dp[r][c],dynamicPro(newR,newC) + 1);
			}
		}
		
		return dp[r][c];
		
	}

}
