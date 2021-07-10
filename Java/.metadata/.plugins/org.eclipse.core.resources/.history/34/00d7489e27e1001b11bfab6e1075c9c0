package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Island4963 {
	
	/*
	  
	  문제
	정사각형으로 이루어져 있는 섬과 바다 지도가 주어진다. 섬의 개수를 세는 프로그램을 작성하시오.



	한 정사각형과 가로, 세로 또는 대각선으로 연결되어 있는 사각형은 걸어갈 수 있는 사각형이다. 

	두 정사각형이 같은 섬에 있으려면, 한 정사각형에서 다른 정사각형으로 걸어서 갈 수 있는 경로가 있어야 한다. 
	지도는 바다로 둘러싸여 있으며, 지도 밖으로 나갈 수 없다.

	입력
	입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스의 첫째 줄에는 지도의 너비 w와 높이 h가 주어진다. 
	w와 h는 50보다 작거나 같은 양의 정수이다.

	둘째 줄부터 h개 줄에는 지도가 주어진다. 
	1은 땅, 0은 바다이다.

	입력의 마지막 줄에는 0이 두 개 주어진다.

	출력
	각 테스트 케이스에 대해서, 
	섬의 개수를 출력한다.

	예제 입력 1 
	1 1
	0
	2 2
	0 1
	1 0
	3 2
	1 1 1
	1 1 1
	5 4
	1 0 1 0 0
	1 0 0 0 0
	1 0 1 0 1
	1 0 0 1 0
	5 4
	1 1 1 0 1
	1 0 1 0 1
	1 0 1 0 1
	1 0 1 1 1
	5 5
	1 0 1 0 1
	0 0 0 0 0
	1 0 1 0 1
	0 0 0 0 0
	1 0 1 0 1
	0 0
	
	예제 출력 1 
	0
	1
	1
	3
	1
	9

	 **/

	static int arr[][];
	static int col, row;
	static int islandCount = 0;
	static void search(int r, int c) {
		arr[r][c] = 0;
		int dx,dy;
		int ax[] = {1,1,0,-1,-1,-1,0,1};
		int ay[] = {0,1,1,1,0,-1,-1,-1};
		
		for (int i = 0; i < 8; i++) {
			dx = r + ax[i];
			dy = c + ay[i];
			if (arr[dx][dy] == 1) {
				search(dx,dy);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			col = Integer.parseInt(stk.nextToken());
			row = Integer.parseInt(stk.nextToken());
			
			if (col == 0 && row == 0) {
				break;
			} else {
				arr = new int[row+2][col+2];
				
				for (int i = 1; i <= row; i++) {
					String[] contents = br.readLine().split(" "); 
					for (int j = 1; j <= col; j++) {
						arr[i][j] = Integer.parseInt(contents[j-1]);
					}
				}//사용자 숫자를 행렬에 넣어주는 작업.
				
				//탐색과정 시작.
				for (int i = 1; i <= row; i++) {
					for (int j = 1; j <= col; j++) {
						if (arr[i][j] == 1) {
							islandCount++;
							search(i,j);
						}
					}
				}		
			}
			bw.write(islandCount + "\n");
			islandCount= 0;
		}
		
		bw.close();
			
	}
}

