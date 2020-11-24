package ch10Traits.s14WhatHappensUnderTheHood;

public interface ShortLoggerJava extends LoggerJava {
    int maxLength();

    void weird_prefix$maxLength_$eq(int i);

    default void log(String msg) {
        System.out.println(maxLength());
    } // Calls maxLength()

    default void $init$() {
        weird_prefix$maxLength_$eq(15);
    }
}
