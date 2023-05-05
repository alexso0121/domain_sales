package org.example.Exception.utilsException;

public class ProductMapInternalException extends RuntimeException{
    public ProductMapInternalException(String message) {
        super(message);
    }

    public ProductMapInternalException(String message, Throwable cause) {
        super(message, cause);
    }
}
