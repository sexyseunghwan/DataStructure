package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Maze2178 {

	static int[][] matrix;
	static int[][] visit;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int N, M;
	static Queue<int[]> queue = new LinkedList<>();
	static Queue<Integer> answerQueue = new LinkedList<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);

		matrix = new int[N][M];
		visit = new int[N][M];

		for (int i = 0; i < N; i++) {

			String[] numInputs = br.readLine().split("");

			for (int j = 0; j < M; j++) {
				matrix[i][j] = Integer.parseInt(numInputs[j]);
			}
		}

		// 초기화 지정
		int[] init = { 0, 0 };
		queue.offer(init);
		answerQueue.offer(1);
		visit[0][0] = 1;
		
		while (queue.size() != 0) {

			int[] curr = queue.poll();
			int count = answerQueue.poll();

			int curX = curr[0];
			int curY = curr[1];

			if (curX == N - 1 && curY == M - 1) {
				bw.write(count + "");
				bw.close();
				br.close();
				break;
			}

			checking(curX, curY, count);

		} // while

	}

	static void checking(int curX, int curY, int count) {

		for (int i = 0; i < 4; i++) {

			int newX = curX + dx[i];
			int newY = curY + dy[i];

			if (newY < 0 || newX < 0 || newY >= M || newX >= N || matrix[newX][newY] == 0 || visit[newX][newY] == 1)
				continue;

			int[] coordinate = new int[2];
			coordinate[0] = newX;
			coordinate[1] = newY;
			
			visit[newX][newY] = 1;//여기서 방문 체크를 안하면 메모리 초과가 발생함.
			
			queue.offer(coordinate);
			answerQueue.offer(count + 1);

		}

	}

}