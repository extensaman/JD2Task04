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
    private final PersonDao personDao;
    private final Output output;

    public PersonServiceImpl(PersonDao personDao, Output output) {
        this.personDao = personDao;
        this.output = output;
    }

    @Override
    public List<Person> generateList(int count) {
        return Stream.generate(PersonCreator.getInstance()::create)
                .limit(count).collect(Collectors.toList());
    }

    @Override
    public List<Person> makeFirstTaskSample(List<Person> people) {
        return people.stream().filter(person -> person.getAge() < AGE_LIMIT)
                .peek(output::printPerson)
                .sorted(Comparator.comparing(Person::getSurname).thenComparing(Person::getName))
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Person> writeReadPersonList(List<Person> people) throws PersonServiceException {
        try {
            personDao.writeCollection(people);
        } catch (PersonDaoException e) {
            throw new PersonServiceException(e);
        }

        Collection<Person> personsFromDao = null;
        try {
            personsFromDao = personDao.readCollection();
        } catch (PersonDaoException e) {
            throw new PersonServiceException(e);
        }
        return personsFromDao;
    }

    @Override
    public List<String> makeSecondTaskSample(Collection<Person> people) {
        return people.stream()
                .map(person -> person.getSurname() +
                        SPACE +
                        person.getName() +
                        "\n")
                .peek(output::printString)
                .collect(Collectors.toList());
    }
}
