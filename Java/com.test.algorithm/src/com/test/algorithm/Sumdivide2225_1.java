package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Sumdivide2225_1 {
	
	static int N,K;
	static long DIV = 1000000000;
	static long[][] mat;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());
		
		mat = new long[K+1][N+1];
		
		for (int i = 0; i <= K; i++) mat[i][0] = 1;
		for (int i = 0; i <= N; i++) mat[1][i] = 1;
		
		
		for (int i = 2; i <= K; i++) {
			for (int j = 1; j <= N; j++) {
				
				long sumVal = 0;
				
				for (int k = 0; k <= j; k++) {
					sumVal += mat[i-1][k];
				}
				
				mat[i][j] = sumVal % DIV;
 			}
		}
		
		
		bw.write(mat[K][N] + "");
		bw.close();
		br.close();
		
	}
	
	static int dp(int r, int c) {
		
		
		
		return 0;
	}
}
