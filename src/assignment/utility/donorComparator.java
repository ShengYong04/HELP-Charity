/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.utility;

import assignment.entity.*;
import java.util.Comparator;
/**
 *
 * @author weeya
 */
public class donorComparator implements Comparator<Donor>{

    @Override
    public int compare(Donor o1, Donor o2) {
        return o1.getId().compareTo(o2.getId());
    }
    
}
