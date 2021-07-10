package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Treasuer1026 {
	
	/*
	
	문제
	옛날 옛적에 수학이 항상 큰 골칫거리였던 나라가 있었다. 
	이 나라의 국왕 김지민은 다음과 같은 문제를 내고 큰 상금을 걸었다.
	
	길이가 N인 정수 배열 A와 B가 있다. 다음과 같이 함수 S를 정의하자.
	
	S = A[0]*B[0] + ... + A[N-1]*B[N-1]
	
	S의 값을 가장 작게 만들기 위해 A의 수를 재배열하자. 
	단, B에 있는 수는 재배열하면 안 된다.
	
	S의 최솟값을 출력하는 프로그램을 작성하시오.
	
	입력
	첫째 줄에 N이 주어진다. 둘째 줄에는 A에 있는 N개의 수가 순서대로 주어지고, 셋째 줄에는 B에 있는 수가 순서대로 주어진다. 
	N은 50보다 작거나 같은 자연수이고, A와 B의 각 원소는 100보다 작거나 같은 음이 아닌 정수이다.
	
	출력
	첫째 줄에 S의 최솟값을 출력한다.
	
	예제 입력 1 
	5
	1 1 1 6 0
	2 7 8 3 1
	
	예제 출력 1 
	18
	
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = Integer.parseInt(br.readLine());//카운트 받기
		String[] alist = br.readLine().split(" ");//이 배열을 오름차순 정렬
		String[] blist = br.readLine().split(" ");//이 배열을 내림차순 정렬 
		
		int[] anumList = new int[count];
		int[] bnumList = new int[count];
		
		for (int i = 0; i < count; i++) {
			anumList[i] = Integer.parseInt(alist[i]);
			bnumList[i] = Integer.parseInt(blist[i]);
		}//여기서 숫자배열로 바꾸는 작업 완료
		
		//두개의 배열 모두 정렬
		Arrays.sort(anumList);
		Arrays.sort(bnumList);
		
		int sumation = 0;//총합
		
		for (int i = 0; i < count; i++) {
			sumation += anumList[i]*bnumList[count-(i+1)];
		}
		
		bw.write(sumation + "");
		bw.close();	
	}
}
