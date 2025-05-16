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
public class donationComparator implements Comparator<Donation>{

    @Override
    public int compare(Donation o1, Donation o2) {
        return o1.getDonationNumber().compareTo(o2.getDonationNumber());
    }
}
