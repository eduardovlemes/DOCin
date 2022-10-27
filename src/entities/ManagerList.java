package entities;

import persons.Manager;

import java.util.ArrayList;
import java.util.List;

public class ManagerList {
    public static List<Manager> managers = new ArrayList<>();
    public static void addManager (Manager manager){
        managers.add(manager);
    }
    public static Manager returnManager (Integer idManager){
        return managers.get(idManager);}

    public static List<Manager> returnAllManagers(){
        return managers;
    }
}
