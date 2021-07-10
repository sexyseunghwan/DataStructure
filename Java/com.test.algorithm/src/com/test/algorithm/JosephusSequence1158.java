package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class JosephusSequence1158 {
	/*
	 
	문제
	요세푸스 문제는 다음과 같다.
	
	1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 
	이제 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 
	이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 
	예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
	
	N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.
	
	입력
	첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 5,000)
	
	출력
	예제와 같이 요세푸스 순열을 출력한다.
	
	예제 입력 1 
	7 3
	예제 출력 1 
	<3, 6, 2, 7, 5, 1, 4> 
	 
	 
	 */
	
	
	public static void main(String[] args) throws Exception{
		
		
		m1();
		//m2();
		
		
	}
	
	
	private static void m2() throws Exception{
		
		//Queue 를 사용한 풀이방법.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(stk.nextToken());//1 ~ N 까지의 수 
		int K = Integer.parseInt(stk.nextToken());//K 번째를 지울것
		
		Queue<Integer> queue = new LinkedList<Integer>();//큐 생성
		
		//큐에 숫자를 집어넣어준다.
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		//큐가 비워질때까지 계속한다.
		while(!queue.isEmpty()) {
			
			for (int i = 1; i <= K; i++) {
				
				if (i == K) {
					//주기에 도달했을 경우
					if (queue.size() == 1) {
						sb.append(queue.poll());
					} else {
						sb.append(queue.poll());
						sb.append(", ");
					}
					
				} else {
					//아직 주기에 도달하지 못했을 경우
					queue.offer(queue.poll());	
				}	
			}
		
		}//while
		
		
		sb.append(">");
		
		bw.write(sb.toString());
		bw.close();
		
	}

	private static void m1() throws Exception{
		//1. 일반적인 배열을 이용한 풀이방법
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(stk.nextToken());//1 ~ N 까지의 수 
		int K = Integer.parseInt(stk.nextToken());//K 번째를 지울것
		
		int[] calList = new int[N];//계산해줄 수열
		
		//1~N 까지 차례로 정수를 담는다.
		for (int i = 0; i < N; i++) {
			calList[i] = i+1;
		}
		 
		List<Integer> answerList = new ArrayList<Integer>();
		int index = K-1;//처음의 인덱스
		int count = 0;
		
		//처음의 경우
		answerList.add(calList[K-1]);
		calList[K-1] = 0;//제외한 수열은 0으로 지정한다.
		
		//처음을 제외하고 그 다음부터의 경우 -> 계속 원처럼 돌아가는 성질을 가진다.
		//answerList 의 수열의 길이가 N 이 되면 다 찬것이므로 중단한다.
		while(answerList.size() != N) {
			
			if (calList[index] != 0) {
				count++;
				
				if (count == K) {
					answerList.add(calList[index]);
					calList[index] = 0;
					count = 0;//count 초기화
				}
				
			} 
			
			index++;
			if (index > N-1) {
				index = 0;
			}
		}
		
		
		//답을 넣기
		bw.write("<");
		int answerIndex = 0;
		
		for (int i = 0; i < answerList.size() - 1; i++) {
			bw.write(answerList.get(answerIndex) + ", ");
			answerIndex++;
		}
		bw.write(answerList.get(answerIndex) + "");
		bw.write(">");
		
		bw.close();
		
	}
}
