package by.academy.it.task04.service.impl;

import by.academy.it.task04.dao.PersonDao;
import by.academy.it.task04.dao.impl.PersonDaoImpl;
import by.academy.it.task04.entity.Person;
import by.academy.it.task04.service.PersonService;
import by.academy.it.task04.service.PersonServiceException;
import by.academy.it.task04.view.impl.ConsoleOutput;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

public class PersonServiceImplTest extends Assert {
    public static final String FOR_TEST_INOUT_PATH = "inout_for_test.obj";
    private PersonDao dao;
    private PersonService service;

    {
        dao = new PersonDaoImpl(FOR_TEST_INOUT_PATH, FOR_TEST_INOUT_PATH);
        service = new PersonServiceImpl(dao, ConsoleOutput.getInstance());
    }

    @Test
    public void generateList() {
        assertEquals("List<Person> generateList(int count) error", 10, service.generateList(10).size());
    }

    @Test
    public void makeFirstTaskSample() {
    }

    @Test
    public void writeReadPersonList() throws PersonServiceException {
        List<Person> peopleToDao = service.generateList(10);
        Collection<Person> peopleFromDao = service.writeReadPersonList(peopleToDao);
        assertTrue("writeReadPersonList() error", peopleFromDao.containsAll(peopleToDao));
    }

    @Test
    public void makeSecondTaskSample() {
    }
}