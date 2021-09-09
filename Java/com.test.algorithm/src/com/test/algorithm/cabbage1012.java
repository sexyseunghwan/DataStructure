package com.test.algorithm;

import java.io.*;
/*
차세대 영농인 한나는 강원도 고랭지에서 유기농 배추를 재배하기로 하였다. 농약을 쓰지 않고 배추를 재배하려면 배추를 해충으로부터 보호하는 것이 중요하기 때문에, 
한나는 해충 방지에 효과적인 배추흰지렁이를 구입하기로 결심한다. 이 지렁이는 배추근처에 서식하며 해충을 잡아 먹음으로써 배추를 보호한다. 
특히, 어떤 배추에 배추흰지렁이가 한 마리라도 살고 있으면 이 지렁이는 인접한 다른 배추로 이동할 수 있어, 그 배추들 역시 해충으로부터 보호받을 수 있다. 
한 배추의 상하좌우 네 방향에 다른 배추가 위치한 경우에 서로 인접해있는 것이다.

한나가 배추를 재배하는 땅은 고르지 못해서 배추를 군데군데 심어 놓았다. 
배추들이 모여있는 곳에는 배추흰지렁이가 한 마리만 있으면 되므로 서로 인접해있는 배추들이 몇 군데에 퍼져있는지 조사하면 총 몇 마리의 지렁이가 필요한지 알 수 있다. 
예를 들어 배추밭이 아래와 같이 구성되어 있으면 최소 5마리의 배추흰지렁이가 필요하다. 0은 배추가 심어져 있지 않은 땅이고, 1은 배추가 심어져 있는 땅을 나타낸다.

1	1	0	0	0	0	0	0	0	0
0	1	0	0	0	0	0	0	0	0
0	0	0	0	1	0	0	0	0	0
0	0	0	0	1	0	0	0	0	0
0	0	1	1	0	0	0	1	1	1
0	0	0	0	1	0	0	1	1	1

입력
입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다. 그 다음 줄부터 각각의 테스트 케이스에 대해 첫째 줄에는 배추를 심은 배추밭의 가로길이 M(1 ≤ M ≤ 50)과 세로길이 N(1 ≤ N ≤ 50), 
그리고 배추가 심어져 있는 위치의 개수 K(1 ≤ K ≤ 2500)이 주어진다. 그 다음 K줄에는 배추의 위치 X(0 ≤ X ≤ M-1), Y(0 ≤ Y ≤ N-1)가 주어진다. 두 배추의 위치가 같은 경우는 없다.

출력
각 테스트 케이스에 대해 필요한 최소의 배추흰지렁이 마리 수를 출력한다.

예제 입력 1 
2
10 8 17
0 0
1 0
1 1
4 2
4 3
4 5
2 4
3 4
7 4
8 4
9 4
7 5
8 5
9 5
7 6
8 6
9 6
10 10 1
5 5

예제 출력 1 
5
1


예제 입력 2 
1
5 3 6
0 2
1 2
2 2
3 2
4 2
4 0


예제 출력 2 
2
 
 
 
 
 * */
public class cabbage1012 {

	static int N, M, K;
	static int[][] matrix;
	static int[][] visit;
	static int count = 0;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cycle = Integer.parseInt(br.readLine());

		
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < cycle; i++) {

			count = 0;
			String[] inputs = br.readLine().split(" ");

			N = Integer.parseInt(inputs[0]);
			M = Integer.parseInt(inputs[1]);
			K = Integer.parseInt(inputs[2]);

			matrix = new int[N][M];
			visit = new int[N][M];

			for (int j = 0; j < K; j++) {
				String[] coordinate = br.readLine().split(" ");
				int x = Integer.parseInt(coordinate[0]);
				int y = Integer.parseInt(coordinate[1]);

				matrix[x][y] = 1;
			} // for

			for (int j = 0; j < N; j++) {
				for (int s = 0; s < M; s++) {

					if (matrix[j][s] == 1 && visit[j][s] == 0) {

						dfs(j, s);

						count++;
					}
				}
			}

			sb.append(count + "\n");
		} // for

		System.out.println(sb.toString());
	}

	static void dfs(int x, int y) {

		visit[x][y] = 1;

		for (int i = 0; i < 4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];

			if (newX < 0 || newY < 0 || newX >= N || newY >= M || matrix[newX][newY] == 0 || visit[newX][newY] == 1) {

				continue;
			}

			dfs(newX, newY);
		}
	}
}
