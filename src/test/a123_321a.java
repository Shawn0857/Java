package test;

import java.util.*;

public class a123_321a {

	public static void main(String[] args) {
		Scanner ii = new Scanner(System.in);
		int num = ii.nextInt();
		int result = 0;
		while (true) {
			int n = num % 10;
			result = result * 10 + n;
			num = num / 10;
			if (num == 0) {
				break;
			}
		}
		System.out.println(result);
	}

}
