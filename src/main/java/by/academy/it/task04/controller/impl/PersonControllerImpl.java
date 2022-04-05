package by.academy.it.task04.controller.impl;

import by.academy.it.task04.controller.PersonController;
import by.academy.it.task04.controller.PersonControllerException;
import by.academy.it.task04.entity.Person;
import by.academy.it.task04.service.PersonService;
import by.academy.it.task04.service.PersonServiceException;

import java.util.Collection;
import java.util.List;

public class PersonControllerImpl implements PersonController {
    public static final int PERSON_LIMIT = 100;
    private PersonService personService;

    public PersonControllerImpl(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public void execute() throws PersonControllerException {

        List<Person> generatedPersonList = personService.generateList(PERSON_LIMIT);
        List<Person> personFirstSample = personService.makeFirstTaskSample(generatedPersonList);
        Collection<Person> personListAfterDao = null;
        try {
            personListAfterDao = personService.writeReadPersonList(personFirstSample);
        } catch (PersonServiceException e) {
            throw new PersonControllerException(e);
        }
        personService.makeSecondTaskSample(personListAfterDao);
    }
}
