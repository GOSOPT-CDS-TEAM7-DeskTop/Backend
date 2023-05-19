package sopt.org.Pinterest.exception.model;

import sopt.org.Pinterest.exception.Error;

public class ConflictException extends SoptException {
    public ConflictException(Error error, String message) {
        super(error, message);
    }
}