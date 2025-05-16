/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.utility;

/**
 *
 * @author User
 */
public class successfulMsg {
    public static void addSuccessful(){
        Colour.printGreen("\n**********Donee details added successfully!**********\n");
    }
    
    public static void deleteSuccessful(){
        Colour.printGreen("\n**********Donee Removed Successfully**********");
    }
    
    public static void updateSuccessful(String s){
        Colour.printGreen("\n**********Donee "+s+ " updated successfully**********");
    }
}
