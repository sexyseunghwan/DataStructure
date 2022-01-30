package com.test.algorithm;

import java.io.*;
import java.util.*;

public class Crash2_2_14442
{
	static int N,M,R;
	static int[][] map;
	static int[][] visit;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	static int amt = Integer.MAX_VALUE;
	
	static class Node{
	    int r,c,step,drill;
	    
	    public Node(int r, int c, int step, int drill) {
	        this.r = r;
	        this.c = c;
	        this.step = step;
	        this.drill = drill;
	    }
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] rc = br.readLine().split(" ");
		
		N = Integer.parseInt(rc[0]);//행
		M = Integer.parseInt(rc[1]);//열
		R = Integer.parseInt(rc[2]);//벽 부술 수 있는 최대 횟수
		
		map = new int[N][M];
		visit = new int[N][M];
		
        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
                visit[i][j] = Integer.MAX_VALUE;
            }
        }
        
        bfs(0,0);
        
        if (amt == Integer.MAX_VALUE) amt = -1;
        
        bw.write(amt + "");
        bw.close();
        br.close();
		
	}
	
	static void bfs(int r, int c) {
	    
	    Deque<Node> queue = new ArrayDeque<>();
	    Node node = new Node(r,c,1,0);
	    queue.offer(node);
	    
	    while(!queue.isEmpty()) {
	       Node nd = queue.poll();
	       
	       if (nd.r == N-1 && nd.c == M-1) {
	           amt = nd.step;
	           break;
	       }
	       
	       for (int i = 0; i < 4; i++) {
	           int nr = nd.r + dr[i];
	           int nc = nd.c + dc[i];
	           
	           if (nr < 0 || nc < 0 || nr >= N || nc >= M || visit[nr][nc] <= nd.drill) continue;
	           
	           if (map[nr][nc] == 0) {
	               queue.offer(new Node(nr,nc,nd.step+1,nd.drill));
	               visit[nr][nc] = nd.drill;
	           } else if (nd.drill < R) {
	               queue.offer(new Node(nr,nc,nd.step+1,nd.drill+1));
	               visit[nr][nc] = nd.drill+1;
	           }
	       }
	    }//while
	}
}