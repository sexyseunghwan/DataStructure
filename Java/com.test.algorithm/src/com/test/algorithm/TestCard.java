package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class TestCard {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int input = Integer.parseInt(br.readLine());
		
		Queue<Integer> myQ = new LinkedList<Integer>();
		
		for (int i = 0; i < input; i++) {
			myQ.add(i + 1);
		}
		
		while(myQ.size() != 1) {
			myQ.poll();
			int instance = myQ.poll();
			myQ.add(instance);
		}
		
		bw.write(myQ.peek() + "");
		br.close();
		bw.close();
		
	}
}
