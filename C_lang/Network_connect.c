#include <stdio.h>
#include <stdlib.h>
//성능상 무리가 발생함
int parents[1001];

typedef struct nodes {
    int x;
    int y;
    int w;
} Nodes;

struct nodes nodes_arr[10001];
void union_parents(int x1,int x2);
int true_parent(int x1,int x2);
int get_parent(int x);
//int compare(const void *a, const void *b);

int main(){
    int N,M;
    int count = 0;
    int max_weight = 0;

    scanf("%d\n%d",&N,&M);

    for (int i = 1; i < N+1; i++) {
        parents[i] = i;
    }

    for (int i = 0; i < M; i++) {
        int x1,y1,w1;
        scanf("%d %d %d",&x1,&y1,&w1);

        nodes_arr[i].x = x1;
        nodes_arr[i].y = y1;
        nodes_arr[i].w = w1;
    }


    qsort(nodes_arr, M,sizeof(nodes_arr[0]), compare);

    for (int i = 0; i < M; i++) {
        if (count < N-1) {
            int x = nodes_arr[i].x;
            int y = nodes_arr[i].y;
            int w = nodes_arr[i].w;
            
            if (true_parent(x,y) == 0) {
                union_parents(x,y);
                max_weight += w;
                count++;
            }
            
        }
        
    }

    printf("%d",max_weight);

    return 0;        
}

int get_parent(int x) {
    if (parents[x] == x) return x;
    else return get_parent(parents[x]);
}

void union_parents(int x1,int x2) {
    x1 = get_parent(x1);
    x2 = get_parent(x2);

    if (x1 > x2) parents[x1] = x2;
    else parents[x2] = x1;
}

int true_parent(int x1,int x2) {
    if (get_parent(x1) == get_parent(x2)) return 1;
    else return 0;
}

int compare(const void *a, const void *b)    // 내림차순 비교 함수 구현
{
    return ((Nodes*)a)->w - ((Nodes*)b)->w;
}

void Swap(int arr[], int a, int b) // a,b 스왑 함수 
{
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
}
int Partition(int arr[], int left, int right)
{
    int pivot = arr[left]; // 피벗의 위치는 가장 왼쪽에서 시작
    int low = left + 1;
    int high = right;
 
    while (low <= high) // 교차되기 전까지 반복한다 
    {
        while (low <= right && pivot >= arr[low]) // 피벗보다 큰 값을 찾는 과정 
        {
            low++; // low를 오른쪽으로 이동 
        }
        while (high >= (left+1)  && pivot <= arr[high]) // 피벗보다 작은 값을 찾는 과정 
        {
            high--; // high를 왼쪽으로 이동
        }
        if (low <= high)// 교차되지 않은 상태이면 스왑 과정 실행 
        {
            Swap(arr, low, high); //low와 high를 스왑 
        }
    }
    Swap(arr, left, high); // 피벗과 high가 가리키는 대상을 교환 
    return high;  // 옮겨진 피벗의 위치정보를 반환 
 
}
 
 
void QuickSort(int arr[], int left, int right)
{
    if (left <= right)
    {
        int pivot = Partition(arr, left, right); // 둘로 나누어서
        QuickSort(arr, left, pivot - 1); // 왼쪽 영역을 정렬한다.
        QuickSort(arr, pivot + 1, right); // 오른쪽 영역을 정렬한다.
    }
}

