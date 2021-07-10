package com.test.algorithm;

public class SegmentTree {
	static int[] tree, arr;
	
	public static void main(String[] args) {
	
		int N = 8;
		tree = new int[N * 4];
		arr = new int[N+1];
		
		for (int i = 1; i <= 8; i++) {
			arr[i] = i;
		}
		
		
//		for (int i = 0; i < 8; i++) {
//			System.out.println(arr[i]);
//		}
		
		init(1,N,1);
		
		
		for (int i = 0; i < tree.length; i++) {
			System.out.print(tree[i] + " ");
		}
		
 		
	}
	
	
	public static int init(int start, int end, int node) {
		
		if (start == end) {
			//System.out.println("**node : " + node + ",start : " + start + " end : " + end);
			return tree[node] = arr[start];
		}
		
		int mid = (start + end) / 2;
		//System.out.println("node : " + node + ",start : " + start + " end : " + end);
		//return tree[node] = Math.min(init(start, mid, node * 2), init(mid + 1, end, node * 2 + 1));//재귀적인 방법.
		return tree[node] = init(start,mid,node*2) + init(mid+1,end,node*2 + 1);
	}//무슨 말인지 전혀 모르겠다 이말이제...;;
}
