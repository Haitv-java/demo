package com.aptech.ishop.utils;

import java.util.Scanner;

public class ScannerCommon {
    private static final Scanner scanner = new Scanner(System.in);
    public static String stringInput() {
        do {
            try {
                return scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Input invalid! try again.");
            }
        } while (true);
    }

    public static float floatInput() {
        do {
            try {
                return scanner.nextFloat();
            } catch (Exception e) {
                System.out.println("Number Input invalid! try again.");
            }
            nextLine();
        } while (true);
    }

    public static int integerInput() {
        do {
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Number input invalid! try again.");
            }
            nextLine();
        } while (true);
    }

    public static void nextLine() {
        scanner.nextLine();
    }
}
