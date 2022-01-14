package com.test.algorithm;

import java.io.*;

public class TestMain
{
	static int N,M;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		String[] colRow = br.readLine().split(" ");
		N = Integer.parseInt(colRow[0]);
		M = Integer.parseInt(colRow[1]);
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
		    String[] inputs = br.readLine().split(" ");
		    
		    for (int j = 0; j < M; j++) {
		        map[i][j] = Integer.parseInt(inputs[j]);
		    }
		}//for
		
		dfs(0,0);
		
	}
	
	//dfs 알고리즘
	static void dfs(int cnt,int index) {
	    
	    //벽 3개를 세웠으면 중지.
	    if (cnt == 3) {
	        printMap();
	        return;
	    }

	    for (int i = 0; i < N*M; i++) {
	    	if (map[i/M][i%M] == 0) {
	    		map[i/M][i%M] = 2;
	    		dfs(cnt+1,i);
	    		map[i/M][i%M] = 0;
	    	}
	    }

	    
	}
	
	//map 표시
	static void printMap() {
	    System.out.println("=========================");
	        
	   for (int i = 0; i < N; i++) {
	       for (int j = 0; j < M; j++) {
	           System.out.print(map[i][j] + " ");
	       }
	       System.out.println();
	    }
	}
}