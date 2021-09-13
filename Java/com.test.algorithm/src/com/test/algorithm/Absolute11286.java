package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Absolute11286 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cycle = Integer.parseInt(br.readLine());//반복할 횟수aa
		
		List<Integer> list = new ArrayList<Integer>();
		
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < cycle; i++) {
			
			int input = Integer.parseInt(br.readLine());
			
			if (input == 0) { //0을 입력한 경우
				
				if (list.size() == 0) {
					//배열내에 숫자가 더이상 없는경우
					sb.append("0\n");
		
				} else {
					//배열내에 숫자가 있는 경우
					int min = 2147483647;
					int minIndex = -1;//가장작은수의 인덱스
					
					for (int j = 0; j < list.size(); j++) {
						
						boolean flag = true;
						
						int num = list.get(j);
						
						if (num < 0) {
							//숫자가 0보다 작은 경우
							num *= -1;
							flag = false;
						} 
						
						if (min > num) {
							minIndex = j;
							min = num;
							
						} else if (min == num) {
							
							if (!flag) {
								minIndex = j;
								min = num;
							} 
						}
					}
					
					sb.append(list.get(minIndex) + "\n");
					list.remove(minIndex);
					
				}
				
			} else {//0이외숫자를 입력한 경우
				
				list.add(input);//숫자 넣기

				
			}
			
			
		}//for
		
		bw.write(sb + "");
		br.close();
		bw.close();
	}
}
