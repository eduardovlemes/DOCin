package persons;

import documents.Document;
import entities.PersonList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Collaborator extends Person{
    private List<Document> documents = new ArrayList<>();
    public Collaborator(String firstname, String lastName, LocalDate birthday, Double cpf, String address, Integer id) {
        super(firstname, lastName, birthday, cpf, address, id);
        PersonList.addCollaborator(this);
    }
    public void addDocuments(Document document){}
    public void requestApproval(Integer idSupervisor, Integer idDocument){}
    public void approveDocuments (Document document){}
    public void archiveDocuments (Document document){}
}
