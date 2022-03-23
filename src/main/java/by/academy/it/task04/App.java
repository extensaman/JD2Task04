package by.academy.it.task04;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Making a program in maven, covering it with unit tests
 *
 * PART 1.
 * Create a class Person, with fields "name, surname, age". Generate a group of 100 people aged 15 to 30.
 * 1) select objects whose age is less than 21;
 * 2) print them on the screen;
 * 3) sort by last name, and then by first name (use thenComparing on the Comparator object);
 * 4) remove duplicates (if name, surname, age are the same)
 * 5) save to a file, as an object, each instance of the Person class
 * 6) read from file
 * 7) using stream for creating a new collection (List<String>) containing only surnames and names for objects
 * that were read from file
 * 8) display
 *
 * PART 2.
 * Create MySQL database 'People'
 * create a 'Person' table in this database with fields:
 * -id - Integers (identifier)
 * -age - Integers
 * -salary - Decimal fractional numbers
 * -passport - Fixed length strings (10 characters)
 * -address - Strings with variable length (up to 200 characters)
 * -dateOfBirthday - Date
 * -dateTimeCreate- Date and time
 * -timeToLunch - Time (only)
 * -letter - Large text
 *
 * Add 5 arbitrary Persons
 * Select from this table all Persons with age > 21, and sort this selection by the 'dateTimeCreate' field.
 *
 * The scripts that do all this need to be uploaded to git and create a PullRequest.
 *
 * @author Yusikau Aliaksandr
 * @version 1.0
 */

public class App 
{
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );
    }
}
