package ch17;

import java.util.stream.IntStream;

public class _3_StreamFilterMapReduce {

	public static void main(String[] args) {
		// 每一個值乘2
		int sum = 0;
		for (int i = 1; i < 11; i++) {
			if (i % 2 == 0) sum += i * 3;
		}
		System.out.printf("Sum of the triples of the even ints 2 throught 10 is %d\n",
				sum);
		
		System.out.printf("Sum of the triples of the even ints 2 throught 10 is %d\n", 
				IntStream.rangeClosed(1, 10)
				.filter(x -> x % 2 == 0)
				.map(x -> x * 3)
				.sum());
	}

}
