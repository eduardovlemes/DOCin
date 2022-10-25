package persons;

import documents.Document;
import entities.PersonList;

import java.util.ArrayList;
import java.util.List;

public class Collaborator extends Person{
    private List<Document> documents = new ArrayList<>();

    public Collaborator(String name, String lastName, Integer personId){
        super(name, lastName, personId);
        PersonList.addPerson(this);
    }

    public void CreateDocument(Document document){
        documents.add(document);
        System.out.println("Documento criado");
    }
}
