package ch17;

import java.util.stream.IntStream;

public class _1_StreamReduce {

	public static void main(String[] args) {
		int sum = 0;
		for(int i = 1; i < 11; i++) { sum += i; }
		System.out.printf("Sum of 1 throught 10 is %d\n", sum);
		
		System.out.printf("Sum of 1 throught 10 is %d\n", 
				IntStream.rangeClosed(1, 10).sum());
	}

}
