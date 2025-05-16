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
public class Distribution implements Serializable{
    
    private String distributionID;
    private Donee donee;
    private double cash;
    private Item item;
    private Food food;

    public Distribution(String distributionID, Donee donee , double cash, Item item, Food food) {
        this.distributionID = "DTB" + distributionID;
        this.donee = donee;
        this.cash = cash;
        this.item = item;
        this.food = food;
    }

    public String getDistributionID() {
        return distributionID;
    }

    public void setDistributionID(String distributionID) {
        this.distributionID = distributionID;
    }

    public Donee getDonee() {
        return donee;
    }

    public void setDonee(Donee donee) {
        this.donee = donee;
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
        return String.format("Distribution ID: %s \nDonee ID\t: %s \nDonee Name\t: %s \nCash donated\t: %.2f \nItem donated\t: %s\nQuantity\t: %d \nFood donated\t: %s \nQuantity\t: %d", distributionID, donee.getDoneeID(), donee.getDoneeName(), cash, item.getType(), item.getQuantity(), food.getType(), food.getQuantity());
    }
}
