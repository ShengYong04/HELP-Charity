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
public class DonationUI {
    private DonationMessage errorMsg = new DonationMessage();
    private Scanner scan = new Scanner(System.in);

    public int donationMenu() {
        int selection = -1;

        do {
            try {
                ClearScreen.clear();
                System.out.println("\n\t\t\tDonation Page");
                System.out.println("============================================================");
                System.out.printf("%-4s %-19s %-15s %n", "", " Choice", "Function");
                System.out.println("============================================================");
                System.out.println("\t1.\t\tAdd new donation\t\t");
                System.out.println("\t2.\t\tRemove donation\t\t");
                System.out.println("\t3.\t\tUpdate donation details\t");
                System.out.println("\t4.\t\tView donation list\t");
                System.out.println("\t5.\t\tView report\t");
                System.out.println("\t0.\t\tExit\t");
                System.out.println("============================================================");
                System.out.print("Enter your selection(0-5): ");

                selection = scan.nextInt();
                scan.nextLine();

                break;
            } catch (InputMismatchException ex) {
                errorMsg.invalidInput();
                scan.nextLine();
            }
        } while (true);

        return selection;
    }
    
    public int userOption(){
        System.out.println("\n\t\t\tDonation");
        System.out.println("============================================================");
        System.out.printf("%-20s %-20s %n", "Selection", "  Type of Donation ");
        System.out.println("============================================================");
        System.out.println("  1. \t\t\tMoney");
        System.out.println("  2. \t\t\tItem");
        System.out.println("  3. \t\t\tFood");
        System.out.println("  0. \t\t\tExit");
        System.out.println("============================================================");
        System.out.print("Your choice(0-3): ");
        return scan.nextInt();
    }

    public int donorSelection() {
        System.out.print("Select donor to add donation: ");
        return scan.nextInt();
    }

//    public char moneyDonationSelection() {
//        System.out.print("Do you want to donate money?(Y/N): ");
//        return scan.next().charAt(0);
//    }
    
//    public static String displayContinueYN(){
//        String yesno;
//        Scanner scan = new Scanner(System.in);
//        System.out.print("Do you want to continue (y/n): ");
//        yesno = scan.nextLine();
//        return yesno;
//        
//    }

    public double moneyDonation() {
        System.out.print("Enter amount of cash wanted to donate: ");
        double cash = scan.nextDouble();
        if (cash < 0) {
            System.err.println("Please enter number 0 or larger.");
            cash = 0;
        }
        return cash;
    }

//    public char itemDonationSelection() {
//        System.out.print("Do you want to donate any items?(Y/N): ");
//        return scan.next().charAt(0);
//    }

    public int itemDonation() {
        System.out.println("\n\t\t\tITEM TYPE");
        System.out.println("============================================================");
        System.out.printf("%-20s %-20s %n", "    Selection", "  Type of Item");
        System.out.println("============================================================");
        System.out.println("\t1.\t\t Clothes");
        System.out.println("\t2.\t\t Pants");
        System.out.println("\t3.\t\t Shoes");
        System.out.println("\t4.\t\t Bed");
        System.out.println("\t5.\t\t Others");
        System.out.println("============================================================");
        System.out.print("Enter items wanted to donate(1-5): ");

        return scan.nextInt();
    }

//    public char foodDonationSelection() {
//        System.out.print("Do you want to donate any food?(Y/N): ");
//        return scan.next().charAt(0);
//    }

    public int foodDonation() {
        System.out.println("\n\t\t\tITEM TYPE");
        System.out.println("============================================================");
        System.out.printf("%-20s %-20s %n", "    Selection", "  Type of Food");
        System.out.println("============================================================");
        System.out.println("\t1.\t\t Rice");
        System.out.println("\t2.\t\t Sugar");
        System.out.println("\t3.\t\t Salt");
        System.out.println("\t4.\t\t Oil");
        System.out.println("\t5.\t\t Others");
        System.out.println("============================================================");
        System.out.print("Enter food wanted to donate(1-5): ");

        return scan.nextInt();
    }

    public int donationQuantity() {
        System.out.print("Enter quantity: ");
        return scan.nextInt();
    }

    public int removeDonation() {
        
        System.out.print("Which donation record you want to remove(0 to exit): ");
        return scan.nextInt();
    }

    public int searchMenu() {
        ClearScreen.clear();
        System.out.println("\n\t\t\tSearch Type");
        System.out.println("============================================================");
        System.out.printf("%-20s %-20s %n", "    Selection", "  Type ");
        System.out.println("============================================================");
        System.out.println("\t1.\t\t List all donation\t\t");
        System.out.println("\t2.\t\t List donation by donor name\t\t");
        System.out.println("\t3.\t\t List donation by donated items\t");
        System.out.println("\t4.\t\t List donation by cash donated\t");
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
        System.out.println("\nEnter cash donated range");
        System.out.print("Lowest: ");
        double lowest = scan.nextDouble();
        System.out.print("Highest: ");
        double highest = scan.nextDouble();

        double[] range = {lowest, highest};
        return range;
    }

    public int amendDonationMenu() {
        System.out.print(">>>Enter 0 to exit");
        System.out.print("\nWhich donation record you want to amend: ");
        return scan.nextInt();
    }

    public int amendDonation() {
        System.out.println("\n\t\t\tField Type");
        System.out.println("============================================================");
        System.out.printf("%-20s %-20s %n", "    Selection", "\tField");
        System.out.println("============================================================");
        System.out.println("\t1.\t\t Cash Donated\t\t");
        System.out.println("\t2.\t\t Item Donated\t\t");
        System.out.println("\t3.\t\t Item Quantity\t");
        System.out.println("\t4.\t\t Food Donated");
        System.out.println("\t5.\t\t Food Quantity");
        System.out.println("\t0.\t\t Back to menu");
        System.out.println("============================================================");
        System.out.print("Enter field wanted to amend(0-5): ");
        
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

    public void summary(LinkedListInterface<Donation> donationList, Stock stockList) {
        double avgPerMonth = donationList.getNumberOfEntries() / 30;
        
        System.out.println("\n\t\tMonthly Donation Summray Report");
        System.out.println("============================================================");
        System.out.printf("Total numbers of donation: %d\n", donationList.getNumberOfEntries());
        System.out.printf("Total money donated: %.2f\n", stockList.getMoney());
        System.out.println("============================================================");
        System.out.printf("%-2s %-20s %-30s %n", "No.", "Type of Donation", "Total Quantity");
        System.out.println("============================================================");
        System.out.printf("1.  Clothes \t\t\t%d\n",stockList.getClothes());
        System.out.printf("2.  Pants \t\t\t%d\n", stockList.getPants());
        System.out.printf("3.  Shoes \t\t\t%d\n", stockList.getShoes());
        System.out.printf("4.  Bed \t\t\t%d\n", stockList.getBed());
        System.out.printf("5.  Rice \t\t\t%d\n", stockList.getRice());
        System.out.printf("6.  Sugar \t\t\t%d\n", stockList.getSugar());
        System.out.printf("7.  Salt \t\t\t%d\n", stockList.getSalt());
        System.out.printf("8.  Oil \t\t\t%d\n", stockList.getOil());
        System.out.println("============================================================");
        System.out.printf("Average donation per Month: %.2f\n", avgPerMonth);
        System.out.println("============================================================");
        System.out.print("Press enter to continue");
        scan.nextLine();
    }
    
    public boolean displayList(int x, int index, LinkedListInterface<Donation> donationList) {

        System.out.printf("%d.%s\n\n", index, donationList.readForward(x).toString());
        index++;

        return false;
    }

    public boolean displayDonorList(int x,LinkedListInterface<Donor> donorList ) {
        System.out.printf("%d.\tDonor ID\t: %s \n\tDonor Name\t: %s \n", x, donorList.readForward(x).getId(),donorList.readForward(x).getName() );
        
        return false;
    }
    
    public void displayaddedDonation(Donation donation) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("                  Donation Details Added                 ");
        System.out.println("-------------------------------------------------------------");
        System.out.println(donation.toString());
        System.out.println("-------------------------------------------------------------");
    }
    
    public void displayDonationTitle(){
        System.out.println("\n============================================================");
        System.out.println("\t\t\tDonation List");
        System.out.println("============================================================");
    }
    
    public void displayDonorTitle() {
        System.out.println("\n============================================================");
        System.out.println("\t\t\tDonor List");
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
}
