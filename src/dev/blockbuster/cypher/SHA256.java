package dev.blockbuster.cypher;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {
    public static byte[] hash(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String hashToString(String input) throws NoSuchAlgorithmException {
        return bytesToHex(hash(input));
    }

    public static String bytesToHex(byte[] hash) {
        BigInteger bigInteger = new BigInteger(1, hash);
        StringBuilder hex = new StringBuilder(bigInteger.toString(16));

        while (hex.length() < 32) {
            hex.insert(0, '0');
        }

        return hex.toString();
    }

    public static void main(String[] args) {
        String text = "Hello World";

        try {
            System.out.println("HashCode generated via SHA-256 for: ");
            System.out.println(text + ": " + hashToString(text));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown for incorrect algorithm: " + e.getMessage());
        }
    }
}
