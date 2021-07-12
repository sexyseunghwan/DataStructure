package com.test.datastructure;


//조합 구현
public class Combination {
	
	
	private static boolean[] selected;
	private static int arr[];
	private static int totalCnt = 0;
	
	
	public static void main(String[] args) {
		
		selected = new boolean[4];
		arr = new int[]{1,2,3,4};
		
		dfs(0,0,2);
		
	}	
	
	
	public static void dfs(int idx, int cnt,int r) {
		
		if (cnt == r) {
			totalCnt++;
			print();
			return;
			
		}
		
		for (int i = idx; i < arr.length; i++) {
			
			if(selected[i]) continue;
			
			selected[i] = true;
			
			dfs(i,cnt+1,r);
			selected[i] = false;
		}
	}
	
	public static void print() {
		for(int i = 0; i < arr.length; i++) {
			if (selected[i]) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();
	}
	
	
}
