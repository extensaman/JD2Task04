package by.academy.it.task04.service.impl;

import by.academy.it.task04.dao.PersonDao;
import by.academy.it.task04.dao.PersonDaoException;
import by.academy.it.task04.entity.Person;
import by.academy.it.task04.service.PersonService;
import by.academy.it.task04.service.PersonServiceException;
import by.academy.it.task04.service.util.PersonCreator;
import by.academy.it.task04.view.Output;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonServiceImpl implements PersonService {
    public static final String SPACE = " ";
    public static final int AGE_LIMIT = 21;
    public static final int PERSON_LIMIT = 100;
    private final PersonDao personDao;
    private final Output output;

    public PersonServiceImpl(PersonDao personDao, Output output) {
        this.personDao = personDao;
        this.output = output;
    }

    @Override
    public void operate() throws PersonServiceException {
        List<Person> personsToDao = Stream.generate(PersonCreator.getInstance()::create)
                .filter(person -> person.getAge() < AGE_LIMIT)
                .limit(PERSON_LIMIT)
                .peek(output::printPerson)
                .sorted(Comparator.comparing(Person::getSurname).thenComparing(Person::getName))
                .peek(output::printPerson)
                .distinct()
                .collect(Collectors.toList());

        try {
            personDao.writeCollection(personsToDao);
        } catch (PersonDaoException e) {
            throw new PersonServiceException(e);
        }

        Collection<Person> personsFromDao = null;
        try {
            personsFromDao = personDao.readCollection();
        } catch (PersonDaoException e) {
            throw new PersonServiceException(e);
        }

        personsFromDao.stream()
                .map(person -> "".concat(person.getSurname()).concat(SPACE).concat(person.getName()))
                .forEach(output::printString);
    }
}
