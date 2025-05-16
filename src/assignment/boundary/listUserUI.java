/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.boundary;

import assignment.entity.*;
import java.util.Scanner;

/**
 *
 * @author weeya
 */
public class listUserUI {
    private static final Scanner scan = new Scanner(System.in);
    private static final String clearScreen = "\n".repeat(50);
    
    public static void listUserHeader(){
        
        System.out.println("==================================================================================================");
        System.out.printf("%-10s %-20s %-35s %-20s %n", " No", "Donor ID", "Username", "Type");
        System.out.println("==================================================================================================");
    }
    
    public static void emptyUser(){
        System.out.println("\nThere is currently no donor registered.\n");
    }
    
    public static void displayUser(int no, Donor donor){
        System.out.printf("%-10s %-20s %-35s %-20s %n", no, donor.getId(), donor.getName(), donor.getType());
    }
    
    public static void listUserFooter(int currentPage, int pageNum){
        System.out.println("==================================================================================================");
        System.out.println("\t\t\t\t\t" + currentPage + " of " + pageNum);
        System.out.println("==================================================================================================");
        System.out.println("Enter \"0\" to exit");
        System.out.println("Enter \"1\" to display previous page");
        System.out.println("Enter \"2\" to display next page");
        System.out.println("Enter \"3\" to filter\n");
    }
    
    public static void filterHeader(){
        System.out.println(clearScreen);
        System.out.println("                          Filter                            ");
    }
    
    public static int filterInterface(boolean publicStat, boolean privateStat, boolean governmentStat) {
        filterHeader();
        System.out.println("============================================================");
        System.out.printf("%-5.2s %-18s %-14s %-9s %n","", " No", "Type","Status");
        System.out.println("============================================================");
        System.out.println("\t1.\t\t Public\t\t"+ publicStat);
        System.out.println("\t2.\t\t Private\t\t"+ privateStat);
        System.out.println("\t3.\t\t Government\t"+ governmentStat);
        System.out.println("------------------------------------------------------------");
        
        System.out.println("Enter \"0\" to exit\n");
        System.out.print("Enter selection: ");
        int choice = scan.nextInt();
        scan.nextLine();
        
        return choice;
    }
}
