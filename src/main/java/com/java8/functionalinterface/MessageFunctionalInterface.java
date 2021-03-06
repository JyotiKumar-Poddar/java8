package com.java8.functionalinterface;

import java.time.LocalDate;
import java.util.Locale;

/**
 * FunctionalInterface implementation
 *
 * Created by jyotipoddar on 13-01-2017.
 */
@FunctionalInterface
interface MessageFunctionalInterface {

    String getWelcomeMessage(String msg);  // abstract method in interface

    default String getCurrentTime() {  // default method with definition in interface
        return LocalDate.now().toString();
    }
    static String getLocaleInfo() {  // static method definition in interface
        return Locale.getDefault().toString();
    }
}
