package com.test.algorithm;

import java.util.StringTokenizer;
 
public class TestMain {
 
  
    public static void main(String[] args) throws Exception {
    	
    	
    	StringTokenizer stk = new StringTokenizer("85#","#");
		
		while(stk.hasMoreTokens()) {
    		System.out.println(stk.nextToken());
    	}
    	
    	
    	
		
    }
 
   
}