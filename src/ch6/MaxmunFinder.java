package ch6;

import java.util.Scanner;
public class MaxmunFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("請輸入3個正整數, 用空白區分:");
		int number1 = input.nextInt();
		int number2 = input.nextInt();
		int number3 = input.nextInt();
		int max = fnMax(number1,number2,number3);
		System.out.println("最大值是:"+max);
		max = fnAllMax(1,34,6,8,9,100,234,123,22,1);
		System.out.println("最大值是:"+max);
	}

	private static int fnAllMax(int ... d) {   // [] = ...
		// TODO Auto-generated method stub
		int max = d[0];
		for(int i = 1; i< d.length; i++) {
			if(d[i]>max) max=d[i];
		}
		return 0;
	}

	private static int fnMax(int number1, int number2, int number3) {
		// TODO Auto-generated method stub
		int max = number1;
		if(number2 > max) max = number2;
		if(number3 > max) max = number3;
		return max;
		/*return(number3 > ((number1 > number2)? number1 : number2))? 
					 number3 : (number1 >= number2)? number1 : number2;*/
	}

}
