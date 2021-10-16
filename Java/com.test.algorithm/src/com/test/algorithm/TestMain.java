package com.test.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestMain {
	
	public static void main(String[] args) {
		
		Product p1 = new Product("갤럭시", 12000000);
		Product p2 = new Product("오포", 10000000);
		Product p3 = new Product("아이폰", 16000000);
		Product p4 = new Product("샤오미", 8000000);
		
		
		ArrayList<Product> arr = new ArrayList<Product>();
		arr.add(p1);
		arr.add(p2);
		arr.add(p3);
		arr.add(p4);
		
		Collections.sort(arr, new ListCompare());
		
		for (Product pd : arr) {
			System.out.println(pd.name);
			System.out.println(pd.price);
		}
		
		
	}
	
	static class ListCompare implements Comparator<Product> {

		@Override
		public int compare(Product p1, Product p2) {
			
			int productValue1 = p1.price;
			int productValue2 = p2.price;
			
			if (productValue1 > productValue2) return -1;
			else if (productValue1 < productValue2) return 1;
			else return 0;
		}
	
	}
	
	static class Product implements Comparator {
		public String name;
		public int price;
		
		public Product(String name,int price)  {
			this.name = name;
			this.price = price;
		}

		@Override
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
}
