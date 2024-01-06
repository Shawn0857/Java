package ch17;

import java.util.Arrays;
import java.util.stream.Collectors;

public class _7_ArraysAndStreams2 {

	public static void main(String[] args) {
		String[] strings = {"Red", "orange", "Yellow", "green", "Blue", 
				"indigo", "Violet"};

		// display original strings
		System.out.println("Original strings : " + Arrays.asList(strings));
		
		// strings in uppercase
		System.out.println("strings in uppercase : " + 
				Arrays.stream(strings)
				.map(String::toUpperCase)
				.collect(Collectors.toList()));
		
		// 不區分大小寫小於 "n" 的字符
		// strings less than "n" (case insensitive) sorted ascending
		System.out.println("strings less than n sorted ascending : "
				+ Arrays.stream(strings)
				.filter(s -> s.compareToIgnoreCase("n") < 0)
				.sorted(String.CASE_INSENSITIVE_ORDER)
				.collect(Collectors.toList()));
		
		// strings less than "n" (case insensitive) sorted descending
		System.out.println("strings less than n sorted descending : "
				+ Arrays.stream(strings)
				.filter(s -> s.compareToIgnoreCase("n") < 0)
				.sorted(String.CASE_INSENSITIVE_ORDER.reversed())
				.collect(Collectors.toList()));
	}

}
