package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DigitalRoot6378 {
	
	/*
	 
	시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
	1 초	128 MB	3905	1480	1313	41.057%
	문제
	양의 정수 N의 디지털 루트를 구하려면 N을 이루고 있는 모든 자리수를 더해야 한다. 
	이때, 더한 값이 한 자리 숫자라면, 그 수가 N의 디지털 루트가 된다. 
	두 자리 이상 숫자인 경우에는 다시 그 수를 이루고 있는 모든 자리수를 더해야 하며, 한 자리 숫자가 될 때 까지 반복한다.
	
	24의 디지털 루트를 구해보자. 2+4=6이다. 6은 한 자리 숫자이기 때문에, 24의 디지털 루트는 6이 된다. 
	39의 경우에는 3+9=12이기 때문에, 한 번 더 더해야 한다. 따라서, 1+2=3이 디지털 루트가 된다.
	
	양의 정수 N이 주어졌을 때, 그 수의 디지털 루트를 구하는 프로그램을 작성하시오.
	
	입력
	한 줄에 하나씩 양의 정수가 주어진다. 입력의 마지막 줄은 0으로 나타낸다.  
	수는 최대 1000자리이다.
	
	출력
	입력으로 주어진 양의 정수의 디지털 루트를 한 줄에 하나씩 주어진 순서대로 출력한다.
	
	예제 입력 1 
	24
	39
	0
	
	예제 출력 1 
	6
	3
	  
	  
	
	 * */
	
	
	public static void main(String[] args) throws Exception{
		
		//m1();
		m2();
		

	}
	
	private static void m1() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		while(true) {//여기서 몇개의 숫자를 받을건지 봐야한다.
			
			String inputNum = br.readLine();
			
			if (inputNum.equals("0")) {//들어온 숫자가 0인 경우에
				break;
			} else {//들어온 숫자가 0이 아닐 경우에
				
				while(true) {
					int tempSum = 0;
					String[] inputNumArr = inputNum.split("");
					
					for (int i = 0 ;i < inputNumArr.length; i++) {
						tempSum += Integer.parseInt(inputNumArr[i]);//들어온 숫자들을 하나 씩 더해주는 작업
					}
					
					if (tempSum >= 10) {//더한 숫자가 2자리 이상이면 다시 쪼개준다.
						inputNum = "" + tempSum;
					} else {
						bw.write(tempSum + "\n");
						break;
					}
				}
			}
		}
		
		br.close();
		bw.close();
		
	}
	private static void m2() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			
			String num = br.readLine();//숫자입력
			int sum = 0;//각 자리수를 더해준 값
			
			for (int i = 0; i < num.length(); i++) {
				sum += num.charAt(i) - '0';//입력한 숫자 자리별로 더해주기 
			}
			
			if (sum != 0) {
				//각 자리수를 모두 더한 합이 0이 아니라면 계속 진행한다.
				while(sum >= 10) {
					int sum2 = sum;//임시적으로 새로운 총덧셈값 sum2를 생성
					sum = 0;//여기서 sum을 0 으로 지정하는 이유는 위에while조건을 위해서임
					
					for (;sum2>0;sum2 /= 10) {
						sum += sum2%10;
					}
				}
				
				bw.write(sum + "\n");
				
				
			} else {
				//각 자리수를 모든 더한 합이 0 이 된다면 끝낸다.
				break;
			}
			
		}
		
		br.close();
		bw.close();
		
		
	}

	
}
