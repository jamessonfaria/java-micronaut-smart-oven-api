package br.com.jamesson.smart.oven.api.exception;

public class InvalidTemperatureException extends RuntimeException {
    public InvalidTemperatureException(String message) {
        super(message);
    }
}
