package persons;

import documents.Document;

import java.util.ArrayList;
import java.util.List;

public class Supervisor extends Collaborator {
    private static List<Document> approvedDocuments = new ArrayList<>();

    public Supervisor(String name, String lastName, Integer personId){
        super(name, lastName, personId);
    }
    @Override
    public void approveDocuments (Document document){
        System.out.println("Documento aprovado pelo supervisor.");
        approvedDocuments.add(document);
        System.out.println(approvedDocuments);
    }
}
