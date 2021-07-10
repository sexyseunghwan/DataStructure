package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class AngruyChang3034 {
	
	/*
	 문제
	창영이는 화가나서 성냥을 바닥에 던졌다.

	상근이는 바닥이 더러워진 것을 보고 창영이를 매우 혼냈다.

	강산이는 근처에서 박스를 발견했다.

	상덕이는 강산이가 발견한 박스를 상근이에게 주었다.

	상근이는 박스에 던진 성냥을 모두 담아오라고 시켰다.

	하지만, 박스에 들어가지 않는 성냥도 있다.

	이런 성냥은 박스에 담지 않고 희원이에게 줄 것이다.

	성냥이 박스에 들어가려면, 박스의 밑면에 성냥이 모두 닿아야 한다.

	박스의 크기와 성냥의 길이가 주어졌을 때, 성냥이 박스에 들어갈 수 있는지 없는지를 구하는 프로그램을 작성하시오. 
	창영이는 성냥을 하나씩 검사한다.

	입력
	첫째 줄에 던진 성냥의 개수 N과 박스의 가로 크기 W와 세로 크기 H가 주어진다. (1 ≤ N ≤ 50, 1 ≤ W, H ≤ 100)
	
	다음 N개 줄에는 성냥의 길이가 주어진다. 길이는 1보다 크거나 같고 1000보다 작거나 같은 자연수이다. 
	
	출력
	입력으로 주어지는 각각의 성냥에 대해서, 박스안에 들어갈 수 있으면 "DA" 없으면 "NE"를 출력한다.
	
	예제 입력 1 
	5 3 4
	3
	4
	5
	6
	7
	
	예제 출력 1 
	DA
	DA
	DA
	NE
	NE
	  
	 */
	
	public static void main(String[] args) throws Exception{
		m1();
		//m2();
		//수정사항
		
	}
	
	private static void m1() throws Exception{
		//첫번째 풀이
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer input = new StringTokenizer(br.readLine()," ");//사용자가 입력한 값
		int matchesCount = Integer.parseInt(input.nextToken());//성냥의 개수
		int boxW = Integer.parseInt(input.nextToken());//박스의 가로크기
		int boxH = Integer.parseInt(input.nextToken());//박스의 세로크기
		
		double maxLength = Math.pow((Math.pow(boxW,2)  + Math.pow(boxH,2)),0.5);//박스에 들어갈 수 있는 성냥의 길이의 최대값
		
		for (int i = 0; i < matchesCount; i++) {
			int matchesLength = Integer.parseInt(br.readLine());//박스에 들어오는 성냥의 길이
			
			if (matchesLength <= maxLength) {
				bw.write("DA\n");
			} else {
				bw.write("NE\n");
			}
		}
		
		br.close();
		bw.close();
	}
	
	private static void m2() throws Exception{
		//두번쨰 풀이
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int matches = Integer.parseInt(stk.nextToken());//성냥의 개수
		int W = Integer.parseInt(stk.nextToken());//박스의 가로크기
		int H = Integer.parseInt(stk.nextToken());//박스의 세로크기

		
		for (int i = 0; i < matches; ++i) {
			int matchLen = Integer.parseInt(br.readLine());
			
			String result = matchLen * matchLen <= W*W + H*H ? "DA" : "NE";//삼항 연산자 사용
			
			bw.write(result + "\n");
		}
	
		br.close();
		bw.close(); 
		
	}


}
