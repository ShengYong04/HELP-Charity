/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.boundary;

import assignment.dao.*;
import assignment.adt.*;
import java.time.LocalDate;
import java.util.Scanner;
import assignment.utility.*;
import assignment.entity.*;

/**
 *
 * @author User
 */
public class doneeManagementUI {
    public static final Scanner scan = new Scanner(System.in);
    private static final DoneeDAO dataFile = new DoneeDAO();
    private static final String clearScreen = "\n".repeat(50);
    
    private static LinkedListInterface<Donee> doneeList = new LinkedList<>();
    
    public static String getUserChoice(){
        String userChoice;
        System.out.print("\nYour choice: ");
        userChoice = scan.nextLine().trim();
        return userChoice;
    }
    
    public static String addGetType(){
        System.out.print("Enter the donee type(I,F,O): ");
        String doneeType = scan.nextLine().trim();
        return doneeType;
    }
    
    public static String addIndName(){
        String doneeName;
        
        System.out.println("Donee Type: Individual");

        do {                            
            System.out.print("Beneficiary name: ");
            doneeName = scan.nextLine().trim(); 
        } while (!validation.validateName(doneeName));
        return doneeName;  
    }
    
    public static String addPhoneNum(){
        String phoneNumber;
         do {                            
            System.out.print("Contact number: ");
            phoneNumber = scan.nextLine().trim(); 
        } while (!validation.validatephoneNumber(phoneNumber));
         return phoneNumber;
    }
    
    public static String addEmail(){
        String email;
        do {                            
            System.out.print("Email address: ");
            email = scan.nextLine().trim();
        } while (!validation.validateEmail(email));
        return email;
    }
    
    public static String addAddress(){
        String address;
        do {                            
            System.out.print("Address: ");
            address = scan.nextLine().trim();
        } while (!validation.validateAddress(address));
        return address;
    }
    
    public static int addIndAge(){
        int age;
        do {                            
            System.out.print("Age: ");
            age = scan.nextInt(); 
        } while (!validation.validateAge(age));
        scan.nextLine();
        return age;
    }
    
    public static char addIndGender(){
        char gender;
        do {                            
            System.out.print("Gender (F/M): ");
            gender = scan.next().charAt(0); 
        } while (!validation.validateGender(gender));
        return gender;
    }
    
    public static Donee inputDoneeDetailI(String doneeType){
        String doneeName,phoneNumber,email,address;
        char gender;
        int age;
        
        doneeName = addIndName();
        gender = addIndGender();
        age = addIndAge();
        phoneNumber = addPhoneNum();
        email = addEmail();
        address = addAddress();
        
        individual ind = new individual(age, gender);
        return new Donee(doneeName,phoneNumber, email, address, validation.generateDoneeID(), doneeType,LocalDate.now(), ind);
    }
    
    public static String addFamName(){
        String doneeName;
        System.out.println("Donee Type: Family");
        do {                            
            System.out.print("Primary beneficiary name: ");
            doneeName = scan.nextLine().trim();
        } while (!validation.validateName(doneeName));
        return doneeName;
    }
    
    public static char addFamGender(){
        char gender;
        do {                            
            System.out.print("Primary beneficiary's gender (F/M): ");
            gender = scan.next().charAt(0);
        } while (!validation.validateGender(gender));
        return gender;
    }
    
    public static int addFamAge(){
        int age;
        do {                            
            System.out.print("Primary beneficiary's age: ");
            age = scan.nextInt();
        } while (!validation.validateAge(age));
        scan.nextLine();
        return age;
    }
    
    public static int addFamPax(){
        int noPax;
        
        do {                            
            System.out.print("No of pax: ");
            noPax = scan.nextInt();
        } while (!validation.validatenoPax(noPax));
        scan.nextLine();
        return noPax;
    }
    
    public static Donee inputDoneeDetailF(String doneeType){
        String doneeName,phoneNumber,email,address;
        char gender;
        int age,noPax;
        
        doneeName = addFamName();
        gender = addFamGender();
        age = addFamAge();
        phoneNumber = addPhoneNum();
        email = addEmail();
        address = addAddress();
        noPax = addFamPax();
        
        family fam = new family(noPax,age, gender);
        
        return new Donee(doneeName,phoneNumber, email, address, validation.generateDoneeID(), doneeType,LocalDate.now(), fam);
    }
    
    public static String addOrgName(){
        String orgName;
        System.out.print("Donee Type: Organization");
        do {                            
            System.out.print("\nBeneficiary organization name: ");
            orgName = scan.nextLine().trim();
        } while (!validation.validateorgName(orgName));
        return orgName;
    }
    
    public static String addOrgDonName(){
        String doneeName;
        do {                            
            System.out.print("Organizational representative name: ");
            doneeName = scan.nextLine().trim();
        } while (!validation.validateName(doneeName));
        return doneeName;
    }
    
    public static String addOrgPhone(){
        String phoneNumber;
        do {                            
            System.out.print("Organization contact number: ");
            phoneNumber = scan.nextLine().trim();   
        } while (!validation.validatephoneNumber(phoneNumber));
        return phoneNumber;
    }
    
    public static String addOrgEmail(){
        String email;
        do {                            
            System.out.print("Organization email address: ");
            email = scan.nextLine().trim();
        } while (!validation.validateEmail(email));
        return email;
    }
    
    public static String addOrgAddress(){
        String address;
        do {                            
            System.out.print("Organization address: ");
            address = scan.nextLine().trim();   
        } while (!validation.validateAddress(address));
        return address;
    }
    
    public static Donee inputDoneeDetailO(String doneeType){
        String orgName,doneeName,phoneNumber,email,address;
        
        orgName = addOrgName();
        doneeName = addOrgDonName();
        phoneNumber = addPhoneNum();
        email = addEmail();
        address = addAddress();
        
        organization org = new organization(orgName);
        return new Donee(doneeName,phoneNumber, email, address, validation.generateDoneeID(), doneeType,LocalDate.now(), org); 
    }
            
    public static boolean contAdd(LinkedListInterface<Donee> doneeList, DoneeDAO dataFile) {
        boolean validContinue = false;
        String continueAdd;

        do {
            System.out.print("\n\nDo you wish to continue adding new donee? (y/n): ");
            continueAdd = scan.nextLine().trim();
            if (continueAdd.equalsIgnoreCase("y")) {
                header.Header("Continue adding a new donee");
                validContinue = true;
            } else if (continueAdd.equalsIgnoreCase("n")) {
                doneeList.sort(new doneeComparator());
                dataFile.writeFile(doneeList);
                System.out.println("Press any key to continue...");
                scan.nextLine();
                validContinue = false;
            } else {
                errorMsg.YesNoErrMsg();
                validContinue = false;
            }
        } while (!validContinue && !continueAdd.equalsIgnoreCase("n"));

        return validContinue;
    }
    
    public static void applyFilter(){
        System.out.print("\nEnter \"0\" to exit ");
        System.out.print("\nEnter \"1\" to apply filter ");
        System.out.print("\nEnter \"2\" to continue next action without filter\n ");
    }
        
    public static String inputDoneeID(){        
        System.out.print("Enter the donee ID: ");
        String inputID = scan.nextLine().trim();
        return inputID;
    }
    
    public static void confirmKey(){
        System.out.println("Press enter to confirm...");
        scan.nextLine();
    }
    
    public static String inputDoneePH(){
        System.out.print("Enter the contact number: ");
        String inputHpNum = scan.nextLine().trim();
        return inputHpNum;   
    }
                           
    public static boolean contRemove(){
        boolean validContinue = false;
        String continueInput;
        do {
            successfulMsg.deleteSuccessful();
            System.out.print("\nDo you want to remove other donee?(y/n): ");
            continueInput = scan.nextLine().trim();


            if(continueInput.equalsIgnoreCase("y")){
                validContinue = true;
                System.out.println("\n**********Proceed to continue remove donee**********");
                System.out.println("\npress any key to continue...");
                scan.nextLine();

            }else if(continueInput.equalsIgnoreCase("n")){
                System.out.println("Press any key to continue... ");
                scan.nextLine();

            }else{
                validContinue = false;
                errorMsg.YesNoErrMsg();
            }
        } while (!validContinue && !continueInput.equalsIgnoreCase("n"));
        return validContinue;
    }
                
    public static boolean updateDoneeDetails(Donee doneeToUpdate, Scanner scan) {
        boolean validUpdateOption = false;
        boolean continueUpdate = false;
        boolean validContinue = false;
        String updateOrgName;
        char updateGender;
        int updateAge, updateNoPax;

        if (doneeToUpdate != null) {
            do {
                if (doneeToUpdate.getDoneeType().equals("i")) {

                    header.updateHeader1();
                    do {                        
                        System.out.print("\nYour option: ");
                        String updateOption = scan.nextLine().trim();
                        

                        if (updateOption.equalsIgnoreCase("5")) {
                            validUpdateOption = true;
                            System.out.println("\n********Update Donee Gender********");
                            do {
                                System.out.print("Enter new donee gender: ");
                                updateGender = scan.next().charAt(0);
                            } while (!validation.validateGender(updateGender));

                            ((individual) doneeToUpdate.getInfo()).setGender(updateGender);
                            successfulMsg.updateSuccessful("Gender");

                        } else if (updateOption.equalsIgnoreCase("6")) {
                            validUpdateOption = true;
                            System.out.println("\n********Update Donee Age********");
                            do {
                                System.out.print("Enter new donee age: ");
                                updateAge = scan.nextInt();
                                
                                scan.nextLine();
                            } while (!validation.validateAge(updateAge));
                            ((individual) doneeToUpdate.getInfo()).setAge(updateAge);
                            successfulMsg.updateSuccessful("Age");

                        } else if (updateOption.equalsIgnoreCase("0")) {
                            validUpdateOption = true;
                            continueUpdate = true;
                            break;
                        }else{

                            if (!updateCommonInfo(updateOption, doneeToUpdate)) {
                                errorMsg.ErrMsg("6");
                            } else {
                                validUpdateOption = true;
                            }
                        }
                    } while (validUpdateOption == false);
                    

                } else if (doneeToUpdate.getDoneeType().equals("f")) {

                    header.updateHeader2();
                    do {                        
                        System.out.print("\nYour option: ");
                        String updateOption = scan.nextLine().trim();

                        if (updateOption.equalsIgnoreCase("5")) {
                            validUpdateOption = true;
                            System.out.println("\n********Update Donee Gender********");
                            do {
                                System.out.print("Enter new donee gender: ");
                                updateGender = scan.next().charAt(0);
                            } while (!validation.validateGender(updateGender));
                            ((family) doneeToUpdate.getInfo()).setGender(updateGender);
                            successfulMsg.updateSuccessful("Gender");

                        } else if (updateOption.equalsIgnoreCase("6")) {
                            validUpdateOption = true;
                            System.out.println("\n********Update Donee Age********");
                            do {
                                System.out.print("Enter new donee age: ");
                                updateAge = scan.nextInt();
                                scan.nextLine();
                                
                            } while (!validation.validateAge(updateAge));
                            ((family) doneeToUpdate.getInfo()).setAge(updateAge);
                            successfulMsg.updateSuccessful("Age");

                        } else if (updateOption.equalsIgnoreCase("7")) {
                            validUpdateOption = true;
                            System.out.println("\n********Update Donee No of Pax********");
                            do {
                                System.out.print("Enter new no of pax: ");
                                updateNoPax = scan.nextInt();
                                scan.nextLine();
                            } while (!validation.validatenoPax(updateNoPax));
                            ((family) doneeToUpdate.getInfo()).setNoPax(updateNoPax);
                            successfulMsg.updateSuccessful("No of Pax");

                        } else if (updateOption.equalsIgnoreCase("0")) {
                            validUpdateOption = true;
                            continueUpdate = true;
                            break;
                        }else{
                            if (!updateCommonInfo(updateOption, doneeToUpdate)) {
                                errorMsg.ErrMsg("Invalid option.");
                            } else {
                                validUpdateOption = true;
                            }
                            
                        }
                    } while (validUpdateOption == false);
                    
                } else {
                    header.updateHeader3();
                    do {                        
                        System.out.print("\nYour option: ");
                        String updateOption = scan.nextLine().trim();

                        

                        if (updateOption.equalsIgnoreCase("5")) {
                            validUpdateOption = true;
                            System.out.println("\n********Update Organization Name********");
                            do {
                                System.out.print("Enter new organization name: ");
                                updateOrgName = scan.nextLine().trim();
                            } while (!validation.validateorgName(updateOrgName));
                            ((organization) doneeToUpdate.getInfo()).setOrgName(updateOrgName);
                            successfulMsg.updateSuccessful("Organization Name");

                        } else if (updateOption.equalsIgnoreCase("0")) {
                            validUpdateOption = true;
                            continueUpdate = true;
                            break;
                        }else{
                            
                            if (!updateCommonInfo(updateOption, doneeToUpdate)) {
                                errorMsg.ErrMsg("Invalid option.");
                            } else {
                                validUpdateOption = true;
                            }
                            
                        }
                    } while (validUpdateOption ==false);
                }

                do {
                    header.Header("Updated Information");
                    System.out.println(doneeToUpdate.toString());
                    System.out.print("\nAny other information to be updated for this donee?(y/n): ");
                    String continueInput = scan.nextLine().trim();

                    if (continueInput.equalsIgnoreCase("y")) {
                        validContinue = true;
                        System.out.println("Update continued, press any key to continue...");
                        validUpdateOption = false;
                        scan.nextLine();

                    } else if (continueInput.equalsIgnoreCase("n")) {
                        validUpdateOption = true;
                        continueUpdate = true;
                        System.out.println("press Enter to confirm...");
                        scan.nextLine();
                        break;
                    } else {
                        validContinue = false;
                        errorMsg.YesNoErrMsg();
                    }
 
                } while (!validContinue);
                
                if (continueUpdate == true){
                        break;
                }
            } while (!validUpdateOption);
        }
        return continueUpdate;
    }
        
    public static boolean updateCommonInfo(String updateOption, Donee doneeToUpdate) {
        boolean updateSuccessful = false;
        String updateName, updatephNumber, updateEmail, updateAddress;

        switch(updateOption) {
            case "1":
                System.out.println("\n********Update Donee Name********");
                do {                    
                    System.out.print("Enter new donee name: ");
                    updateName = scan.nextLine().trim();
                } while (!validation.validateName(updateName));

                doneeToUpdate.setDoneeName(updateName);
                successfulMsg.updateSuccessful("Name");
                updateSuccessful = true;
                break;

            case "2":
                System.out.println("\n********Update Donee Phone Number********");
                do {                    
                    System.out.print("Enter new donee phone number: ");
                    updatephNumber = scan.nextLine().trim();
                } while (!validation.validatephoneNumber(updatephNumber));

                doneeToUpdate.setPhoneNumber(updatephNumber);
                successfulMsg.updateSuccessful("Phone Number");
                updateSuccessful = true;
                break;

            case "3":
                System.out.println("\n********Update Donee Email********");
                do {                    
                    System.out.print("Enter new donee email: ");
                    updateEmail = scan.nextLine().trim();
                } while (!validation.validateEmail(updateEmail));

                doneeToUpdate.setEmail(updateEmail);
                successfulMsg.updateSuccessful("Email");
                updateSuccessful = true;
                break;

            case "4":
                System.out.println("\n********Update Donee Address********");
                do {                    
                    System.out.print("Enter new donee address: ");
                    updateAddress = scan.nextLine().trim();
                } while (!validation.validateAddress(updateAddress));

                doneeToUpdate.setAddress(updateAddress);
                successfulMsg.updateSuccessful("Address");
                updateSuccessful = true;
                break;

            default:
                updateSuccessful = false;
                break;
        }
        return updateSuccessful;
    }
    
    public static void returnMain(){
        System.out.println("Enter to return to main page...");
        scan.nextLine();
    }
    
    public static String monthGetInput(){
        System.out.print("\nYour option (00 - 12): ");
        String monthOption = scan.nextLine().trim();
        return monthOption;
    }
    
    public static String getMonthTitle(String monthOption) {
        switch (monthOption) {
            case "01":
                return "January";
            case "02":
                return "February";
            case "03":
                return "March";
            case "04":
                return "April";
            case "05":
                return "May";
            case "06":
                return "June";
            case "07":
                return "July";
            case "08":
                return "August";
            case "09":
                return "September";
            case "10":
                return "October";
            case "11":
                return "November";
            case "12":
                return "December";
            default:
                return "";
        }
    }

    public static void displayMonthlyReport(String title, int indCount, int famCount, int orgCount, String symbol) {
        System.out.println("\n\n\t******************" + title + " Report of Types of Donee******************");
        System.out.println("One \"*\" symbolizing one donee\n");
        System.out.print("Number of individual-type donee\t\t: ");
        for (int i = 0; i < indCount; i++) {
            System.out.print(symbol + " ");
        }
        System.out.println("\n");
        System.out.print("Number of family-type donee\t\t: ");
        for (int i = 0; i < famCount; i++) {
            System.out.print(symbol + " ");
        }
        System.out.println("\n");
        System.out.print("Number of organizational-type donee\t: ");
        for (int i = 0; i < orgCount; i++) {
            System.out.print(symbol + " ");
        }
        System.out.println("\n");
        System.out.println("===============================================================================");
        System.out.print("Total registered donee for the month of " + title + "\t: " + (indCount + famCount + orgCount));
        System.out.println("\n===============================================================================");
        System.out.println("\n\nPress any key to continue... ");
        scan.nextLine();
    }

    public static void displayAnnualReport(int indCount, int famCount, int orgCount, String title) {
        System.out.println("\n\n\n****************Annual Report of Types of Donee****************");
        System.out.println("\nTotal registered number of individual-type donee\t\t: " + indCount);
        System.out.println("\nTotal registered number of family-type donee\t\t: " + famCount);
        System.out.println("\nTotal registered number of organization-type donee\t: " + orgCount);
        System.out.println("\n===============================================================================");
        System.out.println("Total registered donee of the year\t\t\t: " + (indCount + famCount + orgCount));
        System.out.println("The month with most number of registered donee\t\t: " + title);
        System.out.println("===============================================================================");
        System.out.println("\n\nPress any key to continue... ");
        scan.nextLine();
    }
    
    public static void printList(){
        doneeList = dataFile.openFile();
        int dataEntry = doneeList.getNumberOfEntries();
        for (int i=1 ; i <= dataEntry; i++) {
            Donee donee = (Donee)doneeList.readForward(i);
            System.out.printf("%-10s %-35s %-15s %-20s %n",donee.getDoneeID(), donee.getDoneeName() , donee.getDoneeType(), donee.getPhoneNumber());
        }
        System.out.println("--------------------------------------------------------------------------------------------------");
    }
    
    public static void doneeDetail(Donee donee){
        System.out.println(donee.toString());
    }
}
