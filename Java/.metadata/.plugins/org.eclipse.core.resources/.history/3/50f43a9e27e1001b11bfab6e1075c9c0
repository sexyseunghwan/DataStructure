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
public class CondoSelect2246 {
	/*
	 
	 문제
	콘도를 선정할 때에는 가급적이면 싸고 바닷가에 가까운 곳으로 하려 한다. 이를 위해 우선 적당한 콘도 몇 곳을 후보로 선정하려 하는데,
	 다음 두 조건을 만족하는 콘도 X가 후보가 된다.
	X보다 바닷가에 더 가까운 콘도들은 모두 X보다 숙박비가 더 비싸다.
	X보다 숙박비가 더 싼 콘도들은 모두 X보다 바닷가에서 더 멀다.
	각 콘도의 바닷가에서의 거리와 숙박비에 대한 정보가 주어졌을 때, 후보 콘도의 개수를 구해내는 프로그램을 작성하시오.
	
	입력
	첫째 줄에 콘도의 개수를 나타내는 자연수 N(1≤N≤10,000)이 주어진다. 다음 N개의 줄에는 각 콘도에 대한 정보를 나타내는 두 정수 D(1≤D≤10,000), C(1≤C≤10,000)가 주어진다.
	D는 그 콘도의 바닷가로부터의 거리를 나타내고, C는 그 콘도의 숙박비를 나타낸다. D와 C값이 서로 같은 콘도가 주어지지는 않는다.
	출력
	첫째 줄에 후보가 될 수 있는 콘도의 수를 출력한다.
	 
	 
	 예제 입력 1 
	5
	300 100
	100 300
	400 200
	200 400
	100 500
	
	예제 출력 1 
	2
	 
	 */
	
	public static void main(String[] args) throws Exception{
		
		
		
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int condo = Integer.parseInt(br.readLine());
		
		int[][] matrix = new int[condo][2];
		
		for (int i = 0; i < condo; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			matrix[i][0] = Integer.parseInt(stk.nextToken());//distance
			matrix[i][1] = Integer.parseInt(stk.nextToken());//cost
		}
				
		int count = 0;
		
		for (int i = 0; i < condo; i++) {
			boolean flag = true;
			for (int j = 0; j < condo; j++) {
				if (i != j) {
					if (matrix[i][0] >= matrix[j][0]) {
						if (matrix[i][1] >= matrix[j][1]) {
							flag = false;
							break;
						}
					}
					
					if (matrix[i][1] >= matrix[j][1]) {
						if (matrix[i][0] >= matrix[j][0] ) {
							flag = false;
						}
					}
				}
			}
			if (flag) count++;
		}
		
		bw.write(count + "\n");
		bw.close();
		
		
	}
}
