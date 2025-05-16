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
public class organization implements Serializable{
    private String orgName;
    
    public organization(){
        this("");
    }
    
    public organization(String orgName){
        this.orgName = orgName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
    
    @Override
    public String toString(){
        return "\nOrganization Name\t:" + orgName;
    }
    
}
