package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Snail1913 {
	
	
	/*
	 문제
	홀수인 자연수 N(3≤N≤999)이 주어지면, 
	다음과 같이 1부터 N2까지의 자연수를 달팽이 모양으로 N*N의 표에 늘어놓을 수 있다.

	9	2	3
	8	1	4
	7	6	5
	25	10	11	12	13
	24	9	2	3	14
	23	8	1	4	15
	22	7	6	5	16
	21	20	19	18	17
	N이 주어졌을 때, 이러한 표를 출력하는 프로그램을 작성하시오. 
	또한 N2 이하의 자연수가 하나 주어졌을 때, 그 좌표도 함께 출력하시오. 
	예를 들어 N=5인 경우 6의 좌표는 (4,3)이다.

	입력
	첫째 줄에 홀수인 자연수 N이 주어진다. 
	둘째 줄에는 위치를 찾고자 하는 N2 이하의 자연수가 하나 주어진다.

	출력
	N개의 줄에 걸쳐 표를 출력한다. 각 줄에 N개의 자연수를 한 칸씩 띄어서 출력하면 되며, 
	자릿수를 맞출 필요가 없다. 
	N+1번째 줄에는 입력받은 자연수의 좌표를 나타내는 두 정수를 한 칸 띄어서 출력한다.

	예제 입력 1 
	7
	35
	
	예제 출력 1 
	49 26 27 28 29 30 31
	48 25 10 11 12 13 32
	47 24 9 2 3 14 33
	46 23 8 1 4 15 34
	45 22 7 6 5 16 35
	44 21 20 19 18 17 36
	43 42 41 40 39 38 37
	5 7

	 * */
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int N = Integer.parseInt(br.readLine());
		int wonderNum = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N+2][N+2];
		
		int row = 1;
		int col = 1;
		int number = N*N - 1;
		
		int[] prow = {1,0,-1,0};
		int[] pcol = {0,1,0,-1};
		int flag = 0;
		
		int fRow = 1;
		int fCol = 1;
		
		arr[1][1] = N*N;
		
		for (int i = 1; i < N*N; i++) {
			if(arr[row + prow[flag%4]][col + pcol[flag%4]] != 0
			   || (row + prow[flag%4] > N || row + prow[flag%4] < 1)
			   || (col + pcol[flag%4] > N || col + pcol[flag%4] < 1)) {
				   flag++;
				   row += prow[flag%4];
				   col += pcol[flag%4];
				   arr[row][col] = number;
				   if (number == wonderNum) {
					   fRow = row;
					   fCol = col;
				   }
				   number--;
			   } else {
				   row += prow[flag%4];
				   col += pcol[flag%4];
					if (number == wonderNum) {
						   fRow = row;
						   fCol = col;
					}
				   arr[row][col] = number;
				   number--;
			   }
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				bw.write(arr[i][j] + " ");
			}
			bw.write("\n");
		}
		
		
		bw.write(fRow + " ");
		bw.write(fCol + " ");
		
		bw.close();

	}
}
