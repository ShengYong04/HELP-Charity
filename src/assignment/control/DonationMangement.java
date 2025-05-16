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
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @Tan Junn Yi
 */
public class DonationMangement {

    private Scanner scan = new Scanner(System.in);
    private LinkedListInterface<Donation> donationList = new LinkedList<>();
    private LinkedListInterface<Donor> donorList = new LinkedList<>();
    private DonationUI donationUI = new DonationUI();
    private DonationDAO donationDAO = new DonationDAO();
    private Stock stockList = new Stock();
    private Donor donor;
    private DonationMessage errorMsg = new DonationMessage();
    private String[] itemList = {"Clothes", "Pants", "Shoes", "Bed", "Others"};
    private String[] foodList = {"Rice", "Sugar", "Salt", "Oil", "Others"};

    public void newDonation() {
        Random random = new Random();
        String donationNumber = 1000 + random.nextInt(9000) + "";
        double cash = 0;
        Item item = new Item("NA", 0);
        Food food = new Food("NA", 0);

        try {
            boolean emptyResult = true;
            donationUI.displayDonorTitle();
            for (int x = 1; x <= donorList.getNumberOfEntries(); x++) {
                emptyResult = donationUI.displayDonorList(x, donorList);
            }
            donationUI.displayLine();
            if (emptyResult) {
                errorMsg.emptyResult();
            } else {

                int selection = donationUI.donorSelection();
                if (selection == 0) {
                    return;
                } else if (selection <= donorList.getNumberOfEntries()) {
                    Donor donor = donorList.readForward(selection);
                    System.out.println("\nYou are currently creating a new donation on behalf of " + donor.getName());
                    boolean addCont = true;
                    do {
                        int option = donationUI.userOption();

                        switch (option) {
                            case 1:
                                cash = moneyDonation();
                                break;
                            case 2:
                                item = itemDonation(item);
                                break;
                            case 3:
                                food = foodDonation(food);
                                break;
                            case 0:
                                addCont = false;
                                break;
                            default:
                                errorMsg.inputOutOfRange(0, 3);
                                break;
                        }
                    } while (addCont);

                    Donation donation = new Donation(donationNumber, donor, cash, item, food);
                    donationList.add(donation);
                    if (cash > 0) {
                        stockList.modifyMoney(cash);
                    }
                    if (item != null && !"NA".equals(item.getType())) {
                        stockList.modifyStock(item.getType(), item.getQuantity());
                    }
                    if (food != null && !"NA".equals(food.getType())) {
                        stockList.modifyStock(food.getType(), food.getQuantity());
                    }
                    errorMsg.successfuladded();
                    donationUI.displayaddedDonation(donation);
                    donationUI.displayContinue();

                    donationList.sort(new donationComparator());
                    donationDAO.storeData(donationList, stockList);
                } else {
                    errorMsg.invalidInput();
                }
            }

        } catch (InputMismatchException ex) {
            errorMsg.invalidInput();
        }
    }

    public double moneyDonation() {
        double cash = 0;
        //char moneySelection = donationUI.moneyDonationSelection();
        //if (moneySelection == 'Y' || moneySelection == 'y') {
        do {
            cash = donationUI.moneyDonation();
        } while (cash <= 0);
        //}
        return cash;
    }

    public Item itemDonation(Item item) {
//        char selection = donationUI.itemDonationSelection();
//        if (selection == 'Y' || selection == 'y') {
        //String yesno; 
        //boolean validCont = false;
        //boolean validInput = false;
        int itemIndex = 0;
        //do {            
        do {
            itemIndex = donationUI.itemDonation();
            if (itemIndex < 1 || itemIndex > 5) {
                errorMsg.inputOutOfRange(1, 5);
            }
        } while (itemIndex < 1 || itemIndex > 5);

        String type = itemList[itemIndex - 1];

        int quantity = 0;
        do {
            quantity = donationUI.donationQuantity();
            if (quantity <= 0) {
                errorMsg.invalidInput();
            }
        } while (quantity <= 0);

        item.setType(type);
        item.setQuantity(quantity);

        return item;
    }

    public Food foodDonation(Food food) {
        int itemIndex = 0;
        do {
            itemIndex = donationUI.foodDonation();
            if (itemIndex < 1 || itemIndex > 5) {
                errorMsg.inputOutOfRange(1, 5);
            }
        } while (itemIndex < 1 || itemIndex > 5);

        String type = foodList[itemIndex - 1];

        int quantity = 0;
        do {
            quantity = donationUI.donationQuantity();
            if (quantity <= 0) {
                errorMsg.invalidInput();
            }
        } while (quantity <= 0);

        food.setType(type);
        food.setQuantity(quantity);
        //}
        return food;
    }

    public void removeDonation() {
        boolean emptyResult = true;
        donationUI.displayDonationTitle();
        for (int x = 1; x <= donationList.getNumberOfEntries(); x++) {
            emptyResult = donationUI.displayList(x, x, donationList);
        }
        donationUI.displayLine();
        if (emptyResult) {
            errorMsg.emptyResult();
        } else {
            try {
                int selection = donationUI.removeDonation();
                if (selection == 0) {
                    return;
                } else if (selection > 0) {
                    donationList.delete(selection);
                    errorMsg.successfulRemoved();
                } else {
                    errorMsg.invalidInput();
                }
            } catch (InputMismatchException ex) {
                errorMsg.invalidInput();
            } catch (ArrayIndexOutOfBoundsException ex) {
                errorMsg.indexOutOfBound();
            }
        }
        donationUI.displayContinue();
    }

    public void amendDonation() {
        try {
            Donation selectedDonation = null;
            boolean emptyResult = true;
            donationUI.displayDonationTitle();
            for (int x = 1; x <= donationList.getNumberOfEntries(); x++) {
                emptyResult = donationUI.displayList(x, x, donationList);
            }
            donationUI.displayLine();
            if (emptyResult) {
                errorMsg.emptyResult();
            } else {
                int selection = donationUI.amendDonationMenu();
                if (selection == 0) {
                    return;
                } else if (selection > 0) {
                    selectedDonation = donationList.readForward(selection);
                } else if (selection == 0) {

                } else {
                    errorMsg.invalidInput();
                    selection = 0;
                }
                while (selection != 0) {
                    System.out.println("1. " + selectedDonation.toString());
                    selection = donationUI.amendDonation();
                    switch (selection) {
                        case 0:
                            break;
                        case 1:
                            selectedDonation.getCash();
                            double newMoney = donationUI.changeCash();
                            stockList.modifyMoney(newMoney - selectedDonation.getCash());
                            selectedDonation.setCash(newMoney);
                            errorMsg.successfulAmend();
                            donationUI.displayContinue();
                            break;
                        case 2:
                            selectedDonation.getItem().getType();
                            try {
                                String itemType = itemList[donationUI.changeItem() - 1];
                                selectedDonation.getItem().setType(itemType);
                            } catch (ArrayIndexOutOfBoundsException ex) {
                                errorMsg.inputOutOfRange(1, 4);
                            }
                            errorMsg.successfulAmend();
                            donationUI.displayContinue();
                            break;
                        case 3:
                            selectedDonation.getItem().getQuantity();
                            int newItemQuantity = donationUI.changeQuantity();
                            stockList.modifyStock(selectedDonation.getItem().getType(), newItemQuantity - selectedDonation.getItem().getQuantity());
                            selectedDonation.getItem().setQuantity(newItemQuantity);
                            errorMsg.successfulAmend();
                            donationUI.displayContinue();
                            break;
                        case 4:
                            selectedDonation.getFood().getType();
                            try {
                                String foodType = foodList[donationUI.changeFood() - 1];
                                selectedDonation.getFood().setType(foodType);
                            } catch (ArrayIndexOutOfBoundsException ex) {
                                errorMsg.inputOutOfRange(1, 4);
                            }
                            errorMsg.successfulAmend();
                            donationUI.displayContinue();
                            break;
                        case 5:
                            selectedDonation.getFood().getQuantity();
                            int newFoodQuantity = donationUI.changeQuantity();
                            stockList.modifyStock(selectedDonation.getFood().getType(), newFoodQuantity - selectedDonation.getFood().getQuantity());
                            selectedDonation.getFood().setQuantity(newFoodQuantity);
                            errorMsg.successfulAmend();
                            donationUI.displayContinue();
                            break;
                        default:
                            errorMsg.inputOutOfRange(0, 5);
                            break;
                    }
                }
            }
        } catch (InputMismatchException ex) {
            errorMsg.invalidInput();
            scan.nextLine();
        } catch (NullPointerException ex) {
            errorMsg.indexOutOfBound();
        }
    }

    public void searchDonation() {
        boolean emptyResult = true;
        int index = 1;
        try {

            int selection = donationUI.searchMenu();
            switch (selection) {
                case 0:
                    emptyResult = false;
                    break;
                case 1:
                    donationUI.displayDonationTitle();
                    for (int x = 1; x <= donationList.getNumberOfEntries(); x++) {
                        emptyResult = donationUI.displayList(x, x, donationList);
                    }
                    donationUI.displayContinue();
                    break;
                case 2:
                    String name = donationUI.searchDonatorName();
                    donationUI.displayDonationTitle();
                    for (int x = 1; x <= donationList.getNumberOfEntries(); x++) {
                        if (donationList.readForward(x).getDonator().getName().equalsIgnoreCase(name)) {
                            emptyResult = donationUI.displayList(x, x, donationList);
                        }
                    }
                    donationUI.displayContinue();
                    break;

                case 3:
                    String[] searchItem = {"Clothes", "Pants", "Shoes", "Bed", "Rice", "Sugar", "Salt", "Oil"};
                    try {
                        int searchIndex = donationUI.searchItems();
                        donationUI.displayDonationTitle();
                        for (int x = 1; x <= donationList.getNumberOfEntries(); x++) {
                            if (donationList.readForward(x).getFood().getType().equalsIgnoreCase(searchItem[searchIndex - 1]) || donationList.readForward(x).getItem().getType().equalsIgnoreCase(searchItem[searchIndex - 1])) {
                                emptyResult = donationUI.displayList(x, x, donationList);
                            }
                        }
                        donationUI.displayContinue();
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        errorMsg.inputOutOfRange(1, 8);
                    }
                    break;
                case 4:
                    double[] range = donationUI.searchCash();
                    donationUI.displayDonationTitle();
                    for (int x = 1; x <= donationList.getNumberOfEntries(); x++) {
                        if (donationList.readForward(x).getCash() >= range[0] && donationList.readForward(x).getCash() <= range[1]) {
                            emptyResult = donationUI.displayList(x, x, donationList);
                        }
                    }
                    donationUI.displayContinue();
                    break;
                default:
                    errorMsg.inputOutOfRange(1, 3);
                    break;
            }
            if (emptyResult == true) {
                errorMsg.emptyResult();
            }
        } catch (InputMismatchException ex) {
            errorMsg.invalidInput();
        }
    }

    public void summaryReport() {
        donationUI.summary(donationList, stockList);
    }

    public void donationMain() {
        donorList = donationDAO.initializeDonorList();
        donationList = donationDAO.initializeList();
        stockList = donationDAO.initializeStockList();
        boolean cont = true;
        do {
            try {
                int selection = donationUI.donationMenu();
                switch (selection) {
                    case 1:
                        this.newDonation();
                        donationList.sort(new donationComparator());
                        donationDAO.storeData(donationList, stockList);
                        break;
                    case 2:
                        this.removeDonation();
                        donationList.sort(new donationComparator());
                        donationDAO.storeData(donationList, stockList);
                        break;
                    case 3:
                        this.amendDonation();
                        donationList.sort(new donationComparator());
                        donationDAO.storeData(donationList, stockList);
                        break;
                    case 4:
                        this.searchDonation();
                        break;
                    case 5:
                        this.summaryReport();
                        break;
                    case 0:
                        cont = false;
                        break;
                    default:
                        errorMsg.inputOutOfRange(0, 4);
                        break;
                }
            } catch (InputMismatchException ex) {
                errorMsg.invalidInput();
                scan.nextLine();
            }
        } while (cont);
    }
}

//        char selection = donationUI.foodDonationSelection();
//        if (selection == 'Y' || selection == 'y') {