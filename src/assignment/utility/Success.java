/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.utility;

import java.util.Scanner;

/**
 *
 * @author weeya
 */
public class Success {
    private static final Scanner scan = new Scanner(System.in);
    private static final String line = "------------------------------------------------------------";
    private static final String proceed = "Press Enter to continue...";
    
    public static void registerSuccess(){
        Colour.printGreen("\nRegister Successfully");
        System.out.print(proceed);
        scan.nextLine();
    }
    
    public static void deleteSuccess() {
        Colour.printGreen("\nThe donor has been successfully deleted");
        System.out.print(proceed);
        scan.nextLine();
    }
    
    public static void userFound(){
        Colour.printGreen("\nThe donor has been successfully deleted");
        System.out.print(proceed);
        scan.nextLine();
    }
    
    public static void userModify(){
        Colour.printGreen("\nThe donor has been successfully modified");
        System.out.print(proceed);
        scan.nextLine();
    }
}
