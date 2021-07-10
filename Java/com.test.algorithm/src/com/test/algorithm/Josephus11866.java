package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Josephus11866 {
	
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
	
	public static void main(String[] args) throws Exception {
		
		//m1();//첫번째 방법
		//m2();//두번쨰 방법
		//m3();


	}
	
	private static void m3() throws Exception {
		// TODO Auto-generated method stub
		
	       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        
	       String[] input = br.readLine().split(" ");
	        
	        int n = Integer.parseInt(input[0]);
	        int k = Integer.parseInt(input[1]);
	        
	        StringBuffer sb = new StringBuffer();//스트링 버퍼 생성
	        
	        int count = 0;//수 카운트
	        int checked = 0;//확인할 숫자
	        int index = 0;//배열 인덱스
	        
	        int[] room = new int[n];
	        
	        sb.append("<");
	        
	        while(checked != n) {
	            
	            if(room[index] == 0) {
	                count++;
	                
	                if (count == k) {
	                    if (checked == n-1) {
	                        sb.append((index + 1) + "");
	                    } else {
	                        sb.append((index + 1) + ", ");
	                    }
	                    room[index] = 1;
	                    checked++;
	                    count = 0;
	                }
	            }
	            index++;
	            index %= n;
	        }
	        
	        sb.append(">");
	        
	        bw.write(sb+"");
	        bw.close();
	        
		}

	private static void m2() throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");//입력받기
		
		int n = Integer.parseInt(input[0]);//N명의 사람이 존재
		int k = Integer.parseInt(input[1]);//K번쨰 요세푸스 순열
		
		int[] numArr = new int[n+1];//처음 수열 준비 1 ~ 지정한 숫자까지의 array를 만들것이다.
		
		StringBuffer sb = new StringBuffer();
		sb.append("<");
		
		int count = 0;//카운트 해줄것
		int realNum = 1;
		
		for (int i = 1; i <= n; i++) {
			
			count = 0;
			
			while (true) {
				
				if (numArr[realNum] == 0) count++;
				
				if (count == k) {
					numArr[realNum] = 1;//수열에 1로 지정하면 지워졌다는 뜻이 된다.
					
					if (i == n) sb.append(realNum + ">"); 
					else sb.append(realNum + ", ");
					
					break;
				}
				
				realNum++;
				
				if (realNum > n) realNum %= n;
			}//while
			
		}//for
		
		
		bw.write(sb + "");
		br.close();
		bw.close();
		
		
		
	}

	private static void m1() throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");//입력받기
		
		int n = Integer.parseInt(input[0]);//N명의 사람이 존재
		int k = Integer.parseInt(input[1]);//K번쨰 요세푸스 순열
		
		int[] numArr = new int[n];//처음 수열 준비 1 ~ 지정한 숫자까지의 array를 만들것이다.
		
		for (int i = 0; i < n; i++) {
			numArr[i] = i+1;
		}
		
		int totalCount = 0;
		int count = 0;
		int index = 0;
		
		StringBuffer sb = new StringBuffer();
		sb.append("<");
		
		while(totalCount != n) {
			
			index %= n;
			
			if (numArr[index] != 0) {
				count++;
			}
			
			if (count == k) {
				
				if (totalCount == n - 1) {
					sb.append(numArr[index] + ">");
				} else {
					sb.append(numArr[index] + ", ");
				}
				
				numArr[index] = 0;
				totalCount++;
				count = 0;
			}
			
			index++;
		}//while
		
		
		bw.write(sb + "");
		br.close();
		bw.close();
	}
}
