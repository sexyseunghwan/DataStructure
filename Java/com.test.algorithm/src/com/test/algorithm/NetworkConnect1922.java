/*
 
 도현이는 컴퓨터와 컴퓨터를 모두 연결하는 네트워크를 구축하려 한다. 하지만 아쉽게도 허브가 있지 않아 컴퓨터와 컴퓨터를 직접 연결하여야 한다. 
 그런데 모두가 자료를 공유하기 위해서는 모든 컴퓨터가 연결이 되어 있어야 한다. 
 (a와 b가 연결이 되어 있다는 말은 a에서 b로의 경로가 존재한다는 것을 의미한다. a에서 b를 연결하는 선이 있고, b와 c를 연결하는 선이 있으면 a와 c는 연결이 되어 있다.)

그런데 이왕이면 컴퓨터를 연결하는 비용을 최소로 하여야 컴퓨터를 연결하는 비용 외에 다른 곳에 돈을 더 쓸 수 있을 것이다. 
이제 각 컴퓨터를 연결하는데 필요한 비용이 주어졌을 때 모든 컴퓨터를 연결하는데 필요한 최소비용을 출력하라. 모든 컴퓨터를 연결할 수 없는 경우는 없다.

입력
첫째 줄에 컴퓨터의 수 N (1 ≤ N ≤ 1000)가 주어진다.

둘째 줄에는 연결할 수 있는 선의 수 M (1 ≤ M ≤ 100,000)가 주어진다.

셋째 줄부터 M+2번째 줄까지 총 M개의 줄에 각 컴퓨터를 연결하는데 드는 비용이 주어진다. 
이 비용의 정보는 세 개의 정수로 주어지는데, 만약에 a b c 가 주어져 있다고 하면 a컴퓨터와 b컴퓨터를 연결하는데 비용이 c (1 ≤ c ≤ 10,000) 만큼 든다는 것을 의미한다. a와 b는 같을 수도 있다.

출력
모든 컴퓨터를 연결하는데 필요한 최소비용을 첫째 줄에 출력한다.

예제 입력 1 
6
9
1 2 5
1 3 4
2 3 2
2 4 7
3 4 6
3 5 11
4 5 3
4 6 8
5 6 8


예제 출력 1 
23
  
*/


package com.test.algorithm;


import java.io.*;
import java.util.*;

public class NetworkConnect1922 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());//컴퓨터의 수
		int M = Integer.parseInt(br.readLine());//간선의 수
		
		ArrayList<Nodes> nodArr = new ArrayList<Nodes>();//각 노드를 품은 배열
		int[] parent = new int[N+1];//부모 노드 포인터
		int valueSum = 0;//가중치 합계
		
		//자기자신을 가리키는 포인터 생성
		for (int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}
		
		//노드들과 가중치 값 입력받기
		for (int i = 0; i < M; i++) {
			String[] inputs = br.readLine().split(" ");
			Nodes node = new Nodes(Integer.parseInt(inputs[0]),Integer.parseInt(inputs[1]),Integer.parseInt(inputs[2]));
			nodArr.add(node);
		}
		
		//노드를 품은 배열을 가중치를 기준으로 오름차순으로 정렬
		Collections.sort(nodArr, new ListSort());
		
		//최소 카운트 => 크루스칼 알고리즘 에서는 간선은 무조건 노드 - 1 개일때 최소값을 가지게 된다.
		int minCount = 0;
		
		//각자의 Nodes 객체를 가져와서 비교
		for (int i = 0; i < nodArr.size(); i++) {
			if (minCount >= N) break;
			else {
				int node1 = nodArr.get(i).node1;
				int node2 = nodArr.get(i).node2;
				
				if (findParent(parent,node1,node2) != 1) {
					unionParent(parent,node1,node2);
					valueSum += nodArr.get(i).weight;
				} 
			}
		}
		
		bw.write(valueSum + "");
		bw.close();
		br.close();
		
		
	}
	
	static class ListSort implements Comparator<Nodes> {

		@Override
		public int compare(Nodes n1, Nodes n2) {
			int productValue1 = n1.weight;
			int productValue2 = n2.weight;
			
			if (productValue1 > productValue2) return 1;
			else if (productValue1 < productValue2) return -1;
			else return 0;
		}
		
	}
	
	static class Nodes {
		public int node1;
		public int node2;
		public int weight;
		
		public Nodes(int node1,int node2,int weight) {
			this.node1 = node1;
			this.node2 = node2;
			this.weight = weight;
		}
	}
	
	static int getParent(int[] parent,int x) {
		if (parent[x] == x) return x;
		return parent[x] = getParent(parent,parent[x]);
	}
	
	static void unionParent(int parent[],int a,int b) {
		a = getParent(parent,a);
		b = getParent(parent,b);
		
		if (a < b) parent[b] = a;
		else parent[a] = b;
	}
	
	static int findParent(int parent[],int a,int b) {
		a = getParent(parent,a);
		b = getParent(parent,b);
		if (a == b) return 1;
		return 0;
	}
	
}
