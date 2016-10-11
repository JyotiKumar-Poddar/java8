package com.java8.predicate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jyotipoddar on 06-02-2016.
 */
public class Person {
	private String fName;
	private String lName;
	private int age;

	public Person() {

	}

	public Person(String fName, String lName, int age) {
		this.fName = fName;
		this.lName = lName;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person{" + "fName='" + fName + '\'' + ", lName='" + lName
				+ '\'' + ", age=" + age + '}';
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static List<Person> getPersonList() {
		List<Person> personList = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			personList.add(new Person("i" + i, "j" + i, i));
		}
		for (int i = 0; i < 10; i++) {
			personList.add(new Person("i" + i, "j" + i, i));
		}
		return personList;

	}

	public void printMessage() {
		System.out.println("====printMessage====");
	}
}
