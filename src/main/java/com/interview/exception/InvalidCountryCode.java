package com.interview.exception;

public class InvalidCountryCode extends Exception {
    public InvalidCountryCode(String code) {
        super(String.format("Error. Invalid country code id: '%s'.", code));
    }
}
