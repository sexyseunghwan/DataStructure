package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class TestPagerest {
	
	static int T,W;
	static int[][][] dp;
	static int[] input;
	static int maxCount;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(stk.nextToken());
		W = Integer.parseInt(stk.nextToken());
		
		input = new int[T+1];
		dp = new int[3][T+1][W+2];
		
		for (int i = 1; i <= T; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		
		for (int i = 1; i <= T; i++) {
			for (int j = 1; j <= W+1; j++) {
				
				if (input[i] == 1) {
					dp[1][i][j] = Math.max(dp[1][i-1][j] + 1, dp[2][i-1][j-1] + 1);
					dp[2][i][j] = Math.max(dp[1][i-1][j-1], dp[2][i-1][j]);
				} else {
					if (i == 1 && j == 1) continue;
					
					dp[1][i][j] = Math.max(dp[1][i-1][j], dp[2][i-1][j-1]);
					dp[2][i][j] = Math.max(dp[1][i-1][j-1] + 1, dp[2][i-1][j] + 1);
				}
			}
		}
		
		for (int i = 1; i <= W+1; i++) maxCount = Math.max(dp[1][T][i], dp[2][T][i]);
		
		bw.write(maxCount + "");
		bw.close();
		br.close();
		
	}
}
