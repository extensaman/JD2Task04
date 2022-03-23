package by.academy.it.task04.service.util;

public class Validator {
    public static boolean isAgeValid(Integer age) {
        return age != null && age >= 15 && age <= 30;
    }
}
