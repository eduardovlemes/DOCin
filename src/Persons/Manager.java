package persons;

import documents.Document;
import entities.ManagerList;
import entities.SupervisorList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Manager extends Collaborator{
    private static Integer counter = 0;
    private static List<Document> approvedDocuments = new ArrayList<>();
    private static List<Document> archivedDocuments = new ArrayList<>();

    public Manager(String firstname, String lastName, LocalDate birthday, String cpf, String address){
        super(firstname, lastName, birthday, cpf, address,counter++);
        ManagerList.addManager(this);
    }
    @Override
    public void addDocument(Document document){
        approvedDocuments.add(document);
        System.out.println("Documento aprovado pelo supervisor, nome:" + this.getFirstname());
        System.out.println(approvedDocuments);
    }

    public void archiveDocuments (Integer documentId){
        System.out.println("Documento arquivado pelo gerente, nome:" + this.getFirstname());
        for (Document document: approvedDocuments) {
            if (Objects.equals(document.getDocumentId(),documentId)){
                approvedDocuments.remove(document);
                document.setDocumentTitle("");
                archivedDocuments.add(document);
            }
        }
    }
    public void unarchiveDocuments (Integer documentId, Integer supervisorId){
        Supervisor supervisor = SupervisorList.returnSupervisor(supervisorId);
        for (Document document:archivedDocuments) {
            if (Objects.equals(document.getDocumentId(),documentId)){
                supervisor.addDocument(document);
                archivedDocuments.remove(document);
            }
        }
    }

}
