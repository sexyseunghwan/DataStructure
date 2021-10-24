/*
 
 문제
N×M크기의 배열로 표현되는 미로가 있다.

1	0	1	1	1	1
1	0	1	0	1	0
1	0	1	0	1	1
1	1	1	0	1	1
미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 
한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.

위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

입력
첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각
각의 수들은 붙어서 입력으로 주어진다.

출력
첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.

예제 입력 1 
4 6
101111
101010
101011
111011


예제 출력 1 
15
예제 입력 2 
4 6
110110
110110
111111
111101


예제 출력 2 
9
예제 입력 3 
2 25
1011101110111011101110111
1110111011101110111011101
예제 출력 3 
38



예제 입력 4 
7 7
1011111
1110001
1000001
1000001
1000001
1000001
1111111
예제 출력 4 
13
 
 
 */

package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Maze2178_1 {
	
	static int N,M;
	static int[][] matrix;
	static int[][] visit;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static Queue<Node> queue = new LinkedList<>();
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);
		
		matrix = new int[N][M];
		visit = new int [N][M];
		
		for (int i = 0; i < N; i++) {
			String[] numInputs = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				matrix[i][j] = Integer.parseInt(numInputs[j]);
			}
		}
		
		Node node = new Node(0,0,1);
		queue.offer(node);
		visit[0][0] = 1;
		
		while(!queue.isEmpty()) {
			Node nodes = queue.poll();
	
			if (nodes.x == N-1 && nodes.y == M-1) {
				bw.write(nodes.count + "");
				bw.close();
				br.close();
				break;
			}
			
			bfs(nodes.x,nodes.y,nodes.count);
			
		}//while
	
		
	}
	
	static void bfs(int x,int y,int count) {
		
		for (int i = 0; i < 4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			
			if (newY < 0 || newX < 0 || newX >= N || newY >= M || matrix[newX][newY] == 0 || visit[newX][newY] == 1) continue;
			
			visit[newX][newY] = 1;
			Node node = new Node(newX,newY,count+1);
			queue.offer(node);
		}
	}
	
	static class Node {
		public int x;
		public int y;
		public int count;
		
		public Node(int x,int y,int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
}
