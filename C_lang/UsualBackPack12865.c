#include <stdio.h>
#include <math.h>

#define MAX(a, b) (((a) > (b)) ? (a) : (b))
int knapsack(int n,int w);
int matrix[101][100001];//배열선언
int w_arr[101];//무게배열
int v_arr[101];//가치배열

int main(){

    int N,W;
    scanf("%d %d",&N,&W);
 
    for (int i = 0; i < N; i++) {
        int w,v;
        scanf("%d %d",&w,&v);

        w_arr[i] = w;
        v_arr[i] = v;
    }

    printf("%d",knapsack(N-1,W));
   
    return 0;
}

int knapsack(int n,int w) {

    if (n < 0) {
        return 0;
    }

    if (matrix[n][w] == 0) {
        if (w - w_arr[n] < 0) {
            matrix[n][w] = knapsack(n-1,w);
        } else {
            matrix[n][w] = MAX(knapsack(n-1,w),knapsack(n-1,w-w_arr[n]) + v_arr[n]);
        }
    }

    return matrix[n][w];
}