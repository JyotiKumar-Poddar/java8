package com.java8.lambdaexamples;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Stream is an abstraction, composition some common functions
 * 
 * most common functions in streams are
 *  
 * - filter: for filtering the stream on certain condition
 * 			// Stream<T> filter Predicate<T>  
 * - map: transforms value
 * 			// number of input parameter is same as the number of output 
 * 			// There is no guarantee on type of input parameter and output
 *     Stream<T> maps takes Function<T,R> to return Stream<R>
 *     
 * - reduce: reduce cuts across the swim lanes
 * Stream is a non mutable pipe line 
 * 
 * @author jyotipoddar
 *
 */

public class StreamExample {
	
	
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(1, 1, 2, 3, 4, 4, 5, 5, 6, 7, 8,
				9, 10, 10, 11, 12, 13, 14, 14, 15);
		
		numbers.stream();
		double sum1=numbers.stream()
			   .filter(e -> e % 2 == 0)
			   .map(e -> e * 2.0) // type coming as integer and returned as double 
			   .reduce(0.0, (carry, e) -> carry + e);  // first parameter of type T , and the second parameter is BiFunction<T, U, R>
													   // to produce the result of type R
		
		
		// cuts across the swim lanes to achieve below points
		// reduce operation makes value comes together
		// reduce can also get the concrete value form the stream to a value or list.
		
		System.out.println("sum1 "+sum1);
		
		
		double sum2=numbers.stream()
				   .filter(e -> e % 2 == 0)
				   .mapToDouble(e -> e * 2.0) 
				   .sum(); // sum is also kind of reduce operation
		
		System.out.println("Sum2 "+sum2);
		
		
		// Collecting value to the list of integer
		List<Integer> listOfevenNumbers = numbers.stream()
										.filter(e -> e % 2 == 0)
										//.map(e -> e * 2)
										.collect(Collectors.toList()); // Collectors should be used to avoid shared mutability 
		
		System.out.print("List of even numbers ");
		listOfevenNumbers.forEach(v -> System.out.printf("%d  ", v));  // printing value in 'C' style
		
		TreeSet<Integer> treeSetOfevenNumbers = numbers.stream()
				.filter(e -> e % 2 == 0)
				.map(e -> e * 2)
				.collect(Collectors.toCollection(TreeSet::new));

		System.out.print("\nSet of even numbers ");
		treeSetOfevenNumbers.forEach(v -> System.out.printf("%d ",v));
	}

}
