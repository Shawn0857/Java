package ch4;

import java.util.Scanner;

public class DoWhileStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int total = 0;
		int gradeCounter = 1;
		int grade;
		do {
			System.out.print("Enter grade or -1 to quit:");
			grade = input.nextInt();
			if(grade != -1) {
			   total += grade;
			   gradeCounter++;
				}
			}while(grade!= -1);
			System.out.printf("Total of all %d grades is %d\n", gradeCounter, total);
			System.out.printf("Class average is %f\n ", (double)total/gradeCounter);
		}

}
