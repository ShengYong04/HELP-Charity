/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.boundary;

import assignment.utility.Colour;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author weeya
 */
public class SystemMainUI {
    private static final Scanner scan = new Scanner(System.in);
    
    public static int mainChoice(){
        int selection = -1;
        
        do {
            try {
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
                Colour.printBlue("\t\t\t\t __ __    ___  _      ____          __  __ __   ____  ____   ____  ______  __ __     ");
                Colour.printBlue("\t\t\t\t|  |  |  /  _]| |    |    \\        /  ]|  |  | /    ||    \\ |    ||      ||  |  |    ");
                Colour.printBlue("\t\t\t\t|  |  | /  [_ | |    |  o  )      /  / |  |  ||  o  ||  D  ) |  | |      ||  |  |    ");
                Colour.printBlue("\t\t\t\t|  _  ||    _]| |___ |   _/      /  /  |  _  ||     ||    /  |  | |_|  |_||  ~  |    ");
                Colour.printBlue("\t\t\t\t|  |  ||   [_ |     ||  |       /   \\_ |  |  ||  _  ||    \\  |  |   |  |  |___, |    ");
                Colour.printBlue("\t\t\t\t|  |  ||     ||     ||  |       \\     ||  |  ||  |  ||  .  \\ |  |   |  |  |     |    ");
                Colour.printBlue("\t\t\t\t|__|__||_____||_____||__|        \\____||__|__||__|__||__|\\_||____|  |__|  |____/     ");
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("\t\t\t\t\t\t      Welcome to HELP CHARITY");
                System.out.println("\n\t\t\t\t\t\t\t  Main Menu");
                System.out.println("\t\t\t\t============================================================");
                System.out.printf("\t\t\t\t%-4s %-21s %-20s %n", "", " Choice", "Subsystem Management");
                System.out.println("\t\t\t\t============================================================");
                System.out.println("\t\t\t\t\t1.\t\t\tDonor\t\t");
                System.out.println("\t\t\t\t\t2.\t\t\tDonee\t\t");
                System.out.println("\t\t\t\t\t3.\t\t\tDonation\t");
                System.out.println("\t\t\t\t\t4.\t\t\tDistribution\t");
                System.out.println("\t\t\t\t\t5.\t\t\tGeneral Report\t");
                System.out.println("\t\t\t\t\t0.\t\t\tExit\t");
                System.out.println("\t\t\t\t------------------------------------------------------------");
                System.out.print("\t\t\t\tEnter your choice(0-5): ");
                selection = scan.nextInt();
                scan.nextLine();
                System.out.println("\n\n\n");
                
                break;
            } catch (InputMismatchException ex) {
                scan.nextLine();
                System.out.print("\t\t\t\t");
                assignment.utility.Error.integerOnly();
            }
        }while(true);

        return selection;
    }
}
