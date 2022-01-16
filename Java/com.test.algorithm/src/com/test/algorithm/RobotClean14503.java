package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RobotClean14503 {
	
	static int[][] map;
	static int N,M;
	static int cleanCount = 0;
	
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
			int[] cor = leftRotate(p);
			int vx = cor[0];
			int vy = cor[1];
			p = cor[2];
			
			int newX = x + vx;
			int newY = y + vy;
			
			if (map[newX][newY] == 0) {
				start(newX,newY,p,0);
				return;
			}
		}
		
		//4면이 막힌경우이거나 청소가 이미 된경우
		int[] backCor = backGo(p);
		
		int backX = x + backCor[0];
		int backY = y + backCor[1];	
		
		if (map[backX][backY] != 1) {
			start(backX, backY,p,1);
			return;
		} else return;
	}
	
	static int[] leftRotate(int p) {
		
		int[] cor = new int[3];
		
		if (p == 0) {
			cor[0] = 0;
			cor[1] = -1;
			cor[2] = 3;
		} else if (p == 1) {
			cor[0] = -1;
			cor[1] = 0;
			cor[2] = 0;
		} else if (p == 2) {
			cor[0] = 0;
			cor[1] = 1;
			cor[2] = 1;
		} else {
			cor[0] = 1;
			cor[1] = 0;
			cor[2] = 2;
		}
		
		return cor;
	}
	
	static int[] backGo(int p) {
		
		int[] cor = new int[2];
		
		if (p == 0) {
			cor[0] = 1;
			cor[1] = 0;
		} else if (p == 1) {
			cor[0] = 0;
			cor[1] = -1;
		} else if (p == 2) {
			cor[0] = -1;
			cor[1] = 0;
		} else {
			cor[0] = 0;
			cor[1] = 1;
		}
		
		return cor;
	}
	
	
	
}
