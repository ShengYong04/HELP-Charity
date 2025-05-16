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
public class Error {
    private static final Scanner scan = new Scanner(System.in);
    private static final String line = "------------------------------------------------------------";
    private static final String proceed = "Press Enter to continue...";
    
    public static void integerOnly(){
        Colour.printRed("\nPlease enter integer only");
        System.out.print(proceed);
        scan.nextLine();
    }
    
    public static void yesOrNo(){
        Colour.printRed("\nPlease enter y/n only");
        System.out.print(proceed);
        scan.nextLine();
    }
    
    public static void invalidChoice(int num) {
        Colour.printRed("\nInvalid choice. Please enter number between 0 and " + num);
        System.out.print(proceed);
        scan.nextLine();
    }
    
    public static void topPage() {
        Colour.printRed("\nYou have reached the top of the page");
        System.out.print(proceed);
        scan.nextLine();
    }
    
    public static void bottomPage(){
        Colour.printRed("\nYou have reached the end of the page");
        System.out.print(proceed);
        scan.nextLine();
    }
    
    public static void userNotFound(String userID) {
        Colour.printRed("\nThere is no existing user with the ID: " + userID);
        System.out.print(proceed);
        scan.nextLine();
    }
    
    public static void fileNotFound(){
        Colour.printRed("\nFile not found");
        System.out.print(proceed);
        scan.nextLine();
    }
    
    public static void cannotSave(){
        Colour.printRed("\nCannot save to file");
        System.out.print(proceed);
        scan.nextLine();
    }
    
    public static void classNotFound() {
        Colour.printRed("\nClass not found");
        System.out.print(proceed);
        scan.nextLine();
    }
    
    public static void cannotRead(){
        Colour.printRed("\nCannot read from file");
        System.out.print(proceed);
        scan.nextLine();
    }
    
    public static void empty(){
        Colour.printRed("\nPlease do not leave it blank");
        System.out.print(proceed);
        scan.nextLine();
    }
    
    public static void nameLength(){
        Colour.printRed("\nInvalid input. Donor name should be more than 3 characters");
        System.out.print(proceed);
        scan.nextLine();
    }
    
    public static void nameFormat(){
        Colour.printRed("\nInvalid name. It should only contain alphabets and spaces");
        System.out.print(proceed);
        scan.nextLine();
    }
    
    public static void phoneFormat(){
        Colour.printRed("\nInvalid phone number. It should start with '01' followed by 8 or 9 digits");
        System.out.print(proceed);
        scan.nextLine();
    }
    
    public static void emailFormat(){
        Colour.printRed("\nInvalid email address. Please provide a valid email with format (E.g. abc@gmail.com)");
        System.out.print(proceed);
        scan.nextLine();
    }
    
    public static void addressFormat(){
        Colour.printRed("\nInvalid address. It should be at least 8 characters long and can include letters, numbers, commas, periods, and slashes.");
        System.out.print(proceed);
        scan.nextLine();
    }
}
