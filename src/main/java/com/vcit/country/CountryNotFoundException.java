package com.vcit.country;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException() {
        super();
    }
    public CountryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public CountryNotFoundException(String message) {
        super(message);
    }
    public CountryNotFoundException(Throwable cause) {
        super(cause);
    }
}