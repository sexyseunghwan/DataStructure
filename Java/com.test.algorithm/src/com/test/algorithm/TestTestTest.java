package com.test.algorithm;

import java.util.LinkedList;

public class TestTestTest {

	
	public static void main(String[] args) {
		
		
		int[] arr = new int[4];
		
		for (int i = 0; i < 4;i++) {
			arr[i] = i+34;
		}
		
		
		
		int[] test = arr;
		
		
		for (int i = 0; i < 4; i++) {
			System.out.println(test[i]);	
		}
		
		
		System.out.println("==================");
		
		test[0] = 9300;
		
		for (int i = 0; i < 4; i++) {
			System.out.println(arr[i]);	
		}
		
		
		
		
	}
	
}
