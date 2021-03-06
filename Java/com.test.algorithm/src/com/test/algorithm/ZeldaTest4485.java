package com.test.algorithm;

import java.io.*;
import java.util.*;

public class ZeldaTest4485
{   
    static int N;
    static int INF = Integer.MAX_VALUE;
    static int CASE = 1;
    static int[][] vertex;
    static int[][] dist;
    static int[] dr = {0,0,-1,1};
    static int[] dc = {1,-1,0,0};
    
    static class Node {
        int r,c,dist;
        
        public Node(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	    while(true) {
	        N = Integer.parseInt(br.readLine());
	        
	        if (N == 0) break;
	        
	        vertex = new int[N][N];
	        dist = new int[N][N];
	        
	        for (int i = 0; i < N; i++) {
	            String[] inputs = br.readLine().split(" ");
	            for (int j = 0; j < N; j++) {
	                vertex[i][j] = Integer.parseInt(inputs[j]);
	            }
	        }
	        
	        initial();
	        dijkstra();
	        answer();
	    }
	    br.close();
	}
	
	static void dijkstra() {
	    PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				
				if (n1.dist > n2.dist) return -1;
				else if (n2.dist > n1.dist) return 1;
				else return 0;
			}
		});
		
		dist[0][0] = vertex[0][0];
		pq.offer(new Node(0,0,-dist[0][0]));
		
		while(!pq.isEmpty()) {
		    Node nd = pq.poll();
		    
		    int curR = nd.r;
		    int curC = nd.c;
		    int curDist = -nd.dist;
		    
		    for (int i = 0; i < 4; i++) {
		        int newR = curR + dr[i];
		        int newC = curC + dc[i];
		        
		        if (newR >= 0 && newC >= 0 && newR < N && newC < N) {
		            if (dist[newR][newC] > curDist + vertex[newR][newC]) {
		                dist[newR][newC] = curDist + vertex[newR][newC];
		                pq.offer(new Node(newR,newC, -dist[newR][newC]));
		            }
		        }
		    }
		}//while
	}
	
	static void answer() {
	    System.out.printf("Problem %d: %d\n",CASE++, dist[N-1][N-1]);
	}
	
	static void initial() {
	    for (int i = 0; i < N*N; i++) {
	        dist[i/N][i%N] = INF;
	    }
	}
}


