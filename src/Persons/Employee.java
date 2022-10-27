package persons;

import documents.Document;
import entities.EmployeeList;
import entities.SupervisorList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employee extends Collaborator{
    private static Integer counter = 0;
    private List<Document> documents = new ArrayList<>();

    public Employee(String firstname, String lastName, LocalDate birthday, Double cpf, String address) {
        super(firstname, lastName, birthday, cpf, address,counter++);
        EmployeeList.addEmployee(this);
    }
    @Override
    public void addDocuments(Document document){
        documents.add(document);
        System.out.println("Documento criado pelo funcionário");
        System.out.println(document);
        System.out.println(documents);
    }
    public void requestApproval(Integer idSupervisor, Integer idDocument){
        Supervisor approver = SupervisorList.returnSupervisor(idSupervisor);
        approver.pendingDocuments(documents.get(idDocument));
    }
}
