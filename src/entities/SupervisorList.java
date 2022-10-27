package entities;

import persons.Employee;
import persons.Supervisor;

import java.util.ArrayList;
import java.util.List;

public class SupervisorList {
    public static List<Supervisor> supervisors = new ArrayList<>();
    public static void addSupervisor (Supervisor supervisor){
        supervisors.add(supervisor);
    }
    public static Supervisor returnSupervisor (Integer idSupervisor){
    return supervisors.get(idSupervisor);}

    public static List<Supervisor> returnAllSupervisors(){
        return supervisors;
    }
}

