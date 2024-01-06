package ch2;

import java.util.Scanner;

public class Welcome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the First Integer :");
		int number1 = input.nextInt();
		//input.next(); //輸入字串
		//input.nextDouble(); //輸入是浮點數
		
		System.out.println("Enter the Second Integer :");
		int number2 = input.nextInt();
		
		System.out.printf("%d + %d = %d\n ", number1, number2, 
				number1+number2);
		System.out.printf("%d - %d = %d\n ", number1, number2, 
				number1-number2);
		System.out.printf("%d * %d = %d\n ", number1, number2, 
				number1*number2);	
		System.out.printf("%d / %d = %d\n ", number1, number2, 
				number1/number2);	
		System.out.printf("%d mod %d = %d\n ", number1, number2, 
				number1%number2);
		System.out.printf("%d power %d = %f\n ", number1, number2, 
				Math.pow(Double.valueOf(number1),Double.valueOf(number2)));		
		System.out.printf("%d xor %d = %d\n ", number1, number2, 
				number1^number2);
		// XOR T^T=F, F^F=F, T^F=T ( T=1, F=0 )
		// XOR 1^1=0, 0^0=0, 0^1=1
		// 23 = 10111, 3=00011 ==> 23^3 = 10100 = 20
		System.out.printf("%d / %d = %f\n ", number1, number2, 
				Double.valueOf(number1)/number2);	
	}

}
