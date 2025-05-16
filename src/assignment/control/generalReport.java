/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.control;
import assignment.dao.*;
import assignment.adt.LinkedListInterface;
import assignment.entity.Donee;
import assignment.entity.Donor;
import assignment.adt.*;
import java.time.LocalDate;

/**
 *
 * @author User
 */
public class generalReport {
    private static LinkedListInterface<Donee> doneeList = new LinkedList<>();
    private static LinkedListInterface<Donor> donorList = new LinkedList<>();
    private static DoneeDAO dataFile = new DoneeDAO();
    private static DonorDAO donorDataFile = new DonorDAO();
        
    public static int[] generateDoneeMonthlyCounts() {
        doneeList = dataFile.openFile();
        int dataEntry = doneeList.getNumberOfEntries();
        int[] monthlyCounts = new int[12];

        for (int i = 1; i <= dataEntry; i++) {
            Donee donee = (Donee) doneeList.readForward(i);
            LocalDate registerDate = donee.getRegisterDate();
            int registeredMonth = registerDate.getMonthValue() - 1;
            monthlyCounts[registeredMonth]++;
        }

        return monthlyCounts;
    }

    public static int[] generateDonorMonthlyCounts() {
        donorList = donorDataFile.readFile();
        int numofEntries = donorList.getNumberOfEntries();
        int[] monthlyCounts = new int[12];

        for (int i = 1; i <= numofEntries; i++) {
            Donor donor = (Donor) donorList.readForward(i);
            LocalDate registerDate = donor.getRegisterDate();
            int registeredMonth = registerDate.getMonthValue() - 1;
            monthlyCounts[registeredMonth]++;
        }

        return monthlyCounts;
    }
}
