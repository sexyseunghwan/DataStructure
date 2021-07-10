#include <stdio.h>

int matrix[101][101];//matrix
int dfs(int matrix[101][101], int row,int col,int count);
int row;//행
int col;//열
int coordinates[4][2] = { {1,0} ,{-1,0}, {0,1} ,{0,-1} };//상하좌우

int main() 
{
	int a = 3;
	int b = 4;


	int count;//음식물 몇개있는지 카운트 해준다.

	scanf("%d %d %d", &row, &col, &count);

	for (int i = 0; i < count; i++) {
		int x,y;
		scanf("%d %d", &x, &y);

		matrix[x - 1][y - 1] = 1;//음식물을 위치시킨다
	}

	int maxCount = 0;

	for (int i = 0; i < row; i++) {
		for (int j = 0; j < col; j++) {
			
			int size = dfs(matrix, i, j, 0);

			maxCount = maxCount > size ? maxCount : size;

		}
	}

	printf("%d\n", maxCount);


	return 0;
}

int dfs(int matrix[101][101], int in_row, int in_col, int count) 
{
	if (in_row >= row || in_row < 0 || in_col >= col || in_col < 0 || matrix[in_row][in_col] == 0)
	{
		return count;
	}

	matrix[in_row][in_col] = 0;

	count++;

	for (int i = 0; i < 4; i++) {
		int x = coordinates[i][0];//x좌표
		int y = coordinates[i][1];//y좌표	
	
		count = dfs(matrix, in_row + x, in_col + y, count);
	}
	
	return count;
}