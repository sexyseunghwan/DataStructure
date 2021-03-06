package com.test.algorithm;

import java.util.*;
import java.io.*;
import java.util.LinkedList;


public class Main
{  
   
    static Queue<Nods> queue = new LinkedList<>();
    static int N,M;
    static int[][] matrix;
    static int[][] visit;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
   
    public static void main(String[] args) throws Exception {
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    		String[] inputs = br.readLine().split(" ");
    		N = Integer.parseInt(inputs[0]);
    		M = Integer.parseInt(inputs[1]);

    		matrix = new int[N][M];
    		visit = new int[N][M];

    		for (int i = 0; i < N; i++) {
    				String[] rows = br.readLine().split("");
   
    				for(int j = 0; j < M; j++) {
    					matrix[i][j] = Integer.parseInt(rows[j]);
    				}
    		}//for

    		queue.offer(new Nods(0,0,1));
    		visit[0][0] = 1;
    		
    		while(!queue.isEmpty()) {
    			Nods node = queue.poll();
    			
    			if (node.x == N-1 && node.y == M-1) {
    				bw.write(node.count + "");
    				bw.close();
    				br.close();
    				break;
    			}
    			
    			bfs(node);
    		}
    
	}
 	//BFS 알고리즘
	static void bfs(Nods nods) {
		
		int x = nods.x;
		int y = nods.y;
		int count = nods.count;
		
		for (int i = 0; i < 4; i++) {
			int nX = x + dx[i];
			int nY = y + dy[i];
			
			if (nX < 0 || nY < 0 || nX >= N || nY >= M  || matrix[nX][nY] == 0 || visit[nX][nY] == 1) continue;
			
			visit[nX][nY] = 1;
			queue.offer(new Nods(nX,nY,count+1));
			
		}
	}
	
}

class Nods {
	public int x;
	public int y;
	public int count;

	public Nods(int x,int y,int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
}