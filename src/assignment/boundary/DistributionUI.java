package assignment.boundary;

import assignment.entity.*;
import assignment.adt.*;
import assignment.utility.*;
import java.util.InputMismatchException;
import java.util.Scanner;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author User
 */
public class DistributionUI {
    private DistributionMessage DistributionMSG = new DistributionMessage();
    private Scanner scan = new Scanner(System.in);

    public int distributionMenu() {
        int selection = -1;

        do {
            try {
                ClearScreen.clear();
                System.out.println("\n\t\t\tDistribution Page");
                System.out.println("============================================================");
                System.out.printf("%-4s %-19s %-15s %n", "", " Choice", "Function");
                System.out.println("============================================================");
                System.out.println("\t1.\t\tAdd new distribution\t\t");
                System.out.println("\t2.\t\tRemove distribution\t\t");
                System.out.println("\t3.\t\tUpdate distribution details\t");
                System.out.println("\t4.\t\tView distribution list\t");
                System.out.println("\t5.\t\tView report\t");
                System.out.println("\t0.\t\tExit\t");
                System.out.println("============================================================");
                System.out.print("Enter your selection(0-5): ");

                selection = scan.nextInt();
                scan.nextLine();

                break;
            } catch (InputMismatchException ex) {
                DistributionMSG.invalidInput();
                scan.nextLine();
            }
        } while (true);

        return selection;
    }

    public int doneeSelection() {
        System.out.print("Select donee to add distribution: ");
        return scan.nextInt();
    }
    
    public int userOption() {
        System.out.println("\n\t\t\tDistribution");
        System.out.println("============================================================");
        System.out.printf("%-20s %-20s %n", "Selection", "  Type of Item ");
        System.out.println("============================================================");
        System.out.println("  1. \t\t\tMoney");
        System.out.println("  2. \t\t\tItem");
        System.out.println("  3. \t\t\tFood");
        System.out.println("  0. \t\t\tExit");
        System.out.println("============================================================");
        System.out.print("Your choice(0-3): ");
        return scan.nextInt();
    }
    

//    public char moneyDistributionSelection() {
//        System.out.print("Do you want to distribute money?(Y/N): ");
//        return scan.next().charAt(0);
//    }

    public double moneyDistribution(Stock stockList) {
        System.out.println("\n\t\t\tAvailable Cash");
        System.out.println("============================================================");
        System.out.printf("%-20s %-20s %-20s %n", "    Selection", "  Type of Item", "Quantity");
        System.out.println("============================================================");
        System.out.printf("\t1.\t\t  Cash\t\t     %s\n", stockList.getMoney());
        System.out.println("============================================================");
        System.out.print("Enter amount of cash wanted to distribute: ");
        double cash = scan.nextDouble();
        if (cash < 0) {
            System.err.println("Please enter number 0 or larger.");
            cash = 0;
        }
        return cash;
    }

//    public char itemDistributionSelection() {
//        System.out.print("Do you want to distribute any items?(Y/N): ");
//        return scan.next().charAt(0);
//    }

    public int itemDistribution(Stock stockList) {
        System.out.println("\n\t\t\tITEM TYPE");
        System.out.println("============================================================");
        System.out.printf("%-20s %-20s %-20s %n", "    Selection", "  Type of Item", "Quantity");
        System.out.println("============================================================");
        System.out.printf("\t1.\t\t Clothes\t     %d\n", stockList.getClothes());
        System.out.printf("\t2.\t\t Pants\t\t     %d\n", stockList.getPants());
        System.out.printf("\t3.\t\t Shoes\t\t     %d\n", stockList.getShoes());
        System.out.printf("\t4.\t\t Bed\t\t     %d\n", stockList.getBed());
        System.out.printf("\t5.\t\t Others\t\t     %d\n", stockList.getOthers());
        System.out.println("============================================================");
        System.out.print("Enter items wanted to distribute(1-4): ");

        return scan.nextInt();
    }

//    public char foodDistributionSelection() {
//        System.out.print("Do you want to distribute any food?(Y/N): ");
//        return scan.next().charAt(0);
//    }

    public int foodDistribution(Stock stockList) {
        System.out.println("\n\t\t\tITEM TYPE");
        System.out.println("============================================================");
        System.out.printf("%-20s %-20s %n", "    Selection", "  Type of Food");
        System.out.println("============================================================");
        System.out.println("\n\t\t\tFood TYPE");
        System.out.println("============================================================");
        System.out.printf("%-20s %-20s %-20s %n", "    Selection", "  Type of Food", "Quantity");
        System.out.println("============================================================");
        System.out.printf("\t1.\t\t Rice\t\t     %d\n", stockList.getRice());
        System.out.printf("\t2.\t\t Sugar\t\t     %d\n", stockList.getSugar());
        System.out.printf("\t3.\t\t Salt\t\t     %d\n", stockList.getSalt());
        System.out.printf("\t4.\t\t Oil\t\t     %d\n", stockList.getOil());
        System.out.printf("\t5.\t\t Others\t\t     %d\n", stockList.getOthers());
        System.out.println("============================================================");
        System.out.print("Enter food wanted to distribute(1-5): ");

        return scan.nextInt();
    }

    public int distributionQuantity() {
        System.out.print("Enter quantity: ");
        return scan.nextInt();
    }

    public int removeDistribution() {

        System.out.print("Which distribution record you want to remove(0 to exit): ");
        return scan.nextInt();
    }

    public int searchMenu() {
        ClearScreen.clear();
        System.out.println("\n\t\t\tSearch Type");
        System.out.println("============================================================");
        System.out.printf("%-20s %-20s %n", "    Selection", "  Type ");
        System.out.println("============================================================");
        System.out.println("\t1.\t\t List all distribution\t\t");
        System.out.println("\t2.\t\t List distribution by donee name\t\t");
        System.out.println("\t3.\t\t List distribution by distributed items\t");
        System.out.println("\t4.\t\t List distribution by cash distributed\t");
        System.out.println("\t0.\t\t Exit\t");
        System.out.println("============================================================");
        System.out.print("Enter search selection: ");
        return scan.nextInt();
    }

    public String searchDonatorName() {
        scan.nextLine();
        System.out.print("\nEnter donee name: ");
        String name = scan.nextLine();
        System.out.println("");

        return name;
    }

    public int searchItems() {
        System.out.println("\n\t\t\tITEM TYPE");
        System.out.println("============================================================");
        System.out.printf("%-20s %-20s %n", "    Selection", "  Type of Item");
        System.out.println("============================================================");
        System.out.println("\t1.\t\t Clothes\t\t");
        System.out.println("\t2.\t\t Pants\t\t");
        System.out.println("\t3.\t\t Shoes\t");
        System.out.println("\t4.\t\t Bed\t");
        System.out.println("\t5.\t\t Rice\t\t");
        System.out.println("\t6.\t\t Sugar\t\t");
        System.out.println("\t7.\t\t Salt\t");
        System.out.println("\t8.\t\t Oil\t");
        System.out.println("============================================================");
        System.out.print("Enter item name: ");

        return scan.nextInt();
    }

    public double[] searchCash() {
        System.out.println("\nEnter cash distributed range");
        System.out.print("Lowest: ");
        double lowest = scan.nextDouble();
        System.out.print("Highest: ");
        double highest = scan.nextDouble();

        double[] range = {lowest, highest};
        return range;
    }

    public int modifyDistributionMenu() {
        System.out.print(">>>Enter 0 to exit");
        System.out.print("\nWhich distribution record you want to modify: ");
        return scan.nextInt();
    }

    public int modifyDistribution() {
        System.out.println("\n\t\t\tField Type");
        System.out.println("============================================================");
        System.out.printf("%-20s %-20s %n", "    Selection", "\tField");
        System.out.println("============================================================");
        System.out.println("\t1.\t\t Cash Distributed\t\t");
        System.out.println("\t2.\t\t Item Distributed\t\t");
        System.out.println("\t3.\t\t Item Quantity\t");
        System.out.println("\t4.\t\t Food Distributed");
        System.out.println("\t5.\t\t Food Quantity");
        System.out.println("\t0.\t\t Back to menu");
        System.out.println("============================================================");
        System.out.print("Enter field wanted to modify(0-5): ");

        return scan.nextInt();
    }

    public double changeCash() {
        System.out.print("Change value to: ");

        return scan.nextDouble();
    }

    public int changeItem() {
        System.out.println("\n\t\t\tITEM TYPE");
        System.out.println("============================================================");
        System.out.printf("%-20s %-20s %n", "    Selection", "  Type of Item");
        System.out.println("============================================================");
        System.out.println("\t1.\t\t Clothes\t\t");
        System.out.println("\t2.\t\t Pants\t\t");
        System.out.println("\t3.\t\t Shoes\t");
        System.out.println("\t4.\t\t Bed\t");
        System.out.println("============================================================");
        System.out.print("Change item to: ");

        return scan.nextInt();
    }

    public int changeQuantity() {
        System.out.print("Change quantity to: ");

        return scan.nextInt();
    }

    public int changeFood() {
        System.out.println("\n\t\t\tFood TYPE");
        System.out.println("============================================================");
        System.out.printf("%-20s %-20s %n", "    Selection", "  Type of Food");
        System.out.println("============================================================");
        System.out.println("\t1.\t\t Rice\t\t");
        System.out.println("\t2.\t\t Sugar\t\t");
        System.out.println("\t3.\t\t Salt\t");
        System.out.println("\t4.\t\t Oil\t");
        System.out.println("============================================================");
        System.out.print("Change food to: ");

        return scan.nextInt();
    }
    
    public boolean displayList(int x, int index, LinkedListInterface<Distribution> distributionList) {

        System.out.printf("%d.%s\n\n", index, distributionList.readForward(x).toString());
        index++;

        return false;
    }
    
    public void displayCash(Stock stockList) {
        System.out.println("\n\t\t\tAvailable Cash");
        System.out.println("============================================================");
        System.out.printf("%-20s %-20s %-20s %n", "    Selection", "  Type of Item", "Quantity");
        System.out.println("============================================================");
        System.out.printf("\t1.\t\t Cash\t\t: %s\n", stockList.getMoney());
        System.out.println("============================================================");
    }

    public void displayItems(Stock stockList) {
        System.out.println("\n\t\t\tITEM TYPE");
        System.out.println("============================================================");
        System.out.printf("%-20s %-20s %-20s %n", "    Selection", "  Type of Item", "Quantity");
        System.out.println("============================================================");
        System.out.printf("\t1.\t\t Clothes\t\t:      %d\n", stockList.getClothes());
        System.out.printf("\t2.\t\t Pants\t\t:  %d\n", stockList.getPants());
        System.out.printf("\t3.\t\t Shoes\t\t:  %d\n", stockList.getBed());
        System.out.printf("\t4.\t\t Bed\t\t:%d\n", stockList.getShoes());
    }

    public void displayFood(Stock stockList) {
        System.out.println("\n\t\t\tFood TYPE");
        System.out.println("============================================================");
        System.out.printf("%-20s %-20s %-20s %n", "    Selection", "  Type of Food", "Quantity");
        System.out.println("============================================================");
        System.out.printf("\t1.\t\t Rice\t\t: %d\n", stockList.getRice());
        System.out.printf("\t2.\t\t Oil\t\t: %d\n", stockList.getOil());
        System.out.printf("\t3.\t\t Sugar\t\t: %d\n", stockList.getSugar());
        System.out.printf("\t4.\t\t Salt\t\t: %d\n", stockList.getSalt());
    }
    
    public void displayaddedDistribution(Distribution distribution) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("                  Distribution Details Added                 ");
        System.out.println("-------------------------------------------------------------");
        System.out.println(distribution.toString());
        System.out.println("-------------------------------------------------------------");
    }

    public boolean displayDoneeList(int x, LinkedListInterface<Donee> doneeList) {
        System.out.printf("%d.\tDonee ID\t: %s \n\tDonee Name\t: %s \n", x, doneeList.readForward(x).getDoneeID(), doneeList.readForward(x).getDoneeName());
        return false;
    }
    
    public void displayDistributionTitle() {
        System.out.println("\n============================================================");
        System.out.println("\t\t\tDistribution List");
        System.out.println("============================================================");
    }

    public void displayDoneeTitle() {
        System.out.println("\n============================================================");
        System.out.println("\t\t\tDonee List");
        System.out.println("============================================================");
    }

    public void displayLine() {
        System.out.println("============================================================");
    }

    public void displayContinue() {
        System.out.print("Press Enter to Continue");
        scan.nextLine();
        scan.nextLine();
    }
    
    public void summaryReport(LinkedListInterface<Distribution> distributionList, DistributedStock distributedstockList){
        System.out.println("==========================================================================");
        System.out.println("         Annual Report of Total Distributed Distribution in Year 2024         ");
        System.out.println("==========================================================================");
        System.out.printf("Total numbers of distribution: %d\n", distributionList.getNumberOfEntries());
        System.out.printf("Total money distributed: %.2f\n", distributedstockList.getMoney());
        System.out.println("Total items distributed:");
        System.out.printf("1.\tClothes: %d\n", distributedstockList.getClothes());
        System.out.printf("2.\tPants: %d\n", distributedstockList.getPants());
        System.out.printf("3.\tShoes: %d\n", distributedstockList.getShoes());
        System.out.printf("4.\tBed: %d\n", distributedstockList.getBed());
        System.out.printf("5.\tRice: %d\n", distributedstockList.getRice());
        System.out.printf("6.\tSugar: %d\n", distributedstockList.getSugar());
        System.out.printf("7.\tSalt: %d\n", distributedstockList.getSalt());
        System.out.printf("8.\tOil: %d\n", distributedstockList.getOil());
        System.out.println("==========================================================================");
        System.out.print("Press enter to continue");
        scan.nextLine();
    }
}
    

