package com.test.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackSequence1874 {
	
/*
 문제
스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다. 
스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아 제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.

1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다. 
이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자. 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 
있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 이를 계산하는 프로그램을 작성하라.

입력
첫 줄에 n (1 ≤ n ≤ 100,000)이 주어진다. 둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다. 
물론 같은 정수가 두 번 나오는 일은 없다.

출력
입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다. push연산은 +로, pop 연산은 -로 표현하도록 한다. 불가능한 경우 NO를 출력한다.

===============================
예제 입력 1 
8
4
3
6
8
7
5
2
1

예제 출력 1 
+
+
+
+
-
-
+
+
-
+
+
-
-
-
-
-
===============================
예제 입력 2 
5
1
2
5
3
4

예제 출력 2 
NO 

 
 * */
	
	
	public static void main(String[] args) throws Exception{
		//m1();
		//m2();
		m3();
	}

	private static void m3() throws Exception{
		//3. 3번째 방법
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int input = Integer.parseInt(br.readLine());//1이상 input 이하의 정수가 들어있음.
		
		int[] stack = new int[input];//stack 구현.
		int top = 0;
		int index = 0;
		
		StringBuilder stb = new StringBuilder();//스트링빌더 생성.
		
		for (int i = 0; i < input; i++) {
			
			int num = Integer.parseInt(br.readLine());//스택수열을 차례로 입력.
			
			if (num > top) {
				//현재 비교할 숫자가 스택에 맨위에 숫자보다 큰 경우
				while(num >= top + 1) {
					top++;
					stack[index] = top;
					stb.append("+\n");
					index++;
				}
			} else if (num < top) {
				//현재 비교할 숫자가 스택에 맨위에 숫자보다 작을 경우
				if (stack[index-1] > num) {
					bw.write("NO");
					bw.close();
					return;
				}
				
			}
			
			stb.append("-\n");
			index--;
			
		}//for
		
		bw.write(stb + "");
		bw.close();		
	}

	private static void m2() throws Exception{
		//2. stack을 사용하지 않은경우 -> 이 방법이 메모리와 시간의 낭비가 적은 방법이다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());//1~n 까지 숫자 받을때 n 을 뜻함
		
		int[] stack = new int[n];//stack을 고정배열로 생성.
		
		StringBuilder sb = new StringBuilder();//스트링 빌더를 생성하여 답으로 쓸것.
		
		int idx = 0;
		int top = 0;//stack에 가장 위에 있는 숫자.
		int input = 0;//원하는 배열의 숫자를 차례대로 지정할 것이다.
		
		while(n-- > 0) {
			input = Integer.parseInt(br.readLine());//원하는 배열의 숫자.
			
			if(input > top) {
				while(input >= top + 1) {
					top++;
					stack[idx] = top;
					idx++;
					sb.append("+\n");
				}
			} else if(input < top){
				if(stack[idx - 1] != input) {//스택수열이 될수 없는경우
					System.out.println("NO");
					return;//여기서 중단시키는것이다.
				}
			}
			
			idx--;
			sb.append("-\n");
		}//while
		
		System.out.println(sb);
		
	}
	
	private static void m1() throws Exception{
		//1. stack을 사용한 경우
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int input = Integer.parseInt(br.readLine());//몇까지의 정수가 들어올건지 정해준다 1이 기준.
		
		List<Integer> standardList = new ArrayList<Integer>();//새로운 리스트를 만들어준다 1~input 까지의 숫자를 넣어줄것이다.
		Stack<Integer> stack = new Stack<Integer>();//스택 생성
		List<String> answerList = new ArrayList<String>();//답 리스트.
		int[] compList = new int[input];//원하는 수열 넣을것
		
		//원하는 수열을 넣어주는 작업 수행.
		for (int i = 0; i < input; i++) {
			compList[i] = Integer.parseInt(br.readLine());
		}
		
		//standardList 에 숫자를 넣어준다. -> 1부터 지정한 숫자까지 넣어준다. 
		for (int i = 1; i <= input; i++) {
			standardList.add(i);
		}
		
		boolean possible = true;//스택수열이 가능한 경우 true 를 써준다.
		
		for (int i = 0; i < input; i++) {
			
			//스택수열이 가능할때
			if (possible) {
				
				int num = compList[i];//만들고싶은 수열 순서대로
				boolean flag = false;
				
				while(!flag) {
					
					if (stack.size() != 0) {
						//stack size 가 0 이 아닐경우
						if(stack.peek() == num) {
							//스택 맨 위에 있는게 찾고자하는 번호인 경우
							stack.pop();
							answerList.add("-");
							flag = true;
						} else {
							//스택 맨 위에 있는게 찾고자하는 번호가 아닌경우.
							
							if (stack.peek() > num) {//스택 맨 위에 있는 숫자가 내가 찾고자하는 숫자보다 큰 경우
								possible = false;//스택수열이 불가능함.
								break;
							} else {
								while(standardList.size() != 0 && standardList.get(0) <= num) {//여기서 오류가 발생.****
									stack.push(standardList.remove(0));//스택에 숫자를 넣어준다.
									answerList.add("+");
								}
							}
						}
						
					} else {
						//stack 의 사이즈가 0 인경우.
						while(standardList.size() != 0 && standardList.get(0) <= num) {//여기서도 오류가 발생하네?****
							stack.push(standardList.remove(0));//스택에 숫자를 넣어준다.
							answerList.add("+");
						}
						
					}

				}//while
			
			//스택수열이 불가능할때
			} else {
				break;
			}
		}//for
		
		if (possible) {
			//스택수열로 만들 수 있는경우 -> -,+ 를 차례대로 꺼내준다.
			for (String item : answerList) {
				bw.write(item + "\n");
			}
			
		} else {
			//스택수열로 만들 수 없는 경우
			bw.write("NO");
		}
		
		bw.close();
		
	}
}
