/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.dao;

import assignment.entity.*;
import assignment.adt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author User
 */
public class DonationDAO {

    private LinkedListInterface<Donor> donorList = new LinkedList<>();
    LinkedListInterface<Donation> donationList = new LinkedList<>();
    Stock stockList = new Stock();

    public void storeData(LinkedListInterface<Donation> list, Stock stockList) {
        try {
            File file = new File("donation.dat");
            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream(file));
            ooStream.writeObject(list);
            ooStream.close();

            file = new File("stock.dat");
            ooStream = new ObjectOutputStream(new FileOutputStream(file));
            ooStream.writeObject(stockList);
            ooStream.close();

        } catch (FileNotFoundException ex) {
            System.err.println("File not found");
        } catch (IOException ex) {
            System.err.println("Cannot save to file");
        }
    }

    public LinkedListInterface<Donation> initializeList() {

        File file = new File("donation.dat");
        try (ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(file))) {
            donationList = (LinkedList<Donation>) (oiStream.readObject());

        } catch (FileNotFoundException ex) {
            System.err.println("File not found" + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Cannot read from file" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println("Class not found" + ex.getMessage());
        }
        return donationList;
    }

    public Stock initializeStockList() {

        File file = new File("stock.dat");
        try (ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(file))) {
            stockList = (Stock) (oiStream.readObject());

        } catch (FileNotFoundException ex) {
            System.err.println("File not found");
        } catch (IOException ex) {
            System.err.println("Cannot read from file");
        } catch (ClassNotFoundException ex) {
            System.err.println("Class not found");
        }
        return stockList;

    }

    public LinkedListInterface<Donor> initializeDonorList() {
        File file = new File("donorList.dat");
        try (ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(file))) {
            donorList = (LinkedList<Donor>) (oiStream.readObject());

        } catch (FileNotFoundException ex) {
            System.err.println("File not found" + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Cannot read from file" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println("Class not found" + ex.getMessage());
        }
        return donorList;

    }
}
