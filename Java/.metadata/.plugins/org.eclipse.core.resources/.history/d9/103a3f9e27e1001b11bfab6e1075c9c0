package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class TruckParking2979 {
	
	/*
	 문제
	상근이는 트럭을 총 세 대 가지고 있다. 오늘은 트럭을 주차하는데 비용이 얼마나 필요한지 알아보려고 한다.

	상근이가 이용하는 주차장은 주차하는 트럭의 수에 따라서 주차 요금을 할인해 준다.

	트럭을 한 대 주차할 때는 1분에 한 대당 A원을 내야 한다. 
	두 대를 주차할 때는 1분에 한 대당 B원, 세 대를 주차할 때는 1분에 한 대당 C원을 내야 한다.

	A, B, C가 주어지고, 상근이의 트럭이 주차장에 주차된 시간이 주어졌을 때, 
	주차 요금으로 얼마를 내야 하는지 구하는 프로그램을 작성하시오.

	입력
	첫째 줄에 문제에서 설명한 주차 요금 A, B, C가 주어진다. (1 ≤ C ≤ B ≤ A ≤ 100)

	다음 세 개 줄에는 두 정수가 주어진다. 이 정수는 상근이가 가지고 있는 트럭이 주차장에 도착한 시간과 주차장에서 떠난 시간이다. 
	도착한 시간은 항상 떠난 시간보다 앞선다. 입력으로 주어지는 시간은 1과 100사이 이다.

	출력
	첫째 줄에 상근이가 내야하는 주차 요금을 출력한다.

	예제 입력 1 
	5 3 1
	1 6
	3 5
	2 8
	
	
	예제 출력 1 
	33
	 

	 * */
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer stk1 = new StringTokenizer(br.readLine());
		int oneFee = Integer.parseInt(stk1.nextToken());
		int twoFee = Integer.parseInt(stk1.nextToken());
		int threeFee = Integer.parseInt(stk1.nextToken());
		
		int totalFee = 0;//전체 요금
		
		int[][] parkArea = new int[3][101];
		
		for (int i = 0; i < 3; i++) {
			StringTokenizer stk2 = new StringTokenizer(br.readLine());
			int inTime = Integer.parseInt(stk2.nextToken());
			int outTime = Integer.parseInt(stk2.nextToken());
			
			for (int j = inTime; j < outTime; j++) {
				parkArea[i][j] = 1;
			}
			
		}
		
		
		for (int i = 1; i < 101; i++) {
			
			int count = (parkArea[0][i] + 
					parkArea[1][i] + 
					parkArea[2][i]);
			
			switch(count) {
			case 1 :
				totalFee += oneFee;
				break;
			case 2 : 
				totalFee += twoFee*2;
				break;
			case 3 : 
				totalFee += threeFee*3;
				break;
			}
			
		}
		
		bw.write(totalFee + "\n");
		bw.close();

	}

}
