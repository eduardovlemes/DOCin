package services;

import documents.Document;
import persons.Employee;
import persons.Manager;
import persons.Supervisor;

import java.time.LocalDate;
import java.util.Scanner;

public class Service {
    private static Scanner scanner;
    private static Scanner scanner2;
    private static Document document;
    private static Integer documentId;
    private static Employee employee;
    private static Supervisor supervisor;
    private static Manager manager;

    public void registerEmployee (){
        scanner = new Scanner(System.in);
        scanner2 = new Scanner(System.in);
        System.out.println("Digite o nome do(a) funcionário(a):");
        String firstNameEmployee = scanner.nextLine();
        System.out.println("Digite o sobrenome do(a) funcionário(a):");
        String lastNameEmployee = scanner.nextLine();
        System.out.println("Digite a data de aniversário(ex: 1990 enter 12 enter 31) do(a) funcionário(a):");
        LocalDate birthdayEmployee = LocalDate.of(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
        System.out.println("Digite o CPF(ex:000.000.000-00) do(a) funcionário(a):");
        String cpfEmployee = scanner2.nextLine();
        System.out.println("Digite o endereço do(a) funcionário(a):");
        String addressEmployee = scanner2.nextLine();
        employee = new Employee(firstNameEmployee, lastNameEmployee, birthdayEmployee, cpfEmployee, addressEmployee);
    }
    public void createDocument (Employee employee){
        scanner = new Scanner(System.in);
        System.out.println("Digite o título do documento:");
        String documentTitle = scanner.nextLine();
        System.out.println("Digite o link do documento:");
        String documentLink = scanner.nextLine();
        document = new Document(documentTitle, documentLink);
        Service.employee.addDocument(document);
    }
    public void sendDocumentToApproval (Employee employee){
        scanner = new Scanner(System.in);
        System.out.println("Digite o id do supervisor:");
        Integer supervisorId = scanner.nextInt();
        System.out.println("Digite o id do documento:");
        documentId = scanner.nextInt();
        Service.employee.requestApprovalDocument(supervisorId, documentId);
    }

    public void registerSupervisor (){
        scanner = new Scanner(System.in);
        scanner2 = new Scanner(System.in);
        System.out.println("Digite o nome do(a) supervisor(a):");
        String firstNameSupervisor = scanner.nextLine();
        System.out.println("Digite o sobrenome do(a) supervisor(a):");
        String lastNameSupervisor = scanner.nextLine();
        System.out.println("Digite a data de aniversário(ex: 1990 enter 12 enter 31) do(a) supervisor(a):");
        LocalDate birthdaySupervisor = LocalDate.of(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
        System.out.println("Digite o CFP(ex: 000.000.000-00) do(a) supervisor(a):");
        String cpfSupervisor = scanner2.nextLine();
        System.out.println("Digite o endereço do(a) supervisor(a):");
        String addressSupervisor = scanner2.nextLine();
        supervisor = new Supervisor(firstNameSupervisor, lastNameSupervisor, birthdaySupervisor, cpfSupervisor, addressSupervisor);
    }
    public void loadPendingDocument(Supervisor supervisor){
        Service.supervisor.addDocument(document);
    }
    public void approveDocument(Supervisor supervisor){
        Service.supervisor.approveDocument(document.getDocumentId());
    }
    public void rejectDocument(Supervisor supervisor){
        Service.supervisor.rejectDocument(document.getDocumentId(),employee.getId());
    }

    public void registerManager (){
        scanner = new Scanner(System.in);
        scanner2 = new Scanner(System.in);
        System.out.println("Digite o nome do(a) gerente:");
        String firstNameManager = scanner.nextLine();
        System.out.println("Digite o sobrenome do(a) gerente:");
        String lastNameManager = scanner.nextLine();
        System.out.println("Digite a data de aniversário(ex: 1990 enter 12 enter 31) do(a) gerente:");
        LocalDate birthdayManager = LocalDate.of(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
        System.out.println("Digite o CPF(ex: 000.000.000-00) do(a) gerente:");
        String cpfManager = scanner2.nextLine();
        System.out.println("Digite o endereço do(a) gerente:");
        String addressManager = scanner2.nextLine();
        manager = new Manager(firstNameManager, lastNameManager, birthdayManager, cpfManager, addressManager);
    }
    public void loadApproveDocument(Manager manager){
        Service.manager.addDocument(document);
    }
    public void archiveApproveDocument(Manager manager){
        Service.manager.archiveDocument(document.getDocumentId());
    }
    public void unArchiveApproveDocument(Manager manager){
        Service.manager.unarchiveDocuments(document.getDocumentId(),supervisor.getId());
    }
}