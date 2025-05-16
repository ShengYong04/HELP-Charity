package assignment.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Donor implements Serializable{
    private String id;
    private String name;
    private String phoneNum;
    private String email;
    private String type;
    private String address;
    private LocalDate registerDate;
    
    public Donor(String id, String name, String phoneNum, String email, String type, String address, LocalDate registerDate){
        this.id = id;
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
        this.type = type;
        this.address = address;
        this.registerDate = registerDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }
    
    @Override
    public String toString(){
        return "ID\t\t:" + id +
                "\nName\t\t:" + name +
                "\nPhone Number\t:" + phoneNum +
                "\nEmail\t\t:" + email +
                "\nType\t\t:" + type +
                "\nAddress\t\t:" + address +
                "\nRegister Date\t:" + registerDate;
    }
}
