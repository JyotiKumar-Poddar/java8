package com.java8.predicate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * Created by jyotipoddar on 06-02-2016.
 */

@FunctionalInterface
interface DefaultMethodInterface {
	void printMessage();

	default public void defaultMethod() {
		System.out.println("DefaultMethodInterface2");
	}
}

interface DefaultMethodInterface2 {
	default public void defaultMethod() {
		System.out.println("DefaultMethodInterface2");
	}
}

class DefaultClass implements DefaultMethodInterface2 {

	public void defaultMethod() {
		System.out.println("DefaultMethodClass");
	}

	public void defaultMethod2() {
		DefaultMethodInterface2.super.defaultMethod();
	}
}

public class PredicateExample {

	public static void main(String[] args) {

		DefaultClass defaultClass = new DefaultClass();
		defaultClass.defaultMethod2();

		Predicate<String> p1 = s -> s.length() < 20;
		// System.out.println("p1 = [" + p1.test("jyoti") + "]");
		Predicate<String> p2 = s -> s.length() > 3;
		// System.out.println("p2 = [" + p2.test("jyoti") + "]");
		Predicate<String> p3 = p1.and(p2);

		System.out.println("p3 for test Hi = [" + p3.test("Hi") + "]");
		System.out.println("p3 for test Hi = [" + p3.test("Jyoti") + "]");
		System.out.println("p3 for test Hi to jyoti kumar poddar = ["
				+ p3.test("Hi to jyoti kumar poddar") + "]");

		/*
		 * Predicate<String> p4 = Predicate.isEqualTo("Yes");
		 * 
		 * System.out.println("p4 for Yes = [" + p4.test("Yes") + "]");
		 * System.out.println("p4 for NO = [" + p4.test("NO") + "]");
		 * 
		 * // generic equalTO
		 * 
		 * Predicate<Integer> p5 = Predicate.isEqualToGenric(4);
		 * System.out.println("p5 for 4 = [" + p5.test(4) + "]");
		 * System.out.println("p5 for 5 = [" + p5.test(5) + "]");
		 */

		Person person1 = new Person("jyoti", "kumar", 3);
		Person person2 = new Person("kanak", "kumari", 26);
		Person person3 = new Person("khushbu", "kumari", 46);

		Predicate<Person> p6 = person -> person.getAge() > 0;
		Predicate<Person> p7 = person -> person.getAge() < 18;
		BiPredicate<Person, Person> p8 = (xPerson, yPerson) -> xPerson.getAge() > yPerson
				.getAge();
		System.out.println(p8.test(person1, person2));

		List<Person> personList = new ArrayList<>();
		personList.add(person1);
		personList.add(person2);
		personList.add(person3);
		personList.forEach(System.out::println);
		personList.removeIf(person -> person.getAge() > 50);// newly method
															// added to
															// collection
		personList.forEach(System.out::println);
		personList.replaceAll(per -> {
			per.setlName(per.getfName().toUpperCase());
			return per;
		});
		personList.forEach(System.out::println);
		List<String> name = new ArrayList<String>();
		name.add("One");
		name.add("Tow");
		name.add("Three");
		// name.replaceAll(n-> n.toUpperCase());
		name.replaceAll(String::toUpperCase);
		name.forEach(System.out::println);

		personList.sort(Comparator.comparing(Person::getAge).thenComparing(
				Person::getfName));
		personList.forEach(System.out::println);

	}
}
