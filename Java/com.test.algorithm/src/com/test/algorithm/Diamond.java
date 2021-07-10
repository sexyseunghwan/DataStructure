package com.test.algorithm;



public class Diamond {
	
	public static void main(String[] args) {
		
		//Dia dia = new Dia();
		//dia.total = 5;
		//dia.dia(1);
		
		//재귀함수를 어케 썻는지 분석해보자 인간아...
		
		//int result = sumfunc(10);
		//System.out.println(result);
		stepfunc(3);
		
	}
	
	
	public static int sumfunc(int num) {
		
		if(num == 1) {
			return 1;
		} else {
			return num + sumfunc(num - 1);
		}
		
	}
	
	public static int stepfunc(int num) {
		
		
		return 0;
		
		
	}
	
	
}



class Dia {


	int total = 0;

	int width = 1;

	int count = 0;

	boolean flag = false;
	
	

	public void dia(int n){

		

		if(flag == false && n == total+1){

			width = (n-total)*2-1;

			count = (total*2)-width-2;

			flag = true;

		}

		

		if(n == total*2){

			return;

		}


		if(n <= total){

			if(width != total){

				System.out.print(" ");

				width++;

				dia(n);

			}else{

				if(count!=(n*2)-1){

					System.out.print("*");

					count++;

					dia(n);

				}else{

					System.out.println();

					n++;

					width = n;

					count = 0;

					dia(n);

				}

			}

		}else{

			if(width > 0){

				System.out.print(" ");

				width--;

				dia(n);

			}else{

				if(count>0){

					System.out.print("*");

					count--;

					dia(n);

				}else{

					System.out.println();

					n++;

					width = n-total;

					count = (total*2)-(width*2)-1;

					dia(n);

				}

			}

		}

	}

}