/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author User
 */
public class Donee implements Serializable{

    private String doneeName;
    private String phoneNumber;
    private String email;
    private String address;
    private String doneeID;
    private String doneeType;
    private LocalDate registerDate;
    private Object info;
    
    
    public Donee(String doneeName, String phoneNumber, String email,  
                 String address, String doneeID, String doneeType ,LocalDate registerDate,Object info) {
        this.doneeName = doneeName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.doneeID = doneeID;
        this.doneeType = doneeType;
        this.registerDate = registerDate;
        this.info = info;
        
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public String getDoneeName() {
        return doneeName;
    }

    public void setDoneeName(String doneeName) {
        this.doneeName = doneeName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getDoneeID() {
        return doneeID;
    }

    public void setDoneeID(String doneeID) {
        this.doneeID = doneeID;
    }

    public String getDoneeType() {
        return doneeType;
    }

    public void setDoneeType(String doneeType) {
        this.doneeType = doneeType;
    }
    
    public LocalDate getRegisterDate() {
        return registerDate;
    }
    
    @Override
    public String toString(){
        String r;
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedRegisterDate = registerDate.format(dateFormatter);
         r="Donee ID\t\t\t:" + doneeID +
                "\nName\t\t\t:" + doneeName +
                "\nPhone Number\t\t:" + phoneNumber +
                "\nEmail\t\t\t:" + email +
                "\nType\t\t\t:" + doneeType +
                "\nAddress\t\t\t:" + address +
                "\nDonee Register Date\t:" + formattedRegisterDate;
         
         if(doneeType.equalsIgnoreCase("i")){
             r= r.concat(((individual)info).toString());
         }else if(doneeType.equalsIgnoreCase("f")){
             r = r.concat(((family)info).toString());
         }else if(doneeType.equalsIgnoreCase("o")){
             r = r.concat(((organization)info).toString());
         }
        return r;
    }
  

}


    
    
    
    

