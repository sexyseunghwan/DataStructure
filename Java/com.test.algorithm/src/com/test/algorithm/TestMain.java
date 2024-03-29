package com.test.algorithm;

import java.io.FileNotFoundException;
import java.util.Calendar;

public class TestMain {
 
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		Calendar c1 = Calendar.getInstance();
		
		//c1.add(Calendar.HOUR_OF_DAY,-9);
		
		int years = c1.get(Calendar.YEAR);
		int months = c1.get(Calendar.MONTH) + 1;
		int date = c1.get(Calendar.DATE);

		int hour = c1.get(Calendar.HOUR_OF_DAY);
		int min = c1.get(Calendar.MINUTE);
		int sec = c1.get(Calendar.SECOND);
		int milSec = c1.get(Calendar.MILLISECOND);
		
		
		StringBuffer sb = new StringBuffer();

		sb.append(years);
		sb.append("-");
		sb.append((Integer.toString(months)));
		sb.append("-");
		sb.append((Integer.toString(date)));
		sb.append(" ");
		
		sb.append((Integer.toString(hour)));
		sb.append(":");
		sb.append((Integer.toString(min)));
		sb.append(":");
		sb.append(sec);
		sb.append(".");
		sb.append(milSec);
		
		System.out.println(sb.toString());
		
    }
 
}