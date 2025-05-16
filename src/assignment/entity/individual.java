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
public class individual implements Serializable{

    private int age;
    private char gender;

    public individual() {
        this(0, '-');
    }

    public individual(int age, char gender) {
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
    
    @Override
    public String toString(){
        return "\nGender\t\t\t:" + gender +
                "\nAge\t\t\t:" + age;
    }
}
