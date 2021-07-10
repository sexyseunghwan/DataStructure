package com.test.algorithm;

/*
문제
이 문제는 아주 평범한 배낭에 관한 문제이다.

한 달 후면 국가의 부름을 받게 되는 준서는 여행을 가려고 한다. 세상과의 단절을 슬퍼하며 최대한 즐기기 위한 여행이기 때문에, 가지고 다닐 배낭 또한 최대한 가치 있게 싸려고 한다.

준서가 여행에 필요하다고 생각하는 N개의 물건이 있다. 각 물건은 무게 W와 가치 V를 가지는데, 해당 물건을 배낭에 넣어서 가면 준서가 V만큼 즐길 수 있다.
아직 행군을 해본 적이 없는 준서는 최대 K만큼의 무게만을 넣을 수 있는 배낭만 들고 다닐 수 있다. 준서가 최대한 즐거운 여행을 하기 위해 배낭에 넣을 수 있는 물건들의 가치의 최댓값을 알려주자.

입력
첫 줄에 물품의 수 N(1 ≤ N ≤ 100)과 준서가 버틸 수 있는 무게 K(1 ≤ K ≤ 100,000)가 주어진다. 
두 번째 줄부터 N개의 줄에 거쳐 각 물건의 무게 W(1 ≤ W ≤ 100,000)와 해당 물건의 가치 V(0 ≤ V ≤ 1,000)가 주어진다.

입력으로 주어지는 모든 수는 정수이다.

출력
한 줄에 배낭에 넣을 수 있는 물건들의 가치합의 최댓값을 출력한다.

예제 입력 1 
4 7
6 13
4 8
3 6
5 12

예제 출력 1 
14



*/


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class UsualBackPack12865 {
	
	public static int[] weightArr;
	public static int[] valArr;
	public static int[][] matrix;
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] inputs = br.readLine().split(" ");
		
		int N = Integer.parseInt(inputs[0]);//물품의 수 
		int W = Integer.parseInt(inputs[1]);//버틸 수 있는 무게
		
		matrix = new int[N][W+1];  
		
		weightArr = new int[N];//무게들이 존재
		valArr = new int[N];//무게에 대응되는 value들 
		
		//아래에서 배열에 하나씩 대응시켜준다고 생각하면된다.
		for(int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			weightArr[i] = Integer.parseInt((String)stk.nextElement());
			valArr[i] = Integer.parseInt((String)stk.nextElement());	
		}
		
		bw.write(knapsack(N-1,W) + "");
		bw.close();
		br.close();
	
	}
	
	public static int knapsack(int N,int W) {
		
		if (N < 0) {
			return 0;
		}
		//탐색하지 않은 위치
		if (matrix[N][W] == 0) {
			
			
			if (W - weightArr[N] < 0) {
				matrix[N][W] = knapsack(N-1,W);
			}
			else {
				matrix[N][W] = Math.max(knapsack(N-1,W), knapsack(N-1,W-weightArr[N])+ valArr[N]);
			}
		}
		
		return matrix[N][W];	
	}
}
