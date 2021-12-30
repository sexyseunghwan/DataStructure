package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Laboratory_14502_2 {
	
	static int N,M;
	static int maxCount = 0;
	static int[][] map;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	//맵 안의 순서쌍 객체(위치객체)
	static class VirusNode {
		int x,y;
		
		VirusNode(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] inputs = br.readLine().split(" ");
		
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}// 맵 생성
		
		dfs(0);
		
		bw.write(maxCount + "");
		bw.close();
		br.close();
		
	}
	
	static void dfs(int cnt) {
		
		//만약 벽이 세개가 세워졌다면, 바이러스를 퍼뜨린다.
		if (cnt == 3) {
			bfs();
			return;
		}
		
		//map 중에서 세개의 벽을 랜덤으로 하나씩 세워주는 작업
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					dfs(cnt+1);
					map[i][j] = 0;
				}
			}
		}
		
	}
	
	static void bfs() {
		
		int[][] virus_map = new int[N][M];
		Queue<VirusNode> que = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				virus_map[i][j] = map[i][j];
			}
		}
		
		//바이러스가 있는 위치 큐에 담아주기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (virus_map[i][j] == 2) {
					que.add(new VirusNode(i, j));
				}
			}
		}
		
		while(!que.isEmpty()) {
			VirusNode vr = que.poll();
			
			for (int i = 0; i < 4; i++) {
				int newX = vr.x + dx[i];
				int newY = vr.y + dy[i];
				
				if (newX >= 0 && newY >= 0 && newX < N && newY < M && virus_map[newX][newY] == 0) {
					virus_map[newX][newY] = 2;
					que.offer(new VirusNode(newX, newY));
				}
				
			}
		}
		
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (virus_map[i][j] == 0) {
					count++;
				}
			}
		}
		
		maxCount = Math.max(count, maxCount);
		
	}
	
}
