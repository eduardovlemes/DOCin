package entities;

import persons.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonList {
    public static List<Person> collaborators = new ArrayList<>();

    public static void addCollaborator(Person person){
        collaborators.add(person);
    }
    public static Person returnCollaborator(Integer idPerson){
        return collaborators.get (idPerson);
    }
    public static List<Person> returnAllCollaborator(){
        return collaborators;
    }
}
