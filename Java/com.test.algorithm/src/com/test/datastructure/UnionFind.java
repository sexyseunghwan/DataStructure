package com.test.datastructure;

//union find 알고리즘
public class UnionFind {
	public static void main(String[] args) {
		
		int[] parent = new int[11];
		
		for (int i = 0; i < 11; i++) {
			parent[i] = i;//자기자신을 부모로 가리키기로 지정해줌
		}
		
		//System.out.println(getParent(parent,0));
		unionParent(parent,0,1);
		unionParent(parent,1,2);
		unionParent(parent,2,3);
		unionParent(parent,4,5);
		unionParent(parent,5,6);
		unionParent(parent,6,7);
		
		System.out.println(getParent(parent,2));
		
	}
	
	static int getParent(int[] parent,int x) {
		if (parent[x] == x) return x;
		return parent[x] = getParent(parent,parent[x]);
	}
	
	static void unionParent(int parent[],int a,int b) {
		a = getParent(parent,a);
		b = getParent(parent,b);
		
		if (a < b) parent[b] = a;
		else parent[a] = b;
	}
	
	static int findParent(int parent[],int a,int b) {
		a = getParent(parent,a);
		b = getParent(parent,b);
		if (a == b) return 1;
		return 0;
	}
}
