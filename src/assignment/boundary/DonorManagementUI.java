/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.boundary;

import assignment.entity.*;
import assignment.adt.*;
import assignment.utility.Error;
import assignment.utility.*;
import assignment.control.*;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author weeya
 */
public class DonorManagementUI {
    private static final Scanner scan = new Scanner(System.in);
    private static final String line = "------------------------------------------------------------";
    
    public static void exitKey(){
        System.out.println(">>> Enter \"0\" to exit\n");
    }
    
    public static String askName(){
        System.out.print("Enter your name: ");
        String name = scan.nextLine();
        
        return name;
    }
    
    public static String inputDonorName() {
        String name;

        do {
            do {
                DonorManagementHeader.registerHeader();
                exitKey();
                name = askName();

                if (name.equals("0") && confirmExit()) {
                    return "0";
                }

            } while (name.equals("0"));
        } while (!DonorValidation.validateName(name));

        return name;
    }

    public static String askPNum() {
        System.out.print("Enter your phone number: ");
        String phoneNum = scan.nextLine();
        
        return phoneNum;
    }
    
    public static String inputDonorPNum(String name) {
        String phoneNum;
        boolean first = true;

        do {
            do {
                if (!first) {
                    DonorManagementHeader.registerHeader();
                    exitKey();
                    System.out.println("Enter your name: " + name);
                }
                phoneNum = askPNum();

                if (phoneNum.equals("0") && confirmExit()) {
                    return "0";
                }

                first = false;
            } while (phoneNum.equals("0"));
        } while (!DonorValidation.validatePhoneNumber(phoneNum));

        return phoneNum;
    }
    
    public static String askEmail() {
        System.out.print("Enter your email: ");
        String email = scan.nextLine();
        
        return email;
    }
    
    public static String inputEmail(String name, String phoneNum) {
        String email;
        boolean first = true;

        do {
            do {
                if (!first) {
                    DonorManagementHeader.registerHeader();
                    exitKey();
                    System.out.println("Enter your name: " + name);
                    System.out.println("Enter your phone number: " + phoneNum);
                }
                email = askEmail();

                if (email.equals("0") && confirmExit()) {
                    return "0";
                }

                first = false;
            } while (email.equals("0"));
        } while (!DonorValidation.validateEmail(email));

        return email;
    }
    
    public static void currentProgress(String name, String phoneNum, String email) {
        DonorManagementHeader.registerHeader();
        exitKey();
        System.out.println("Enter your name: " + name);
        System.out.println("Enter your phone number: " + phoneNum);
        System.out.println("Enter your email: " + email);
    }
    
    public static int askType() {
        System.out.print("""
                         What is the type of donor?
                         1. Public
                         2. Private
                         3. Government""");
        System.out.print("\nEnter your selection: ");
        int select = scan.nextInt();
        scan.nextLine();
        
        return select;
    }
    
    public static String typeSwitch(int select){
        String type = "";

        switch (select) {
            case 0 ->
                type = "0";
            case 1 ->
                type = "Public";
            case 2 ->
                type = "Private";
            case 3 ->
                type = "Government";
            default -> {
                Error.invalidChoice(3);
            }
        }

        return type;
    }

    public static String inputType(String name, String phoneNum, String email) {
        String type = "";
        int select = -1;
        boolean first = true;

        do {
            do {
                try {
                    if (!first){
                        currentProgress(name, phoneNum, email);
                    }
                    select = askType();
                    break;
                } catch (InputMismatchException ex) {
                    scan.nextLine();
                    Error.integerOnly();
                    first = false;
                }
            } while (true);

            type = typeSwitch(select);

            if (type.equals("0") && confirmExit()) {
                return "0";
            }
            
            first = false;
        } while (type.equals("0") || !(select >= 1 && select <= 3));
        
        return type;
    }
    
    public static String askAddress(){
        System.out.print("Enter your address: ");
        String address = scan.nextLine();
        
        return address;
    }
    
    public static String inputAddress(String name, String phoneNum, String email, String type) {
        String address;
        int num;
        boolean first = true;
        
        num = switch (type) {
            case "Public" -> 1;
            case "Private" -> 2;
            default -> 3;
        };

        do {
            do {
                if (!first) {
                    DonorManagementHeader.registerHeader();
                    exitKey();
                    System.out.print("Enter your name: " + name);
                    System.out.print("\nEnter your phone number: " + phoneNum);
                    System.out.print("\nEnter your email: " + email + "\n");
                    System.out.print("""
                         What is the type of donor?
                         1. Public
                         2. Private
                         3. Government
                         Enter your selection: """ + num + "\n");
                }
                address = askAddress();

                if (address.equals("0") && confirmExit()) {
                    return "0";
                }

                first = false;
            } while (address.equals("0"));
        } while (!DonorValidation.validateAddress(address));

        return address;
    }
    
    public static Donor inputDonorDetail() {
        String name, phoneNum = null, email = null, type = null, address = null, id = null;
        
        name = DonorManagementUI.inputDonorName();

        if (!name.equals("0")) {
            phoneNum = DonorManagementUI.inputDonorPNum(name);
            
            if (!phoneNum.equals("0")){
                email = DonorManagementUI.inputEmail(name, phoneNum);
                
                if (!email.equals("0")) {
                    type = DonorManagementUI.inputType(name, phoneNum, email);
                    
                    if (!type.equals("0")){
                        address = DonorManagementUI.inputAddress(name, phoneNum, email, type);
                        
                        if (!address.equals("0")){
                            id = DonorValidation.generateDonorID();
                        }
                    }
                }
            }
        }

        return new Donor (id, name, phoneNum, email, type, address, LocalDate.now());
    }
    
    public static boolean confirmExit() {
        char sure;

        do {
            DonorManagementHeader.exitHeader();
            System.out.print("Are you sure you want to exit? (y/n): ");

            sure = Character.toLowerCase(scan.next().charAt(0));
            scan.nextLine();

            switch (sure) {
                case 'y' -> {
                    return true;
                }
                case 'n' -> {
                    return false;
                }
                default -> {
                    Error.yesOrNo();
                }
            }
        } while (true);
    }
    
    public static void userDetail(Donor donor) {
        System.out.println(donor.toString());
        System.out.println(line);
    }    
    
    public static void backKey(){
        System.out.println("Enter \"0\" to go back\n");
    }
    
    public static char informationCorrect(Donor donor){
        DonorManagementHeader.confirmationHeader();
        userDetail(donor);
        exitKey();
        System.out.print("Is the information above correct?(y/n): ");
        char confirm = scan.next().charAt(0);
        scan.nextLine();
        confirm = Character.toLowerCase(confirm);
        
        return confirm;
    }
    
    public static int updateChoice(){
        System.out.println("============================================================");
        System.out.printf("%-4s %-19s %-15s %n","", " Choice", "Function");
        System.out.println("============================================================");
        System.out.println("\t1.\t\tName\t\t");
        System.out.println("\t2.\t\tPhone Number\t\t");
        System.out.println("\t3.\t\tEmail\t");
        System.out.println("\t4.\t\tType of donor\t");
        System.out.println("\t5.\t\tAddress\t");
        System.out.println("------------------------------------------------------------");
        exitKey();
        System.out.print("Enter your selection: ");
        int choice = scan.nextInt();
        scan.nextLine();
        
        return choice;
    }

    public static int inputUpdate(Donor donor) {
        int choice = 0;
        
        do {
            try {
                DonorManagementHeader.confirmationHeader();
                userDetail(donor);
                backKey();
                choice = updateChoice();
                break;
            } catch (InputMismatchException ex) {
                scan.nextLine();
                Error.integerOnly();
            }
        } while (true);
        
        return choice;
    }

    public static String updateName(Donor donor){
        DonorManagementHeader.confirmationHeader();
        userDetail(donor);
        backKey();
        
        return askName();
    }
    
    public static String updatePNum(Donor donor){
        DonorManagementHeader.confirmationHeader();
        userDetail(donor);
        backKey();
        
        return askPNum();
    }
    
    public static String updateEmail(Donor donor){
        DonorManagementHeader.confirmationHeader();
        userDetail(donor);
        backKey();
        
        return askEmail();
    }

    public static String updateType(Donor donor) {
        int select = -1;
        String type = "";
        
        do {
            do {
                try {
                    DonorManagementHeader.confirmationHeader();
                    userDetail(donor);
                    backKey();

                    select = askType();
                    break;
                } catch (InputMismatchException ex) {
                    scan.nextLine();
                    Error.integerOnly();
                }
            } while (true);

            type = typeSwitch(select);

        } while (!(select >= 0) && !(select <= 3));

        return type;
    }

    public static String updateAddress(Donor donor) {
        DonorManagementHeader.confirmationHeader();
        userDetail(donor);
        backKey();
        
        return askAddress();
    }
    
    public static String inputDelete(LinkedListInterface<Donor> donorList){
        DonorManagementHeader.deleteHeader();
        listUser.listUsers(donorList);
        System.out.print("Enter UserID: ");
        String input = scan.next();
        scan.nextLine();
        
        return input;
    }

    public static int inputFunction() {
        int select = -1;
        do {
            try {
                DonorManagementHeader.donorMangementHeader();
                System.out.println("============================================================");
                System.out.printf("%-4s %-19s %-15s %n","", " Choice", "Function");
                System.out.println("============================================================");
                System.out.println("\t1.\t\tAdd Donor\t\t");
                System.out.println("\t2.\t\tDelete Donor\t\t");
                System.out.println("\t3.\t\tList Donor\t");
                System.out.println("\t4.\t\tModify Donor\t");
                System.out.println("\t5.\t\tGenerate Report\t");
                System.out.println("\t6.\t\tGenerate Dummy Data\t");
                System.out.println("\t0.\t\tExit to Main Menu\t");
                System.out.println("------------------------------------------------------------");
                System.out.print("\nEnter your selection: ");
                select = scan.nextInt();
                scan.nextLine();
                break;
            } catch (InputMismatchException ex) {
                scan.nextLine();
                Error.integerOnly();
            }
        } while (true);

        return select;
    }

    public static String inputSearch(LinkedListInterface<Donor> donorList) {
        DonorManagementHeader.searchDonor();
        listUser.listUsers(donorList);
        System.out.print("Enter donor ID: ");
        String input = scan.next();
        scan.nextLine();

        return input;
    }

    public static void displayUser(Donor donor) {
        DonorManagementHeader.donorDetail();
        System.out.println(donor.toString());
        Success.userFound();
    }

    public static String inputModify(LinkedListInterface<Donor> donorList) {
        DonorManagementHeader.modifyHeader();
        listUser.listUsers(donorList);
        System.out.print("Enter UserID: ");
        String input = scan.next();
        scan.nextLine();

        return input;
    }

    public static int inputModifyChoice(Donor donor) {
        int choice = -1;

        do {
            try {
                DonorManagementHeader.modifyHeader();
                userDetail(donor);
                choice = updateChoice();
                break;
            } catch (InputMismatchException ex) {
                scan.nextLine();
                Error.integerOnly();
            }
        } while (true);

        return choice;
    }

    public static String modifyName(Donor donor) {
        DonorManagementHeader.modifyHeader();
        userDetail(donor);
        backKey();
        
        return askName();
    }

    public static String modifyPNum(Donor donor) {
        DonorManagementHeader.modifyHeader();
        userDetail(donor);
        backKey();

        return askPNum();
    }

    public static String modifyEmail(Donor donor) {
        DonorManagementHeader.modifyHeader();
        userDetail(donor);
        backKey();

        return askEmail();
    }

    public static String modifyType(Donor donor) {
        String type;
        int select = -1;
        do {
            do {
                try {
                    DonorManagementHeader.modifyHeader();
                    userDetail(donor);
                    backKey();
                    select = askType();
                    break;
                } catch (InputMismatchException ex) {
                    scan.nextLine();
                    Error.integerOnly();
                }
            } while (true);

            type = typeSwitch(select);
        } while (!(select >= 0) && !(select <= 3));
        
        return type;
    }

    public static String modifyAddress(Donor donor) {
        DonorManagementHeader.modifyHeader();
        userDetail(donor);
        backKey();

        return askAddress();
    }

    public static int inputReportChoice() {
        int userInput = -1;

        do {
            try {
                DonorManagementHeader.reportChoice();
                System.out.printf("%-4s %-19s %-15s %n", "", " Option", "Function");
                System.out.println("============================================================");
                System.out.println("\t1.\t\tMonthly report of types of donee\t\t");
                System.out.println("\t2.\t\tAnnual report of types of donee\t\t");
                System.out.println(line);
                System.out.println(">>>Enter \"0\" to exit\n");
                System.out.print("\nYour choice: ");
                userInput = scan.nextInt();
                scan.nextLine();
                break;
            } catch (InputMismatchException ex) {
                scan.nextLine();
                Error.integerOnly();
            }
        } while (true);

        return userInput;
    }

    public static int inputMonth() {
        DonorManagementHeader.reportSelectMonth();
        System.out.println("\t1.\t\tJanuary\t\t");
        System.out.println("\t2.\t\tFebruary\t\t");
        System.out.println("\t3.\t\tMarch\t\t");
        System.out.println("\t4.\t\tApril\t\t");
        System.out.println("\t5.\t\tMay\t\t");
        System.out.println("\t6.\t\tJune\t\t");
        System.out.println("\t7.\t\tJuly\t\t");
        System.out.println("\t8.\t\tAugust\t\t");
        System.out.println("\t9.\t\tSeptember\t\t");
        System.out.println("\t10.\t\tOctober\t\t");
        System.out.println("\t11.\t\tNovember\t\t");
        System.out.println("\t12.\t\tDecember\t\t");
        System.out.println(line);
        System.out.println("Enter \"0\" to go back\n");
        System.out.print("Your option: ");

        int monthOption = scan.nextInt();
        scan.nextLine();

        return monthOption;
    }

    public static void displayReport(String title, int privateCount, int publicCount, int governmentCount) {
        System.out.println("\n\n\t******************" + title + " Report of Types of Donor******************");
        System.out.print("Number of private-type donor\t\t: " + privateCount + "\n");
        System.out.print("Number of public-type donor\t\t: " + publicCount + "\n");
        System.out.print("Number of government-type donor\t\t: " + governmentCount + "\n");
        System.out.println("===============================================================================");
        System.out.print("Total registered donor for the month of " + title + "\t: " + (privateCount + publicCount + governmentCount));
        System.out.println("\n===============================================================================");
        System.out.println("\n\nPress any key to continue... ");
        scan.nextLine();
    }

    public static void displayAnnualReport(String title, int privateCount, int publicCount, int governmentCount) {
        System.out.println("\nTotal registered number of private-type donor\t\t: " + privateCount);
        System.out.println("\nTotal registered number of public-type donor\t\t: " + publicCount);
        System.out.println("\nTotal registered number of government-type donor\t\t: " + governmentCount);
        System.out.println("\n===============================================================================");
        System.out.println("Total registered donor of the year\t\t\t: " + (privateCount + publicCount + governmentCount));
        System.out.println("The month with most number of registered donor\t\t: " + title);
        System.out.println("===============================================================================");
        System.out.println("\n\nPress any key to continue... ");
        scan.nextLine();
    }
}
