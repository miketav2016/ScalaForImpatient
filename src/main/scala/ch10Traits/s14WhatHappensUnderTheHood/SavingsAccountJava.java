package ch10Traits.s14WhatHappensUnderTheHood;

import ch10Traits.s3TraitsWithConcreteImplementation.Account;

public class SavingsAccountJava extends Account
        implements ConsoleLoggerJava, ShortLoggerJava {
    private int maxLength;
    public int maxLength() { return maxLength; }
    public void weird_prefix$maxLength_$eq(int arg) { maxLength = arg; }


    public SavingsAccountJava() {
        super();
//        ConsoleLoggerJava.$init$();
//        ShortLoggerJava.$init$();
    }

    @Override
    public void log(String msg) {

    }

    @Override
    public void $init$() {

    }
}
