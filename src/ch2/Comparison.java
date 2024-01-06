package ch2;

import java.util.Scanner;

public class Comparison {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				Scanner input = new Scanner(System.in);
				System.out.println("Enter the First Integer :");
				int number1 = input.nextInt();
				//input.next(); //輸入字串
				//input.nextDouble(); //輸入是浮點數
				
				System.out.println("Enter the Second Integer :");
				int number2 = input.nextInt();
				
				if (number1 < 10) {
					System.out.printf("%d < 10\n", number1);
				} else if (number1 >50) {
					System.out.printf("%d > 50\n", number1);
				}else {
					System.out.printf("%d in 10 ~ 50\n", number1);
				}
					
				String s = (number1 > number2)? ">" : "<";
				System.out.printf("%d in 10 ~50\n",number1, s, number2);
				// && = and , || = or
	}

}
