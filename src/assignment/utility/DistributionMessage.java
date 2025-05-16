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
public class DistributionMessage {
    private final Scanner scan = new Scanner(System.in);
    
    public void invalidInput(){
        Colour.printRed("Invalid input");
    }
    
    public void inputOutOfRange(int n1, int n2){
        System.err.printf("Only numbers between %d-%d are acceptable.\n",n1, n2);
    }
    
    public void indexOutOfBound(){
        System.err.println("Index does not exist");
    }
    
    public void emptyResult(){
        System.out.println("No result found");
    }
    
    public void successfuladded() {
        Colour.printGreen("Donation added succesfully\n");
    }

    public void successfulRemoved() {
        Colour.printGreen("Donation removed succesfully\n");
    }

    public void successfulModify() {
        Colour.printGreen("Donation modify succesfully\n");
    }
    
    public void insufficientMoney() {
        Colour.printRed("Insufficient Money!\n");
    }
    
    public void insufficientItemStock(String type) {
        Colour.printRed("Insufficient stock for item type: " + type + ". Please enter a quantity less than or equal to the available stock.");
    }
    
    public void insufficientFoodStock(String type) {
        System.out.println("Insufficient stock for food type: " + type + ". Please enter a quantity less than or equal to the available stock.");
    }
    
}
