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
 * @author weeya
 */
public class DonorValidation {
    private static final String ID_NUMBER = "0123456789";
    private static final int ID_LENGTH = 6;
    
    public static boolean validateName(String name){
        boolean isValidDonorName = name != null && !name.trim().isEmpty() && name.trim().length() >= 3 && name.trim().matches("[a-zA-Z-/ ]*");
        
        if (!isValidDonorName) {
            if (name == null || name.trim().isEmpty()) {
                Error.empty();
            } else if (name.trim().length() < 3) {
                Error.nameLength();
            } else {
                Error.nameFormat();
            }
            return false;
        }
        
        return true;
    }
    
    public static boolean validatePhoneNumber(String phoneNumber){
        boolean isValidPhoneNumber = phoneNumber != null && phoneNumber.matches("01\\d{8,9}");
        
        if (!isValidPhoneNumber) {
            if(phoneNumber == null || phoneNumber.trim().isEmpty()){
                Error.empty();
            }else{
                Error.phoneFormat();
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
                Error.empty();
            }else{
                Error.emailFormat();
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
                Error.empty();
            }else{
                Error.addressFormat();
            }

            return false;
        }
        
        return true;
    }
    
    public static String generateDonorID() {
        SecureRandom random = new SecureRandom();
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < ID_LENGTH; i++) {
            int randomIndex = random.nextInt(ID_NUMBER.length());
            char randomChar = ID_NUMBER.charAt(randomIndex);
            strBuilder.append(randomChar);
        }

        String donorID = "DNR" + strBuilder.toString();
        return donorID;
    }
}


