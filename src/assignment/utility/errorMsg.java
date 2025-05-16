/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.utility;

import java.util.Scanner;


/**
 *
 * @author User
 */
public class errorMsg {
    public static final Scanner scan = new Scanner(System.in);
    //========doneeMain=========
    public static void ErrMsg(String s){
        Colour.printRed("Invalid input. please enter a valid choice of 0-"+ s +"\n");
    }
    
    public static void CatchErrMsg(Exception e){
        Colour.printRed("Error: "+ e.getMessage());
    }
    
    //=========addDoneeDetails=========
    public static void DoneeTypeErrMsg(){
        Colour.printRed("Invalid input. Please choose between \"i\", \"f\", \"o\"");
    }
    
    public static void YesNoErrMsg(){
        Colour.printRed("Invalid Input. Please enter only \"y\" or \"n\" \n");
    }
    
    //=========removeDonee=========
    
    public static void enterAgainErrMsg(String s){
        Colour.printRed(s +" Please proceed to select the choice again");
    }
    
    //=========generateReport========
    public static void reportErrMsg(){
        Colour.printRed("Invalid input. Please enter between 00 - 12 only!\n");
    }
}
