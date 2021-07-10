
/*
	 문제
	푸르고 아름다운 남해에는 많은 섬이 장관을 이루고 있다. 
	그림이 아니면 볼 수 없을 것 같은 아름다운 장관을 실제로 볼 수 있는 다도해로 상근이는 여행을 떠났다.
	
	다도해에 도착한 상근이는 서울에서 보던 것과는 다른 풍경에 큰 충격을 받았다. 
	지구 온난화로 인해 해수면이 상승해 섬의 일부가 바다에 잠겨버렸다.
	
	서울로 다시 돌아온 상근이는 이렇게 지구 온난화가 계속 될 경우 남해의 지도는 어떻게 바뀔지 궁금해졌다.
	
	다도해의 지도는 R*C 크기의 그리드로 나타낼 수 있다. 'X'는 땅을 나타내고, '.'는 바다를 나타낸다.
	
	50년이 지나면, 인접한 세 칸 또는 네 칸에 바다가 있는 땅은 모두 잠겨버린다는 사실을 알았다.
	
	상근이는 50년 후 지도를 그려보기로 했다. 섬의 개수가 오늘날보다 적어질 것이기 때문에, 
	지도의 크기도 작아져야 한다. 지도의 크기는 모든 섬을 포함하는 가장 작은 직사각형이다. 
	50년이 지난 후에도 섬은 적어도 한 개 있다. 또, 지도에 없는 곳, 지도의 범위를 벗어나는 칸은 모두 바다이다.
	
	입력
	첫째 줄에 지도의 크기 R과 C (1 ≤ R, C ≤ 10)가 주어진다. 다음 R개 줄에는 현재 지도가 주어진다.
	
	출력
	50년 후의 지도를 출력한다.
	
	예제 입력 1 
	3 10
	..........
	..XXX.XXX.
	XXX.......
	
	예제 출력 1 
	.XX...X
	XX..... 
 
*/
package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class GlobalWarming5212 {
	
	static String[][] answerMatrix;
	static String[][] matrix;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] inputs = br.readLine().split(" ");
		
		int row = Integer.parseInt(inputs[0]);//행
		int col = Integer.parseInt(inputs[1]);//열
		
		//행렬을 만들어야 한다? -> 가장자리 행렬을 하나씩 추가해준다.
		matrix = new String[row+2][col+2];
		answerMatrix = new String[row+2][col+2];
		
		//행렬에 바다표시 육지표시 표시를 해주기 -> 가장자리 표시를 위해서 행렬 하나씩 늘려준다.
		for (int i = 0; i < row + 2; i++) {
			for (int j = 0; j < col + 2; j++) {
				matrix[i][j] = ".";
				answerMatrix[i][j] = ".";
			}
		}//for
		
		//행렬 입력 받기
		for (int i = 1; i < row+1; i++) {
			String[] landSeas = br.readLine().split("");
			for (int j = 1; j < col+1; j++) {
				matrix[i][j] = landSeas[j-1];
			}
		}//for
		
		
		for (int i = 1; i < row + 1; i++) {
			for (int j = 1; j < col + 1; j++) {
				
				if (matrix[i][j].equals("X")) {
					int count = 0;//인접한곳에 바다가 몇개 있는지 카운트 해주려고 만들어준것이다.
					
					if (matrix[i-1][j].equals(".")) count++;
					if (matrix[i][j-1].equals(".")) count++;
					if (matrix[i+1][j].equals(".")) count++;
					if (matrix[i][j+1].equals(".")) count++;
					
					if (count >= 3) {
						answerMatrix[i][j] = ".";
					} else {
						answerMatrix[i][j] = "X";
					}
				}
			}
		}//for
		 
		//여기서 이제 마지막 답을 도출하기 위해서 바다를 제거해준다.
		int rstart = answerCheckAsc(row,col,1);
		int rlast = answerCheckDesc(row,col,1);
		int cstart = answerCheckAsc(col,row,0);
		int clast = answerCheckDesc(col,row,0);

		//답 도출하는 곳.
		for (int i = rstart; i <= rlast; i++) {
			for (int j = cstart; j <= clast; j++) {
				bw.write(answerMatrix[i][j] + "");
			}
			bw.write("\n");
		}

		br.close();
		bw.close();
		
	}
	
	static int answerCheckAsc(int index1,int index2, int select) {
		
		int answerIndex = 0;
		
		for (int i = 1; i < index1 + 1; i++) {
			boolean flag = true;
			for (int j = 1; j < index2 + 1; j++) {
				if (select == 1) {
					if (answerMatrix[i][j].equals("X")) {
						flag = false;
						answerIndex = i;
						break;
					}
				} else {
					if (answerMatrix[j][i].equals("X")) {
						flag = false;
						answerIndex = i;
						break;
					}
				}
			}
			if (!flag)  break;
		}
		return answerIndex;
	}
	
	static int answerCheckDesc(int index1,int index2, int select) {
		int answerIndex = 0;
		
		for (int i = index1; i >= 1; i--) {
			boolean flag = true;
			for (int j = 1; j < index2 + 1; j++) {
				if (select == 1) {
					if (answerMatrix[i][j].equals("X")) {
						flag = false;
						answerIndex = i;
						break;
					}
				} else {
					if (answerMatrix[j][i].equals("X")) {
						flag = false;
						answerIndex = i;
						break;
					}
				}
				
			}
			if (!flag) break;
		}
		return answerIndex;
	}
	
	static void dfs(int x, int y) {
		if (matrix[x][y].equals(".")) return;
		
		int cnt = 0;
	
		if (matrix[x-1][y].equals(".")) cnt++;
		if (matrix[x][y-1].equals(".")) cnt++;
		if (matrix[x+1][y].equals(".")) cnt++;
		if (matrix[x][y+1].equals(".")) cnt++;
		
		if (cnt >= 3) {answerMatrix[x][y] = ".";}
		else {answerMatrix[x][y] = "X";}
	}
}
