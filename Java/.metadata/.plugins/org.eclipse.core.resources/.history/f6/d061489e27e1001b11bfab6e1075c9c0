package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MaxOfIsland4963 {
	static int[][] arr;
	static int col, row;
	static int IslandCount = 0;
	
	static void search(int c, int r) {
		int[] ax = {1,1,0,-1,-1,-1,0,1}; 
		int[] ay = {0,1,1,1,0,-1,-1,-1};
		
		arr[c][r] = 0; 	
		
		for (int i = 0; i < 8; i++) {
			int dx = c + ax[i];
			int dy = r + ay[i];
			
			if (arr[dx][dy] == 1) {
				search(dx,dy);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean loop = true;
		
		while(loop) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			col = Integer.parseInt(stk.nextToken());
			row = Integer.parseInt(stk.nextToken());
			
			if (col == 0 && row == 0) {
				loop = false;
				break;
			} else {
				arr = new int[row + 2][col + 2];
				
				for (int i = 1; i <= row; i++) {
					String[] input = br.readLine().split(" ");
					for (int j = 1; j <= col; j++) {
						arr[i][j] = Integer.parseInt(input[j-1]);
					}
				}
				
				for (int i = 1; i <= row; i++) {
					for (int j = 1; j <= col; j++) {
						if (arr[i][j] == 1) {
							IslandCount++;
							search(i,j);
						}
					}
				}		
			}
			bw.write(IslandCount + "\n");
			IslandCount = 0;
		}
		
		bw.flush();
		bw.close();
		
	}
}