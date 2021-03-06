package com.test.algorithm;

import java.util.*;
import java.io.*;
import java.util.LinkedList;


public class Main2
{  
   
    static Queue<int[]> queue = new LinkedList<>();
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
    		
    		int[] arr = {0,0};
    		queue.offer(arr);
    		visit[0][0] = 1;
    		
    		while(!queue.isEmpty()) {
    			int[] arrs = queue.poll();
    			
    			if (arrs[0] == N-1 && arrs[1] == M-1) {
    				bw.write(visit[N-1][M-1] + "");
    				bw.close();
    				br.close();
    				break;
    			}
    			
    			bfs(arrs);
    		}
    
	}
 	//BFS 알고리즘
	static void bfs(int[] arr) {
		int x = arr[0];
		int y = arr[1];
		
		for (int i = 0; i < 4; i++) {
			int nX = x + dx[i];
			int nY = y + dy[i];
			
			if (nX < 0 || nY < 0 || nX >= N || nY >= M  || matrix[nX][nY] == 0 || visit[nX][nY] != 0) continue;
			
			visit[nX][nY] = visit[x][y] + 1;
			int[] newArr = {nX,nY};
			queue.offer(newArr);
			
		}
	}
}
