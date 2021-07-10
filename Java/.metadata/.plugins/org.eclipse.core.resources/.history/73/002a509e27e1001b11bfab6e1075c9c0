package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Octal2998 {
	/*
	 문제
	창영이는 여러 가지 진법을 공부하고 있다. 
	창영이는 어제 2진법을 배웠고, 오늘은 8진법을 배웠다. 
	이제, 2진법 수를 8진법 수로 변환하려고 한다.

	창영이가 사용한 방법은 다음과 같다.

	2진수의 길이가 3으로 나누어 떨어질 때 까지 수의 앞에 0을 붙인다.
	그 다음, 3자리씩 그룹을 나눈다.
	아래의 표를 참고해 8진수로 바꾼다.
	2진수가 주어졌을 때, 창영이가 사용한 방법을 이용해 8진수로 바꾸는 프로그램을 작성하시오.

	000	0
	001	1
	010	2
	011	3
	100	4
	101	5
	110	6
	111	7
	입력
	첫째 줄에 2진수가 주어진다. 
	이 수는 100자리 이내이고, 첫 번째 자리는 1이다.

	출력
	첫째 줄에 8진수를 출력한다.

	예제 입력 1 
	1010
	예제 출력 1 
	12
	  
	 * */
	static String octTransfer(String num) {
		switch(num) {
		case "000" :
			return "0";
		case "001" :
			return "1";
		case "010" : 
			return "2";
		case "011" :
			return "3";
		case "100" :
			return "4";
		case "101" :
			return "5";
		case "110" :
			return "6";
		default :
			return "7";
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		
		String input = br.readLine();
		
		while(input.length() % 3 != 0) {
			input = "0" + input;
		}
		
		String octNum = "";
		
		for (int i = 0; i < input.length() / 3; i++) {
			String tempStr = "";
			
			for (int j = i*3; j < i*3+3; j++) {
				tempStr += "" + input.charAt(j);
			}
			
			octNum += octTransfer(tempStr);
		}
		
		bw.write(octNum);
		bw.close();
	}

}
