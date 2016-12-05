package com.java8.lambdaexamples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

class Student {
	int year;
	double maxMarks;

	public Student(int year, double maxMarks) {
		super();
		this.year = year;
		this.maxMarks = maxMarks;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getMaxMarks() {
		return maxMarks;
	}

	public void setMaxMarks(double maxMarks) {
		this.maxMarks = maxMarks;
	}

	@Override
	public String toString() {
		return "Student [year=" + year + ", maxMarks=" + maxMarks + "]";
	}
	

}

public class LambdaExpressionExample {

	public static void main(String[] args) {

		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student(2000, 450));
		studentList.add(new Student(2012, 450));
		studentList.add(new Student(2011, 590));
		studentList.add(new Student(2000, 250));
		studentList.add(new Student(2011, 250));
		studentList.add(new Student(2011, 450));

		studentList.forEach((v) -> System.out.println("value " + v.toString()));
		
		// functional  interface without lambda expression
		Double max = studentList.stream().filter(new Predicate<Student>() {
			@Override
			public boolean test(Student t) {

				return (t.getYear() == 2011);
			}
		}).map(new Function<Student, Double>() {

			@Override
			public Double apply(Student t) {
				return t.getMaxMarks();
			}

		}).max(new Comparator<Double>() {
			@Override
			public int compare(Double o1, Double o2) {
				return o1.compareTo(o2);
			}
		}).get();

		System.out.println("Max score is " + max);

		Comparator<? super Double> comp = (o1, o2) -> Double.compare(
				o1.doubleValue(), o1.doubleValue());

		// Type inference in the below example 
		// statically type

		int year = 2011; // variable should be effectively final
		Optional<Double> dd = studentList.stream()
				.filter(s -> s.getYear() == year)
				.map(s -> s.getMaxMarks())
				.max(comp);

		System.out.println("Max score is " + dd.get());

		

	}

}
