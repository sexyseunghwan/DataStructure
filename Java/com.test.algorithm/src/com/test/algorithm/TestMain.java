package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.util.LinkedList;

public class TestMain {
	
	static int N,M;
	static int[][] matrix;
	static int[][] visit;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static Queue<Node> queue = new LinkedList<>();
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);
		
		matrix = new int[N][M];
		visit = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				matrix[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		queue.offer(new Node(0,0));
		visit[0][0] = 1;
		
		while(!queue.isEmpty()) {
			Node nd = queue.poll();
			
			if (nd.x == N-1 && nd.y == M-1) {
				System.out.println(visit[N-1][M-1]);
				break;
			}
			
			bfs(nd);
		}
	}
	
	static void bfs(Node node) {
		
		for (int i = 0; i < 4; i++) {
			
			int newX = node.x + dx[i];
			int newY = node.y + dy[i];
			
			if (newY < 0 || newX < 0 || newY >= M || newX >= N || matrix[newX][newY] == 0 || visit[newX][newY] != 0) continue;
			
			queue.offer(new Node(newX,newY));
			visit[newX][newY] = visit[node.x][node.y] + 1;
			
		}
		
	}
	
	static class Node {
		public int x;
		public int y;
		
		public Node(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	
}
