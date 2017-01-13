package com.java8.functionalinterface;

import java.lang.annotation.Annotation;
import java.time.LocalDate;
import java.util.Locale;

/**
 * Created by jyotipoddar on 13-01-2017.
 */

public class FunctionalInterfaceSample {
    public static void main(String[] args) {

        // implementation of abstract method using lambda expression
        MessageFunctionalInterface msg = s -> s.concat("Welcome to Custom functional interface implementation ");
        System.out.println(msg.getCurrentTime()); // default method
        System.out.println(MessageFunctionalInterface.getLocaleInfo());  // static method of interface
        System.out.println(msg.getWelcomeMessage("In Java 8: "));

    }
}
