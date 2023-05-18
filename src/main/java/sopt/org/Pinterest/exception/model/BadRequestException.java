package sopt.org.Pinterest.exception.model;

import sopt.org.Pinterest.exception.Error;

public class BadRequestException extends SoptException {
    public BadRequestException(Error error, String message) {
        super(error, message);
    }
}