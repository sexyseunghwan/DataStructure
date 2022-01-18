package com.test.algorithm;

import java.io.*;

public class RobotClean14503_3 {
	
	static int cleanCount = 0;
    static int[][] map;
    static int index;
    static int[] dr = {0,1,0,-1};//행에 관한 방향데이터
    static int[] dc = {1,0,-1,0};//열에 관한 방향 데이터
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
	    String[] inputs = br.readLine().split(" ");
	    int N = Integer.parseInt(inputs[0]);
	    int M = Integer.parseInt(inputs[1]);
	    
	    map = new int[N][M];
	    
	    String[] robots = br.readLine().split(" ");
	    int rr = Integer.parseInt(robots[0]);//로봇의 행 위치
	    int rc = Integer.parseInt(robots[1]);//로봇의 열 위치
	    int rd = Integer.parseInt(robots[2]);//로봇의 방향
	    
	    //맵의 속성 대입
	    for (int i = 0; i < N; i++) {
	        String[] rInfos = br.readLine().split(" ");
	        for (int j = 0; j < M; j++) {
	            map[i][j] = Integer.parseInt(rInfos[j]);
	        }
	    }//for
		
	    cleanStart(rr,rc,rd,false);
	    
	    bw.write(cleanCount + "");
	    bw.close();
	    br.close();
		
	}
	
	static void cleanStart(int rr,int rc, int rd, boolean backYn) {
	    
		if (!backYn) {
			map[rr][rc] = 2;//청소
		    cleanCount++;//청소구역 카운트
		}
	    
	    
	    for (int i = 0; i < 4; i++) {
	    	rd = leftRotate(rd);
	    	
	    	System.out.println("rd : "+ rd);
	    	
	    	int nr = rr + dr[index];
	    	int nc = rc + dc[index];
	    	
	    	if (map[nr][nc] == 0) {
	    		cleanStart(nr,nc,rd,false);
	    		return;
	    	}	
	    }
	    
	    //4면 중 청소할수 있는 공간이 없을 경우
	    backRotate(rd);
	    int nr = rr + dr[index];
	    int nc = rc + dc[index];
	    if (map[nr][nc] != 1) cleanStart(nr,nc,rd,true);
	    else return;
	    
	    
	}

	static int leftRotate(int rd) {
		
		index = (rd + 2) % 4;
		return (rd + 3) % 4;
		
		
	}

	static void backRotate(int rd) {
		
		index = (rd + 1)  % 4;

	}
}
