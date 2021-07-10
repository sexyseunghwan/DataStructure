package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class StringType1120 {
	/*
	 

	문제
	길이가 N으로 같은 문자열 X와 Y가 있을 때, 두 문자열 X와 Y의 차이는 X[i] ≠ Y[i]인 i의 개수이다. 
	예를 들어, X=”jimin”, Y=”minji”이면, 둘의 차이는 4이다.

	두 문자열 A와 B가 주어진다. 이때, A의 길이는 B의 길이보다 작거나 같다. 
	이제 A의 길이가 B의 길이와 같아질 때 까지 다음과 같은 연산을 할 수 있다.

	A의 앞에 아무 알파벳이나 추가한다.
	A의 뒤에 아무 알파벳이나 추가한다.
	이때, A와 B의 길이가 같으면서, A와 B의 차이를 최소로 하는 프로그램을 작성하시오.

	입력
	첫째 줄에 A와 B가 주어진다. 
	A와 B의 길이는 최대 50이고, A의 길이는 B의 길이보다 작거나 같고, 알파벳 소문자로만 이루어져 있다.

	출력
	A와 B의 길이가 같으면서, A와 B의 차이를 최소가 되도록 했을 때, 그 차이를 출력하시오.

	예제 입력 1 
	adaabc aababbc
	
	예제 출력 1 
	2 
	 
	 * */
	
	
	public static void main(String[] args) throws Exception{//메인
		s1();
		//s2();
	
	}
	
	public static int comparison(String a,String b) {//첫번쨰 풀이를 위한 정적메서드
		
		int minCount = Integer.MAX_VALUE;//최소값을 의미한다.
		
		for (int i = 0; i <= b.length() - a.length(); i++) {
			
			String text = b.substring(i,i + a.length());
			int count = 0;
			
			
			for (int j = 0; j < a.length(); j++) {
				if (a.charAt(j) != text.charAt(j)) {
					count++;
				}
			}
			
			minCount = (count <= minCount) ? count : minCount;
			
		}
		
		
		return minCount;
	}
	
	public static void s1() throws Exception {//첫번쨰 풀이
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		StringTokenizer stk = new StringTokenizer(input," ");
		
		String first = stk.nextToken();
		String second = stk.nextToken();
		
		
		int answer = comparison(first, second);
		
		bw.write(answer + "");
		
		br.close();
		bw.close();
	}
	
	public static void s2() throws Exception {//두번쨰 풀이
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		String a = stk.nextToken();
		String b = stk.nextToken();
		
		int difference = 0;
		
		int aLength = a.length(),
			bLength = b.length();
		
		if (aLength == bLength) {//길이가 같은경우
			for (int i = 0; i < aLength; i++) {
				if (a.charAt(i) != b.charAt(i)) {
					difference++;
				}
			}
		} else {//길이가 다른경우.
			int min = Integer.MAX_VALUE;
			int stringGap = bLength - aLength;
			
			for (int i = 0; i < stringGap + 1; i++) {
				int count = 0;
				for (int j = 0; j < aLength; j++) {
					if (a.charAt(j) != b.charAt(j + i)) {
						count++;
					}
				}
				min = min > count ? count : min;
			}
			difference = min;
		}
		
		bw.write(difference + "\n");
		br.close();
		bw.close();
	}
}
