package test;

import java.util.Scanner;

public class MultiplicationTable {
	public static void main(String[] args) {
		Scanner ii = new Scanner(System.in);
		int a = ii.nextInt();
		for (int i = 1; i <= a; i++) {
			for (int j = 1; j <= a; j++) {
				System.out.printf("%-2d* %-2d= %-4s", j, i, Integer.toString(i * j));
			}
			System.out.print("\n");
		}
	}
}
