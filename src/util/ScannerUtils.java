package util;

import content.Category;

import java.util.Scanner;

public class ScannerUtils {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static String captureText(String message) {
        System.out.println(message + ": ");
        return SCANNER.nextLine();
    }

    public static int captureInt(String message) {
        System.out.println(message + ": ");

        while(!SCANNER.hasNextInt()) {
            System.out.println("Dato no aceptado." + message + ": ");
            SCANNER.next();
        }

        int number = SCANNER.nextInt();
        SCANNER.nextLine();
        return number;
    }

    public static double captureDouble(String message) {
        System.out.println(message + ": ");

        while(!SCANNER.hasNextDouble()) {
            System.out.println("Dato no aceptado." + message + ": ");
            SCANNER.next();
        }

        double number = SCANNER.nextDouble();
        SCANNER.nextLine();
        return number;
    }

    public static Category captureCategory(String message) {

        while (true) {
            String input = captureText(message);
            try {
                return Category.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Dato incorrecto.");
            }
        }
    }
}
