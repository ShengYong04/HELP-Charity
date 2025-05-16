/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.utility;

/**
 *
 * @author User
 */
public class DonationMessage {
    
    public void invalidInput(){
        System.err.println("Invalid input");
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
    
    public void successfuladded(){
        Colour.printGreen("Donation added succesfully\n");
    }
    
    public void successfulRemoved() {
        Colour.printGreen("Donation removed succesfully\n");
    }
    
    public void successfulAmend() {
        Colour.printGreen("Donation amend succesfully\n");
    }
    
}
