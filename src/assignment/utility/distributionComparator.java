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
public class distributionComparator implements Comparator<Distribution>{

    @Override
    public int compare(Distribution o1, Distribution o2) {
        return o1.getDistributionID().compareTo(o2.getDistributionID());
    }
}
