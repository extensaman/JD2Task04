package by.academy.it.task04.service.util;

import by.academy.it.task04.entity.Person;

import java.util.Random;

public class PersonCreator {

    public static final int LIVE_LIMIT = 120;

    private static class SingletonHolder {
        private static final PersonCreator INSTANCE = new PersonCreator();
    }

    private final Random random;

    private PersonCreator() {
        random = new Random();
    }

    public static PersonCreator getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public Person create() {
        int age;
        while (Validator.isAgeValid(age = random.nextInt(LIVE_LIMIT)));
        return new Person(Surnames.values()[0].toString(),Names.values()[0].toString(),age);
    }
}
