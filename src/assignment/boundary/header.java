/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.boundary;

/**
 *
 * @author User
 */
public class header {
    private static final String clearScreen = "\n".repeat(50);
    
    public static void Header(String s){
        System.out.println(clearScreen);
        System.out.println("=========================================================");
        System.out.println("\t\t"+s);
        System.out.println("=========================================================");
    }
    
    public static void reportHeader(String s){
        System.out.println("\n=====================================================================");
        System.out.println("\t\t"+s);
        System.out.println("=====================================================================");
    }
    
    public static void doneeMainHeader(){
        System.out.println(clearScreen);
        System.out.println("\n\t\t\tDonee Page");
        System.out.println("============================================================");
        System.out.printf("%-4s %-19s %-15s %n","", " Choice", "Function");
        System.out.println("============================================================");
        System.out.println("\t1.\t\tAdd new donee\t\t");
        System.out.println("\t2.\t\tRemove donee\t\t");
        System.out.println("\t3.\t\tUpdate donee details\t");
        System.out.println("\t4.\t\tView donee list\t");
        System.out.println("\t5.\t\tView report\t");
        System.out.println("\t6.\t\tCreate Dummy Donee\t");
        System.out.println("\t0.\t\tExit\t");
        System.out.println("------------------------------------------------------------");
    }
    
    public static void addDoneeHeader(){
        System.out.println("\n\t\tAdding a new donee");
        System.out.println("============================================================");
        System.out.printf("%-4s %-19s %-15s %n","", " Option", "Donee Type");
        System.out.println("============================================================");
        System.out.println("\ti\t\tIndividual\t\t");
        System.out.println("\tf\t\tFamily\t\t");
        System.out.println("\to\t\tOrganization\t");
        System.out.println("------------------------------------------------------------");
    }
    
    public static void removeDoneeHeader(){
        System.out.println("\n\n\n\t\t\tRemove a donee");
        System.out.println("============================================================");
        System.out.printf("%-4s %-19s %-15s %n","", " Option", "Function");
        System.out.println("============================================================");
        System.out.println("\t1.\t\tDonee ID\t\t");
        System.out.println("\t2.\t\tContact number\t\t");
        System.out.println("\t0.\t\tExit\t");
        System.out.println("------------------------------------------------------------");
    }
    
    public static void updateDoneeHeader(){
        System.out.println("\n\n\n\t\tUpdate Donee Information");
        System.out.println("============================================================");
        System.out.printf("%-4s %-19s %-15s %n","", " Option", "Function");
        System.out.println("============================================================");
        System.out.println("\t1.\t\tDonee ID\t\t");
        System.out.println("\t2.\t\tContact number\t\t");
        System.out.println("\t0.\t\tExit\t");
        System.out.println("------------------------------------------------------------");
    }
    
    public static void updateHeader1(){
        System.out.println("\n\n\n\t\tUpdate Specific Field of Information");
        System.out.println("============================================================");
        System.out.printf("%-4s %-19s %-15s %n","", " Option", "Function");
        System.out.println("============================================================");
        System.out.println("\t1.\t\tDonee Name\t\t");
        System.out.println("\t2.\t\tPhone Number\t\t");
        System.out.println("\t3.\t\tEmail\t");
        System.out.println("\t4.\t\tAddress\t");
        System.out.println("\t5.\t\tGender\t");
        System.out.println("\t6.\t\tAge\t");
        System.out.println("\t0.\t\tExit\t");
        System.out.println("------------------------------------------------------------");
    }
    
    public static void updateHeader2(){
        System.out.println("\n\n\n\t\tUpdate Specific Field of Information");
        System.out.println("============================================================");
        System.out.printf("%-4s %-19s %-15s %n","", " Option", "Function");
        System.out.println("============================================================");
        System.out.println("\t1.\t\tDonee Name\t\t");
        System.out.println("\t2.\t\tPhone Number\t\t");
        System.out.println("\t3.\t\tEmail\t");
        System.out.println("\t4.\t\tAddress\t");
        System.out.println("\t5.\t\tGender\t");
        System.out.println("\t6.\t\tAge\t");
        System.out.println("\t7.\t\tNo of Pax\t");
        System.out.println("\t0.\t\tExit\t");
        System.out.println("------------------------------------------------------------");
    }
    
    public static void updateHeader3(){
        System.out.println("\n\n\n\t\tUpdate Specific Field of Information");
        System.out.println("============================================================");
        System.out.printf("%-4s %-19s %-15s %n","", " Option", "Function");
        System.out.println("============================================================");
        System.out.println("\t1.\t\tDonee Name\t\t");
        System.out.println("\t2.\t\tPhone Number\t\t");
        System.out.println("\t3.\t\tEmail\t");
        System.out.println("\t4.\t\tAddress\t");
        System.out.println("\t5.\t\tOrganization Name\t");
        System.out.println("\t0.\t\tExit\t");
        System.out.println("------------------------------------------------------------");
    }
    
    public static void reportHeader1(){
        System.out.println("\n\n\t\tReport of Donee Information");
        System.out.println("============================================================");
        System.out.printf("%-4s %-19s %-15s %n","", " Option", "Function");
        System.out.println("============================================================");
        System.out.println("\t1.\t\tMonthly report of types of donee\t\t");
        System.out.println("\t2.\t\tAnnual report of types of donee\t\t");
        System.out.println("\t0.\t\tExit\t\t");
        System.out.println("------------------------------------------------------------");
    }
    
    public static void reportHeader2(){
        System.out.println("\n\t\t\tSelect a Month");
        System.out.println("============================================================");
        System.out.printf("%-4s %-19s %-15s %n","", " Option", "Function");
        System.out.println("============================================================");
        System.out.println("\t01.\t\tJanuary\t\t");
        System.out.println("\t02.\t\tFebruary\t\t");
        System.out.println("\t03.\t\tMarch\t\t");
        System.out.println("\t04.\t\tApril\t\t");
        System.out.println("\t05.\t\tMay\t\t");
        System.out.println("\t06.\t\tJune\t\t");
        System.out.println("\t07.\t\tJuly\t\t");
        System.out.println("\t08.\t\tAugust\t\t");
        System.out.println("\t09.\t\tSeptember\t\t");
        System.out.println("\t10.\t\tOctober\t\t");
        System.out.println("\t11.\t\tNovember\t\t");
        System.out.println("\t12.\t\tDecember\t\t");
        System.out.println("\t00.\t\tExit\t\t");
        System.out.println("------------------------------------------------------------");
    }
    
    public static void doneeListHeader(){
        System.out.println("\n\t\t\t\t\tDonee List");
        System.out.println("==================================================================================================");
        System.out.printf("%-10s %-30s %-20s %-20s %n", " DoneeID", "Donee Name", "Donee Type", "Donee contact number");
        System.out.println("==================================================================================================");
    }
    
    public static void filterHeader(){
        System.out.println("\n\t\tFilter Donee Information");
        System.out.println("============================================================");
        System.out.printf("%-15s %-15s %n", " Option", "Donee Type");
        System.out.println("============================================================");
        System.out.println("1.\t\tIndividual\t\t");
        System.out.println("2.\t\tFamily\t\t");
        System.out.println("3.\t\tOrganization\t");
        System.out.println("------------------------------------------------------------");
        System.out.println("Enter \"4\" to cancle filter\n");
    }
    

}
