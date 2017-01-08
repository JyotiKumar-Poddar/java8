package com.java8.consumer;

import com.java8.predicate.Person;

import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Created by jyotipoddar on 08-01-2017.
 *
 * */


class PConsumer implements  Consumer<Person> {

    @Override
    public void accept(Person person) {
        System.out.println(person.toString());
    }

    @Override
    public Consumer<Person> andThen(Consumer<? super Person> after) {
        Objects.requireNonNull(after);
        return (Person t) -> { accept(t); after.accept(t); };
    }
}

public class SimpleConsumer {

    public static void main(String[] args) {
        // creating a consumer that take string a an argument

        Consumer<String> stringConsumer = s -> System.out.println(s);

        // using the consumer for printing the message
        stringConsumer.accept("Hello, String Consumer ;) ");

        // Custom consumer for printing the details of Person class
        Consumer<Person> personConsumer = p -> {
            System.out.format("First Name:%s,Last Name %s", p.getfName(), p.getlName());
        };

        Person.getPersonList().forEach(personConsumer);
        System.out.println("");


        BiConsumer<String, String> stringConcat= (t,v) -> System.out.println(t.toUpperCase()+" "+v.toUpperCase());
        stringConcat.accept("First Input","Second Input");

        Person.getPersonList().forEach(new PConsumer());
    }

}
