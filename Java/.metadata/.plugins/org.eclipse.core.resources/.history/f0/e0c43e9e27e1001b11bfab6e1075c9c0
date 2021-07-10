package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class AvoidFood1743 {
	
	public static int[][] matrix;//이차행렬을 static 변수로 선언.
	public static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};//dfs 를 만들기 위한 방향키
	public static int row;
	public static int col;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] inputs = br.readLine().split(" ");
		
		row = Integer.parseInt(inputs[0]);//행 개수
		col = Integer.parseInt(inputs[1]);//열 개수
		int food = Integer.parseInt(inputs[2]);//음식 개수
		
		matrix = new int[row][col];//여기서 matrix 의 크기를 지정해준다.
		
		//음식물의 위치를 지정해준다.
		for (int i = 0; i < food; i++) {
			String[] coordinate = br.readLine().split(" "); 
			int xc = Integer.parseInt(coordinate[0]);
			int yc = Integer.parseInt(coordinate[1]);
			
			matrix[xc-1][yc-1] = 1;//음식물이 떨어진곳에 1을 넣어준다.
		}
		
		int maxSizeOfFood = 0;//가장큰 음식의 크기.
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int sizeOfFood = dfs(matrix,i,j,0);
				
				maxSizeOfFood = Math.max(maxSizeOfFood, sizeOfFood);
			}
		}
		
		bw.write(maxSizeOfFood + "");
		br.close();
		bw.close();
	}
	
	public static int dfs(int[][] matrix, int i,int j, int sizeOfFood) {
		
		
		if (i < 0 || i >= row || j < 0 || j >= col || matrix[i][j] == 0) {
			return sizeOfFood;
		}
		
		matrix[i][j] = 0;
		
		sizeOfFood++;
		
		for (int[] dirs : dir) {
			sizeOfFood = dfs(matrix, i + dirs[0], j + dirs[1], sizeOfFood);
		}
		
		return sizeOfFood;
	}

}
