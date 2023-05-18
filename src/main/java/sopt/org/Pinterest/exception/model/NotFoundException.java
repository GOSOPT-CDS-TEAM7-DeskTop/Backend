package sopt.org.Pinterest.exception.model;

import sopt.org.Pinterest.exception.Error;

public class NotFoundException extends SoptException {
    public NotFoundException(Error error, String message) {
        super(error, message);
    }
}
