package com.test.algorithm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * 
 * @author shin
 *
 */
public class PagingAlgorithm {
	static List<String[]> testArr;
	
	
	public void make() {//tblinsa의 모든 정보를 가져올것이다.
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		//DBUtill2 util = new DBUtill2(); -> DB연결해주는 코드
		
		
		try {
			
			String sql = "select * from tblinsa";
			//conn = util.open(); -> DB접속
			stat = conn.createStatement();
			
			
			rs = stat.executeQuery(sql);
			
			testArr = new ArrayList<String[]>();
			
			while(rs.next()) {
				
				
				String[] strList = {rs.getString(1),
									rs.getString(2),
									rs.getString(3),
									rs.getString(4).substring(0,11),
									rs.getString(5),
									rs.getString(6),
									rs.getString(7),
									rs.getString(8),
									rs.getString(9),
									rs.getString(10)};
				
				testArr.add(strList);
				
			}//while()
			
			
			stat.close();
			conn.close();
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("오류발생");
		}
		
		
		
	}//make()
	
	
	/**
	 * 페이징해주는 메소드
	 * @param inputList 페이징할 리스트를 적는다 
	 * @param count 한페이지당 몇개의 정보를 가져올건지 정해준다
	 */
	public void page(List<String[]> inputList,int cut)//여기서 직접적으로 페이징을 해줄것이다
	{
		Scanner scan = new Scanner(System.in);
		
		int listLen = inputList.size();//리스트 전체의 길이
		
		int q = listLen/cut;//몫
		int r = listLen%cut;//나머지 -> 나머지가 0이 아니면 바로 올려준다!
		
		if (r != 0) q++;//나머지가 0이 아니면 몫을 하나 올려준다 -> 즉 페이지를 하나 더 만들어준다는 의미가 된다!
		
		//0 ~ cut-1까지 나올것
		
		int index = 1;//인덱스
		int startIndex = 0;//시작인덱스
		
		boolean flag = true;
		
		while(flag) {
			
			//딱 떨어지는 숫자와 아닌것의 차이가 존재한다!
			if (startIndex == cut*(q-1) && r!=0) {//딱 떨어지는 숫자는 여기에 필터 걸릴 일이 없음
				//System.out.println("여기로들어옴");
				for (int i = startIndex; i < startIndex + r; i++) {
					for (int j = 0; j < inputList.get(0).length; j++) {
						System.out.print(inputList.get(i)[j] + " ");
					}
					System.out.println();
					
				}//for
				
			} else {
				for (int i = startIndex; i < cut * index; i++) {
					
					for (int j = 0; j < inputList.get(i).length; j++) {
																		
						System.out.print(inputList.get(i)[j] + " ");
					}
					System.out.println();

				} // for

			}
			
			if (startIndex == 0) {
				System.out.println("1. 다음페이지");
				System.out.println("0. 종료");
				System.out.print("입력 : ");
				String input = scan.nextLine();
				
				if (input.equals("1")) {
					startIndex += cut;
					index++;
				} else {
					flag = false;
				}
				
				
			} else if (startIndex == cut*(q-1)) {
				System.out.println("1. 이전페이지");
				System.out.println("0. 종료");
				System.out.print("입력 : ");
				String input = scan.nextLine();
				
				if (input.equals("1")) {
					startIndex -= cut;
					index--;
				} else {
					flag = false;
				}
				
				
			} else {
				System.out.println("1. 다음페이지");
				System.out.println("2. 이전페이지");
				System.out.println("0. 종료");
				System.out.print("입력 : ");
				String input = scan.nextLine();
				
				if (input.equals("1")) {
					startIndex += cut;
					index++;
				} else if (input.equals("2")){
					startIndex -= cut;
					index--;
				} else {
					flag = false;
				}
				
				
			}


		}//while()
 		
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		
	
		PagingAlgorithm pg = new PagingAlgorithm();
		pg.make();
		pg.page(testArr,7);
		

	}

}