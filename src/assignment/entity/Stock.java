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
public class Stock implements Serializable {

    private double Money;

    private int Clothes;
    private int Pants;
    private int Shoes;
    private int Bed;

    private int Rice;
    private int Oil;
    private int Sugar;
    private int Salt;

    private int Others;

    public Stock() {
    }

    public Stock(double Money, int Clothes, int Pants, int Shoes, int Bed, int Rice, int Oil, int Sugar, int Salt, int Others) {
        this.Money = Money;
        this.Clothes = Clothes;
        this.Pants = Pants;
        this.Shoes = Shoes;
        this.Bed = Bed;
        this.Rice = Rice;
        this.Oil = Oil;
        this.Sugar = Sugar;
        this.Salt = Salt;
        this.Others = Others;
    }
    
    public int getStockQuantity(String type) {
        switch (type.toLowerCase()) {
            case "clothes":
                return Clothes;
            case "pants":
                return Pants;
            case "shoes":
                return Shoes;
            case "bed":
                return Bed;
            case "rice":
                return Rice;
            case "oil":
                return Oil;
            case "sugar":
                return Sugar;
            case "salt":
                return Salt;
            case "others":
                return Others;
            default:
                throw new IllegalArgumentException("Invalid stock item type: " + type);
        }
    }

    public void modifyStock(String stock, int quantity) {
        switch (stock.toLowerCase()) {
            case "clothes":
                if (this.Clothes + quantity < 0) {
                    throw new IllegalArgumentException("Invalid stock quantity, total quantity: " + this.Clothes);
                }
                this.Clothes += quantity;
                break;
            case "pants":
                if (this.Pants + quantity < 0) {
                    throw new IllegalArgumentException("Invalid stock quantity, total quantity: " + this.Pants);
                }
                this.Pants += quantity;
                break;
            case "shoes":
                if (this.Shoes + quantity < 0) {
                    throw new IllegalArgumentException("Invalid stock quantity, total quantity: " + this.Shoes);
                }
                this.Shoes += quantity;
                break;
            case "bed":
                if (this.Bed + quantity < 0) {
                    throw new IllegalArgumentException("Invalid stock quantity, total quantity: " + this.Bed);
                }
                this.Bed += quantity;
                break;
            case "rice":
                if (this.Rice + quantity < 0) {
                    throw new IllegalArgumentException("Invalid stock quantity, total quantity: " + this.Rice);
                }
                this.Rice += quantity;
                break;
            case "oil":
                if (this.Oil + quantity < 0) {
                    throw new IllegalArgumentException("Invalid stock quantity, total quantity: " + this.Oil);
                }
                this.Oil += quantity;
                break;
            case "sugar":
                if (this.Sugar + quantity < 0) {
                    throw new IllegalArgumentException("Invalid stock quantity, total quantity: " + this.Sugar);
                }
                this.Sugar += quantity;
                break;
            case "salt":
                if (this.Salt + quantity < 0) {
                    throw new IllegalArgumentException("Invalid stock quantity, total quantity: " + this.Salt);
                }
                this.Salt += quantity;
                break;
            case "others":
                if (this.Others + quantity < 0) {
                    throw new IllegalArgumentException("Invalid stock quantity, total quantity: " + this.Others);
                }
                this.Others += quantity;
                break;
            default:
                throw new IllegalArgumentException("Invalid stock item: " + stock);
        }
    }

    public void modifyMoney(double Money) {
        if (this.Money + Money < 0) {
            throw new IllegalArgumentException("Invalid stock quantity, total quantity: " + this.Money);
        }
        this.Money += Money;
    }

    public int getOthers() {
        return Others;
    }

    public void setOthers(int Others) {
        this.Others = Others;
    }

    public double getMoney() {
        return Money;
    }

    public void setMoney(double Money) {
        this.Money = Money;
    }

    public int getClothes() {
        return Clothes;
    }

    public void setClothes(int Clothes) {
        this.Clothes = Clothes;
    }

    public int getPants() {
        return Pants;
    }

    public void setPants(int Pants) {
        this.Pants = Pants;
    }

    public int getShoes() {
        return Shoes;
    }

    public void setShoes(int Shoes) {
        this.Shoes = Shoes;
    }

    public int getBed() {
        return Bed;
    }

    public void setBed(int Bed) {
        this.Bed = Bed;
    }

    public int getRice() {
        return Rice;
    }

    public void setRice(int Rice) {
        this.Rice = Rice;
    }

    public int getOil() {
        return Oil;
    }

    public void setOil(int Oil) {
        this.Oil = Oil;
    }

    public int getSugar() {
        return Sugar;
    }

    public void setSugar(int Sugar) {
        this.Sugar = Sugar;
    }

    public int getSalt() {
        return Salt;
    }

    public void setSalt(int Salt) {
        this.Salt = Salt;
    }

}
