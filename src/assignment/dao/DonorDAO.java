/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.dao;

import assignment.entity.*;
import assignment.utility.Error;
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
 * @author weeya
 */
public class DonorDAO {
    public static void saveFile(LinkedListInterface<Donor> donorList) {
        try {
            File file = new File("donorList.dat");
            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream(file));
            ooStream.writeObject(donorList);
            ooStream.close();
        } catch (FileNotFoundException ex) {
            Error.fileNotFound();
        } catch (IOException ex) {
            Error.cannotSave();
        }
    }

    public static LinkedListInterface<Donor> readFile() {
        LinkedListInterface<Donor> donorList = new LinkedList();
        
        try {
            File file = new File("donorList.dat");
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(file));
            donorList = (LinkedList<Donor>) (oiStream.readObject());
            oiStream.close();
        } catch (FileNotFoundException ex) {
            Error.fileNotFound();
        } catch (IOException ex) {
            Error.cannotRead();
        } catch (ClassNotFoundException ex) {
            Error.classNotFound();
        }
        return donorList;
    }
}
