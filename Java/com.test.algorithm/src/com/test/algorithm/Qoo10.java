package com.test.algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;



public class Qoo10 {
	public static void main(String[] args) throws Exception{
		
		BufferedReader readerStaging = new BufferedReader(new FileReader("C:\\test\\app.txt"));
		
		String line = null;
		
		List<String[]> staging = new ArrayList<String[]>();
		List<String[]> errorList = new ArrayList<String[]>();
		
		while((line = readerStaging.readLine())!= null) {
			//String[] input = line.split("%\s+");
			
			//System.out.println(line);
			//System.out.println(line.length());
			
			String[] inputs = new String[4];//이름,형,크기,null 유무
			
			String voca = "";
			int index = 0;
			
			for (int i = 0; i < line.length(); i++) {
				
				String word = line.substring(i,i+1);
				
				if (!word.matches("^[a-zA-Z0-9]$") && (!word.equals("_"))) {
					if (voca.equals("")) {
						
					} else {
						inputs[index] = voca;
						index++;
					}
					voca = "";
				} else {
					voca += line.substring(i,i+1);
				}
				
			}//for

			staging.add(inputs);
			//System.out.println("=====================");
			
			//System.out.println(line);
			
		}//while
		
		
		//System.out.println(staging.toArray());
		
		for (int i = 0; i < staging.size(); i++) {
			
			for (int j = 0; j < 4; j++) {
				System.out.print(staging.get(i)[j] + " ");
			}
			System.out.println();
		}
		//========================여기까지가 스테이징====================
		
		
		System.out.println("*********************************************************");
		
		List<String[]> erdArr = new ArrayList<String[]>();
		
		BufferedReader readerErd = new BufferedReader(new FileReader("C:\\test\\data.txt"));
		
		String line2 = null;
		
		String[] inputErd = new String[3];//이름,형,크기,null 유무
		int indexErd = 0;
		
		while((line2 = readerErd.readLine())!= null) {
			
			//System.out.println(line2);
			
			if (indexErd == 2) {
				if (line2.toLowerCase().equals("not null")) {
					inputErd[indexErd] = "no";
				} else {
					inputErd[indexErd] = "yes";
				}
				
				erdArr.add(inputErd);
				indexErd = 0;
				inputErd = new String[3];
			} else {
				
				inputErd[indexErd] = line2;
				indexErd++;
			}
			
//			if (indexErd == 2) {
//				erdArr.add(inputErd);
//				indexErd = 0;
//			}
			
		}//while
		
		
		//System.out.println(erdArr.size());
		
		for (int i = 0; i < erdArr.size(); i++) {
			
			for (int j = 0; j < 3; j++) {
				System.out.print(erdArr.get(i)[j] + " ");
			}
			System.out.println();
		}
		
		
		
	}

}
