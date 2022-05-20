package com.test.algorithm;

import java.io.*;
import java.util.*;

public class MoonFox16118
{   
    static int N,M;
    static ArrayList<Node>[] map;
    static double[][] wolfResultArr;
    static int[] foxResultArr;
    static int INF = Integer.MAX_VALUE;
    
    static class Node {
        int u,d;
        
        public Node(int u, int d) {
            this.u = u;
            this.d = d;
        }
    }
    
    static class FoxNode implements Comparable<FoxNode> {
        int u,d;
        
        public FoxNode(int u, int d) {
            this.u = u;
            this.d = d;
        }
        
        @Override
        public int compareTo(FoxNode o) {
            if (this.d < o.d) {
                return -1;
            }
            return 1;
        }
    }
    
    static class WolfNode implements Comparable<WolfNode> {
        int u,w;
        double d;
        
        public WolfNode(int u, int w, double d) {
            this.u = u;
            this.w = w;
            this.d = d;
        }
        
        @Override
        public int compareTo(WolfNode o) {
            if (this.d < o.d) {
                return -1;
            }
            return 1;
        }
    }
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stk = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		
		wolfResultArr = new double[N+1][2];
		foxResultArr = new int[N+1];
		map = new ArrayList[N+1];
		
		for (int i = 0; i <= N; i++) {
		   map[i] = new ArrayList<Node>(); 
		}
		
		for (int i = 0; i < M; i++) {
		    stk = new StringTokenizer(br.readLine()," ");
		    
		    int u = Integer.parseInt(stk.nextToken());
		    int v = Integer.parseInt(stk.nextToken());
		    int d = Integer.parseInt(stk.nextToken());
		    
		    map[u].add(new Node(v,d));
		    map[v].add(new Node(u,d));
		}
		
		dijkstraFox();
		dijkstraWolf();
		
		int minCount = 0;
		
		for (int i = 0; i <= N; i++) {
		    if (foxResultArr[i] < wolfResultArr[i][0] && foxResultArr[i] < wolfResultArr[i][1]) minCount++;
		}
	    
	    bw.write(minCount + "");
	    bw.close();
	    br.close();
	}
	
	static void dijkstraFox() {
	    
	    for (int i = 0; i <= N; i++) {
	        foxResultArr[i] = INF;
	    }
	    
	    PriorityQueue<FoxNode> pq = new PriorityQueue<>();
	    pq.offer(new FoxNode(1,0));
	    foxResultArr[1] = 0;
	    
	    while(!pq.isEmpty()) {
	        int curU = pq.peek().u;
	        int curD = pq.peek().d;
	        
	        pq.poll();
	        
	        if (foxResultArr[curU] < curD) continue;
	        
	        for (int i = 0; i < map[curU].size(); i++) {
	            int nextU = map[curU].get(i).u;
	            int nextD = map[curU].get(i).d + curD;
	            
	            if (foxResultArr[nextU] > nextD) {
	                foxResultArr[nextU] = nextD;
	                pq.offer(new FoxNode(nextU,nextD));
	            }
	        }
	    }
	}
	
	static void dijkstraWolf() {
	    for (int i = 0; i <= N; i++) {
	        for (int j = 0; j < 2; j++) {
	            wolfResultArr[i][j] = INF;
	        }
	    }
	    
	    PriorityQueue<WolfNode> pq = new PriorityQueue<>();
	    pq.offer(new WolfNode(1,0,0));
	    wolfResultArr[1][0] = 0;
	    
	    while(!pq.isEmpty()) {
	       	int curU = pq.peek().u;
	        double curD = pq.peek().d;
	        int curW = pq.peek().w;
	        
	        pq.poll();
	        
	        if (wolfResultArr[curU][curW] < curD) continue;
	        
	        for (int i = 0; i < map[curU].size(); i++) {
	           	int nextU = map[curU].get(i).u;
	            int nextW;
	            double nextD;
	            
	            if (curW == 0) {
	                nextD = (map[curU].get(i).d * 0.5) + curD;  
	                nextW = 1;
	            }
	            else {
	               nextD = (map[curU].get(i).d * 2) + curD;
	               nextW = 0;
	            }
	            
	            if (wolfResultArr[nextU][nextW] > nextD) {
	                wolfResultArr[nextU][nextW] = nextD;
	                pq.offer(new WolfNode(nextU,nextW,nextD));
	            }
	        }
	    }
	}
}

