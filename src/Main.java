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
    private static Integer selectedEmployee;
    private static Integer selectedSupervisor;
    private static Integer selectedManager;
    private static  Employee userEmployee;
    private static Supervisor userSupervisor;
    public static void main(String[] args) {
        Employee employee0 = new Employee("Eduardo", "Lemes", LocalDate.of(1989, 01,01), "111.222.333-44", "Rua Itapema, Itapema-SC");
        System.out.println(employee0);
        Employee employee1 = new Employee("Sebastião", "Oliveira", LocalDate.of(1972, 02,02), "222.333.444-55", "Rua Florianópolis, Florianópolis-SC");
        System.out.println(employee1);
        Supervisor supervisor0 = new Supervisor("Camila", "Antunes", LocalDate.of(1994, 03,03), "333.444.555-66", "Rua Joinville, Joinville-SC");
        System.out.println(supervisor0);
        Supervisor supervisor1 = new Supervisor("Lais", "Ferreira", LocalDate.of(1990, 04,04), "444.555.666-77", "Rua Blumenau, Blumenau-SC");
        System.out.println(supervisor1);
        Manager manager0 = new Manager("Fernando", "Moura", LocalDate.of(1991, 05,05), "555.666.777-88", "Rua Chapecó, Chapecó-SC");
        System.out.println(manager0);
        Manager manager1 = new Manager("Fernanda", "Cardoso", LocalDate.of(1987, 06,06), "666.777.888-99", "Rua Laguna, Laguna-SC");
        System.out.println(manager1);


        Service registerCollaborator = new Service();

        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("Seja bem vindo(a) ao DOCin, seu programa de gestão de documentos!");
            //Employee employee = EmployeeList.returnEmployee();



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
                selectedTask = KeyboardInput.getSelected(scanner, "Escolha a tarefa que deseja realizar: \n1- Criar um documento \n2- Enviar documento para supervisor", 1,2);
                if (selectedTask == 1){
                    registerCollaborator.createDocument(userEmployee);
                } else if (selectedTask == 2) {
                    registerCollaborator.sendDocumentToApproval(userEmployee);
                }





            } else if (selectedType == 2) {
                selectedSupervisor = KeyboardInput.getSelected(scanner, "Escolha o modo de acesso do(a) supervisor(a): \n1- Criar um novo usuário \n2- Entrar com uma conta", 1,2);
                if (selectedSupervisor == 1){
                    registerCollaborator.registerSupervisor();
                } else if (selectedSupervisor == 2) {
                    System.out.println("Digite seu id do(a) supervisor(a):");
                    Integer supervisorId = scanner.nextInt();
                    Supervisor user = SupervisorList.returnSupervisor(supervisorId);
                }
                selectedTask = KeyboardInput.getSelected(scanner, "Escolha a tarefa que deseja realizar: \n1- Carregar documentos pendentes \n2- Aprovar documento \n3- Rejeitar documento", 1,3);
                if (selectedTask == 1){
                    registerCollaborator.loadPendingDocument(userSupervisor);
                } else if (selectedTask == 2) {
                    registerCollaborator.approveDocument(userSupervisor);
                } else if (selectedTask == 3) {
                    registerCollaborator.rejectDocument(userSupervisor);

                }


            } else if (selectedType == 3) {
                selectedManager = KeyboardInput.getSelected(scanner, "Escolha o modo de acesso do(a) gerente(a): \n1- Criar um novo usuário \n2- Entrar com uma conta", 1,2);
                if (selectedManager == 1){
                    registerCollaborator.registerManager();
                } else if (selectedManager == 2) {
                    System.out.println("Digite seu id do(a) gerente:");
                    Integer managerId = scanner.nextInt();
                    Manager user = ManagerList.returnManager(managerId);
                }



            }








            selectedType = KeyboardInput.getSelected(scanner, "Escolha o cargo do colaborador(a) que deseja cadastrar: \n1- Funcionário \n2- Supervisor \n3- Gerente", 1,3);
            if (selectedType == 1){
                registerCollaborator.registerEmployee();
                selectedTask = KeyboardInput.getSelected(scanner, "Escolha a tarefa que deseja fazer: \n1- Adicionar um novo documento \n2- Solicitar aprovação de documento", 1,2);
                if (selectedTask == 1){
                    //registerCollaborator.createDocument();
                }
            } else if (selectedType == 2) {
                registerCollaborator.registerSupervisor();
            } else if (selectedType == 3) {
                registerCollaborator.registerManager();
            }





        }



    }
}