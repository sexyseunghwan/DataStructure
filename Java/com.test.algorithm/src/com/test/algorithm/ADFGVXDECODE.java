package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//Decryption 을 수행해 줄것이다.
//XDGVFVVXFGGPXGXXXAVP
public class ADFGVXDECODE {
	
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
	
	static void arrPrint(String[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
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
		
		
		//List<String> inputList = new ArrayList<String>();
		String[] inputList = br.readLine().split("");//encryption 한 값이 들어갈것이다.
		
		String decKey = br.readLine();//복호화를 위한 key 생성 
		String[] decKeySplitArrOrigin = decKey.split("");//split으로 쪼개는 작업 수행. -> origin.
		
		String[] decKeySplitArr = decKey.split("");//split으로 쪼개는 작업 수행.
		Arrays.sort(decKeySplitArr);//정렬 -> s e c u r -> c e r s u 로 변환
		
		int stepOneRow = inputList.length / decKey.length();// 2차 암호화때 도출된 매트릭스 행의 개수
		int stepOneCol = decKey.length();// 2차 암호화때 도출된 매트릭스 열의 개수
		
		String[][] stepOneMatrix = new String[stepOneRow][stepOneCol];
		
		int inputListIndex = 0;//inputList 의 index
		
		for (int i = 0; i < decKeySplitArr.length; i++) {
			
			String selectVoca = decKeySplitArr[i];//선택된 하나의 단어 -> 처음은 c일것이다.
			
			for (int j = 0; j < decKeySplitArrOrigin.length; j++) {//원조의 단어 split 한것과 비교를 해준다.
				
				if (selectVoca.equals(decKeySplitArrOrigin[j])) {
					
					for (int k = 0; k < stepOneRow; k++) {
						
						stepOneMatrix[k][j] = inputList[inputListIndex++];
					}
					
					break;
				}
			}
		}//for
		
		arrPrint(stepOneMatrix);//이상 없음
		
		System.out.println("=============================");
		
		// ============ 암호판 ============
		String[][] initialMatrix = new String[11][11];//여기에 암호들이 들어있음.
		String[] standard = {"A","D","F","G","V","X","S","B","M","Z"};
//		String[] innerContents = {"K","Z","W","R","1","F","9","B","6","C","L","5",
//									"Q","7","J","P","G","X","E","V","Y","3","A","N",
//									"8","O","D","H","0","2","U","4","I","S","T","M"};
		
		String[] innerContents = {"K","Z","W","R","1","F","<","l","c","**",
								  "Q","7","J","P","G","X",">","m","*","**",
								  "E","V","Y","3","A","N","/","v","z","**",
								  "8","O","D","H","0","2","?","'","(","**",
								  "U","4","I","S","T","M","^","n","_","**",
								  "~","`","!","@","#","$","%","b","k","**",
								  "q","i","t","d",":","=","\"","j","h","**",
								  "f",")",";","p","g","s",",","a","o","**",
								  "u","+","y","r","e","w","-","\\","|"," "};
		
		for (int i = 1; i <= standard.length; i++) {
			initialMatrix[0][i] = standard[i-1]; 
			initialMatrix[i][0] = standard[i-1]; 
		}
		
		int shift = 0;
		
		for (int i = 1; i < 7; i++) {
			for (int j = 1; j < 7; j++) {
				initialMatrix[i][j] = innerContents[shift++];
			}
		}
		// ============ 암호판 ============
		
		
		String[] finalArr = new String[stepOneRow*stepOneCol];//마지막 결과배열.
		int finalArrIndex = 0;
		
		for (int i = 0; i < stepOneRow; i++) {
			for (int j = 0; j < stepOneCol; j++) {
				finalArr[finalArrIndex++] = stepOneMatrix[i][j];
			}
		}
		
		arrPrint(finalArr);//이상 없음.
		System.out.println("============");
		arrPrint(initialMatrix);
		
		
		String answerVal = "";//최종 복호화 답
		
		int finalIndex = 0;
		int swich = 1;
		String finalRow = "";
		String finalCol = "";
		String[] resultVoca = {"A","D","F","G","V","X"};
		
		
		while(!finalArr[finalIndex].equals("P")) {
			System.out.println("?");
			swich *= -1;
			
			if (swich == 1) {
				finalCol = finalArr[finalIndex++];
				int row = 0;
				int col = 0;
				
				//여기서부터 탐색에 들어가야 한다. -> 나중에 업글을 시켜보자. -> 성능 튜닝.
				for (int i = 0; i < resultVoca.length; i++) {
					if (finalRow.equals(resultVoca[i])) {
						row = i+1;
						break;
					}
				}
				
				for (int i = 0; i < resultVoca.length; i++) {
					if (finalCol.equals(resultVoca[i])) {
						col = i+1;
						break;
					}
				}
				System.out.println("****");
				System.out.println(row);
				System.out.println(col);
				System.out.println("****");
				answerVal += initialMatrix[row][col];
				
			} else {
				finalRow = finalArr[finalIndex++];
				
			}
		}//while
		
		System.out.println(answerVal);
		//끝난거지 뭐 
		System.out.println("ASD");
		
	}

}
