package ch17;

import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class _2_StreamMapReduce {

	public static void main(String[] args) {
		// 每一個值乘2
		int sum = 0;
		for(int i = 1; i < 11; i++) { sum += i*2; }
		System.out.printf("Sum of even ints 2 throught 20 is %d\n", sum);
		
		System.out.printf("Sum of even ints 2 throught 20 is %d\n", 
				IntStream.rangeClosed(1, 10)
				.map((int x) -> {return x*2;})
				.sum());
	}

}
