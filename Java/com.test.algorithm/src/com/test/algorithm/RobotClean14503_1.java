package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RobotClean14503_1 {
	
	static int[][] map;
	static int N,M;
	static int cleanCount = 0;
	static int vindex = 0;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);
		
		map = new int[N][M];
		
		String[] robots = br.readLine().split(" ");//로봇의 위치정보와 방향정보
		
		int robotsX = Integer.parseInt(robots[0]);
		int robotsY = Integer.parseInt(robots[1]);
		int robotsP = Integer.parseInt(robots[2]);
		
		//map 초기화
		for (int i = 0; i < N; i++) {
			String[] maps = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(maps[j]);
			}
		}
		
		start(robotsX,robotsY,robotsP,0);
		
		
		bw.write(cleanCount + "");
		bw.close();
		br.close();
	}
	
	static void start(int x, int y, int p,int fb) {
		
		if (fb == 0) {
			map[x][y] = 2;
			cleanCount++;
		}
		
		for (int i = 0; i < 4; i++) {
			
			p = leftRotate(p);
			
			int newX = x + dx[vindex];
			int newY = y + dy[vindex];
			
			if (map[newX][newY] == 0) {
				start(newX,newY,p,0);
				return;
			}
		}
		
		//4면이 막힌경우이거나 청소가 이미 된경우
		backGo(p);
		
		int backX = x + dx[vindex];
		int backY = y + dy[vindex];	
		
		if (map[backX][backY] != 1) {
			start(backX, backY,p,1);
			return;
		} else return;
	}
	

	static int leftRotate(int p) {

		vindex = (p + 2) % 4;

		return (p+3) % 4;
	}
	
	static void backGo(int p) {

		vindex =  (p + 1) % 4;

	}
}
