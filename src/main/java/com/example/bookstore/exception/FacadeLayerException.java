package com.example.bookstore.exception;

public class FacadeLayerException extends Exception {
    public FacadeLayerException() {
    }

    public FacadeLayerException(String message) {
        super(message);
    }

    public FacadeLayerException(String message, Throwable cause) {
        super(message, cause);
    }

    public FacadeLayerException(Throwable cause) {
        super(cause);
    }

    public FacadeLayerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
