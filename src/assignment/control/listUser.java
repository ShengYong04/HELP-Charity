// Name: Lim Wee Yang (2307596)
// Program: RSW2S1G2

package assignment.control;

import assignment.entity.*;
import assignment.utility.Error;
import assignment.adt.*;
import assignment.boundary.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class listUser {
    private static int numOfEntries, iterator = 1, leftQuantity, stopCond, pageNum;
    private static int currentPage = 1, revert, no = 1;
    private static boolean filterCond, publicStat, privateStat, governmentStat;
    private static final Scanner scan = new Scanner(System.in);
    private static final String clearScreen = "\n".repeat(50);
    
    public static void setListValue(LinkedListInterface<Donor> donorList){
        numOfEntries = donorList.getNumberOfEntries();
        pageNum = listUser.numOfEntries / 10;
        leftQuantity = listUser.numOfEntries % 10;
        
        if (listUser.numOfEntries >= 10) {
            stopCond = 10;
        } else if (listUser.numOfEntries >= 1) {
            stopCond = listUser.numOfEntries;
        } else {
            stopCond = 0;
            currentPage = 0;
        }

        if (leftQuantity > 0) {
            pageNum++;
        }
    }
    
    public static void listUsers(LinkedListInterface<Donor> donorList){
        revert = 0;
        listUserUI.listUserHeader();

        if (stopCond == 0) {
            listUserUI.emptyUser();
        } else if (!filterCond){
            for (; iterator <= stopCond; iterator++) {
                Donor donor = (Donor) donorList.readForward(iterator);
                listUserUI.displayUser(no, donor);
                revert++;
                no++;
            }
        }else if (filterCond){
            for (; iterator <= stopCond; iterator++) {
                Donor donor = (Donor) donorList.readForward(iterator);
                revert++;

                if (!publicStat && donor.getType().equals("Public")){
                    continue;
                }else if (!privateStat && donor.getType().equals("Private")){
                    continue;
                }else if (!governmentStat && donor.getType().equals("Government")){
                    continue;
                }

                listUserUI.displayUser(no, donor);
                no++;
            }
        }
        listUserUI.listUserFooter(currentPage, pageNum);
    }

    public static void previousPage() {
        if (currentPage > 1) {
            currentPage--;

            if (currentPage == pageNum - 1 && leftQuantity > 0) {
                stopCond -= leftQuantity;
                iterator -= (leftQuantity + 10);
                no -= (leftQuantity + 10);
            } else {
                stopCond -= 10;
                iterator -= 20; 
                no -= 20;
            }
        } else {
            revertNum();
            Error.topPage();
        }
    }

    public static void nextPage() {
        if (currentPage < pageNum) { 
            currentPage++; 

            if (leftQuantity == 0 || currentPage < pageNum) { 
                stopCond += 10; 
            } else if (currentPage == pageNum && leftQuantity > 0) { 
                stopCond += leftQuantity; 
            }
        } else {
            revertNum();
            Error.bottomPage();
        }
    }
    
    public static void filter(){
        int choice = -1;
        iterator -= revert;

        OUTER3:
        do {
            do {
                try {
                    choice = listUserUI.filterInterface(publicStat, privateStat, governmentStat);
                    break;
                } catch (InputMismatchException ex) {
                    scan.nextLine();
                    Error.integerOnly();
                }
            } while (true);

            switch (choice) {
                case 0 -> {
                    break OUTER3;
                }

                case 1 -> {
                    if (publicStat) {
                        publicStat = false;
                    }else {
                        publicStat = true;
                    }
                    
                    no = 1;
                }

                case 2 -> {
                    if (privateStat) {
                        privateStat = false;
                    }else {
                        privateStat = true;
                    }
                    
                    no = 1;
                }

                case 3 -> {
                    if (governmentStat) {
                        governmentStat = false;
                    }else {
                        governmentStat = true;
                    }
                    
                    no = 1;
                }
            }

            if (publicStat || privateStat || governmentStat){
                filterCond = true;
            }else {
                filterCond = false;
            }
        } while (true);
    }
    
    public static void clear(){
        iterator = 1;
        no = 1;
        currentPage = 1;
        
        if (listUser.numOfEntries >= 10) {
            stopCond = 10;
        } else if (listUser.numOfEntries >= 1) {
            stopCond = listUser.numOfEntries;
        } else {
            stopCond = 0;
            currentPage = 0;
        } 
        
        filterCond = false;
        publicStat = false;
        privateStat = false;
        governmentStat = false;
    }
    
    public static void revertNum(){
        iterator -= revert;
        no -= revert;
    }
}
