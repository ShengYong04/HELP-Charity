/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.utility;

import assignment.entity.*;
import java.util.Comparator;

/**
 *
 * @author User
 */
public class doneeComparator implements Comparator<Donee>{

    @Override
    public int compare(Donee o1, Donee o2) {
        return o1.getDoneeID().compareTo(o2.getDoneeID());
    }
}