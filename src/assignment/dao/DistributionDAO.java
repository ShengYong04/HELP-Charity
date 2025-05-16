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
public class DistributionDAO {
    
    private LinkedListInterface<Donee> doneeList = new LinkedList<>();
    LinkedListInterface<Distribution> distributionList = new LinkedList<>();
    Stock stockList = new Stock();
    DistributedStock distributedstockList = new DistributedStock();
    
    public LinkedListInterface<Donee> initializeDoneeList() {
        File file = new File("donee.dat");
        try (ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(file))) {
            doneeList = (LinkedList<Donee>) (oiStream.readObject());

        } catch (FileNotFoundException ex) {
            System.err.println("File not found");
        } catch (IOException ex) {
            System.err.println("Cannot read from file");
        } catch (ClassNotFoundException ex) {
            System.err.println("Class not found");
        }
        return doneeList;
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
    
        public DistributedStock initializeDistributedStockList() {

        File file = new File("distributedstock.dat");
        try (ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(file))) {
            distributedstockList = (DistributedStock) (oiStream.readObject());

        } catch (FileNotFoundException ex) {
            System.err.println("File not found");
        } catch (IOException ex) {
            System.err.println("Cannot read from file");
        } catch (ClassNotFoundException ex) {
            System.err.println("Class not found");
        }
        return distributedstockList;

    }
    
    public LinkedListInterface<Distribution> initializeDistributionList() {
        File file = new File("distribution.dat");
        try (ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(file))) {
            distributionList = (LinkedList<Distribution>) (oiStream.readObject());

        } catch (FileNotFoundException ex) {
            System.err.println("File not found");
        } catch (IOException ex) {
            System.err.println("Cannot read from file");
        } catch (ClassNotFoundException ex) {
            System.err.println("Class not found");
        }
        return distributionList;
    }
    
    public void saveFile(LinkedListInterface<Distribution> distributionList, Stock stockList, DistributedStock distributedstock) {
        try {
            File file = new File("distribution.dat");
            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream(file));
            ooStream.writeObject(distributionList);
            ooStream.close();

            file = new File("stock.dat");
            ooStream = new ObjectOutputStream(new FileOutputStream(file));
            ooStream.writeObject(stockList);
            ooStream.close();

            file = new File("distributedstock.dat");
            ooStream = new ObjectOutputStream(new FileOutputStream(file));
            ooStream.writeObject(distributedstockList);
            ooStream.close();

        } catch (FileNotFoundException ex) {
            System.err.println("File not found");
        } catch (IOException ex) {
            System.err.println("Cannot save to file");
        }
    }
}