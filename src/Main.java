import entities.EmployeeList;
import entities.ManagerList;
import entities.SupervisorList;
import persons.Employee;
import persons.Manager;
import persons.Supervisor;
import services.KeyboardInput;
import services.Service;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static Integer selectedType;
    private static Integer selectedTask;
    private static Integer selectedFinish;
    private static Integer selectedEmployee;
    private static Integer selectedSupervisor;
    private static Integer selectedManager;
    private static  Employee userEmployee;
    private static Supervisor userSupervisor;
    private static Manager userManager;
    public static void main(String[] args) {
        Service registerCollaborator = new Service();
        Scanner scanner = new Scanner(System.in);
        Employee employee0 = new Employee("Eduardo", "Lemes", LocalDate.of(1989, 01,01), "111.222.333-44", "Rua Itapema, Itapema-SC");
        System.out.println(employee0);
        Supervisor supervisor0 = new Supervisor("Camila", "Antunes", LocalDate.of(1994, 03,03), "333.444.555-66", "Rua Joinville, Joinville-SC");
        System.out.println(supervisor0);
        Manager manager0 = new Manager("Fernanda", "Cardoso", LocalDate.of(1987, 06,06), "666.777.888-99", "Rua Laguna, Laguna-SC");
        System.out.println(manager0);
        System.out.println();
        boolean running = true;
        boolean out = true;

        while (running) {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Seja bem vindo(a) ao DOCin, seu programa de gestão de documentos");
            System.out.println("-----------------------------------------------------------------");


            selectedType = KeyboardInput.getSelected(scanner, "Escolha o cargo do colaborador(a) que deseja acessar: \n1- Funcionário \n2- Supervisor \n3- Gerente", 1,3);
            if (selectedType == 1){
                selectedEmployee = KeyboardInput.getSelected(scanner, "Escolha o modo de acesso do(a) funcionário(a): \n1- Criar um novo usuário \n2- Entrar com uma conta", 1,2);
                if (selectedEmployee == 1){
                    registerCollaborator.registerEmployee();
                } else if (selectedEmployee == 2) {
                    System.out.println("Digite seu id d(a) funcionário(a):");
                    Integer employeerId = scanner.nextInt();
                    userEmployee = EmployeeList.returnEmployee(employeerId);
                }
                while (out) {
                    selectedTask = KeyboardInput.getSelected(scanner, "Escolha a tarefa que deseja realizar: \n1- Criar um documento \n2- Enviar documento para supervisor \n3- Sair", 1,3);
                    if (selectedTask == 1) {
                        registerCollaborator.createDocument(userEmployee);
                    } else if (selectedTask == 2) {
                        registerCollaborator.sendDocumentToApproval(userEmployee);

                    } else if (selectedTask == 3) {
                        out = false;
                    }
                }
            } else if (selectedType == 2) {
                selectedSupervisor = KeyboardInput.getSelected(scanner, "Escolha o modo de acesso do(a) supervisor(a): \n1- Criar um novo usuário \n2- Entrar com uma conta", 1,2);
                if (selectedSupervisor == 1){
                    registerCollaborator.registerSupervisor();
                } else if (selectedSupervisor == 2) {
                    System.out.println("Digite seu id do(a) supervisor(a):");
                    Integer supervisorId = scanner.nextInt();
                    userSupervisor = SupervisorList.returnSupervisor(supervisorId);
                }
                while (out){
                    selectedTask = KeyboardInput.getSelected(scanner, "Escolha a tarefa que deseja realizar: \n1- Carregar documentos pendentes \n2- Aprovar documento \n3- Rejeitar documento \n4- Sair", 1,4);
                    if (selectedTask == 1){
                        registerCollaborator.loadPendingDocument(userSupervisor);
                    } else if (selectedTask == 2) {
                        registerCollaborator.approveDocument(userSupervisor);
                    } else if (selectedTask == 3) {
                        registerCollaborator.rejectDocument(userSupervisor);
                    } else if (selectedTask == 4){
                        out = false;
                    }
                }
            } else if (selectedType == 3) {
                selectedManager = KeyboardInput.getSelected(scanner, "Escolha o modo de acesso do(a) gerente(a): \n1- Criar um novo usuário \n2- Entrar com uma conta", 1,2);
                if (selectedManager == 1){
                    registerCollaborator.registerManager();
                } else if (selectedManager == 2) {
                    System.out.println("Digite seu id do(a) gerente:");
                    Integer managerId = scanner.nextInt();
                    userManager = ManagerList.returnManager(managerId);
                }
                while (out) {
                    selectedTask = KeyboardInput.getSelected(scanner, "Escolha a tarefa que deseja realizar: \n1- Carregar documentos aprovados pelo supervisor \n2- Arquivar documento \n3- Desarquivar documento \n4- Sair", 1,4);
                    if (selectedTask == 1){
                        registerCollaborator.loadApproveDocument(userManager);
                    } else if (selectedTask == 2) {
                        registerCollaborator.archiveApproveDocument(userManager);
                    } else if (selectedTask == 3) {
                        registerCollaborator.unArchiveApproveDocument(userManager);
                    } else if (selectedTask == 4) {
                        out = false;
                    }
                }
            }

            selectedFinish = KeyboardInput.getSelected(scanner, "Deseja finalizar o programa? \n1- Sim \n2- Não", 1,2);
            switch (selectedFinish) {
                case 1 -> running = false;
                case 2 -> running = true;
            }
        }
    }
}