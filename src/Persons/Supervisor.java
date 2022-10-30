package persons;

import documents.Document;
import entities.EmployeeList;
import entities.SupervisorList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Supervisor extends Collaborator {
    private static Integer counter = 0;
    private static List<Document> pendingDocuments = new ArrayList<>();
    private static List<Document> approvedDocuments = new ArrayList<>();





    public Supervisor(String firstname, String lastName, LocalDate birthday, String cpf, String address){
        super(firstname, lastName, birthday, cpf, address,counter++);
        SupervisorList.addSupervisor(this);
    }




    @Override
    public void addDocument(Document document){
        pendingDocuments.add(document);
        System.out.println("Documento criado pelo funcionário, nome:" + this.getFirstname());
        System.out.println(pendingDocuments);
    }

    public void approveDocument(Integer documentId){
        System.out.println("Documento aprovado pelo supervisor, nome:" + this.getFirstname());
        for (Document document: pendingDocuments) {
            if (Objects.equals(document.getDocumentId(),documentId)){
                pendingDocuments.remove(document);
                document.setDocumentTitle("");
                approvedDocuments.add(document);
            }
        }
    }

    public void rejectDocument(Integer documentId, Integer employeeId){
        Employee employee = EmployeeList.returnEmployee(employeeId);

        for (Document document:pendingDocuments) {
            if (Objects.equals(document.getDocumentId(),documentId)){
                employee.addDocument(document);
                pendingDocuments.remove(document);
            }
        }
    }

}
