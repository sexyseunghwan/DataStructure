package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Blind2799 {
	
	
	/*
	 
	  
	  
	  문제
	봄이 오고 있다. 해는 높이 떠서 환하게 빛나고 있다. 사람들은 햇볕을 가리기 위해 블라인드를 내린다.

	상근이는 이웃들이 무엇을 하는지를 염탐하고, 이것에 대해서 뒷담화를 하는 주부이다. 올해는 건너편 아파트에 사는 사람들이 블라인드를 얼마나 내리는지를 조사하려고 한다. 

	모든 창문은 4*4 그리드로 나타낼 수 있고, *를 이용해서 블라인드를 나타낸다. 상근이가 볼 수 있는 창문은 다음 5가지 상태 중 하나이다.



	건너편 아파트의 한 층에는 N개의 창문이 있고, 총 M층 건물이다. 현재 건너편 아파트의 창문 상태가 주어졌을 때, 위의 5가지 상태가 각각 몇 번 나오는지 구하는 프로그램을 작성하시오.

	입력
	첫째 줄에 M과 N이 공백으로 구분해서 주어진다. (1 ≤ M, N ≤ 100)

	다음 줄에는 현재 건너편 아파트의 상태가 주어진다. 모든 창문은 문제 설명에 나온 것 처럼 4*4 그리드로 주어진다. 또, 창문과 창문은 '#'를 이용해서 구분한다. 예제 입력 형식을 참고하면 좋다. 아파트의 정보는 5M+1줄, 각 줄은 5N+1개 글자로 이루어져 있다.

	출력
	출력은 총 5개 숫자이다. 문제 설명에 나온 순서대로 각 블라인드 타입이 몇 개 있는지를 출력한다. 숫자를 모두 합하면 M*N이 되어야 한다.

	예제 입력 1 
	2 3
	################
	#****#****#****#
	#****#****#****#
	#****#....#****#
	#....#....#****#
	################
	#....#****#****#
	#....#****#....#
	#....#....#....#
	#....#....#....#
	################
	
	
	예제 출력 1 
	1 1 2 1 1
	  
	 
	 * */
	
	
	
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		
		int[] type = new int[5];//블라인드의 타입.
		String[][] matrix = new String[(n*4)+(n+1)][(m*4)+(m+1)];
		
		
		for (int i = 0; i < (n*4)+(n+1); i++) {
			String[] arr = br.readLine().split("");
			for (int j = 0; j < (m*4)+(m+1); j++) {
				matrix[i][j] = arr[j];
			}
		}//행렬구현 완료. 
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				int count = 0;
				for (int k = 0; k < 4; k++) {
					if (matrix[(5*i-4)+k][(5*j-4)].equals("*")) {
						count++;
					} else {
						break;
					}
				}//k
				type[count]++;
			}
		}
		
		for (int i : type) {
			bw.write(i + " ");
		}
		
		bw.close();

	}
}
