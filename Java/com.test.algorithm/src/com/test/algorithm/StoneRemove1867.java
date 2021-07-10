package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class StoneRemove1867 {
	
	
	/*
	 문제
	n행 n열의 격자로 나뉜 운동장이 있다. 
	이 위에 k개의 돌멩이가 있는데, 하나의 돌멩이는 격자 한 칸에 정확히 들어가 있으며, 
	두 개 이상의 돌멩이가 한 칸에 들어가 있는 경우는 없다.

	사고의 위험을 없애기 위해 이 돌멩이를 모두 제거하고 깨끗한 운동장을 만들려고 한다. 
	돌멩이를 제거할 때에는, 한 행이나 한 열을 따라 직선으로 달려가면서 그 행이나 열에 놓인 돌멩이를 모두 줍는 방식을 쓴다.

	여러분이 할 일은 운동장의 상태가 주어졌을 때 최소 몇 번이나 달려가야 돌멩이 줍기를 끝낼 수 있는지 계산하는 것이다.

	입력
	첫째 줄에 n과 k가 주어진다. (1 ≤ n ≤ 500, 1 ≤ k ≤ 10,000) 
	이후 k개의 줄에는 돌멩이의 위치가 한 줄에 하나씩 주어진다. 
	줄마다 첫 번째 숫자는 행 번호, 두 번째 숫자는 열 번호를 나타낸다.

	출력
	첫 줄에 몇 번의 달리기를 통해 돌멩이를 주울 수 있는지 출력한다.

	예제 입력 1 
	3 4
	1 1
	1 3
	2 2
	3 2
	예제 출력 1 
	2
	힌트
	돌멩이가 있는 곳은 X, 없는 곳은 _으로 표현하면 입력은 다음과 같다.

	X _ X
	_ X _
	_ X _

	1행을 따라 달리며 (1,1), (1,3)에 위치한 돌멩이를 줍는다. 
	2열을 따라 달리며 (2,2), (3,2)에 위치한 돌멩이를 줍는다. 
	두 번의 달리기로 작업을 완료할 수 있다.
	  
	  
	  
	 *
	 * */
	static int n, k, runCount;
	static int[][] matrix;
	static int[] visit;

	static void check(int r, int c) {
		if (visit[c] != 0) {
			int temp = visit[c];
			visit[c] = r;

		} else {
			visit[c] = r;
			matrix[r][c] = 0;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer stk = new StringTokenizer(br.readLine());

		n = Integer.parseInt(stk.nextToken());
		k = Integer.parseInt(stk.nextToken());

		matrix = new int[n + 1][n + 1];
		visit = new int[n + 1];

		for (int i = 0; i < k; i++) {
			StringTokenizer stk2 = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(stk.nextToken());
			int col = Integer.parseInt(stk.nextToken());
			matrix[row][col] = 1;
		}
	}
}
