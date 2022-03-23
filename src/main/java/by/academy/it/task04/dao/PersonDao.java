package by.academy.it.task04.dao;

import by.academy.it.task04.entity.Person;

import java.util.Collection;

public interface PersonDao {
    Collection<Person> readCollection() throws PersonDaoException;
    void writeCollection(Collection<Person> people) throws PersonDaoException;
}
