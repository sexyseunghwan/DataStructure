package com.test.algorithm;



class Review {
	
	public String name;
	public int taste;
	public int amount;
	public int deliver_time;
	
	public Review(String name,int taste, int amount,int deliver_time) {
		
		this.name = name;
		this.taste = taste;
		this.amount = amount;
		this.deliver_time = deliver_time;
		
	}
	
	public void print_review() {
		
		System.out.printf("======== %s =======",this.name);
		System.out.println("맛 : " + this.taste);
		System.out.println("양 : " + this.amount);
		System.out.println("배달시간 : " + this.deliver_time);
	
	}
	
}


public class ReviewTest {
	
	//public static 
	
	public static void main(String[] args) {
		
		
		
		
		
		
	}

}
