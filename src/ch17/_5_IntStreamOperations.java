package ch17;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _5_IntStreamOperations {

	public static void main(String[] args) {
		int[] values = {3, 10, 6, 1, 4, 8, 2, 5, 9, 7};
		
		System.out.println("Original values : " + 
				IntStream.of(values)
				.mapToObj(String::valueOf)
				.collect(Collectors.joining(" ")));
		
		// count , min, max, sum and average of the values
		System.out.println("Count : " + IntStream.of(values).count());
		System.out.println("Min : " + IntStream.of(values).min().getAsInt());
		System.out.println("Max : " + IntStream.of(values).max().getAsInt());
		System.out.println("Sum : " + IntStream.of(values).sum());
		System.out.println("Average : " + IntStream.of(values).average().getAsDouble());
		
		// sum of values with reduce method
		System.out.println("Sum via reduce method : " + 
				IntStream.of(values).reduce(0, (x,y)->x+y));
		System.out.println("Sum via reduce method : " + 
				IntStream.of(values).reduce((x,y)->x+y).getAsInt());
		
		// product of values with reduce method
		System.out.println("Product via reduce method : " + 
				IntStream.of(values).reduce(1, (x,y)->x*y));
		System.out.println("Product via reduce method : " + 
				IntStream.of(values).reduce((x,y)->x*y).getAsInt());
		
		// sum of squares of values with reduce method
		System.out.println("Sum of squares via map and sum : " + 
				IntStream.of(values).map(x -> x * x).sum());
		
		// displaying the elements in sorted order
		System.out.println("Values displayed in sorted order : " + 
				IntStream.of(values).sorted() //排序
				.mapToObj(String::valueOf)
				.collect(Collectors.joining(" ")));
	}

}
