package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FoodVoid1743 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] inputs = br.readLine().split(" ");
		
		int r = Integer.parseInt(inputs[0]);//row
		int c = Integer.parseInt(inputs[1]);//column
		int count = Integer.parseInt(inputs[2]);//개수
		
		String[][] matrix = new String[r+2][c+2];
		
		//배열 초기화
		for (int i = 0; i < r+2 ; i++) {
			for (int j= 0; j < c+2; j++) {
				matrix[i][j] = ".";
			}
		}
		

		for (int i = 0; i < r+2; i++) {
			for (int j = 0; j < c+2; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		
		
		//dfs();
		
		
		
		
	}

	private static void dfs() {
		//깊이탐색
	}
	
	
}
