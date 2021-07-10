package com.test.algorithm;

import java.io.*;

public class Stick1094 {
	
	/*
	 
	 문제
	지민이는 길이가 64cm인 막대를 가지고 있다. 어느 날, 그는 길이가 Xcm인 막대가 가지고 싶어졌다. 
	지민이는 원래 가지고 있던 막대를 더 작은 막대로 자른다음에, 풀로 붙여서 길이가 Xcm인 막대를 만들려고 한다.
	
	막대를 자르는 가장 쉬운 방법은 절반으로 자르는 것이다. 지민이는 아래와 같은 과정을 거쳐서 막대를 자르려고 한다.
	
	지민이가 가지고 있는 막대의 길이를 모두 더한다. 처음에는 64cm 막대 하나만 가지고 있다. 
	이때, 합이 X보다 크다면, 아래와 같은 과정을 반복한다.
	가지고 있는 막대 중 길이가 가장 짧은 것을 절반으로 자른다.
	만약, 위에서 자른 막대의 절반 중 하나를 버리고 남아있는 막대의 길이의 합이 X보다 크거나 같다면, 
	위에서 자른 막대의 절반 중 하나를 버린다.
	이제, 남아있는 모든 막대를 풀로 붙여서 Xcm를 만든다.
	X가 주어졌을 때, 위의 과정을 거친다면, 몇 개의 막대를 풀로 붙여서 Xcm를 만들 수 있는지 구하는 프로그램을 작성하시오. 
	
	입력
	첫째 줄에 X가 주어진다. X는 64보다 작거나 같은 자연수이다.
	
	출력
	문제의 과정을 거친다면, 몇 개의 막대를 풀로 붙여서 Xcm를 만들 수 있는지 출력한다.
	
	예제 입력 1 
	23
	예제 출력 1 
	4
	
	예제 입력 2 
	32
	예제 출력 2 
	1
	
	예제 입력 3 
	64
	예제 출력 3 
	1
	
	예제 입력 4 
	48
	예제 출력 4 
	2 
	*/
	
	
	public static void main(String[] args) throws Exception {
		
		//m1();
		m2();
		
	}//main

	private static void m2() throws Exception{
		
		//두번쨰 풀이 --> 훨씬 간단한 풀이가 된다.
		//이진수로 변환시키는 문제인데 해당 이진수에서 1이 나올때마다 카운트해주면 되는 형식으로 생각하면 된다. -> 이런생각을 어찌하는지 대단하다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int input = Integer.parseInt(br.readLine());
		int answer = 0;
		
		while(input > 0) {
			
			if (input % 2 == 1) answer++;
			
			input /= 2;
			
		}
		
		
		bw.write(answer + "");
		br.close();
		bw.close();
		
		//하지만 아래 방법과 딱히 리소스 차이가 없다 시간복잡도에서도 큰 차이가 나지 않는다...! 그러므로 직관적인 첫번쨰 풀이가 좋다고 할수 있다.
		
	}

	private static void m1() throws Exception{
		
		//첫번째 풀이 -> 가장 기본적인 풀이방법
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int input = Integer.parseInt(br.readLine());//입력값
		
		int sum = 0;
		int count = 0;
		int number = 64;
		boolean flag = true;
		
		
		if (input == 64) {
			count++;
		} else {
			
			while(flag) {
				
				number /= 2;
				
				if ((number + sum) <= input) {
					count++;
					sum += number;
				}
				
				if (sum == input) flag = false;
				
			}//while
			
		}
		
		bw.write(count + "");
		br.close();
		bw.close();
		
	}
}
