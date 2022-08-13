package com.test.algorithm;

import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestMain {
 
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		Pattern pattern = Pattern.compile("^[a-zA-Z가-힣]*$");
		
		
		String test = "test하하하";
		
		
		Matcher mc = pattern.matcher(test);
		
		System.out.println(mc.find());
		
    }
 
}