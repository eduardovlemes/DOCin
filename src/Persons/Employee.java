package persons;

import documents.Document;

import java.util.ArrayList;
import java.util.List;

public class Employee extends Collaborator{
    private List<Document> documents = new ArrayList<>();

    public Employee (String name, String lastName, Integer personId){
        super(name, lastName, personId);
    }
    @Override
    public void CreateDocument(Document document){
        documents.add(document);
        System.out.println("Documento criado");
        System.out.println(document);
        System.out.println(documents);
    }
}
