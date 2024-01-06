package ch4;

import java.util.Scanner;

public class IfStatment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		System.out.println("Enter your score:");

		int score = input.nextInt();

		if (score < 0 || score > 100) {

			System.out.println("Your Score must between 0~100");

		} else if (score >= 90) {

			System.out.printf("Your Score %d is A%n", score);

		} else if (score >= 80) {

			System.out.printf("Your Score %d is B%n", score);

		} else if (score >= 70) {

			System.out.printf("Your Score %d is C%n", score);

		} else if (score >= 60) {

			System.out.printf("Your Score %d is D%n", score);

		} else {

			System.out.printf("Your Score %d is F%n", score);

		}

		String sResultString = (score >= 60) ? "���Z�ή�" : "���Z���ή�";

		System.out.println(sResultString);
	}

}
