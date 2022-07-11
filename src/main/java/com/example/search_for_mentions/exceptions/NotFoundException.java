package com.example.search_for_mentions.exceptions;

import java.util.NoSuchElementException;

public class NotFoundException extends NoSuchElementException {
    String parm;
    String value;
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String s, String parm, String value) {
        super(s);
        this.parm = parm;
        this.value = value;
    }
}
