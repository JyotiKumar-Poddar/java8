package com.java8.predicate;

/**
 * Created by jyotipoddar on 06-02-2016.
 */
@FunctionalInterface
public interface Predicate<T> {
	public boolean test(T t);

	public default Predicate<T> and(Predicate<T> other) {
		System.out.println("And Method called");
		return t -> test(t) && other.test(t);
	}

	public default Predicate<T> or(Predicate<T> other) {
		System.out.println("And Method called");
		return t -> test(t) || other.test(t);
	}

	public static Predicate<String> isEqualTo(String string) {
		return s -> s.equals(string);
	}

	static <U> Predicate<U> isEqualToGenric(U u) {

		System.out.println(u);
		return s -> s.equals(u);
	}

}
