package by.academy.it.task04.service;

public class PersonServiceException extends Exception{
    public PersonServiceException() {
    }

    public PersonServiceException(String message) {
        super(message);
    }

    public PersonServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersonServiceException(Throwable cause) {
        super(cause);
    }
}
