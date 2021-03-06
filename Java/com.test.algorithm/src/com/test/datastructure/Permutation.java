package com.test.datastructure;


//순열 구현
public class Permutation {
	
	
	private static int[] list;
	private static int[] resultList;
	private static boolean[] visited;
	
	public static void main(String[] args) {
		
		list = new int[]{1,2,3};
		resultList = new int[3];
		visited = new boolean[3];
		
		
		permutation(0);
		
		
	}
	
	
	public static void permutation(int idx) {
		
		if (idx == 3) {
			
			for (int i = 0; i < resultList.length; i++) {
				System.out.print(resultList[i] + " ");
			}
			
			System.out.println();
			
			return;
		}
		
		for (int i = 0; i < list.length; i++) {
			
			if (visited[i]) continue;
			
			resultList[idx] = list[i];
			visited[i] = true;
			permutation(idx+1);
			visited[i] = false;
		}
	}
	
	
}
