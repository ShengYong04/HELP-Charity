/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.boundary;

/**
 *
 * @author weeya
 */
public class DonorManagementHeader {
    private static final String clearScreen = "\n".repeat(50);
    private static final String line = "------------------------------------------------------------";
    
    public static void registerHeader(){
        System.out.println(clearScreen);
        //System.out.println("\n=====================================================================");
        System.out.println("\t\t\tRegister a Donor" );
        System.out.println("=====================================================================");

    }
    
    public static void modifyHeader(){
        System.out.println(clearScreen);
        System.out.println("\t\t\t\t\tModify Donor ");
    }
    
    public static void deleteHeader(){
        System.out.println(clearScreen);
        System.out.println("\t\t\t\t\tDelete ");
    }
    
    public static void confirmationHeader(){
        System.out.println(clearScreen);
        System.out.println("\t\t\tComfirmation");
        System.out.println("============================================================");
    }
    
    public static void reportChoice(){
        System.out.println(clearScreen);
        System.out.println("\n\n\t\tReport of Donor Information");
        System.out.println("============================================================");
    }
    
    public static void reportSelectMonth(){
        System.out.println(clearScreen);
        System.out.println("\n\t\t\tSelect a Month");
        System.out.println("============================================================");
        System.out.printf("%-4s %-19s %-15s %n","", " Option", "Function");
        System.out.println("============================================================");
    }
    
    public static void annualReport(){
        System.out.println(clearScreen);
        System.out.println("\n\n\n****************Annual Report of Types of Donor****************");
    }
    
    public static void exitHeader(){
        System.out.println(clearScreen);
        System.out.println("                                            Exit                            ");
        System.out.println(line);
    }
    
    public static void searchDonor(){
        System.out.println(clearScreen);
        System.out.println("                                            Search Donor                        ");
    }
    
    public static void donorDetail(){
        System.out.println(clearScreen);
        System.out.println("                                            Donor Detail                       ");
    }
    
    public static void donorMangementHeader(){
        System.out.println(clearScreen);
        System.out.println("                           Donor                          ");
    }
}
