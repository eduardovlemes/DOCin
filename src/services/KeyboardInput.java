package services;

import java.util.Scanner;

public class KeyboardInput {
    public static Integer getSelected(Scanner keyboard, String query, Integer first, Integer last){
        Integer choice;
        while (true){
            System.out.println(query);
            try{
                choice = keyboard.nextInt();
            } catch (Exception e){
                choice = -1;
                keyboard.nextLine();
            }
            if (choice >= first && choice <= last){
                break;
            } else {
                System.out.println("Digite uma opção válida.\n");
            }
        }
        return choice;
    }
}
