package test;

import java.util.*;

public class square {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double a = in.nextDouble();
		double b = in.nextDouble();
		System.out.printf("Height = %.2f\n", a);
		System.out.printf("Width = %.2f\n", b);
		System.out.printf("Perimeter = %.2f\n", (a + b) * 2);
		System.out.printf("Area = %.2f", a * b);
	}

}
