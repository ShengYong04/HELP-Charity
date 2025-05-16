/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.utility;

/**
 *
 * @author weeya
 */
public class Colour {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32;2m";
    private static final String ANSI_BLUE = "\u001B[34m";

    public static void printRed(String message) {
        System.out.println(ANSI_RED + message + ANSI_RESET);
    }

    public static void printGreen(String message) {
        System.out.println(ANSI_GREEN + message + ANSI_RESET);
    }
    public static void printBlue(String message) {
        System.out.println(ANSI_BLUE + message + ANSI_RESET);
    }
}

