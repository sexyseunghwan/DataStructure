package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 
 * @author shin
 *
 */
public class Chess3076 {
	
	//백준 3076 문제 상근이의 체스판
	/*
	 상근이는 체스판을 만들려고 한다.
	체스판은 검정칸과 흰칸으로 이루어져 있다. 가장 왼쪽 위칸의 색은 검정색이고, 나머지 색은 검정과 흰색이 번갈아가면서 등장한다. 검정색은 'X'로, 흰색은 '.'로 표시한다.
	상근이의 체스판은 R행 * C열로 이루어져 있어야 한다. 또, 각각의 행의 높이는 문자 A개만큼 이며, 각각의 열의 너비는 문자 B개 만큼이다. 예제 출력을 보고 이해하면 쉽다.
	R, C, A, B가 주어졌을 때, 상근이의 체스판을 출력하는 프로그램을 작성하시오.
	입력
	첫째 줄에 두 양의 정수 R과 C가 주어진다. (1 ≤ R, C ≤ 10)
	둘째 줄에 두 양의 정수 A와 B가 주어진다. (1 ≤ A, B ≤ 10)
	출력
	출력은 R * A행 C * B열로 이루어져 있어야 하며, 문제에서 설명한 상근이의 체스판을 출력한다.
	
	
	5 5
	2 3
	
	
	->
	
	
	XXX...XXX...XXX
	XXX...XXX...XXX
	...XXX...XXX...
	...XXX...XXX...
	XXX...XXX...XXX
	XXX...XXX...XXX
	...XXX...XXX...
	...XXX...XXX...
	XXX...XXX...XXX
	XXX...XXX...XXX
	
	 * */
	
	
	public static void main(String[] args) throws Exception{
		//풀이
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		StringTokenizer stk1 = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(stk1.nextToken());//행
		int c = Integer.parseInt(stk1.nextToken());//열
		
		StringTokenizer stk2 = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(stk2.nextToken());//한칸의 행
		int b = Integer.parseInt(stk2.nextToken());//한칸의 열
		
		String[] arr = {"X","."};
		
		int index = 0;
		
		for (int i = 0; i < r; i++) {
			String str = "";
			
			for (int j = 0; j < c; j++) {
				for (int k = 0; k < b; k++) {
					str += arr[index % 2];
				}
				index++;
			}
			
			for (int s = 0; s < a; s++) {
				bw.write(str + "\n");
			}
			
			if (c % 2 == 0) {
				index++;
			}
		}
		
		bw.close();
	}
}