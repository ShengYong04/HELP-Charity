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
public class family implements Serializable{

    private int noPax;
    private int age;
    private char gender;

    public family() {
        this(0, 0, '-');
    }

    public family(int noPax, int age, char gender) {
        this.noPax = noPax;
        this.age = age;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getNoPax() {
        return noPax;
    }

    public void setNoPax(int noPax) {
        this.noPax = noPax;
    }
    
    @Override
    public String toString(){
        return "\nGender\t\t\t:" + gender +
                "\nAge\t\t\t:" + age +
                "\nNo of Pax\t\t:" + noPax;
    }
}
