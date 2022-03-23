package by.academy.it.task04.dao.impl;

import by.academy.it.task04.dao.PersonDao;
import by.academy.it.task04.dao.PersonDaoException;
import by.academy.it.task04.entity.Person;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;

public class PersonDaoImpl implements PersonDao {

    private final File inputFile;
    private final File outputFile;

    public PersonDaoImpl(String inputPath, String outputPath) {
        this.inputFile = new File(inputPath);
        this.outputFile = new File(outputPath);
    }

    @Override
    public Collection<Person> readCollection() throws PersonDaoException {
        Collection<Person> people = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(inputFile)))) {
            while (ois.available() > 0) {
                people.add((Person) ois.readObject());
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new PersonDaoException(e);
        }
        return people;
    }

    @Override
    public void writeCollection(Collection<Person> people) throws PersonDaoException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(outputFile)))) {
            for (Person person : people) {
                oos.writeObject(person);
            }
        } catch (IOException e) {
            throw new PersonDaoException(e);
        }
    }
}
