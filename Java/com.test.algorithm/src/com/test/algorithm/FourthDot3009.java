package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class FourthDot3009 {
	
	/*
	 문제
	세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하시오.

	입력
	세 점의 좌표가 한 줄에 하나씩 주어진다. 좌표는 1보다 크거나 같고, 1000보다 작거나 같은 정수이다.

	출력
	직사각형의 네 번째 점의 좌표를 출력한다.

	예제 입력 1 
	30 20
	10 10
	10 20
	
	
	
	예제 출력 1 
	30 10
	  
	 * */
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int[] xarr = new int[1001];
		int[] yarr = new int[1001];
		
		for (int i = 0; i < 3; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(stk.nextToken());
			int y = Integer.parseInt(stk.nextToken());
			
			xarr[x]++;
			yarr[y]++;
		}
		
		for (int i = 0; i < 1001; i++) {
			if (xarr[i] % 2 == 1) {
				bw.write(i + " ");
				break;
			}
		}
		
		for (int i = 0; i < 1001; i++) {
			if (yarr[i] % 2 == 1) {
				bw.write(i + "\n");
				break;
			}
		}
		bw.close();
	}
}
