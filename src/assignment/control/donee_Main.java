/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.control;

import assignment.entity.*;
import assignment.dao.*;
import assignment.utility.*;
import assignment.adt.*;
import assignment.boundary.*;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class donee_Main {
    

    private LinkedListInterface<Donee> doneeList = new LinkedList<>();
    private static String doneeID;
    private DoneeDAO dataFile = new DoneeDAO();
    private final String clearScreen = "\n".repeat(50);
    public static final Scanner scan = new Scanner(System.in);
    
    public void doneeMain(){
        donee_Main function = new donee_Main();
        boolean validInput = false;
        boolean exit = false;

        while(!exit){
            do{
                try {

                    header.doneeMainHeader();
                    String funcOption = doneeManagementUI.getUserChoice();

                    switch(funcOption){
                        case "1":
                            function.addDoneeDetails();
                            validInput = true;
                            break;
                        case "2":
                            function.removeDonee();
                            validInput = true;
                            break;
                        case "3":
                            function.updateDonee();
                            validInput = true;
                            break;
                        case "4":
                            function.viewDoneeList();
                            validInput = true;
                            break; 
                        case "5":
                            function.viewReport();
                            validInput = true;
                            break;   
                        case "6":
                            doneeList = dataFile.openFile();
                            DummyDonee.addDummydonee(doneeList);
                            break;
                        case "0":
                            validInput = true;
                            exit = true;
                            doneeManagementUI.returnMain();
                            break;
                        default:
                            errorMsg.ErrMsg("6");
                            break;
                    }

                } catch (Exception e) {
                    errorMsg.CatchErrMsg(e);
                }
            }while(validInput == false);
        }  
    }
    
    public void addDoneeDetails() {
        doneeList = dataFile.openFile();
        boolean validInput = false;
        boolean validContinue = false;
        String doneeType;
        Donee donee = null;

        header.addDoneeHeader();
        
        do {
            try {
                doneeType = doneeManagementUI.addGetType();

                switch(doneeType.toLowerCase()){
                    case "i":
                        validInput = true;
                        donee = doneeManagementUI.inputDoneeDetailI(doneeType);
                        break;
    
                    case "f":
                        validInput = true;
                        donee = doneeManagementUI.inputDoneeDetailF(doneeType);
                        break;
 
                    case "o":
                        validInput = true; 
                        donee = doneeManagementUI.inputDoneeDetailO(doneeType);
                        break;

                    default:
                        errorMsg.DoneeTypeErrMsg();
                        validInput = false;
                        break;
                }

                if (validInput==true && donee != null) {
                    doneeList.add(donee);

                    Donee detail = (Donee) doneeList.readForward(doneeList.getNumberOfEntries());
                    successfulMsg.addSuccessful();
                    doneeManagementUI.doneeDetail(detail);

                    validContinue = doneeManagementUI.contAdd(doneeList, dataFile);

                    if (!validContinue) {
                        break;
                    } else {
                        validInput = false;
                    }

                    doneeList.sort(new doneeComparator());
                    dataFile.writeFile(doneeList);
                }
    
            } catch (Exception e) {
                errorMsg.CatchErrMsg(e);
            }
        } while (validInput == false);   
    }

    public void removeDonee() {
        doneeList = dataFile.openFile();
        int dataEntry = doneeList.getNumberOfEntries();
        String filterChoice;
        boolean validFilter = false;
        boolean validInput = false;
        boolean validContinue = false;
        boolean validRemoveOption = false;
        boolean doneeIDFound = false;
        boolean doneeHPFound = false;


        do { 
            header.doneeListHeader();
            doneeManagementUI.printList();
            
            doneeManagementUI.applyFilter();

            do {    
                filterChoice = doneeManagementUI.getUserChoice();

                if(filterChoice.equalsIgnoreCase("0")){
                    validFilter= false;
                    break;
                }
                else if(filterChoice.equalsIgnoreCase("1")){
                    validFilter = true;
                    break;
                }else if(filterChoice.equalsIgnoreCase("2")){
                    validFilter = false;
                    break;
                }else{
                    errorMsg.YesNoErrMsg();
                    validFilter = false;
                }
            } while (validFilter == false && !filterChoice.equalsIgnoreCase("0")&& !filterChoice.equalsIgnoreCase("2"));
             
            if(validFilter == true){
                listUser();
            }else if(validFilter == false && filterChoice.equalsIgnoreCase("0")){
                return;
            }

            header.removeDoneeHeader();
            
            try {
                do{
                    String userInput = doneeManagementUI.getUserChoice();

                    switch (userInput){
                        case "1":
                            validInput = true;
                            String inputID = doneeManagementUI.inputDoneeID();                           
                            
                            for (int i=1; i <= dataEntry; i++) {
                                Donee donee = (Donee) doneeList.readForward(i);
                                String ID = donee.getDoneeID();

                                if (inputID.equalsIgnoreCase(ID)) {
                                    doneeList.delete(i);
                                    dataFile.writeFile(doneeList);
                                    doneeManagementUI.confirmKey();
                                    doneeIDFound = true;
                                    break;
                                }

                            }
                            
                            if (doneeIDFound==false) {
                                errorMsg.enterAgainErrMsg("Donee not found!");
                                validInput = false;
                            }
                            break;

                        case "2":
                            validInput = true;
                            String inputHpNum = doneeManagementUI.inputDoneePH();
                            
                            for (int i =1; i <= dataEntry; i++) {
                                Donee donee = (Donee) doneeList.readForward(i);
                                String hpNum = donee.getPhoneNumber();

                                if (inputHpNum.equalsIgnoreCase(hpNum)) {
                                    doneeList.delete(i);
                                    dataFile.writeFile(doneeList);
                                    doneeManagementUI.confirmKey();
                                    doneeHPFound = true;
                                    break;

                                }

                            }
 
                            if (doneeHPFound == false) {
                                errorMsg.enterAgainErrMsg("Donee not found!");
                                validInput = false;
                            }
                            break;

                        case "0":
                            return;

                        default: 
                            errorMsg.ErrMsg("2");
                            validInput = false;
                            break; 
                    }

                }while(validInput == false);

            } catch (Exception e) {
                errorMsg.CatchErrMsg(e);
            }
            //-------------------------------------------------------------
            header.doneeListHeader();
            doneeManagementUI.printList();
            validContinue = doneeManagementUI.contRemove();
            if(validContinue == true){
                validRemoveOption = true;
            }else{
                return;
            } 
            
        } while (validRemoveOption == true);
    }
    
    public void updateDonee() {
        doneeList = dataFile.openFile();
        int dataEntry = doneeList.getNumberOfEntries();
        String filterChoice;
        boolean validFilter = false;
        boolean validChoice = false;
        boolean idFound = false;
        boolean phNumFound = false;
        boolean continueUpdate = false;
        Donee doneeToUpdate = null;
        int currentPosition;
        
        try {
            do {
                currentPosition = 1;
                header.doneeListHeader();
                
                doneeManagementUI.printList();
                doneeManagementUI.applyFilter();
                
                do {    
                    filterChoice = doneeManagementUI.getUserChoice();

                    if(filterChoice.equalsIgnoreCase("0")){
                        validFilter= false;
                        break;
                    }
                    else if(filterChoice.equalsIgnoreCase("1")){
                        validFilter = true;
                        break;
                    }else if(filterChoice.equalsIgnoreCase("2")){
                        validFilter = false;
                        break;
                    }else{
                        errorMsg.YesNoErrMsg();
                        validFilter = false;
                    }
                } while (validFilter == false && !filterChoice.equalsIgnoreCase("0")&& !filterChoice.equalsIgnoreCase("2"));

                if(validFilter == true){
                    listUser();
                }else if(validFilter == false && filterChoice.equalsIgnoreCase("0")){
                    return;
                }

                header.updateDoneeHeader();

                try {
                    do {
                        String userChoice = doneeManagementUI.getUserChoice();

                        switch (userChoice) {
                            case "1":
                                validChoice = true;
                                String updtDoneeID = doneeManagementUI.inputDoneeID();
                                for (int x = 1; x <= dataEntry; x++) {
                                    Donee donee = (Donee) doneeList.readForward(x);

                                    String inputID = donee.getDoneeID();

                                    if (inputID.equalsIgnoreCase(updtDoneeID)) {
                                        
                                        header.Header("Donee Information");
                                        doneeManagementUI.doneeDetail(donee);
                                        doneeToUpdate = donee;
                                        break;
                                    }
                                    currentPosition++;
                                }

                                if (doneeToUpdate != null) {
                                    idFound = true;
                                    continueUpdate = doneeManagementUI.updateDoneeDetails(doneeToUpdate, scan);
                                } else {
                                    errorMsg.enterAgainErrMsg("Donee not found!");
                                    validChoice = false;
                                }
                                break;

                            case "2":
                                validChoice = true;
                                String updtDoneeHP = doneeManagementUI.inputDoneePH();
                                
                                for (int x = 1; x <= dataEntry; x++) {
                                    Donee donee = (Donee) doneeList.readForward(x);

                                    String inputphNum = donee.getPhoneNumber();

                                    if (inputphNum.equalsIgnoreCase(updtDoneeHP)) {
                                        header.Header("Donee Information");
                                        doneeManagementUI.doneeDetail(donee);
                                        doneeToUpdate = donee;
                                        break;
                                    }
                                }

                                if (doneeToUpdate != null) {
                                    phNumFound = true;
                                    continueUpdate = doneeManagementUI.updateDoneeDetails(doneeToUpdate, scan);
                                } else {
                                    errorMsg.enterAgainErrMsg("Donee not found!");
                                    validChoice = false;
                                }
                                break;

                            case "0":
                                return;

                            default:
                                errorMsg.ErrMsg("2");
                                break;
                        }

                        if(continueUpdate == true){
                            break;
                        }

                    } while (!validChoice);

                } catch (Exception e) {
//                    errorMsg.CatchErrMsg(e);
                      System.err.println("1");
                }
                doneeList.replace(currentPosition, doneeToUpdate);
                dataFile.writeFile(doneeList);

            } while (continueUpdate == true);
        } catch (Exception e) {
//            errorMsg.CatchErrMsg(e);
               System.err.println("2");
        }
    
    }
       
    public void viewDoneeList() {
        doneeList = dataFile.openFile();
        String filterChoice;
        boolean validFilter = false;
        header.doneeListHeader();
        doneeManagementUI.printList();

        doneeManagementUI.applyFilter();
                
        do {    
            filterChoice = doneeManagementUI.getUserChoice();

            if(filterChoice.equalsIgnoreCase("0")){
                validFilter= false;
                break;
            }
            else if(filterChoice.equalsIgnoreCase("1")){
                validFilter = true;
                break;
            }else if(filterChoice.equalsIgnoreCase("2")){
                validFilter = false;
                break;
            }else{
                errorMsg.YesNoErrMsg();
                validFilter = false;
            }
        } while (validFilter == false && !filterChoice.equalsIgnoreCase("0")&& !filterChoice.equalsIgnoreCase("2"));

        if(validFilter == true){
            listUser();
        }else if(validFilter == false && filterChoice.equalsIgnoreCase("0")){
            return;
        }
        doneeManagementUI.returnMain();
    } 
    
    public void viewReport(){
        doneeList = dataFile.openFile();
        int dataEntry = doneeList.getNumberOfEntries();
        String title = "",monthOption = "";
        String symbol = "*";
        boolean validInput = false;
        boolean viewMore = false;
        boolean validMonth = false;
        int indCount = 0, famCount = 0, orgCount = 0;
        int[] monthlyCounts = new int[12];
        int maxEntry = 0;


        try {
            do {

                header.reportHeader1();
                do {
                    String userInput = doneeManagementUI.getUserChoice();
                    indCount = 0;
                    famCount = 0;
                    orgCount = 0;
                    maxEntry = 0;

                    switch(userInput){
                        case "1":
                            validInput = true;
                            
                            header.reportHeader2();
                            do {
                                monthOption = doneeManagementUI.monthGetInput();
                                title = doneeManagementUI.getMonthTitle(monthOption);
                                validMonth = !title.isEmpty();

                                if (!validMonth && !monthOption.equals("00")) {
                                    errorMsg.reportErrMsg();
                                }

                            } while (!validMonth);

                            if (monthOption.equals("00")) {
                                return;
                            }

                            int selectedMonthIndex = Integer.parseInt(monthOption) - 1;

                            for (int i = 1; i <= dataEntry; i++) {
                                Donee donee = (Donee) doneeList.readForward(i);
                                LocalDate registerDate = donee.getRegisterDate();
                                int registeredMonth = registerDate.getMonthValue() - 1;

                                if (selectedMonthIndex == registeredMonth) {
                                    if (donee.getDoneeType().equalsIgnoreCase("i")) {
                                        indCount++;
                                    } else if (donee.getDoneeType().equalsIgnoreCase("f")) {
                                        famCount++;
                                    } else if (donee.getDoneeType().equalsIgnoreCase("o")) {
                                        orgCount++;
                                    }
                                }
                                monthlyCounts[registeredMonth]++;
                            }
                            doneeManagementUI.displayMonthlyReport(title, indCount, famCount, orgCount, symbol);
                            
                            viewMore = true;
                            break;
                            
                        case "2":
                            validInput = true;
                            String[] monthNames = {"January", "February", "March", "April", "May", "June", 
                                                    "July", "August", "September", "October", "November", "December"};
                            
                            for (int i = 1; i <= dataEntry; i++) {
                                Donee donee = (Donee) doneeList.readForward(i);
                                LocalDate registerDate = donee.getRegisterDate();
                                int registeredMonth = registerDate.getMonthValue() - 1; 

                                if (donee.getDoneeType().equalsIgnoreCase("i")) {
                                    indCount++;
                                } else if (donee.getDoneeType().equalsIgnoreCase("f")) {
                                    famCount++;
                                } else if (donee.getDoneeType().equalsIgnoreCase("o")) {
                                    orgCount++;
                                }
                                monthlyCounts[registeredMonth]++;
                            }

                            for (int i = 0; i < monthlyCounts.length; i++) {
                                if (monthlyCounts[i] > monthlyCounts[maxEntry]) {
                                    maxEntry = i;
                                }
                            }

                            title = monthNames[maxEntry];
                            doneeManagementUI.displayAnnualReport(indCount, famCount, orgCount, title);
                            viewMore = true;
                            break;

                        case "0":
                            validInput = true;
                            viewMore = false;
                            break;

                        default:
                            validInput =false;
                            errorMsg.ErrMsg("2");
                            break;   
                    }
                } while (validInput == false);  
            } while (viewMore == true);
            
        }catch (NumberFormatException e) {
//            errorMsg.CatchErrMsg(e);
        } 
    }
 
    public void listUser(){
        doneeList = dataFile.openFile();
        boolean cond = false;
        int iterator = 1;
        int dataEntry = doneeList.getNumberOfEntries();
        boolean filterCond = false;
        boolean indInfo = false;
        boolean famInfo = false;
        boolean orgInfo = false;

        header.filterHeader();
        
        do {
            do {                
                String choice = doneeManagementUI.getUserChoice();

                switch (choice) {

                    case "1" :
                        cond = false;
                        if (indInfo) {
                            indInfo = false;
                        } else {
                            indInfo = true;
                        }
                        break;
                    case "2" :
                        cond = false;
                        if (famInfo) {
                            famInfo = false;
                        } else {
                            famInfo = true;
                        }
                        break;
                    case "3" :
                        cond = false;
                        if (orgInfo) {
                            orgInfo = false;
                        } else {
                            orgInfo = true;
                        }
                        break;
                    
                    case "0" :
                        return;    
                    default:
                        errorMsg.ErrMsg("3");
                        cond = true;
                        break;
                }

                if (!indInfo || !famInfo || !orgInfo) {
                    filterCond = true;
                } else {
                    filterCond = false;
                }
            } while (cond == true);

            header.doneeListHeader();

            if (!filterCond) {
               doneeManagementUI.printList();
            } else if (filterCond) {
                for (; iterator <= dataEntry; iterator++) {
                    Donee testing = (Donee) doneeList.readForward(iterator);

                    if (!indInfo && testing.getDoneeType().equals("i")) {
                        continue;
                    } else if (!famInfo && testing.getDoneeType().equals("f")) {
                        continue;
                    } else if (!orgInfo && testing.getDoneeType().equals("o")) {
                        continue;
                    }

                    System.out.printf("%-10s %-35s %-15s %-20s %n", testing.getDoneeID(), testing.getDoneeName(), testing.getDoneeType(), testing.getPhoneNumber());
                }
            }  
        }while (cond == true);

    }
}
