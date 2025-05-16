/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.dao;

import assignment.adt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import assignment.entity.*;

/**
 *
 * @author User
 */
public class DoneeDAO {
    private LinkedListInterface<Donee> doneeList = new LinkedList<>();
        
    public LinkedListInterface<Donee> openFile() {
        try {
            File file = new File("donee.dat");
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(file));
            doneeList = (LinkedList<Donee>) (oiStream.readObject());
            oiStream.close();
        } catch (FileNotFoundException ex) {
            System.err.println("File not found");
        } catch (IOException ex) {
            System.err.println("Cannot read from file");
        } catch (ClassNotFoundException ex) {
            System.err.println("Class not found");
        }
        return doneeList;
    }
    
    public void writeFile(LinkedListInterface<Donee> doneeList) {
        try { 
            File file = new File("donee.dat");
            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream(file));
            ooStream.writeObject(doneeList);
            ooStream.close();
        } catch (FileNotFoundException ex) {
            System.err.println("File not found");
        } catch (IOException ex) {
            System.err.println("Cannot save to file");
        }
    }
}
