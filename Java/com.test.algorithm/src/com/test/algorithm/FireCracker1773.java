package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class FireCracker1773 {
	
	/*
	 
	 문제
	학생들은 3주가 지난 기념으로 매점에서 1월 1일이 지나 싸게 파는 폭죽을 사서 터뜨리고 있다.

	폭죽쇼를 하는 동안 N명의 학생들이 폭죽을 터뜨린다. 그리고 이 N명의 학생은 각각 일정한 주기로 폭죽을 터뜨린다. 
	물론 이 주기는 학생들마다 같을 수도, 다를 수도 있다. 그리고 우리는 초 단위로 관찰을 하고, 폭죽 역시 초 단위로 터진다.

	폭죽쇼가 끝날 때까지 얼마나 많은 시간동안 밤하늘에 폭죽이 터지는 것을 볼 수 있는지 궁금해 하는 조교를 도와주자.

	입력
	첫 줄에 폭죽을 터뜨리는 학생의 수 N(1 ≤ N ≤ 100)과 폭죽쇼가 끝나는 시간 C(1 ≤ C ≤ 2,000,000)가 주어진다. 
	그 다음 N개의 줄에는 학생들이 폭죽을 터뜨리는 주기가 한 줄에 하나씩 주어진다. 주기는 1보다 크거나 같고, C보다 작거나 같은 자연수이다.

	출력
	폭죽쇼가 시작되고 끝날 때까지 밤하늘에 폭죽을 볼 수 있는 총 시간을 출력한다.

	예제 입력 1 
	2 20
	4
	6
	예제 출력 1 
	7
	힌트
                                    2                       
	            1     2     1           1           1     2     1
	0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20
	            1     2     3           4           5     6     7
	
	위의 그림에서 1,2가 쓰여있는 4, 6, 8, 12, 16, 18, 20초에 폭죽이 밤 하늘에 터진다. 
	단 12초에는 두 폭죽이 동시에 하늘에 터지지만 한번으로 세는 것에 주의하자.
	  
	 * */
	
	
	
	public static void main(String[] args) throws Exception{

		
		m1();
//		m2();
	}
	private static void m1() throws Exception{//첫번째 풀이법
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stk = new StringTokenizer(br.readLine()," ");
		int person = Integer.parseInt(stk.nextToken());//폭죽을 터뜨리는 학생의 수
		int endTime = Integer.parseInt(stk.nextToken());//폭죽쇼가 끝나는 시간
		
		int[] cycle = new int[person];//각 학생의 폭죽 터뜨리는 주기 -> 배열에 따로 저장
		
		for(int i = 0; i < person; i++) {
			cycle[i] = Integer.parseInt(br.readLine());//배열에 주기를 집어넣는다.
		}
		
		int[] bombTime = new int[endTime + 1];//폭죽이 터진시간들을 기록하기 위한 배열
		
		
		for(int i = 0; i < cycle.length; i++) {
			int num = cycle[i];
			for (int j = 1; num*j <= endTime; j++) {
				bombTime[num*j] = 1;
			}
		}
		
		
		int result = 0;//터진횟수
		
		for (int i = 0; i < bombTime.length; i++) {
			if (bombTime[i] == 1) {
				result++;
			}
		}
		
		bw.write(result + "");
		
		br.close();
		bw.close();
		
	}


	private static void m2() throws Exception{//두번째 풀이법
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int person = Integer.parseInt(stk.nextToken());//폭죽 터뜨리는 사람명수
		int time = Integer.parseInt(stk.nextToken());//전체 시간
	
		int[] timeArr = new int[time + 1];//폭죽이 터진시간들을 기록하기 위한 배열
		
		for (int i = 0; i < person; i++) {
			int num = Integer.parseInt(br.readLine());//각 학생의 폭죽터뜨리는 주기
			
			for (int j = 1; j*num <= time; j++) {
				if (timeArr[j*num] == 0) {//폭죽이 안터져 있으면 터진걸로 카운트 하라는것
					timeArr[j*num] = 1;
				}
			}
		}
		
		int bomb = 0;//폭죽이 전체 몇번 터졌는지 알아내기 위한 초기값 -> 중복은 제외
		
		for (int i = 1; i <= time; i++) {
			if (timeArr[i] == 1) {
				bomb++;
			}
		}
		
		bw.write(bomb + "\n");
		br.close();
		bw.close();
		
	}
	

}
