package com.test.datastructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class MazeAlgorithm {
	
	
	public static void main(String[] args) throws Exception{
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		Queue<int[]> queue = new LinkedList<>();
		
		int[] num = {1,1};
		
		queue.offer(num);
		
		int[] num1 = {1,2};
		
		queue.offer(num);
		
		int[] num2 = {1,3};
		
		queue.offer(num);
		
		
		//System.out.println(queue.poll()[0]);
		//System.out.println(queue.poll()[1]);
		
	}
	
	static void bfs() {
		
	}
}
