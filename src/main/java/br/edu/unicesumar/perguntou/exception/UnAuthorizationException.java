package br.edu.unicesumar.perguntou.exception;

public class UnAuthorizationException extends RuntimeException {

    public UnAuthorizationException(String message) {
        super(message);
    }

    public UnAuthorizationException(String message, Throwable cause) {
        super(message, cause);
    }
}
