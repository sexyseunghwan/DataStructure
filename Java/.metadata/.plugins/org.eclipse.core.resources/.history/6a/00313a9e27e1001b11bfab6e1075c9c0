package com.test.algorithm;

import java.util.Scanner;

public class Tree2 {

	
	//이번시간에는 tree 를 이차원 배열구조로 생성해볼것이다.
	static int n;
	static int[][] tree;
	
	
	//1. 전위순회 방식
	public static void preOrder(int x) {
		
		//왼쪽 자식이나 오른쪽 자식이 없다면(-1 이라면) 순회하지 않는다.
		if (tree[x][0] == -1 && tree[x][1] == -1) {
			System.out.println(x + " ");
		} else {
			System.out.println(x + " ");
			if (tree[x][0] != -1) {
				preOrder(tree[x][0]);
			}
			if (tree[x][1] != -1) {
				preOrder(tree[x][1]);
			}
		}
	}//preOrder
	
	//2. 중위순회 방식 ~~>?! 
	public static void inOrder(int x) {
		
		if (tree[x][0] == -1 && tree[x][1] == -1) {
			System.out.println(x + " ");
		} else {
			
			if (tree[x][0] != -1) {
				inOrder(tree[x][0]);
			}
			
			System.out.println(x + " ");
			
			if (tree[x][1] != -1) {
				inOrder(tree[x][1]);
			}
		}
	}
	
	
	//3. 후위순회 방식
	public static void postOrder(int x) {
		if (tree[x][0] == -1 && tree[x][1] == -1) {
			System.out.println(x + " ");
		} else {
			
			if (tree[x][0] != -1) {
				postOrder(tree[x][0]);
			}
			if (tree[x][1] != -1) {
				postOrder(tree[x][1]);
			}
			System.out.println(x + " ");	
		}
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		tree = new int[n][2];//tree 저장을 위한 2차원 배열
		
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			tree[a][0] = b; // 0은 left
			tree[a][1] = c; // 1은 right
		}
		
		
		//1. 전위 순회 방식
		//preOrder(0);
		
		//2. 중위 순회 방식
		//inOrder(0);
		
		//3. 후위 순회 방식
		postOrder(0);
		
	}
}
