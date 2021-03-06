package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MazeMaked2665 {
	
	static class Node {
		int w,r,c;
		
		public Node(int w, int r, int c) {
			this.w  = w;
			this.r =  r;
			this.c = c;
		}
	}
	static int N;
	static int[][] matrix;
	static int[][] result;
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	static int INF = 987654321;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		matrix = new int[N][N];
		result = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String[] inputs = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				int inputNum = Integer.parseInt(inputs[j]);
				
				if (inputNum == 1) inputNum = 0;
				else inputNum = 1;
				
				matrix[i][j] = inputNum;
			}
		}
		
		dijkstra();
		
		bw.write(result[N-1][N-1] + "");
		bw.close();
		br.close();
		
		
	}
	
	static void dijkstra() {
		
		for (int i = 0; i < N*N; i++) {
			result[i/N][i%N] = INF;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				
				if (n1.w > n2.w) return -1;
				else if (n2.w > n1.w) return 1;
				else return 0;
			}
		});
		
		pq.offer(new Node(0,0,0));
		result[0][0] = 0;
		
		while(!pq.isEmpty()) {
			int curW = pq.peek().w;
			int curR = pq.peek().r;
			int curC = pq.peek().c;
			
			pq.poll();
			
			if (result[curR][curC] < curW) continue;
			
			for (int i = 0; i < 4; i++) {
				int nextR = curR + dr[i];
				int nextC = curC + dc[i];
				
				if (nextR >= 0 && nextC >= 0 && nextR < N && nextC < N) {
					if (result[nextR][nextC] > curW + matrix[nextR][nextC]) {
						result[nextR][nextC] = curW + matrix[nextR][nextC];
						pq.offer(new Node(result[nextR][nextC] ,nextR,nextC));
					}
				}
				
			}
			
		}
		
	}

}
