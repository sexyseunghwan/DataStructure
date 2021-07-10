package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//세그먼트 트리 문제...!
public class Sequence14438 {
	static int[] tree, arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());//길이가  N
		arr = new int[N + 1];//길이가 N인 정적배열 생성

		//정적 배열내에 숫자를 삽입
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());//arr 에 숫자를 넣어준다.
		}
		
		//왜 4배나 해준거지??->모르겠는데->세그먼트 트리 특성이라고 생각하면 된다.
		tree = new int[N * 4];

		init(1, N, 1);//start,end,node
		int M = Integer.parseInt(br.readLine());//쿼리의 개수

		StringBuilder sb = new StringBuilder();//스트링빌더 생성 -> 여기에 답들을 넣어줄 것이다.
		
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());//stringTokenizer 객체 생성

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == 1) {
				update(1, N, 1, b, c);
			} else if (a == 2) {
				sb.append(query(1, N, 1, b, c) + "\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	
	// 모든 구간 별로 최솟값을 설정.
	public static int init(int start, int end, int node) {
		if (start == end) {
			return tree[node] = arr[start];
		}

		int mid = (start + end) / 2;
		return tree[node] = Math.min(init(start, mid, node * 2), init(mid + 1, end, node * 2 + 1));//재귀적인 방법.
	}//무슨 말인지 전혀 모르겠다 이말이제...;;

	// left ~ right 중에 최솟값을 반환***
	public static int query(int start, int end, int node, int left, int right) {
		if (left > end || right < start) {
			return Integer.MAX_VALUE;
		}

		if (left <= start && end <= right) {
			return tree[node];
		}

		int mid = (start + end) / 2;
		return Math.min(query(start, mid, node * 2, left, right), query(mid + 1, end, node * 2 + 1, left, right));
	}
	
	//1 , n , 1 , b , c
	public static int update(int start, int end, int node, int idx, int val) {
		if (idx < start || idx > end) {
			return tree[node];
		}

		// 리프 노드
		if (start == end) {
			return tree[node] = val;
		}

		int mid = (start + end) / 2;
		
		// 리프 노드와 연결된 트리의 가지 전체를 업데이트
		return tree[node] = Math.min(update(start, mid, node * 2, idx, val),
				update(mid + 1, end, node * 2 + 1, idx, val));
	}

}
