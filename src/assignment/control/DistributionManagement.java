/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.control;

import assignment.entity.*;
import assignment.entity.Donee;
import assignment.dao.*;
import assignment.utility.*;
import assignment.adt.*;
import assignment.boundary.*;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @Kho Sheng Yong
 */
public class DistributionManagement {
    private Scanner scan = new Scanner(System.in);
    private LinkedListInterface<Distribution> distributionList = new LinkedList<>();
    private LinkedListInterface<Donee> doneeList = new LinkedList<>();
    private DistributionUI distributionUI = new DistributionUI();
    private DistributionDAO distributionDAO = new DistributionDAO();
    private Stock stockList = new Stock();
    private DistributedStock distributedstockList = new DistributedStock();
    private Donee donee;
    private DistributionMessage distributionMSG = new DistributionMessage();
    private String[] itemList = {"Clothes", "Pants", "Shoes", "Bed", "Others"};
    private String[] foodList = {"Rice", "Sugar", "Salt", "Oil", "Others"};

    
    public void addDistribution() {
        Random random = new Random();
        String distributionID = 10000 + random.nextInt(90000) + "";
        double cash = 0.0;
        Item item = new Item("NA", 0);
        Food food = new Food("NA", 0);

        try {
            boolean emptyResult = true;
            distributionUI.displayDoneeTitle();
            for (int x = 1; x <= doneeList.getNumberOfEntries(); x++) {
                emptyResult = distributionUI.displayDoneeList(x, doneeList);
            }
            distributionUI.displayLine();
            if (emptyResult) {
                distributionMSG.emptyResult();
            } else {

                int selection = distributionUI.doneeSelection();
                if (selection == 0) {
                    return;
                } else if (selection <= doneeList.getNumberOfEntries()) {
                    Donee donee = doneeList.readForward(selection);
                    boolean addCont = true;
                    do {
                        int option = distributionUI.userOption();

                        switch (option) {
                            case 1:
                                cash = moneyDistribution();
                                break;
                            case 2:
                                item = itemDistribution(item);
                                break;
                            case 3:
                                food = foodDistribution(food);
                                break;
                            case 0:
                                addCont = false;
                                break;
                            default:
                                distributionMSG.inputOutOfRange(0, 3);
                                break;
                        }
                    } while (addCont);

                    Distribution distribution = new Distribution(distributionID, donee, cash, item, food);
                    distributionList.add(distribution);
                    if (cash > 0) {
                        stockList.modifyMoney(cash);
                        distributedstockList.modifyDistributedMoney(+cash);
                    }
                    if (item != null && !"NA".equals(item.getType())) {
                        stockList.modifyStock(item.getType(), item.getQuantity());
                        distributedstockList.modifyDistributedStock(item.getType(), +item.getQuantity());
                    }
                    if (food != null && !"NA".equals(food.getType())) {
                        stockList.modifyStock(food.getType(), food.getQuantity());
                        distributedstockList.modifyDistributedStock(food.getType(), +food.getQuantity());
                    }
                    distributionMSG.successfuladded();
                    distributionUI.displayaddedDistribution(distribution);
                    distributionUI.displayContinue();

                    distributionList.sort(new distributionComparator());
                    distributionDAO.saveFile(distributionList, stockList, distributedstockList);
                } else {
                    distributionMSG.invalidInput();
                }
            }

        } catch (InputMismatchException ex) {
            distributionMSG.invalidInput();
        }
    }

    public double moneyDistribution() {
        double cash = 0;
        do {
            cash = distributionUI.moneyDistribution(stockList);
        } while (cash <= 0);
        return cash;
    }

    public Item itemDistribution(Item item) {
//        char selection = distributionUI.itemDistributionSelection();
//        if (selection == 'Y' || selection == 'y') {
        //String yesno; 
        //boolean validCont = false;
        //boolean validInput = false;
        int itemIndex = 0;
        //do {            
        do {
            itemIndex = distributionUI.itemDistribution(stockList);
            if (itemIndex < 1 || itemIndex > 5) {
                distributionMSG.inputOutOfRange(1, 5);
            }
        } while (itemIndex < 1 || itemIndex > 5);

        String type = itemList[itemIndex - 1];

        int quantity = 0;
        do {
            quantity = distributionUI.distributionQuantity();
            if (quantity <= 0) {
                distributionMSG.invalidInput();
            }
        } while (quantity <= 0);

        item.setType(type);
        item.setQuantity(quantity);

        return item;
    }

    public Food foodDistribution(Food food) {
        int itemIndex = 0;
        do {
            itemIndex = distributionUI.foodDistribution(stockList);
            if (itemIndex < 1 || itemIndex > 5) {
                distributionMSG.inputOutOfRange(1, 5);
            }
        } while (itemIndex < 1 || itemIndex > 5);

        String type = foodList[itemIndex - 1];

        int quantity = 0;
        do {
            quantity = distributionUI.distributionQuantity();
            if (quantity <= 0) {
                distributionMSG.invalidInput();
            }
        } while (quantity <= 0);

        food.setType(type);
        food.setQuantity(quantity);
        //}
        return food;
    }

    public void removeDistribution() {
        boolean emptyResult = true;
        distributionUI.displayDistributionTitle();
        for (int x = 1; x <= distributionList.getNumberOfEntries(); x++) {
            emptyResult = distributionUI.displayList(x, x, distributionList);
        }
        distributionUI.displayLine();
        if (emptyResult) {
            distributionMSG.emptyResult();
        } else {
            try {
                int selection = distributionUI.removeDistribution();
                if (selection == 0) {
                    return;
                } else if (selection > 0) {
                    distributionList.delete(selection);
                    distributionMSG.successfulRemoved();
                } else {
                    distributionMSG.invalidInput();
                }
            } catch (InputMismatchException ex) {
                distributionMSG.invalidInput();
            } catch (ArrayIndexOutOfBoundsException ex) {
                distributionMSG.indexOutOfBound();
            }
        }
        distributionUI.displayContinue();
    }

    public void modifyDistribution() {
        try {
            Distribution selectedDistribution = null;
            boolean emptyResult = true;
            distributionUI.displayDistributionTitle();
            for (int x = 1; x <= distributionList.getNumberOfEntries(); x++) {
                emptyResult = distributionUI.displayList(x, x, distributionList);
            }
            distributionUI.displayLine();
            if (emptyResult) {
                distributionMSG.emptyResult();
            } else {
                int selection = distributionUI.modifyDistributionMenu();
                if (selection == 0) {
                    return;
                } else if (selection > 0) {
                    selectedDistribution = distributionList.readForward(selection);
                } else if (selection == 0) {

                } else {
                    distributionMSG.invalidInput();
                    selection = 0;
                }
                while (selection != 0) {
                    System.out.println("1. " + selectedDistribution.toString());
                    selection = distributionUI.modifyDistribution();
                    switch (selection) {
                        case 0:
                            break;
                        case 1:
                            selectedDistribution.getCash();
                            double newMoney = distributionUI.changeCash();
                            stockList.modifyMoney(newMoney - selectedDistribution.getCash());
                            selectedDistribution.setCash(newMoney);
                            distributionMSG.successfulModify();
                            distributionUI.displayContinue();
                            break;
                        case 2:
                            selectedDistribution.getItem().getType();
                            try {
                                String itemType = itemList[distributionUI.changeItem() - 1];
                                selectedDistribution.getItem().setType(itemType);
                            } catch (ArrayIndexOutOfBoundsException ex) {
                                distributionMSG.inputOutOfRange(1, 4);
                            }
                            distributionMSG.successfulModify();
                            distributionUI.displayContinue();
                            break;
                        case 3:
                            selectedDistribution.getItem().getQuantity();
                            int newItemQuantity = distributionUI.changeQuantity();
                            stockList.modifyStock(selectedDistribution.getItem().getType(), newItemQuantity - selectedDistribution.getItem().getQuantity());
                            selectedDistribution.getItem().setQuantity(newItemQuantity);
                            distributionMSG.successfulModify();
                            distributionUI.displayContinue();
                            break;
                        case 4:
                            selectedDistribution.getFood().getType();
                            try {
                                String foodType = foodList[distributionUI.changeFood() - 1];
                                selectedDistribution.getFood().setType(foodType);
                            } catch (ArrayIndexOutOfBoundsException ex) {
                                distributionMSG.inputOutOfRange(1, 4);
                            }
                            distributionMSG.successfulModify();
                            distributionUI.displayContinue();
                            break;
                        case 5:
                            selectedDistribution.getFood().getQuantity();
                            int newFoodQuantity = distributionUI.changeQuantity();
                            stockList.modifyStock(selectedDistribution.getFood().getType(), newFoodQuantity - selectedDistribution.getFood().getQuantity());
                            selectedDistribution.getFood().setQuantity(newFoodQuantity);
                            distributionMSG.successfulModify();
                            distributionUI.displayContinue();
                            break;
                        default:
                            distributionMSG.inputOutOfRange(0, 5);
                            break;
                    }
                }
            }
        } catch (InputMismatchException ex) {
            distributionMSG.invalidInput();
            scan.nextLine();
        } catch (NullPointerException ex) {
            distributionMSG.indexOutOfBound();
        }
    }
    
    public void searchDistribution() {
        boolean emptyResult = true;
        int index = 1;
        try {

            int selection = distributionUI.searchMenu();
            switch (selection) {
                case 0:
                    emptyResult = false;
                    break;
                case 1:
                    distributionUI.displayDistributionTitle();
                    for (int x = 1; x <= distributionList.getNumberOfEntries(); x++) {
                        emptyResult = distributionUI.displayList(x, x, distributionList);
                    }
                    distributionUI.displayContinue();
                    break;
                case 2:
                    String name = distributionUI.searchDonatorName();
                    distributionUI.displayDistributionTitle();
                    for (int x = 1; x <= distributionList.getNumberOfEntries(); x++) {
                        if (distributionList.readForward(x).getDonee().getDoneeName().equalsIgnoreCase(name)) {
                            emptyResult = distributionUI.displayList(x, x, distributionList);
                        }
                    }
                    distributionUI.displayContinue();
                    break;

                case 3:
                    String[] searchItem = {"Clothes", "Pants", "Shoes", "Bed", "Rice", "Sugar", "Salt", "Oil", "Others"};
                    try {
                        int searchIndex = distributionUI.searchItems();
                        distributionUI.displayDistributionTitle();
                        for (int x = 1; x <= distributionList.getNumberOfEntries(); x++) {
                            if (distributionList.readForward(x).getFood().getType().equalsIgnoreCase(searchItem[searchIndex - 1]) || distributionList.readForward(x).getItem().getType().equalsIgnoreCase(searchItem[searchIndex - 1])) {
                                emptyResult = distributionUI.displayList(x, x, distributionList);
                            }
                        }
                        distributionUI.displayContinue();
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        distributionMSG.inputOutOfRange(1, 8);
                    }
                    break;
                case 4:
                    double[] range = distributionUI.searchCash();
                    distributionUI.displayDistributionTitle();
                    for (int x = 1; x <= distributionList.getNumberOfEntries(); x++) {
                        if (distributionList.readForward(x).getCash() >= range[0] && distributionList.readForward(x).getCash() <= range[1]) {
                            emptyResult = distributionUI.displayList(x, x, distributionList);
                        }
                    }
                    distributionUI.displayContinue();
                    break;
                default:
                    distributionMSG.inputOutOfRange(0, 4);
                    break;
            }
            if (emptyResult == true) {
                distributionMSG.emptyResult();
            }
        } catch (InputMismatchException ex) {
            distributionMSG.invalidInput();
        }
    }

    public void generateSummaryReport() {
        distributionUI.summaryReport(distributionList, distributedstockList);
    }

    public void distributionMain() {
        doneeList = distributionDAO.initializeDoneeList();
        stockList = distributionDAO.initializeStockList();
        distributedstockList = distributionDAO.initializeDistributedStockList();
        distributionList = distributionDAO.initializeDistributionList();
        
        boolean cont = true;
        do {
            try {
                int selection = distributionUI.distributionMenu();
                switch (selection) {
                    case 1:
                        this.addDistribution();
                        distributionDAO.saveFile(distributionList, stockList, distributedstockList);
                        break;
                    case 2:
                        this.removeDistribution();
                       distributionDAO.saveFile(distributionList, stockList, distributedstockList);
                        break;
                    case 3:
                        this.modifyDistribution();
                        distributionDAO.saveFile(distributionList, stockList, distributedstockList);
                        break;
                    case 4:
                        this.searchDistribution();
                        break;
                    case 5:
                        this.generateSummaryReport();
                        break;
                    case 0:
                        cont = false;
                        break;
                    default:
                        distributionMSG.inputOutOfRange(0, 4);
                        break;
                }
            } catch (InputMismatchException ex) {
                distributionMSG.invalidInput();
                scan.nextLine();
            }
        } while (cont);
    }
}