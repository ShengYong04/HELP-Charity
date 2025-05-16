/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.utility;

import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author User
 */
public class validation {
    private static final String ID_NUMBER = "0123456789";
    private static final int ID_LENGTH = 6;
    private static String doneeID;
    
    public static boolean validateName(String doneeName){
        boolean isValidDoneeName = doneeName != null && !doneeName.trim().isEmpty() && doneeName.trim().length() >= 3 && doneeName.trim().matches("[a-zA-Z-/ ]*");
        
        if (!isValidDoneeName) {
            if (doneeName == null || doneeName.trim().isEmpty()) {
                Colour.printRed("Invalid donee name. Please do not leave it blank.");
            } else if (doneeName.trim().length() < 3) {
                Colour.printRed("Invalid input. Donee name should be more than 3 characters.");
            } else {
                Colour.printRed("Invalid input. Donee name should contain only alphabets and spaces.");
            }
            return false;
        }
        
        return true;
    }
    
    public static boolean validatephoneNumber(String phoneNumber){
        boolean isValidPhoneNumber = phoneNumber != null && phoneNumber.matches("01\\d{8,9}");
        
        if (!isValidPhoneNumber) {
            if(phoneNumber == null || phoneNumber.trim().isEmpty()){
                Colour.printRed("Please do not leave it blank.");
            }else{
                Colour.printRed("Invalid phone number. It should start with '01' followed by 8 or 9 digits.");
            }
            return false;
        }
        
        return true;
    }
    
    public static boolean validateEmail(String email){
        String emailRegex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        
        Pattern pattern1 = Pattern.compile(emailRegex);
        Matcher matcher1 = pattern1.matcher(email);
        
        boolean isValidEmail = email != null && matcher1.matches();
        
        if (!isValidEmail) {
            if(email == null || email.trim().isEmpty()){
                Colour.printRed("Please do not leave it blank.");
            }else{
                Colour.printRed("Invalid email address. Please provide a valid email with format (exm: abc@gmail.com)");
            }
            return false;
        }
        
        return true;
    }
    
    public static boolean validateAddress(String address){
        String addressRegex = "^[a-zA-Z0-9,./ ]{8,}$";
        Pattern pattern2 = Pattern.compile(addressRegex);
        Matcher matcher2 = pattern2.matcher(address);
        
        boolean isValidAddress = address != null && matcher2.matches();
        
        if (!isValidAddress) {

            if(address == null || address.trim().isEmpty()){
                Colour.printRed("Please do not leave it blank.");
            }else{
                Colour.printRed("Invalid address. It should be at least 8 characters long and can include letters, numbers, commas, periods, and slashes.");
            }

            return false;
        }
        
        return true;
    }
    
    public static boolean validatenoPax(int noPax){
        boolean isValidNoPax = noPax > 1 ;
        
        if (!isValidNoPax) {
            if (noPax <1){
                Colour.printRed("Invalid number of pax. It should be greater than 1.");
            }else{
                Colour.printRed("Invalid input.");
            }

            return false;
        }
        
        return true;
    }
    
    public static boolean validateAge(int age){
        boolean isValidAge = age > 0;
        
        if (!isValidAge) {
            if(age <= 0){
                Colour.printRed("Invalid age. Age must be greater than 0.");   
            }else{
                Colour.printRed("Invalid input.");
            }

            return false;
        }
        
        return true;
    }
    
    public static boolean validateGender(char gender){
        boolean isValidGender = gender == 'f' || gender == 'F' || gender == 'm' || gender == 'M';
        
        if (!isValidGender) {
            if(gender != 'f' || gender != 'F' || gender != 'm' || gender != 'M'){
                Colour.printRed("Invalid gender. Please enter 'F' for female or 'M' for male.");
            }else{
               Colour.printRed("Invalid input."); 
            }

            return false;
        }
        
        return true;
    }
    
    public static boolean validateorgName(String orgName){
        boolean isValidOrgName = orgName != null && !orgName.trim().isEmpty() && orgName.trim().length() >= 3 && orgName.trim().matches("[a-zA-Z#&.@/ ]*");
        
        if (!isValidOrgName) {
                if (orgName == null || orgName.trim().isEmpty()) {
                    Colour.printRed("Invalid organization name. Please do not leave it blank.");
                } else if (orgName.trim().length() < 3) {
                    Colour.printRed("Invalid input. Organization name should be more than 3 characters.");
                } else {
                    Colour.printRed("Invalid input. Organization name should contain only alphabets and spaces.");
                }
                return false;
            }
        
        return true;
    }
    
    public static String generateDoneeID() {
        SecureRandom random = new SecureRandom();
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < ID_LENGTH; i++) {
            int randomIndex = random.nextInt(ID_NUMBER.length());
            char randomChar = ID_NUMBER.charAt(randomIndex);
            strBuilder.append(randomChar);
        }

        doneeID = "DNE" + strBuilder.toString();
        return doneeID;
    }
}
