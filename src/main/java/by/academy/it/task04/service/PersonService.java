package by.academy.it.task04.service;

import by.academy.it.task04.entity.Person;

import java.util.Collection;
import java.util.List;

public interface PersonService {
    //void operate() throws PersonServiceException;
    List<Person> generateList(int count);
    List<Person> makeFirstTaskSample(List<Person> people);
    Collection<Person> writeReadPersonList(List<Person> people) throws PersonServiceException;
    List<String> makeSecondTaskSample(Collection<Person> people);
}
