package com.test.algorithm;

import java.io.*;

public class SafetyArea2468 {

	static int input;
	static int[][] matrix;
	static int[][] flagMatrix;
	static int deep;// 물깊이
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		input = Integer.parseInt(br.readLine());

		matrix = new int[input][input];
		flagMatrix = new int[input][input];

		int minNum = Integer.MAX_VALUE;
		int maxNum = Integer.MIN_VALUE;
		int maxCount = 1;

		// 배열에 넣어주기 및 최대,최소값 정하기
		for (int i = 0; i < input; i++) {
			String[] nums = br.readLine().split(" ");
			for (int j = 0; j < input; j++) {
				int number = Integer.parseInt(nums[j]);

				matrix[i][j] = number;

				minNum = number < minNum ? number : minNum;
				maxNum = number > maxNum ? number : maxNum;
			}
		}//for

		for (int i = minNum; i <= maxNum; i++) {
			deep = i;// 깊이지정
			flagMatrix = new int[input][input];// 방문 배열초기화
			int count = 0;// 개수 초기화

			for (int j = 0; j < input; j++) {
				for (int s = 0; s < input; s++) {
					if (flagMatrix[j][s] == 0 && matrix[j][s] > deep) {
						dfs(j, s);
						count++;
					}
				}
			}

			maxCount = count > maxCount ? count : maxCount;

		}//for

		bw.write(maxCount + "");
		bw.close();
		br.close();
	}

	public static void dfs(int x, int y) {
		flagMatrix[x][y] = 1;// 방문

		for (int i = 0; i < 4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];

			if (newX < 0 || newY < 0 || newX >= input || newY >= input || matrix[newX][newY] <= deep
					|| flagMatrix[newX][newY] == 1) {
				continue;
			}

			dfs(newX, newY);
		}

	}

}
