package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Maze2178_1 {
	
	static int N,M;
	static int[][] matrix;
	static int[][] visit;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static Queue<Node> queue = new LinkedList<>();
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);
		
		matrix = new int[N][M];
		visit = new int [N][M];
		
		for (int i = 0; i < N; i++) {
			String[] numInputs = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				matrix[i][j] = Integer.parseInt(numInputs[j]);//?
			}
		}
		
		Node node = new Node(0,0,1);
		queue.offer(node);
		visit[0][0] = 1;
		
		while(!queue.isEmpty()) {
			Node nodes = queue.poll();
	
			if (nodes.x == N-1 && nodes.y == M-1) {
				bw.write(nodes.count + "");
				bw.close();
				br.close();
				break;
			}
			
			bfs(nodes.x,nodes.y,nodes.count);
			
		}//while
	
		
	}
	
	static void bfs(int x,int y,int count) {
		
		for (int i = 0; i < 4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			
			if (newY < 0 || newX < 0 || newX >= N || newY >= M || matrix[newX][newY] == 0 || visit[newX][newY] == 1) continue;
			
			visit[newX][newY] = 1;
			Node node = new Node(newX,newY,count+1);
			queue.offer(node);
		}
	}
	
	static class Node {
		public int x;
		public int y;
		public int count;
		
		public Node(int x,int y,int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
}
