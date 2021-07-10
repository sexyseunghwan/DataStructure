package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Nim11868 {
	/*
	
	 문제
koosaga와 cubelover가 님 게임을 하고 있다. 님 게임은 돌을 차곡 차곡 위로 쌓아올린 돌 더미 k개를 이용한다. 
각각의 돌 더미에는 한 개 이상의 돌이 있다. 두 사람은 서로 턴을 번갈아가면서 님 게임을 진행한다. 
각 사람의 턴이 되면, 돌이 있는 돌 더미를 하나 선택하고, 그 돌 더미에서 돌을 하나 이상 제거한다. 
전체 돌 더미에서 마지막 돌을 제거하는 사람이 게임을 이기게 된다. 

게임은 koosaga가 먼저 시작한다. 두 사람이 최적의 방법으로 게임을 진행했을 때, 이기는 사람을 출력한다.

입력
첫째 줄에 돌 더미의 개수 N (1 ≤ N ≤ 100)이 주어진다.

둘째 줄에는 각 돌 더미에 쌓여있는 돌의 개수 Pi (1 ≤ Pi ≤ 109)가 주어진다.

출력
koosaga가 이기는 경우에는 'koosaga'를, cubelover가 이기는 경우에는 'cubelover'를 출력한다.

예제 입력 1 
1
1
예제 출력 1 
koosaga

예제 입력 2 
1
2
예제 출력 2 
koosaga

예제 입력 3 
2
1 1
예제 출력 3 
cubelover

예제 입력 4 
2
1 2
예제 출력 4 
koosaga

예제 입력 5 
2
2 2
예제 출력 5 
cubelover

예제 입력 6 
4
1 2 3 4
예제 출력 6 
koosaga

예제 입력 7 
6
9 8 9 8 9 9
예제 출력 7 
cubelover

예제 입력 8 
3
2 4 6
예제 출력 8 
cubelover
	 
	 
	 
	 
	 */
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cycle = Integer.parseInt(br.readLine());
		
		String answer = "";
		
		StringTokenizer stk = new StringTokenizer(br.readLine()," ");
		
		if (cycle == 1) {
			answer = "koosaga";
		} else {
			
			int result = 0;
			
			for (int i = 0; i < cycle; i++) {
				result ^= Integer.parseInt(stk.nextToken());
			}
			
			if (result == 0) {
				answer = "cubelover";
			} else {
				answer = "koosaga";
			}
			
		}
		
		bw.write(answer + "");
		bw.close();
		br.close();
		
	}
}
