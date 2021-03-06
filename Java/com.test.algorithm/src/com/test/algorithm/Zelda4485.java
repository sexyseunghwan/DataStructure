package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Zelda4485 {
	
	static int[][] map;
	static int[][] visit;
	static int[] dr = {0,0,-1,1};
	static int[] dc = {1,-1,0,0};
	static int INF = 999999999;
	
	static class Node {
		int dist,r,c;
		
		public Node(int dist, int r, int c) {
			this.dist = dist;
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int count = 1;
		
		while(true) {
			int size = Integer.parseInt(br.readLine());
			
			if (size == 0) break;
			
			map = new int[size][size];
			visit = new int[size][size];
			
			for (int i = 0; i < size; i++) {
				String[] lists = br.readLine().split(" ");
				for (int j = 0; j < size; j++) {
					map[i][j] = Integer.parseInt(lists[j]);
				}
			}
			
			for (int i = 0; i < size*size; i++) visit[i/size][i%size] = INF;
			
			dijsktra(size);
			
			sb.append("Problem " + count + ": " + visit[size-1][size-1]);
			sb.append("\n");
			
			count++;
		}
		
		bw.write(sb.toString() + "");
		bw.close();
		br.close();
	}
	
	static void dijsktra(int size) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				
				if (n1.dist > n2.dist) return -1;
				else if (n2.dist > n1.dist) return 1;
				else return 0;
			}
		});
		
		visit[0][0] = -map[0][0];
		pq.offer(new Node(-map[0][0],0,0));
		
		while(!pq.isEmpty()) {
			Node nd = pq.poll();
			int dist = -nd.dist;
			int r = nd.r;
			int c = nd.c;
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (nr >= 0 && nc >= 0 && nr < size && nc < size) {
					if (visit[nr][nc] > dist + map[nr][nc]) {
						visit[nr][nc] =  dist + map[nr][nc];
						pq.offer(new Node(-visit[nr][nc],nr,nc));
					}
				}
			}
		}//while
	}
}


