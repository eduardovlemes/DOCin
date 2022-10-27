package persons;

import documents.Document;
import entities.EmployeeList;
import entities.SupervisorList;

import javax.print.Doc;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Supervisor extends Collaborator {
    private static Integer counter = 0;

    private static List<Document> pendingDocuments = new ArrayList<>();
    private static List<Document> approvedDocuments = new ArrayList<>();

    public Supervisor(String firstname, String lastName, LocalDate birthday, Double cpf, String address){
        super(firstname, lastName, birthday, cpf, address,counter++);
        SupervisorList.addSupervisor(this);
    }
    @Override
    public void addDocuments (Document document){
        pendingDocuments.remove(document);
    }
    public void approveDocuments (Document document){
        System.out.println("Documento aprovado pelo supervisor, nome:" + this.getFirstname());
        approvedDocuments.add(document);
    }

}
