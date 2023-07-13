package com.need4speed.api.exceptions;

public class ProdutoException extends RuntimeException{
    public ProdutoException() {
        super();
    }

    public ProdutoException(String message) {
        super(message);
    }

    public ProdutoException(String message, Throwable cause) {
        super(message, cause);
    }
}
