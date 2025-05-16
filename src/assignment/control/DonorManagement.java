// Name: Lim Wee Yang (2307596)
// Program: RSW2S1G2

package assignment.control;

import assignment.entity.*;
import assignment.dao.*;
import assignment.utility.*;
import assignment.utility.Error;
import assignment.adt.*;
import assignment.boundary.*;
import java.time.LocalDate;

public class DonorManagement {
    private LinkedListInterface<Donor> donorList = new LinkedList<>();

    public void addDonor() {
        donorList = DonorDAO.readFile();
        
        do {
            Donor donor = DonorManagementUI.inputDonorDetail();
            
            if (donor.getId() == null){
                break;
            }

            char comfirm;

            OUTER:
            do {
                comfirm = DonorManagementUI.informationCorrect(donor);

                switch (comfirm) {
                    case '0' -> {
                        if (DonorManagementUI.confirmExit()){
                            break OUTER;
                        }
                    }
                    
                    case 'y' -> {
                        donorList.add(donor);
                        donorList.sort(new donorComparator());
                        DonorDAO.saveFile(donorList);
                        Success.registerSuccess();
                        break OUTER;
                    }
                    case 'n' -> {

                        int choice = DonorManagementUI.inputUpdate(donor);

                        switch (choice) {
                            case 0 -> {

                            }

                            case 1 -> {
                                String name;
                                
                                do {
                                    name = DonorManagementUI.updateName(donor);

                                    if (name.equals("0")) {
                                        break;
                                    }

                                } while (!DonorValidation.validateName(name));
                          
                                if (!name.equals("0")) {
                                    donor.setName(name);
                                }
                            }

                            case 2 -> {
                                String phoneNum;

                                do {
                                    phoneNum = DonorManagementUI.updatePNum(donor);
                                
                                    if (phoneNum.equals("0")) {
                                        break;
                                    }

                                } while (!DonorValidation.validatePhoneNumber(phoneNum));
                           
                                if (!phoneNum.equals("0")) {
                                    donor.setPhoneNum(phoneNum);
                                }
                            }

                            case 3 -> {
                                String email;

                                do {
                                    email = DonorManagementUI.updateEmail(donor);
                                    
                                    if (email.equals("0")) {
                                        break;
                                    }

                                } while (!DonorValidation.validateEmail(email));
                                
                                if (!email.equals("0")) {
                                    donor.setEmail(email);
                                }   
                            }

                            case 4 -> {
                                String type = DonorManagementUI.updateType(donor);

                                if (!type.equals("0")) {
                                    donor.setType(type);
                                }
                            }

                            case 5 -> {
                                String address;

                                do {
                                    address = DonorManagementUI.updateAddress(donor);

                                    if (address.equals("0")) {
                                        break;
                                    }

                                }while(!DonorValidation.validateAddress(address));
                                
                                if (!address.equals("0")) {
                                    donor.setAddress(address);
                                } 
                            }

                            default -> {
                                Error.invalidChoice(5);
                            }
                        }
                    }
                    default -> {
                        Error.yesOrNo();
                    }
                }
            } while (true);
        } while (true);
    }
    
    public void delDonor() {
        donorList = DonorDAO.readFile();
        
        String input;
        boolean found;
        int numOfEntries = donorList.getNumberOfEntries();
       
        listUser.setListValue(donorList);

        OUTER:
        do {
            found = false;
            input = DonorManagementUI.inputDelete(donorList);

            switch (input) {
                case "0" -> {
                    listUser.clear();
                    break OUTER;
                }

                case "1" -> {
                    listUser.previousPage();
                }

                case "2" -> {
                    listUser.nextPage();
                }
                
                case "3" -> {
                    listUser.filter();
                }

                default -> {
                    listUser.revertNum();
                    for (int i = 1; i <= numOfEntries; i++) {
                        Donor donor = (Donor) donorList.readForward(i);
                        String id = donor.getId();

                        if (input.equals(id)) {
                            donorList.delete(i);
                            DonorDAO.saveFile(donorList);
                            Success.deleteSuccess();
                            found = true;
                            break;
                        }
                    }

                    if (found == false) {
                        Error.userNotFound(input);
                    }
                }
            }
        } while (true);
    }

    public void listDonor() {
        donorList = DonorDAO.readFile();

        int numOfEntries = donorList.getNumberOfEntries();

        listUser.setListValue(donorList);

        OUTER:
        do {
            String input = DonorManagementUI.inputSearch(donorList);
                
            switch (input) {
                case "0" -> {
                    listUser.clear();
                    break OUTER;
                }

                case "1" -> {
                    listUser.previousPage();
                }

                case "2" -> {
                    listUser.nextPage();
                }

                case "3" -> {
                    listUser.filter();
                }

                default -> {
                    listUser.revertNum();
                    boolean found = false;

                    for (int i = 1; i <= numOfEntries; i++) {
                        Donor donor = (Donor) donorList.readForward(i);
                        String id = donor.getId();

                        if (input.equals(id)) {
                            DonorManagementUI.displayUser(donor);
                            found = true;
                            break;
                        } else {
                            found = false;
                        }
                    }

                    if (!found) {
                        Error.userNotFound(input);
                    }
                }
            }
        } while (true);
    }

    public void modifyDonor() {
        donorList = DonorDAO.readFile();
        
        int numOfEntries = donorList.getNumberOfEntries();

        listUser.setListValue(donorList);

        OUTER:
        do {
            String input = DonorManagementUI.inputModify(donorList);

            switch (input) {
                case "0" -> {
                    listUser.clear();
                    break OUTER;
                }

                case "1" -> {
                    listUser.previousPage();
                }

                case "2" -> {
                    listUser.nextPage();
                }
                
                case "3" -> {
                    listUser.filter();
                }

                default -> {
                    listUser.revertNum();
                    int currentPosition = 1;
                    boolean found = false;

                    for (; currentPosition <= numOfEntries; currentPosition++) {
                        Donor donor = (Donor) donorList.readForward(currentPosition);
                        String id = donor.getId();

                        if (input.equals(id)) {
                            found = true;
                            break;
                        }
                    }

                    if (found == false) {
                        Error.userNotFound(input);
                    } else {
                        Donor donor = (Donor) donorList.readForward(currentPosition);

                        do {
                            boolean modifyStat = false;
                            int choice = DonorManagementUI.inputModifyChoice(donor);

                            if (choice == 0) {
                                break;
                            }

                            switch (choice) {
                                case 1 -> {
                                    String name;
                                    
                                    do{
                                        name = DonorManagementUI.modifyName(donor);
                                        
                                        if(name.equals("0")){
                                            break;
                                        }
                                        
                                    }while(!DonorValidation.validateName(name));
                                    
                                    if (!name.equals("0")){
                                        donor.setName(name);
                                        modifyStat = true;
                                    }
                                }

                                case 2 -> {
                                    String phoneNum;
                                    
                                    do{
                                        phoneNum = DonorManagementUI.modifyPNum(donor);
                                        
                                        if(phoneNum.equals("0")){
                                            break;
                                        }
                                        
                                    }while(!DonorValidation.validatePhoneNumber(phoneNum));
                                    
                                    if (!phoneNum.equals("0")){
                                        donor.setPhoneNum(phoneNum);
                                        modifyStat = true;
                                    }
                                }

                                case 3 -> {
                                    String email;
                                    
                                    do{
                                        email = DonorManagementUI.modifyEmail(donor);
                                        
                                        if(email.equals("0")){
                                            break;
                                        }
                                        
                                    }while(!DonorValidation.validateEmail(email));
                                    
                                    if (!email.equals("0")){
                                        donor.setEmail(email);
                                        modifyStat = true;
                                    }
                                }

                                case 4 -> {
                                    String type = DonorManagementUI.modifyType(donor);
                                    
                                    if(!type.equals("0")){
                                        donor.setType(type);
                                        modifyStat = true;
                                    }  
                                }

                                case 5 -> {
                                    String address;
                                    
                                    do{
                                        address = DonorManagementUI.modifyAddress(donor);
                                        
                                        if(address.equals("0")){
                                            break;
                                        }
                                        
                                    }while(!DonorValidation.validateAddress(address));
               
                                    if (!address.equals("0")) {
                                        donor.setAddress(address);
                                        modifyStat = true;
                                    }
                                }
                            }
                            if (modifyStat) {
                                donorList.replace(currentPosition, donor);
                                DonorDAO.saveFile(donorList);
                                Success.userModify();
                            }
                        } while (true);
                    }
                }
            }
        } while (true);
    }
    
    public void donorReport(){
        donorList = DonorDAO.readFile();
        
        int numofEntries = donorList.getNumberOfEntries();
        int privateCount = 0, publicCount = 0, governmentCount = 0;
        String title = "";
        int monthOption;
        int[] monthlyCounts = new int[12];
        int maxEntry = 0;
        boolean validInput;
        boolean validMonth = true;
        
        OUTER:
        do {
            validInput = true;
            int userInput = DonorManagementUI.inputReportChoice();

            switch (userInput) {
                case 0 -> {
                    break OUTER;
                }
                
                case 1 -> {
                    do {
                        validInput = true;
                        
                        monthOption = DonorManagementUI.inputMonth();

                        switch (monthOption) {
                            case 0 -> {
                                return;
                            }
                            case 1 -> {
                                title = "January";
                            }
                            case 2 -> {
                                title = "February";
                            }
                            case 3 -> {
                                title = "March";
                            }
                            case 4 -> {
                                title = "April";
                            }
                            case 5 -> {
                                title = "May";
                            }
                            case 6 -> {
                                title = "June";
                            }
                            case 7 -> {
                                title = "July";
                            }
                            case 8 -> {
                                title = "August";
                            }
                            case 9 -> {
                                title = "September";
                            }
                            case 10 -> {
                                title = "October";
                            }
                            case 11 -> {
                                title = "November";
                            }
                            case 12 -> {
                                title = "December";
                            }
                            default -> {
                                Error.invalidChoice(12);
                                validMonth = false;
                            }
                        }
                    } while (validMonth == false);

                    int selectedMonthIndex = monthOption - 1;

                    for (int i = 1; i <= numofEntries; i++) {
                        Donor donor = (Donor) donorList.readForward(i);
                        LocalDate registerDate = donor.getRegisterDate();
                        int registeredMonth = registerDate.getMonthValue() - 1;

                        if (selectedMonthIndex == registeredMonth) {
                            switch (donor.getType()) {
                                case "Public" -> publicCount++;
                                case "Private" -> privateCount++;
                                case "Government" -> governmentCount++;
                            }
                        }
                        monthlyCounts[registeredMonth]++;
                    }
                    DonorManagementUI.displayReport(title, privateCount, publicCount, governmentCount);
                }

                case 2 -> {
                    DonorManagementHeader.annualReport();
                    for (int i = 1; i <= numofEntries; i++) {
                        Donor donor = (Donor) donorList.readForward(i);
                        switch (donor.getType()) {
                            case "Public" -> publicCount++;
                            case "Private" -> privateCount++;
                            case "Government" -> governmentCount++;
                        }
                    }

                    for (int i = 1; i < monthlyCounts.length; i++) {
                        if (monthlyCounts[i] > monthlyCounts[maxEntry]) {
                            maxEntry = i;
                        }
                    }

                    String[] monthNames = {"January", "February", "March", "April", "May", "June",
                        "July", "August", "September", "October", "November", "December"};
                    title = monthNames[maxEntry];
                    DonorManagementUI.displayAnnualReport(title, privateCount, publicCount, governmentCount);
                }

                default -> {
                    validInput = false;
                    Error.invalidChoice(2);
                }
            }
        } while (validInput == false);
    }

    public void donorInterface() {
        int select;

        OUTER:
        do {
            select = DonorManagementUI.inputFunction();

            switch (select) {
                case 0 -> {
                    break OUTER;
                }
                case 1 -> {
                    addDonor();
                }
                case 2 -> {
                    delDonor();
                }
                case 3 -> {
                    listDonor();
                }
                case 4 -> {
                    modifyDonor();
                }
                case 5 -> {
                    donorReport();
                }
                case 6 -> {
                    donorList = DonorDAO.readFile();
                    DummyDonor.addDummyDonor(donorList);
                }
                default -> {
                    Error.invalidChoice(6);
                }
            }
        } while (true);
    }
}






