package ch10Traits.s14WhatHappensUnderTheHood;

public interface ConsoleLoggerJava {
    default void log(String msg) {
        System.out.println(msg);
    }
}
