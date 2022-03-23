package by.academy.it.task04.view.impl;

import by.academy.it.task04.entity.Person;
import by.academy.it.task04.view.Output;

public class ConsoleOutput implements Output {
    @Override
    public void printString(String message) {
        System.out.print(message);
    }

    @Override
    public void printPerson(Person person) {
        System.out.println(person);
    }
}
