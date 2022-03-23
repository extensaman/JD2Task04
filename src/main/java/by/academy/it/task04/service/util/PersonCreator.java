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
        while (!Validator.isAgeValid(age = random.nextInt(LIVE_LIMIT)));
        Surnames[] surnames = Surnames.values();
        Names[] names = Names.values();
        return new Person(surnames[random.nextInt(surnames.length)].toString(),
                names[random.nextInt(names.length)].toString(),
                age);
    }
}
