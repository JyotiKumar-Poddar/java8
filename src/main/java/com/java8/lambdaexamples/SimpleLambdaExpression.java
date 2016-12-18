package com.java8.lambdaexamples;

import java.util.Arrays;
import java.util.List;

public class SimpleLambdaExpression {

	public static void main(String[] args) {

		List<Integer> intList = Arrays.asList(1, 2, 11, 31, 10, 33, 13, 12, 1);

		/**
		 * Very old way of doing using some external iterator, need to be more
		 * cautious, Since we have written this many times hence become familiar
		 * to this.
		 */
		
		for (int i = 0; i < intList.size(); i++) {
			System.out.println(intList.get(i));
		}

		/**
		 * Still doing the iteration using external iterator
		 */

		
		for (Integer integer : intList) {
			System.out.println(integer);
		}
		 

		/**
		 * Using lambda expression, Here the iteration is done by the internal
		 * iterator, and we are least bothered by the pre conditions of
		 * initialization and the range
		 */
		intList.forEach(value -> System.out.println(value));
		
		
		
		/**
		 * Here we have not defined the type of parameter, which enlighten
		 * as that in lambda expression java can inferred the type of the parameter 
		 */
		
		// or we can remove bracket () from the above expression, only for single argument 
		
		intList.forEach(v -> System.out.println(v));
	}
}
