package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;

public class Coprime4355 {
	
	
	/*
	 문제
	양의 정수 n이 주어졌을 때, n보다 작은 양의 정수 중에서 n과 서로소인 수 개수를 구하는 프로그램을 작성하시오.

	두 정수 a와 b가 서로소가 되려면 x > 1, y > 0, z > 0이면서, a = xy, b= xz를 만족하는 정수가 없어야 한다.
	
	입력
	입력은 여러 개의 테스트 케이스로 이루어져 있으며, 각 테스트 케이스는 n ≤ 1,000,000,000으로 이루어져 있다.
	
	입력의 마지막 줄에는 0이 주어진다.
	
	출력
	입력으로 주어진 n마다 n보다 작으면서 서로소인 양의 정수의 수를 출력한다.
	
	예제 입력 1 
	7
	12
	0
	
	예제 출력 1 
	6
	4 
	 
	 * */

	//소인수분해 메서드
	private static HashMap<Integer, Integer> factorization(int number) {
		
		 HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		 
		 while(number != 1) {
			 for (int i = 2; i <= number; i++) {
				 
				 if (number % i == 0) {
					 number /= i;
					 if (map.containsKey(i)) {
						 map.put(i,map.get(i) + 1);
					 } else {
						 map.put(i,1);
					 }
					 break;
				 }//if
			 }//for
		 }//while
		return map;
	}
	
	//오일러 퓌함수 메서드
	private static int eulerphi(int number) {
		
		int result = 1;
		
		HashMap<Integer, Integer> map = factorization(number);
		
		Iterator<Integer> keys = map.keySet().iterator();
		
		while(keys.hasNext()) {
			int key = keys.next();
			

			int answer = (int)(Math.pow((double)key, map.get(key)) - Math.pow((double)key, map.get(key)-1));
			
			result *= answer;
		}
		
		return result;
	}
	
	public static void main(String[] args) throws Exception{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuffer sb = new StringBuffer();
		
		while(true) {
			
			int input = Integer.parseInt(br.readLine());//입력한 값
			
			if (input != 0) {
				//입력으로 0을 적지 않은 경우 -> 계속 입력 받는다.
				sb.append(eulerphi(input) + "\n");
				
			} else {
				//입력으로 0을 적어준 경우 -> 멈춰준다
				break;
			}
		
		}//while
		
		bw.write(sb + "");
		br.close();
		bw.close();
		
	}

}