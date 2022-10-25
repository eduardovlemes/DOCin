package entities;

import persons.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonList {
    public static List<Person> persons = new ArrayList<>();

    public static void addPerson(Person person){
        persons.add(person);
    }

    public static Person turnBack(Integer personId){
        return persons.get (personId);
    }
}
