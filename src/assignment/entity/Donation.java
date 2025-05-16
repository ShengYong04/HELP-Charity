/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.entity;
import java.io.Serializable;
/**
 *
 * @author User
 */
public class Donation implements Serializable{
    
    //D-XXXX-XXXX
    private String donationNumber;
    private Donor donator;
    private double cash;
    private Item item;
    private Food food;

    public Donation(String donationNumber, Donor donator, double cash, Item item, Food food) {
        this.donationNumber = "D-" + donator.getId() + "-" + donationNumber;
        this.donator = donator;
        this.cash = cash;
        this.item = item;
        this.food = food;
    }

    public String getDonationNumber() {
        return donationNumber;
    }

    public void setDonationNumber(String donationNumber) {
        this.donationNumber = donationNumber;
    }

    public Donor getDonator() {
        return donator;
    }

    public void setDonator(Donor donator) {
        this.donator = donator;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
    
    @Override
    public String toString(){
        return String.format("Donation Number: %s \nDonor ID\t: %s \nDonor Name\t: %s \nCash donated\t: %.2f \nItem donated\t: %s\nQuantity\t: %d \nFood donated\t: %s \nQuantity\t: %d", donationNumber, donator.getId(), donator.getName(), cash, item.getType(), item.getQuantity(), food.getType(), food.getQuantity());
    }
}
