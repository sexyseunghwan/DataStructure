package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FastRoute1446 {
	
	static int N,D;
	static int  INF = Integer.MAX_VALUE;
	static int[] fastRoute;
	static ArrayList<Node> map[];
	
	static class Node  {
		int v,d;
		
		public Node(int v, int d) {
			this.v = v;
			this.d = d;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stk = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(stk.nextToken());
		D = Integer.parseInt(stk.nextToken());
		
		fastRoute = new int[D+1];
		map = new ArrayList[D+1];
		
		for (int i = 0; i <= D ;i++) {
			map[i] = new ArrayList<Node>();
		}
		
		for (int i = 0; i< N; i++) {
			stk = new StringTokenizer(br.readLine()," ");
			
			int s = Integer.parseInt(stk.nextToken());
			int e = Integer.parseInt(stk.nextToken());
			int dist = Integer.parseInt(stk.nextToken());
		
			if (e > D) continue;
			if (e - s < dist) continue;
			
			map[s].add(new Node(e,dist));
		}
		
		dq();
	
		
		bw.write(fastRoute[D] + "");
		bw.close();
		br.close();
		
	}
	
	static void dq() {
		for (int i = 0; i < D; i++) {
			fastRoute[i] = INF;
		}
		
		fastRoute[D] = D;
		
		for (int i = 0; i <= D; i++) {
			int prevDist;
			
			if (i==0) prevDist = -1;
			else prevDist =  fastRoute[i-1];
			
			fastRoute[i] = Math.min(fastRoute[i], prevDist+1);
			
			for (int j = 0; j < map[i].size(); j++) {
				int next = map[i].get(j).v;
				int nextDist = map[i].get(j).d;
				
				if ( fastRoute[next] > nextDist + fastRoute[i] ) {
					fastRoute[next] = nextDist + fastRoute[i];
				}
			}
		}
		
	}
	
}
