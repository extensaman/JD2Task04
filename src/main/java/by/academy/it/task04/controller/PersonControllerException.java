package by.academy.it.task04.controller;

public class PersonControllerException extends Exception{
    public PersonControllerException() {
    }

    public PersonControllerException(String message) {
        super(message);
    }

    public PersonControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersonControllerException(Throwable cause) {
        super(cause);
    }
}
