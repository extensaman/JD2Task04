package by.academy.it.task04.dao;

public class PersonDaoException extends Exception{
    public PersonDaoException() {
    }

    public PersonDaoException(String message) {
        super(message);
    }

    public PersonDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersonDaoException(Throwable cause) {
        super(cause);
    }
}
