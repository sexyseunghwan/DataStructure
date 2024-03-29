package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MatrixSeq11049 {
	
	static int N;
	static int MAX = Integer.MAX_VALUE;
	static int[][]  dp;
	
	static class Node {
		int r,c;
		
		Node(int r, int c)  {
			this.r = r;
			this.c = c;
		}
	}
	
	static Node[] Nodes;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		Nodes = new Node[N];
		dp = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken());
			
			Node node = new Node(r,c);
			
			Nodes[i] = node;
		}
		
		
		for (int i = 0; i < N-1; i++) {
			for (int j = 0; j < N-i-1; j++) {
				int k = j;
				int s = i+j+1;
				
				dp[k][s] = MAX;
				for (int u = k; u < s; u++) {
					dp[k][s] = Math.min(dp[k][s],dp[k][u] + dp[u+1][s] + bias(k,u,s));
				}
			}
		}
		
		bw.write(dp[0][N-1] + "");
		bw.close();
		br.close();
		
	}
	
	static int bias(int k, int u, int s) {
		return Nodes[k].r * Nodes[u].c * Nodes[s].c;
	}
}
