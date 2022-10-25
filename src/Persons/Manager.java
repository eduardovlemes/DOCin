package persons;

import documents.Document;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Collaborator{
    private static List<Document> archivedDocuments = new ArrayList<>();

    public Manager(String name, String lastName, Integer personId){
        super(name, lastName, personId);
    }
    @Override
    public void archiveDocuments (Document document){
        System.out.println("Documento arquivado pelo gerente.");
        archivedDocuments.add(document);
    }
}
