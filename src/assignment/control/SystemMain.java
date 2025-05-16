/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.control;

import assignment.boundary.*;
import assignment.utility.Error;

/**
 *
 * @author User
 */
public class SystemMain {
    
    public static void main(String[] args) {
        DonorManagement register = new DonorManagement();
        DonationMangement donationRegister = new DonationMangement();
        DistributionManagement distributionManagement = new DistributionManagement();
        donee_Main function = new donee_Main();

        int selection;
        
        OUTER:
        do {
            selection = SystemMainUI.mainChoice();
            
            switch (selection) {
                case 0 -> {break OUTER;}
                case 1 -> register.donorInterface();
                case 2 -> function.doneeMain();
                case 3 -> donationRegister.donationMain();
                case 4 -> distributionManagement.distributionMain();
                case 5 -> {
                    int[] doneeMonthlyCounts = generalReport.generateDoneeMonthlyCounts();
                    int[] donorMonthlyCounts = generalReport.generateDonorMonthlyCounts();
                    generalReportUI.displayBothReports(doneeMonthlyCounts, donorMonthlyCounts);
                }
                default -> {
                    System.out.print("\t\t\t\t");
                    Error.invalidChoice(5);
                }

            }
        } while (selection != 0 ||selection != 1|| selection != 2||selection != 3||selection != 4||selection != 5);
    }
    
}
