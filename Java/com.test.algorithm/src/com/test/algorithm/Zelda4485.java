package com.test.algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Zelda4485 {
	public static void main(String[] args) throws Exception {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		PriorityQueue<Goods> pq = new PriorityQueue<>(new Comparator<Goods>() {

			@Override
			public int compare(Goods o1, Goods o2) {
				if (o1.getAge() > o2.getAge()) return -1;
				else if (o2.getAge() > o1.getAge()) return 1;
				else return 0;
			}
			
		});
		
		Goods g1 = new Goods("엄복동",11);
		Goods g2 = new Goods("리무진",32);
		Goods g3 = new Goods("글림피",5);
		
		pq.offer(g1);
		pq.offer(g2);
		pq.offer(g3);
		
		
		System.out.printf("%s %d\n",pq.peek().getName(),pq.peek().getAge());
		pq.poll();
		System.out.printf("%s %d\n",pq.peek().getName(),pq.peek().getAge());
		pq.poll();
		System.out.printf("%s %d\n",pq.peek().getName(),pq.peek().getAge());

		
	}
}



class Goods {
	private String name;
	private int age;
	
	public Goods(String name,int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}