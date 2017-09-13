package main.java.console;

import java.util.Scanner;

/**
 * Created by Kostadin on 11-Sep-17.
 */
public class InputOutput{
    public static void write(String output) {
        System.out.println(output);
    }

    public static String read() {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.next();
        return command;
    }
}
