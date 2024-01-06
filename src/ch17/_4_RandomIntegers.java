package ch17;

import java.security.SecureRandom;
import java.util.stream.Collectors;

public class _4_RandomIntegers {

	public static void main(String[] args) {
		SecureRandom ranNumbers = new SecureRandom();
		System.out.println("Random number on separate spaces:");
		ranNumbers.ints(10,1,7).forEach(x->System.out.print(x + " "));
		
		System.out.println();
		ranNumbers.ints(3,1,10).forEach(System.out::println);
		
		String numbers = ranNumbers.ints(10,1,7)
				.mapToObj(String::valueOf)
				.collect(Collectors.joining(" "));
		System.out.printf("Random numbers on one line : %s\n", numbers);
		
		String numbers2 = ranNumbers.ints(10,1,7)
				.mapToObj(x->String.valueOf(x))
				.collect(Collectors.joining(" "));
		System.out.printf("Random numbers on one line : %s\n", numbers2);
	}

}
