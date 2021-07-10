package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ADFGVX {
	
	static void arrPrint(String[][] arr) {
		
		int rows = arr.length;
		int col = arr[0].length;
		
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static void arrPrint(List<String> arr) {
		
		System.out.println(arr);
		
	}
	
	static void naturalPrint(List<String> arr) {
		
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i));
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		String[][] initialMatrix = new String[11][11];//여기에 암호들이 들어있음.
		String[] standard = {"A","D","F","G","V","X","S","B","M","G"};
//		String[] innerContents = {"K","Z","W","R","1","F","9","B","6","C","L","5",
//									"Q","7","J","P","G","X","E","V","Y","3","A","N",
//									"8","O","D","H","0","2","U","4","I","S","T","M"};
		
		String[] innerContents = {"K","Z","W","R","1","F","<","l","c","**",
								  "9","B","6","C","L","5",".","x","&","**",
								  "Q","7","J","P","G","X",">","m","*","**",
								  "E","V","Y","3","A","N","/","v","z","**",
								  "8","O","D","H","0","2","?","'","(","**",
								  "U","4","I","S","T","M","^","n","_","**",
								  "~","`","!","@","#","$","%","b","k","**",
								  "q","i","t","d",":","=","\"","j","h","**",
								  "f",")",";","p","g","s",",","a","o","**",
								  "u","+","y","r","e","w","-","\\","|"," "};
		
		//System.out.println(innerContents.length);//왜 90개가 된거야
		
		for (int i = 1; i <= standard.length; i++) {
			initialMatrix[0][i] = standard[i-1]; 
			initialMatrix[i][0] = standard[i-1];
		}
		
		int shift = 0;
		
		for (int i = 1; i < 11; i++) {
			for (int j = 1; j < 11; j++) {
				initialMatrix[i][j] = innerContents[shift++];
			}
		}
		
		arrPrint(initialMatrix);//암호판 확인 완료

		
		//System.out.println(innerContents.length);//확인용
		String input = br.readLine();//input -> 암호화 시킬값
		List<String> result = new ArrayList<String>();// 1차 암호화된 값을 담을 그릇
		
		
		//암호변환작업 1 -> encoding
		for (int i = 0; i < input.length(); i++) {
			
			String str = input.substring(i,i+1);
			
			for (int j = 1; j < 7; j++) {
				for (int k = 1; k < 7; k++) {
					
					if (str.equals(initialMatrix[j][k])) {
						result.add(initialMatrix[j][0]);
						result.add(initialMatrix[0][k]);
					}
				}
			}//for
		}//for -> 1차 암호화 완료
		
		System.out.println("=========");
		arrPrint(result);//1 차 암호화 확인 완료
		System.out.println("=========");
		
		
		//일단 후처리는 뒤에 맡겨두고  --> 제 2 암호화를 준비한다.
		String inputKey = br.readLine();//key 값 입력(**)
		int keyRow = (int)Math.ceil((double)result.size() / inputKey.length());//다운캐스팅 까지 완료 -> 올림을 통하여 행을 하나 늘려주는 역할을 수행한다.
		int keyCol = inputKey.length();//key의 길이
		
		System.out.println("****");
		System.out.println(keyRow);
		System.out.println(keyCol);
		System.out.println("****");
		
		String[][] keyMatrix = new String[keyRow+1][keyCol]; //2차 암호화된 결과를 담을 그릇 왜 플러스1을 해주는거지? -> key를 타이틀로 주기 위해서
		
		
		int keyIndex = 0;
		
		for (int i = 0; i < keyRow + 1; i++) {
			for (int j = 0; j < keyCol; j++) {
				
				if (i == 0) { //첫번째 줄일경우
					
					keyMatrix[i][j] = inputKey.substring(j,j+1);//위의 문자 키워드를 집어넣을 것이다. -> key 값을 적겠다는 의미가 된다.
					
				} else { // 두번째 줄 이상일 경우
					
					if (keyIndex < result.size()) {
						keyMatrix[i][j] = result.get(keyIndex++);
					} else {
						keyMatrix[i][j] = "P";
					}
				}
			}
		}//for
		
		arrPrint(keyMatrix);
		//여기까지 문제없음...
		
		//String[] finalArr = new String[keyRow*keyCol];//가변배열을 쓰는게 더 나음
		List<String> finalArr = new ArrayList<String>();//최종 암호화된 문자열을 집어넣을 곳이 된다.
		String[] keySort = inputKey.split("");//입력key를 부분부분 쪼갠다.
		Arrays.sort(keySort);//키 정렬 -> 우선순위를 배정하기 위함이다.
		
		
		
		for (int i = 0; i < keySort.length; i++) {
			
			String selectNum = keySort[i];//key 문자열 하나.
			
			for (int j = 0; j < keyCol; j++) {
				
				if (selectNum.equals(keyMatrix[0][j])) {
					
					
					for (int k = 1; k <= keyRow; k++) {
						
						finalArr.add(keyMatrix[k][j]);
						
					}
					
					break;
				}
			}	
		}//for
		
		
		arrPrint(finalArr);//암호화 완료.
		naturalPrint(finalArr);//
				
	}

}
