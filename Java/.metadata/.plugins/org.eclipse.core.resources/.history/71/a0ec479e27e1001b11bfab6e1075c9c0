package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

class QueueList<T> extends ArrayList<T> {

	@Override
	public boolean add(T e) {
		return super.add(e);
	}
	//왼쪽 쉬프트
	public void leftShift() {
		 T picked = super.get(0);
		 super.remove(0);
		 super.add(picked);
	}
	//오른쪽 쉬프트
	public void rightShift() {
		T picked = super.get(super.size()-1);
		super.remove(super.size()-1);
		super.add(0,picked);
	}
}

public class RotateQueue1021_1 {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		int total = Integer.parseInt(input[0]);//전체 숫자 개수
		int picked = Integer.parseInt(input[1]);//뽑을 숫자 개수
		
		QueueList<Integer> queue = new QueueList<Integer>();//큐의 역할을 수행하는것처럼 보이는 List
		
		int answerCount = 0;//답으로 도출할 녀석
		
		for (int i = 0; i < total; i++) {
			queue.add(i+1);
		}
		
		String[] findNums = br.readLine().split(" ");
		
		for (int i = 0; i < findNums.length; i++) {
			int findNum = Integer.parseInt(findNums[i]);//찾을 숫자.
			boolean flag = true;
			int half = queue.size() / 2;
			int pointer = -1;//숫자의 위치

			
			while(flag) {
				
				if (queue.get(0) == findNum) {queue.remove(0); flag = false;}
				else {
					
					for (int j = 0; j < queue.size(); j++) {
						if (queue.get(j) == findNum) {pointer = j; break;}
					}
					
					if (pointer > half) queue.rightShift();
					else queue.leftShift();
					
					answerCount++;
				}
			}//while
			
		}//for
		
		bw.write(answerCount + " ");
		bw.close();
		br.close();
		
	}
}
