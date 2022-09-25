package com.test.algorithm;

import java.io.*;
import java.util.*;

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
		
		
		
		for (int i = 1; i <= K; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 0; k <= j; k++) mat[i][j] += mat[i-1][k]; 
				
				mat[i][j] %= DIV;
 			}
		}
		
		
		bw.write(mat[K][N] + "");
		bw.close();
		br.close();
		
	}
}
