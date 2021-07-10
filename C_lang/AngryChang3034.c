#include <stdio.h>
#include <math.h>



/*
문제
창영이는 화가나서 성냥을 바닥에 던졌다.
상근이는 바닥이 더러워진 것을 보고 창영이를 매우 혼냈다.
강산이는 근처에서 박스를 발견했다.
상덕이는 강산이가 발견한 박스를 상근이에게 주었다.
상근이는 박스에 던진 성냥을 모두 담아오라고 시켰다.
하지만, 박스에 들어가지 않는 성냥도 있다.
이런 성냥은 박스에 담지 않고 희원이에게 줄 것이다.
성냥이 박스에 들어가려면, 박스의 밑면에 성냥이 모두 닿아야 한다.
박스의 크기와 성냥의 길이가 주어졌을 때, 성냥이 박스에 들어갈 수 있는지 없는지를 구하는 프로그램을 작성하시오. 
창영이는 성냥을 하나씩 검사한다.
입력
첫째 줄에 던진 성냥의 개수 N과 박스의 가로 크기 W와 세로 크기 H가 주어진다. (1 ≤ N ≤ 50, 1 ≤ W, H ≤ 100)
다음 N개 줄에는 성냥의 길이가 주어진다. 길이는 1보다 크거나 같고 1000보다 작거나 같은 자연수이다.
출력
입력으로 주어지는 각각의 성냥에 대해서, 박스안에 들어갈 수 있으면 "DA" 없으면 "NE"를 출력한다.
예제 입력 1
5 3 4
3
4
5
6
7
예제 출력 1
DA
DA
DA
NE
NE
*/


int total_matches[1001];

void m1_3034();
void m2_3034();

int main() 
{	

	m1_3034();
	//m2_3034();

	
	
}

void m1_3034() 
{
	//첫번째 풀이
	
	int matches_count;//성냥의 개수
	int match_w;//성냥의 가로길이
	int match_h;//성냥의 세로길이

	scanf("%d %d %d", &matches_count, &match_w, &match_h);

	int max_length_square = match_w * match_w + match_h * match_h;//성냥이 들어갈 수 있는 최대 길이 제곱
	double max_length = pow(max_length_square, 0.5);//성냥이 들어갈 수 있는 최대길이 제곱근


	for (int i = 0; i < matches_count; ++i) {
		int temp;
		scanf("%d", &temp);

		if (temp <= max_length) total_matches[i] = 1;

	}

	for (int i = 0; i < matches_count; ++i) {
		if (total_matches[i] == 1) printf("DA\n");
		else printf("NE\n");
	}

}

void m2_3034()
{
	//두번째 풀이

	int matches_count;//성냥의 개수
	int match_w;//성냥의 가로길이
	int match_h;//성냥의 세로길이

	scanf("%d %d %d", &matches_count, &match_w, &match_h);

	while(matches_count--) {
		int temp;// 성냥의 길이 : 여러개를 입력할 것이므로
		scanf("%d", &temp);
		
		temp* temp <= match_w * match_w + match_h * match_h ? puts("DA") : puts("NE");

	}


}