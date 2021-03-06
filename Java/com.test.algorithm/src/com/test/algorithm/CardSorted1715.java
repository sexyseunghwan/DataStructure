package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;


public class CardSorted1715 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer n1, Integer n2) {
				
				if (n1 > n2) return 1;
				else if (n2 > n1) return -1;
				else return 0;
			}
		});
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			pq.offer(num);
		}
		
		int result = 0;
		int count = 0;
		
		while(!pq.isEmpty()) {
			if (count == N-1) break;
			
			int sum = 0;
			
			for (int i = 0 ; i < 2; i++) {
				sum += pq.poll();
			}
			
			result += sum;
			pq.offer(sum);
			count++;
		}
		
		bw.write(result + "");
		bw.close();
		br.close();
		
	}
}
