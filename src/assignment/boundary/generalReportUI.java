/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.boundary;

import java.util.Scanner;


/**
 *
 * @author User
 */
public class generalReportUI {
        
    public static void displayBothReports(int[] doneeMonthlyCounts, int[] donorMonthlyCounts) {
        String[] monthNames = {"January", "February", "March", "April", "May", "June", 
                               "July", "August", "September", "October", "November", "December"};
        
        int totalDonees = 0;
        int totalDonors = 0;
        
        System.out.println("\n\n*************Statistical Report of Overall Registered Number of Entries*************\n\n");

        for (int i = 0; i < monthNames.length; i++) {
            int doneesForMonth = doneeMonthlyCounts[i];
            int donorsForMonth = donorMonthlyCounts[i];
            totalDonees += doneesForMonth;
            totalDonors += donorsForMonth;

            System.out.println("~~~~~~~~~~~~~~~~~~");
            System.out.println("     "+monthNames[i]+"     ");
            System.out.println("~~~~~~~~~~~~~~~~~~");

            System.out.println("Registered donees in " + monthNames[i] + " \t: " + doneesForMonth);
            System.out.println("Registered donors in " + monthNames[i] + " \t: " + donorsForMonth);
            System.out.println("__________________________________________");
            System.out.println("Registered Entries of the month\t: " + (doneesForMonth + donorsForMonth)+"\n");
            System.out.println(); 
        }

        System.out.println("\n\n.............................................................");
        System.out.println("Total donee's number of entries: " + totalDonees);
        System.out.println("Total donor's number of entries: " + totalDonors);
        System.out.println("=============================================================");
        System.out.println("Grand total of registed Number of Entries: "+ (totalDonees + totalDonors));
        System.out.println("=============================================================");
        
        System.out.println("Press Enter to return to main menu...");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
    }
            
}
