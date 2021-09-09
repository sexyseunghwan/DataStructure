package com.test.algorithm;

import java.io.*;
import java.util.*;


public class ConnectedComponent11724 {
    
	static int N,M;
    static boolean[] visit;
    static int[][] adjacentMatirx;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);
		
		
		visit = new boolean[N];
		adjacentMatirx = new int[N][2];
		int cnt = 0;//최종 카운트
		
		
		for (int i = 0; i < M; i++) {
		    String[] lines = br.readLine().split(" ");
		    int x = Integer.parseInt(lines[0]);
		    int y = Integer.parseInt(lines[1]);

		    adjacentMatirx[x-1][y-1] = 1;
		    adjacentMatirx[y-1][x-1] = 1;
		}
		
		for (int i = 0; i < N; i++) {
			if(!visit[i]) {
				cnt++;
				dfs(i);
			}
		}
		
		bw.write(cnt+"");
		br.close();
		bw.close();
		
	}
	
	
	public static void dfs(int num) {
		
		visit[num] = true;
		
		for (int i = 0; i < N; i++ ) {
			if (adjacentMatirx[num][i] == 1 && (!visit[i])) {
				dfs(i);
			}
		}
		
		
	}
	
}


