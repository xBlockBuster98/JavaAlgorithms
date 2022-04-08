package dev.blockbuster;

import dev.blockbuster.cypher.CaesarEncrypt;

import java.util.Scanner;

public class Main {
    public static String alphabet;

    public Main() {
        alphabet = "abcdefghijklmnopqrstuvwxyz";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello there!");
        System.out.println("Would you like to encrypt or decrypt a message?");
        System.out.println("Type '1' for encrypt a string, '2' for decrypt a string");

        int number = scanner.nextInt();
        scanner.nextInt();

        if(number == 1) {
            System.out.println("Please enter a string to encrypt");
            String text = scanner.nextLine();

            if(scanner.next().equals("")) {
                System.out.println("Please enter a valid text string!");
                scanner.reset();
            }

            System.out.println("Please enter a key");
            int key = scanner.nextInt();
            CaesarEncrypt.encrypt(text, key);

        } else if(number == 2) {
            System.out.println("Please enter a string to decrypt");
            String text = scanner.next();
            CaesarEncrypt.decrypt(text);

        } else {
            System.out.println("Invalid input");
        }
    }
}
